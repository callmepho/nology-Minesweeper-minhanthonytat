package Minesweeper;

import java.util.Random;

public class Grid {
	int size;
	Cell[][] grid;
	int selectedCount;
	
	public Grid(int size){
		this.size = size;
		this.grid = new Cell[size][size];
		for(int i = 0;i<size;i++) {
			for(int j = 0;j<size;j++) {
				this.grid[i][j] = new Cell();
			}
		}
	}
	
	public void printGrid() {
		for(int i = 0;i<this.size;i++) {
			for(int j = 0;j<this.size;j++) {
				System.out.print(this.grid[i][j] + " ");
			}
			System.out.print("║ "+(i+1));
			System.out.println();
		}
		for(int i = 0; i<this.size; i++) {
			System.out.print("══");
		}
		System.out.print("╝");
		System.out.println();
		for(int i = 0; i<this.size; i++) {
			System.out.print((i+1)+" ");
		}
		System.out.println();
		
	}
	
	public void selectCell(Select coord) {
        if(!validSelect(coord) || grid[coord.y][coord.x].getIsSelected()) {
        	return;
        }

        if(grid[coord.y][coord.x].getMinesNextTo()>0) {
        	this.grid[coord.y][coord.x].selected();
    		this.selectedCount++;
        } else {
        	this.grid[coord.y][coord.x].selected();
        	selectCell(new Select(coord.x+1,coord.y));
        	selectCell(new Select(coord.x-1,coord.y));
        	selectCell(new Select(coord.x,coord.y+1));
        	selectCell(new Select(coord.x,coord.y-1));
        }
    }
	
	public boolean validSelect(Select coord) {
	    return coord.x >= 0 && coord.y >= 0 && coord.x < this.size && coord.y < this.size;
	}
	
	public boolean isCellSelected(Select coord) {
        return grid[coord.y][coord.x].getIsSelected();
    }
	
	public boolean isCellMine(Select coord) {
		return grid[coord.y][coord.x].getIsMine();
	}
	
	public boolean addMineToCell(Select coord) {
		if(isCellMine(coord)) {
			return false;
		}
		
		int minX = Math.max(0, coord.x-1);
        int maxX = Math.min(size-1, coord.x+1);
        int minY = Math.max(0,coord.y-1);
        int maxY = Math.min(size-1, coord.y+1);
        for(int y = minY; y <= maxY; y++) {
            for(int x = minX; x <= maxX; x++) {
                grid[y][x].addMinesNextTo();
            }
        }
        
        grid[coord.y][coord.x].setAsMine();
		return true;
	}
	
	public void addMineToGrid() {
		Random r = new Random();
		for(int i = 0;i < 10;i++) {
			addMineToCell(new Select(r.nextInt(size), r.nextInt(size)));
		}
	}
	
	public void reavelAll() {
		for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                grid[i][j].selected();
            }
        }
	}
	
	public boolean win() {
		return size * size - 10 == selectedCount;
	}
	
}
