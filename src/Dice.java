// Dice class

import java.util.Scanner;

public class Dice 
{
	private int diceValue;
	private String userGuess;
	private String userGuessToInt;
	private String answer;
	private int numOfDices;
	private int userPoints = 0;
	private int highValue = 0;
	private int userGuessInt = 0;
	private int totalGames = 0;
	
	Scanner input = new Scanner(System.in);
	
	// Constructor
	public Dice()
	{
		this.numOfDices = 1;
	}
	
	public int getNumberOfDice()
	{
		// Get number of dice from player
		System.out.print("How many dices do you want to play with? ");
		numOfDices = input.nextInt();
		input.nextLine();
		return numOfDices;
	}
	
	public String getUserGuess()
	{
		// Get user guess
		System.out.printf("Take a guess: 'low' or 'high'? \n"
				+ "low = 1 to %d\n"
				+ "high = %d to %d"
				+ "\nEnter guess: ", ((highValue / 2) - 1), ((highValue / 2) + 1), highValue);
		userGuess = input.nextLine();
		return userGuess;
	}
	
	public int Throw(int pNumOfDices)
	{
		// total game counter
		totalGames++;
		
		// get dice value
		diceValue = (int) (Math.random() * (pNumOfDices * 6)) + 1;
		
		return diceValue;
	}
	
	public int highValue(int pNumOfDices)
	{
		highValue = (pNumOfDices * 6);
		return highValue;
	}
	
	public static boolean isNumeric(String userGuess)
	{
	  return userGuess.matches("-?\\d+(\\.\\d+)?");
	}
	
	public void userGuessInt(String userGuess)
	{
		// This will convert from string to int to give us an integer value
		
		if(userGuess.matches("-?\\d+(\\.\\d+)?"))
		{
			userGuessInt = Integer.parseInt(userGuess);
		}
	}
	
	public void displayRound()
	{
		
		if ((userGuess.equalsIgnoreCase("low")) && (diceValue < (highValue / 2)))
		{
			System.out.print("You Win! The dice rolled " + diceValue + " which is a low from a " + highValue + " sided dice.");
			userPoints++;
		}
		else if ((userGuess.equalsIgnoreCase("low")) && (diceValue > (highValue / 2)))
		{
			System.out.print("You lose! The dice rolled " + diceValue + " which is a high from a " + highValue + " sided dice.");
			userPoints--;
		}
		else if ((userGuess.equalsIgnoreCase("high")) && (diceValue > (highValue / 2)))
		{
			System.out.print("You Win! The dice rolled " + diceValue + " which is a high from a " + highValue + " sided dice.");
			userPoints++;
		}
		
		else if ((userGuess.equalsIgnoreCase("high")) && (diceValue < (highValue / 2)))
		{
			System.out.print("You lose! The dice rolled " + diceValue + " which is a low from a " + highValue + " sided dice.");
			userPoints--;
		}
		
		else if (diceValue == (highValue / 2) && (userGuess.equalsIgnoreCase("high") || (userGuess.equalsIgnoreCase("low"))))
		{
			System.out.print("You lose! The dice rolled " + diceValue + " which is not the range of a " + highValue + " sided dice. So neigther high nor low.");
			userPoints--;
		}
	}
	
	
	public String playAgain()
	{
		System.out.printf("\n\nComputer's roll: %d   Guess was: %s   Current Score: %d", diceValue ,userGuess, userPoints);
		System.out.print("\n\nDo you want to play again? (Yes or No): \n");
		answer = input.next();
		
		return answer;
	}
	
	public void finalResult()
	{
		System.out.println("\nThese are the final results:");
		System.out.println("The total number of games played were: " + totalGames);
		System.out.println("Total user points: " + userPoints);
	}
}