/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class is the logic of the game.
 */
import java.util.Scanner;
  
public class PhraseSolver
{

  private Player player1;
  private Player player2;
  private Board board = new Board();
  private Player currentPlayer;
  private String playerGuess = "";
  private Scanner sc = new Scanner(System.in);
  private String pastGuesses = "";

  public PhraseSolver(){

    this.player1 = new Player();
    this.player2 = new Player();
    player1.setPoints(0);
    player2.setPoints(0);
    currentPlayer = player1;

  }

  public void play()
  {
    
    System.out.println("Your unsolved phrase is currently: " + board.getSolvedPhrase());
  
    while(!stripSpace(board.getPhrase()).equals(stripSpace(board.getSolvedPhrase()))){

      System.out.println("It is currently " + currentPlayer.getName() + "'s turn.");
      System.out.println("Please enter a single letter as your guess.");
      
      while(true){

        playerGuess = sc.nextLine();

        if((playerGuess.length() == 1 || stripSpace(playerGuess).length() == stripSpace(board.getPhrase()).length()) && !pastGuesses.contains(playerGuess)){
          break;
        } else {
          System.out.println("Please enter one character only. Do not enter any past guesses. If guessing the entire phrase, make sure it is the length of the unknown phrase.");
          System.out.println("The current list of past guesses are: " + pastGuesses);
          System.out.println("Enter another guess.");
        }

      }


      if(stripSpace(playerGuess).equals(stripSpace(board.getPhrase()))){

        currentPlayer.addPoints(3*board.getLetterVal());;
        System.out.println("Wow! " + currentPlayer.getName() + " got the phrase in one go! They'll receive three times the normal allotted points for a guess!, putting them at " + currentPlayer.getPoints() + " point(s).");
        break;

      } else if(playerGuess.length() != 1){

        System.out.println("That was not the correct phrase.");
        swapPlayer();
        continue;

      }

      if(board.guessLetter(playerGuess)){

        currentPlayer.addPoints(board.getLetterVal());

        System.out.println("Correct! " + currentPlayer.getName() + " receives " + board.getLetterVal() +  "point(s), putting them at " + currentPlayer.getPoints() + " point(s).");        

      }else{

        System.out.println("That letter was not in the phrase.");

      }

      System.out.println("Your unsolved phrase is currently: " + board.getSolvedPhrase());

      pastGuesses += playerGuess + " ";

      swapPlayer();
    }

    
    
    if(player1.getPoints() > player2.getPoints()){
      System.out.println(player1.getName() + " has won the game!");
    } else if(player1.getPoints() < player2.getPoints()){
      System.out.println(player2.getName() + " has won the game!");
    } else {
      System.out.println("This game is a tie.");
    }
   
  }

  //saves changes of the current turn to the correct player, and sets currentPlayer as the other player.
  public void swapPlayer(){
    if(currentPlayer == player1){
      player1 = currentPlayer;
      currentPlayer = player2;
    } else {
      player2 = currentPlayer;
      currentPlayer = player1;
    }
  }

  //strips all the spaces in a phrase to make it easier to compare phrase lengths and content
  public String stripSpace(String phrase){

    String temp = "";

    for(int i = 0; i < phrase.length(); i++){
      if(!phrase.substring(i, i+1).equals(" ")){
        temp += phrase.substring(i,i+1);
      }
    }

    return temp;
  }
}