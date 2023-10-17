package Minesweeper;

public class Grid {
	int size;
	Cell[][] grid;
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
			System.out.print(" | "+i);
			System.out.println();
		}
		System.out.println();
		
	}
	
	public void selectCell(Selected coord) {
        this.grid[coord.x][coord.y].select();
    }
	
	public boolean validSelect(Selected coord) {
	    return coord.x >= 0 && coord.y >= 0 && coord.x < this.size && coord.y < this.size;
	}
	
	public boolean isCellSelected(Selected coord) {
        return grid[coord.x][coord.y].getIsSelected();
    }
}
