import java.util.Scanner;

public class Player {
    
    private String name = "";
    private int points = 0;

    public Player(String name){
        this.name = name;
    }

    public Player(){
    }

    public Player(boolean overloadPlaceHolder){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a player name:");
        this.name = sc.nextLine();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPoints(){
        return points;
    }

    public void addPoints(int points){
        this.points += points;
    }
}
