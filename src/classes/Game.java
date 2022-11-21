package classes;

import java.util.Arrays;
import java.util.Scanner;
import classes.ConsoleColors;

public class Game {

	ConsoleColors consolecolor = new ConsoleColors();

	public static void Play(String word)
	{
		Scanner input = new Scanner(System.in); // antwoord van gebruiker opvangen
		int rounds=1; // start vanaf ronde 
		int max_rounds=10; // max aantal rondes van spel sessie
		char[] wordC = word.toUpperCase().toCharArray(); // Te raden woord (opsplitsen in letters)
		char[] existingC = {' ',' ',' ',' ',' '}; //Bijhouden geraden letters die in het woord voorkomen maar op een andere positie
		char[] solutionC = {'*','*','*','*','*'};//Bijhouden geraden oplossing, letters op juiste plaats = woord
		String exit = " "; // vergelijkt met exitWord
		String exitWord ="stop"; // vergelijkt met exit
		boolean win=false; //Spel beëndigen wanneer het woord is geraden
		boolean existingCharCheck = false; //Bijhouden of minstens een letter van andere positie werd geraden voor sysout melding
		char[] inputC = new char[5]; //gebruikers input opslitsen in letters voor verdere verwerking

		//Welkom bericht
		//System.out.println(ConsoleColors.BLUE_BOLD + word +" \n"); //Oplossing voor programma test
		System.out.println(ConsoleColors.BLUE+"\n  Raad het woord bestaande uit vijf letters"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.BLUE_BOLD+"  * * * * * \n"+ConsoleColors.RESET);


		do // zolang rondes (rounds) en niet gewonnen (win)
		{
			// Geef antwoord in
			if(rounds==1)
			{
				System.out.print(ConsoleColors.PURPLE_BOLD +" | Type "+ConsoleColors.YELLOW_BACKGROUND_BRIGHT+"stop"+ConsoleColors.RESET+ConsoleColors.PURPLE_BOLD+" om het spel te verlaten\n"+ConsoleColors.RESET);
				System.out.print(ConsoleColors.PURPLE_BOLD +" | Start met een woord van vijf letters. Je hebt "+max_rounds+" kansen om te raden\n : "+ConsoleColors.RESET);
			}
			else
			{
				String space;
				if(rounds<10) {
					space=" ";
				}
				else{
					space="";
				}
				System.out.print(ConsoleColors.PURPLE_BOLD +"| Kans "+space+rounds+"/"+max_rounds+" | : "+ConsoleColors.RESET);
			}
			String inputString = (input.nextLine().toString().toUpperCase()); // Antwoord van gebruiker opvangen
			exit = inputString.toLowerCase(); // wordt verder in programma vergeleken met variabele exitWord (stopwoord) om te verlaten
			// Controleer string op lengte
			while (inputString.length()!=5  && !exit.equals(exitWord)){ //indien antwoord geen vijf letters en niet is gelijk aan stop woord
				System.out.println(ConsoleColors.PURPLE_BOLD + " | Voer een geldig vijf letter woord in: "+ConsoleColors.RESET);
				inputString = (input.nextLine().toString().toUpperCase()); // Herhaald antwoord gebruiker opvangen indien vorig anwtoord ongeldig
				exit = inputString.toLowerCase();//  wordt verder in programma vergeleken met variabele exitWord (stopwoord) om te verlaten
			}

			if(!exit.equals(exitWord))
			{
				// Controleer antwoord
				inputC = inputString.toCharArray();
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
					Status(inputC,solutionC);

					// Bestaande letters weergeven die in het woord voorkomen
					if(existingCharCheck)//indien minstens letter bestaat die in het woord voorkomt op andere plaats 
					{
						int spaceAfterChar=0;// formatting, bijhouden hoeveel spaties nodig zijn voor achter getoonde lettes
						System.out.print(ConsoleColors.YELLOW_BOLD+" Andere plaats: ");
						StringBuilder existingB = new StringBuilder(); // stringbuilder om de letters bij elkaar te zetten, ontdoen van hun array positie, om lege ruimtes te voorkomen bij print
						for(int i=0;i<existingC.length;i++)
						{
							boolean check_double=false;
							if(existingC[i]!=' ')// zorgen dat er geen lege ruimte komt tussen de letters, letters bij elkaar en spaties achteraan --> formatting
							{
								for(int j=0;j<i;j++)
								{
									if(existingC[j]==existingC[i])
									{
										check_double=true; // controle om de dubbele letters er uit te halen
									}
								}
								if(!check_double) { 
									existingB.append(existingC[i]);
									existingB.append(" ");// formatting, achter elke letter een spatie
								}
								else
								{
									spaceAfterChar=spaceAfterChar+2; // formatting, maak spaties achter de getoonde letters
								}
							}
							else // spatie naar achter zetten --> formatting
							{
								if(inputC[i]!=solutionC[i])
								{
									spaceAfterChar=spaceAfterChar+2;
								}
								else
								{
									spaceAfterChar=spaceAfterChar+2;
								}
							}
						}
						// bestaande letters van andere plaats, lijst leegmaken
						for(int i=0;i<existingC.length;i++)
						{
							existingC[i]=' ';
						}
						System.out.print(existingB.toString());
						// formatting: dynamisch spaties toevoegen aan de hand van de getoonde letters
						for(int i=0;i<spaceAfterChar;i++) // formatting, aantal bijgehouden spaties uitprinten voor achter alle getoonde letters
						{
							System.out.print(" ");
						}
						existingCharCheck=false; // terug op false zetten om volgende letter te controleren
					}
					else
					{
						System.out.print(ConsoleColors.GREEN_BOLD +" Andere plaats: geen      "+ConsoleColors.RESET); // geen letters weer te geven die op andere positie in oplossing voorkomen
					}

					rounds++; // Gespeelde ronde
				}
			}
		}
		while(win!=true && rounds<=max_rounds && !exit.equals(exitWord));

		// Weergeven gewonnen of verloren
		if(!exit.equals(exitWord)) // negeren indien gebruiker stopwoord heeft ingetypt
		{
			if(win)
			{
				Status(inputC,solutionC);
				System.out.println(ConsoleColors.BLUE_BOLD +"\n\n  Proficiat, je hebt het woord: "+word+" volledig geraden"+ConsoleColors.RESET);
			}
			else
			{
				System.out.println(ConsoleColors.BLUE_BOLD +"\n\n  Jammer, je hebt het woord: "+word+" niet geraden"+ConsoleColors.RESET);
			}
			System.out.println(ConsoleColors.PURPLE_BOLD +"\n  **************************************************** "+ConsoleColors.RESET);
		}
	}

	// FUNCTIE sysout --> Reeds geraden letters weergeven van de juiste oplossing
	private static void Status(char[] inputC, char[] solutionC)
	{
		// letters van gebruikersinvoer printen
		System.out.print(ConsoleColors.GREEN_BOLD+" | "+ConsoleColors.BLACK);
		for(int i=0;i<inputC.length;i++) 
		{
			System.out.print(inputC[i]+" ");
		}
		// oplossing printen
		System.out.print(ConsoleColors.GREEN_BOLD+" | Geraden: ");
		for(int i =0;i<solutionC.length;i++) 
		{
			System.out.print(ConsoleColors.BLUE_BOLD+solutionC[i]+" "+ConsoleColors.RESET);
		}
		System.out.print(ConsoleColors.GREEN_BOLD + "|"+ConsoleColors.RESET);
	}

}
