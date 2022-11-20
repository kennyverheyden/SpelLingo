package classes;

import java.util.Scanner;
import classes.ConsoleColors;

public class Game {


	
	ConsoleColors consolecolor = new ConsoleColors();
	

	public static void Play(String word)
	{
		Scanner input = new Scanner(System.in);
		System.out.println(ConsoleColors.PURPLE_BOLD + word +" \n");
		char[] wordC = word.toCharArray();
		char[] solutionC = {'*','*','*','*','*'};
		System.out.println("Raad het woord bestaande uit vijf letters");
		System.out.println("* * * * *");
		
		System.out.println("Geen een woord van vijf tekens in: ");
		String inputString = (input.nextLine().toString());
		while (inputString.length()!=5){
		System.out.println("Geen een woord van vijf tekens in: ");
		inputString = (input.nextLine().toString());
		}
		
		char[] inputC = inputString.toCharArray();
		for(int i = 0;i<wordC.length;i++)
		{
			if(inputC[i]==wordC[i])
			{
				solutionC[i]=wordC[i];
			}
		}
		
		for(int i =0;i<solutionC.length;i++)
		{
			System.out.print(solutionC[i]);
		}
		
	}


}
