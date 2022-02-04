/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String phrase = "";
  private String solvedPhrase = "";
  private int currentLetterValue = 0; 

  public Board(){
    phrase = "test phrase here ";
    solvedPhrase = "_ _ _ _  _ _ _ _ _ _  _ _ _ _  ";
    setLetterValue();
  } 
  
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  /*
  this method takes the player's guess and checks 
  it against every letter in the phrase, 
  adding it as a visible letter in the return phrase
  and updates the running phrase with the guessed letter made visible

  returns boolean value depending on if letter is found

  preconditions: guess must not be null and the solved must not equal true

  postconditions: must be stored in a boolean variable and used to distribute points
  */

  public boolean guessLetter(String guess)
  {

    //whether or not the guess is in the phrase is what we will be testing in this method, so foundLetter begins as false
    boolean foundLetter = false;

    //initialize the phrase that will be updated 
    String newSolvedPhrase = "";
    
    //runs an iteration for each letter of the phrase 
    for (int i = 0; i < phrase.length(); i++)
    {

      //if the current letter in phrase is the same as the guessed letter, replace one underscore in the running phrase with a visible letter
      if (phrase.substring(i, i + 1).equals(guess))
      {
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      }

      //otherwise, don't do anything and add the character and space that was already there and move on
      else
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    
    //updates the running phrase to the new updated phrase
    solvedPhrase = newSolvedPhrase;

    //returns whether or not the letter was found in the phrase
    return foundLetter;
  } 

  public String getSolvedPhrase(){
    return solvedPhrase;
  }

  public String getPhrase(){
    return phrase;
  }

  public int getPointVal(){
    return currentLetterValue;
  }
} 