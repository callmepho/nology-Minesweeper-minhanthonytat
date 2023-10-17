package Minesweeper;

import java.util.Scanner;

public class Game {
	private Scanner s;
	private Grid grid;
	
	public Game() {
	    s = new Scanner(System.in);
	    grid = new Grid(10);
	}
	
	public void startGame() {
		Selected input;
		while(true) {
	        grid.printGrid();
	        input = getInput();
	        grid.selectCell(input);
	    }
	}
	
	public boolean isSelectedInputValid(Selected selected) {
        if (!grid.validSelect(selected)) {
            System.out.println("Invalid input!");
            return false;
        }
        if(grid.isCellSelected(selected)) {
            System.out.println("Already selected");
            return false;
        }
        return true;
    }
	
	public Selected getInput() {
		Selected select = new Selected(0,0);
		do{
			System.out.println("Input verticle number 1-10: ");
			select.x = s.nextInt();
			System.out.println("Input horizontal number 1-10: ");
			select.y = s.nextInt();
			
		}while(!isSelectedInputValid(select));
		return select;
	}
}
