/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{

  Player player1 = new Player();
  Player player2 = new Player();
  Board board = new Board();
  Scanner sc = new Scanner(System.in);
  boolean solved = false;
  int turnNumber = 1;
  String playerGuess = "";

  public PhraseSolver(){
  }

  public void runner(Player currentPlayer){

    System.out.println(board.getSolvedPhrase());

    System.out.println("Enter a letter: ");
    playerGuess = sc.nextLine();

    if(board.guessLetter(playerGuess)){
      currentPlayer.addPoints(board.getPointVal());
      System.out.println("Correct guess! Updated phrase is below:");
      System.out.println(board.getPhrase());
    }else{
      System.out.println("Wrong guess idoit");
    }

    turnNumber ++;

    if(board.isSolved(board.getSolvedPhrase())){
      solved = true; 
    }
  }

  public void play()
  {

    while(!solved){
      if(turnNumber%2 == 1){
        runner(player1);
      }else{
        runner(player2);
      }
    }
    System.out.println("Phrase is solved.");
    System.out.println(player1.getName() + "'s score: " + player1.getPoints());
    System.out.println(player2.getName() + "'s score: " + player2.getPoints());
   
  }
  
}