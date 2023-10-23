package Minesweeper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;



public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		Game game;
		Scanner scan = new Scanner(System.in);
		String input;boolean playAgain = true;
		Object config = new JSONParser().parse(new FileReader("src/Minesweeper/config.json"));
		JSONObject jsonObject = (JSONObject) config;
		int size = (int) (long)jsonObject.get("size");
		int mines = (int) (long) jsonObject.get("mines");
		if(size*size <= mines) {
			System.out.println("Invalid config setting, number of mines larger and larger than or equal to grid.");
			playAgain = false;
		}
		while(playAgain) {
			playAgain = true;
			game = new Game(size,mines);
			game.startGame();
			System.out.println("Type quit to stop playing or anything to play again.");
			input = scan.nextLine().trim().toLowerCase();
			if(input.equals("quit")){
				playAgain = false;
			}
		}
		scan.close();
	}
}
