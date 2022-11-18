package main;
import java.util.ArrayList;
import java.util.Random;

public class Word {

	public Word()
	{

	}

	public String getRandomWord()
	{
		// make DB connection
		DBConnect myDBConnection = new DBConnect();
		// retrieve words
		myDBConnection.retrieveData();
		ArrayList<String> woorden = myDBConnection.retrieveData();
		// make random number
		Random rn = new Random();
		int random = rn.nextInt(woorden.size());
		String woord=woorden.get(random);
		return woord;	
	}

}
