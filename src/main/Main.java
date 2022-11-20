package main;

import classes.Game;
import classes.Word;
import classes.ConsoleColors;

public class Main {

	public static void main(String[] args) {
	
	Word word = new Word();
	ConsoleColors consolecolor = new ConsoleColors();
	Game game = new Game();
	
	
	System.out.println(consolecolor.BLUE_BOLD + "LINGO SPEL RAAD HET WOORD");
	System.out.println(consolecolor.RESET);
	
	game.Play(word.getRandomWord());
	
	}
	

	
}
