package classes;

import java.util.Arrays;
import java.util.Scanner;
import classes.ConsoleColors;

public class Game {

	ConsoleColors consolecolor = new ConsoleColors();

	public static void Play(String word)
	{
		Scanner input = new Scanner(System.in);
		int rounds=1;
		int max_rounds=10;
		char[] wordC = word.toUpperCase().toCharArray(); // Te raden woord (opsplitsen in letters)
		char[] existingC = {' ',' ',' ',' ',' '}; //Bijhouden geraden letters die in het woord voorkomen maar op een andere positie
		char[] solutionC = {'*','*','*','*','*'};//Bijhouden geraden oplossing, letters op juiste plaats = woord
		boolean win=false; //Spel beëndigen wanneer het woord is geraden
		boolean existingCharCheck = false; //Bijhouden of minstens een letter van andere positie werd geraden voor sysout melding
		
		System.out.println(ConsoleColors.BLUE_BOLD + word +" \n"); //Oplossing
		System.out.println(ConsoleColors.BLUE+"Raad het woord bestaande uit vijf letters"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.BLUE_BOLD+" * * * * * \n"+ConsoleColors.RESET);


		do // zolang rondes (rounds) en niet gewonnen (win)
		{
			// Geef antwoord in
			System.out.print(ConsoleColors.PURPLE_BOLD +" | Kans "+rounds+"/"+max_rounds+" | : "+ConsoleColors.RESET);
			String inputString = (input.nextLine().toString().toUpperCase());
			while (inputString.length()!=5){
				System.out.println(ConsoleColors.PURPLE_BOLD + "     Voer een geldig vijf letter woord in:"+ConsoleColors.RESET);
				inputString = (input.nextLine().toString());
			}

			// Controleer antwoord
			char[] inputC = inputString.toCharArray();
			for(int i = 0;i<wordC.length;i++)
			{
				if(inputC[i]==wordC[i])
				{
					solutionC[i]=wordC[i]; //Oplossing bijhouden

				}
			}

			// Controleer of er bestaande letters in het woord zitten op een andere plaats
			for(int i = 0;i<wordC.length;i++)
			{
				for(int j=0;j<wordC.length;j++)
				{
					if(inputC[i]==wordC[j])
					{
						if(inputC[i]!=solutionC[j])
						{
							existingC[i] = inputC[i];
							existingCharCheck=true; //Bijhouden of minstens een letter van andere positie geraden voor sysout melding
						}
					}
				}
			}

			if(Arrays.equals(solutionC, wordC))
			{
				win=true; // Gewonnen, doorbreek de while loop
			}
			else
			{
				// Reeds geraden letters weergeven van de juiste positie
				System.out.print(ConsoleColors.GREEN_BOLD+" | "+ConsoleColors.BLACK);
				for(int i=0;i<inputC.length;i++)
				{
					System.out.print(inputC[i]+" ");
				}
				System.out.print(ConsoleColors.GREEN_BOLD+" | Geraden: ");
				for(int i =0;i<solutionC.length;i++)
				{
					System.out.print(ConsoleColors.BLUE_BOLD+solutionC[i]+" "+ConsoleColors.RESET);
				}
				System.out.print(ConsoleColors.GREEN_BOLD + "|"+ConsoleColors.RESET);

				// Bestaande letters weergeven die in het woord voorkomen
				if(existingCharCheck)
				{
					System.out.print(ConsoleColors.YELLOW_BOLD+" Andere plaats: ");
					for(int i=0;i<existingC.length;i++)
					{
						if(existingC[i]!=' ')
						{
							System.out.print(existingC[i]+" ");
						}
					}
					//bestaande letters van andere plaats, lijst leegmaken
					for(int i=0;i<existingC.length;i++)
					{
						existingC[i]=' ';
					}
					existingCharCheck=false;
				}
				else
				{
					System.out.print(ConsoleColors.GREEN_BOLD +" Geen andere plaats letters "+ConsoleColors.RESET);
				}

				rounds++; // Gespeelde ronde
			}
		}
		while(win!=true && rounds<=max_rounds);

		if(win)
		{
			System.out.println(ConsoleColors.BLUE_BOLD +" \nProficiat, je hebt het woord: "+word+" volledig geraden"+ConsoleColors.RESET);
		}
		else
		{
			System.out.println(ConsoleColors.BLUE_BOLD +" \nJammer, je hebt het woord: "+word+" niet geraden"+ConsoleColors.RESET);
		}
	}
}
