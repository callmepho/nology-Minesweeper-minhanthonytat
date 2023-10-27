package Minesweeper;

import java.util.Scanner;

public class Game {
	private Scanner s;
	private Grid grid;
	
	public Game(int size, int mines) {
	    s = new Scanner(System.in);
	    grid = new Grid(size);
	    grid.addMineToGrid(mines);
	}
	
	public void startGame() {
		Coord input;
		System.out.println(Colour.PURPLE_BOLD + "╔═════════════════════╗" + Colour.RESET);
		System.out.println(Colour.PURPLE_BOLD + "║     " + Colour.YELLOW_BOLD + "Minesweeper" + Colour.PURPLE_BOLD + "     ║" + Colour.RESET);
		System.out.println(Colour.PURPLE_BOLD + "╚═════════════════════╝" + Colour.RESET);
		System.out.println();
		
		do{
	        grid.printGrid();
	        input = getInput();
	        grid.selectCell(input);
	    } while(!grid.win() && !grid.isCellMine(input));
		grid.reavelAll();
		grid.printGrid();
		if(grid.win()) {
			System.out.println("You win");
		} else {
			System.out.println("You lose. You have selected a mine");
		}
	}
	
	public boolean isSelectedInputValid(Coord selected) {
        if (!grid.validSelect(selected)) {
            System.out.println(Colour.RED_BOLD + "Invalid input! Please input X/Y coordinate between 1-10" + Colour.RESET);
            return false;
        }
        if(grid.isCellSelected(selected)) {
            System.out.println("Already selected");
            return false;
        }
        return true;
    }
	
	public Coord getInput() {
		Coord select = new Coord(0,0);
		do{
			System.out.println("Input X coordinate number 1-10: ");
			while(!s.hasNextInt()) {
				System.out.println(Colour.RED_BOLD + "Input not an integar!" + Colour.RESET);
				System.out.println("Input X coordinate number 1-10: ");
				s.nextLine();
			}
			select.x = s.nextInt();
			
			System.out.println("Input Y number 1-10: ");
			while(!s.hasNextInt()) {
				System.out.println(Colour.RED_BOLD + "Input not an integar!" + Colour.RESET);
				System.out.println("Input Y coordinate number 1-10: ");
				s.nextLine();
			}
			select.y = s.nextInt();
			System.out.println("X input: "+select.x+". Y input: "+select.y);
			select.x--; 
			select.y--; 
			
		}while(!isSelectedInputValid(select));
		return select;
	}
	
	public String getString() {
		String input = s.nextLine();
		return input;
	}
}
