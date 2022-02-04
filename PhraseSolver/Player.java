/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player implements Cloneable
{

  public Object Clone() throws CloneNotSupportedException{
    return super.clone();
  }
  
  String playerName = "";
  int points = 0;

  public Player(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter your name:");
    playerName = sc.nextLine();
    System.out.println("Welcome, " + playerName);
    points = 0;
  }

  public Player(String inputName){
    System.out.println("Welcome, " + inputName);
    playerName = inputName;
    points = 0;
  }

  public String getName(){
    return playerName;
  }

  public void setName(String newName){
    playerName = newName;
  }
  
  public int getPoints(){
    return points;
  }

  public void addPoints(int numPoints){
    points += numPoints;
  }
}