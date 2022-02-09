/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{

  private String name;
  private int points;
  private Scanner sc = new Scanner(System.in);

  public Player(String name){
    this.name = name;
  }

  public Player(){
    System.out.println("Enter a player name:");
    name = sc.nextLine();
  }
  
  public void addPoints(int points){
    this.points += points;
  }

  public void setPoints(int points){
    this.points = points;
  }

  public int getPoints(){
    return points;
  }

  public String getName(){
    return name;
  }
}