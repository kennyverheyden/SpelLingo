package main;

import classes.Game;
import classes.Word;
import classes.ConsoleColors;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Word word = new Word();
		ConsoleColors consolecolor = new ConsoleColors();
		Game game = new Game();
		Scanner userinput = new Scanner(System.in);
		int userChose=0;
		boolean exitProgram = false;

		System.out.println(consolecolor.PURPLE_BOLD + "\n     LINGO SPEL RAAD HET WOORD");
		System.out.println(consolecolor.RESET);

		do
		{
			System.out.println(ConsoleColors.BLUE_BOLD);
			System.out.println("     1. Spelen\n");
			System.out.println("     2. Toepassing verlaten\n");
			System.out.println(ConsoleColors.RESET);
			
			System.out.print("  Keuze: ");
			userChose=userinput.nextInt();

			switch(userChose) {
			case 1:
				game.Play(word.getRandomWord());
				break;
			case 2:
				exitProgram = true;
				break;
			}

		}
		while(!exitProgram);

		System.out.println(consolecolor.PURPLE_BOLD + "\n  Fijn dat je gespeeld hebt");
		System.out.println(consolecolor.RESET);
	}
}