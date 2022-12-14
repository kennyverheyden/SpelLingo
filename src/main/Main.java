package main;

import classes.Game;
import classes.Word;
import classes.ConsoleColors;
import java.util.Scanner;
import classes.ConsoleColors;
import classes.ConsoleColors;
public class Main {

	public static void main(String[] args) {

		WelcomeMSG();
		Content();
		EndMSG();

	}

	public static void WelcomeMSG()
	{
		System.out.println(ConsoleColors.BLUE_BOLD+"\n  *************************************************************************");
		System.out.println("  *****                  "+ConsoleColors.PURPLE_BOLD+"LINGO SPEL RAAD HET WOORD"+ConsoleColors.RESET+ConsoleColors.BLUE_BOLD+"                    *****");
		System.out.println("  *****              "+ConsoleColors.PURPLE_BOLD+"Raad in tien kansen het woord!"+ConsoleColors.RESET+ConsoleColors.BLUE_BOLD+"                   *****");
		System.out.println("  *************************************************************************"+ConsoleColors.RESET);
	}

	public static void Content()
	{
		Game game = new Game();
		Word word = new Word();
		Scanner userInput = new Scanner(System.in);
		boolean exitProgram = false;
		boolean validInput = false;
		int userChose=0;

		do
		{
			System.out.println("     1. Play\n");
			System.out.println("     2. Exit the game\n");
			do
			{
				try
				{
					System.out.print("  Kueze: ");
					userChose=userInput.nextInt();
					validInput=true;
				}
				catch(Exception e){
					userInput.next();
					System.out.println("Enter valid number\n");
				}
			}
			while(!validInput);

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
	}

	public static void EndMSG()
	{
		System.out.println(ConsoleColors.PURPLE_BOLD + "\n  Fijn dat je gespeeld hebt");
		System.out.println(ConsoleColors.RESET);
	}
}