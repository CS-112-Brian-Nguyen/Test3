import java.util.Scanner;

public class HiLowGame 
{

	public static void main(String[] args) 
	{
		// Variables
		String userGuess;
		String answer = "NO";
		int numOfDice;
		int randomVal = 0;	
		int highVal = 0;
		int userGuessInt = 0;
		
		Scanner input = new Scanner(System.in);
		
		// Create new object of Dice type
		Dice hiLow = new Dice();
		
		do
		{
			// get number of dice from user
			numOfDice = hiLow.getNumberOfDice();
			
			// get random value from computer
			randomVal = hiLow.Throw(numOfDice);
			
			// debug Show dice number.
			System.out.println("The computer rolled: " + randomVal);
			
			// Generate high value
			highVal = hiLow.highValue(numOfDice);
			
			// get user guess
			userGuess = hiLow.getUserGuess();
			
			// convert String to Int if needed
			hiLow.userGuessInt(userGuess);
			
			// display this round result
			hiLow.displayRound();
			
			// Ask user to play again
			answer = hiLow.playAgain();
			
		}while(answer.equalsIgnoreCase("YES"));
		
		
		// display final tally
		hiLow.finalResult();
		
	}

}