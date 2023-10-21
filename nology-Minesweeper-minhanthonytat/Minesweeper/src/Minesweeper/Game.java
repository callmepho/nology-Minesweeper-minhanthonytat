package Minesweeper;

import java.util.Scanner;

public class Game {
	private Scanner s;
	private Grid grid;
	
	public Game() {
	    s = new Scanner(System.in);
	    grid = new Grid(10);
	    grid.addMineToGrid();
	}
	
	public void startGame() {
		Select input;
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
			System.out.println("You lose. You have found a mine");
		}
	}
	
	public boolean isSelectedInputValid(Select selected) {
        if (!grid.validSelect(selected)) {
            System.out.println("Invalid input! Please input X/Y coordinate between 1-10");
            return false;
        }
        if(grid.isCellSelected(selected)) {
            System.out.println("Already selected");
            return false;
        }
        return true;
    }
	
	public Select getInput() {
		Select select = new Select(0,0);
		do{
			System.out.println("Input X coordinate number 1-10: ");
			while(!s.hasNextInt()) {
				System.out.println("Input not a integar!");
				System.out.println("Input X coordinate number 1-10: ");
				s.nextLine();
			}
			select.x = s.nextInt();
			
			System.out.println("Input Y number 1-10: ");
			while(!s.hasNextInt()) {
				System.out.println("Input not a integar!");
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
