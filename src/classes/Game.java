package classes;

import java.util.Scanner;
import classes.ConsoleColors;

public class Game {

	ConsoleColors consolecolor = new ConsoleColors();

	public static void Play(String word)
	{
		Scanner input = new Scanner(System.in);
		int rounds=1;
		int gueses=0;
		int max_rounds=10;
		System.out.println(ConsoleColors.PURPLE_BOLD + word +" \n");
		char[] wordC = word.toCharArray();
		char[] solutionC = {'*','*','*','*','*'};
		System.out.println("Raad het woord bestaande uit vijf letters");
		System.out.println("* * * * *");


		do
		{
			gueses=0;
			System.out.println("\n| Kans "+rounds+" van "+max_rounds+" | Geef een woord van vijf letters in: ");
			String inputString = (input.nextLine().toString());
			while (inputString.length()!=5){
				System.out.println("| Kans "+rounds+" van "+max_rounds+" | Geef een woord van vijf letters in: ");
				inputString = (input.nextLine().toString());
			}

			char[] inputC = inputString.toCharArray();
			for(int i = 0;i<wordC.length;i++)
			{
				if(inputC[i]==wordC[i])
				{
					solutionC[i]=wordC[i];
					gueses++;

				}
			}
			System.out.print("Reeds geraden: ");
			for(int i =0;i<solutionC.length;i++)
			{
				System.out.print(solutionC[i]);
			}
			System.out.println("");
			rounds++;

		}
		while(gueses!=wordC.length && rounds<=max_rounds);
		if(gueses ==5)
		{
			System.out.println("Proficiat, je hebt het woord volledig geraden");
		}
	}


}
