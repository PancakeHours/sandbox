import java.util.Scanner;

public class NimLogic{

    public int pieces = 20;
    
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner sc = new Scanner(System.in);
    private String continuation = "";
    private boolean isComp;
    private int difficulty;
    private int intput;





    public NimLogic(boolean isComp){
        this.isComp = isComp;
        if(!isComp){
            this.player1 = new Player(true);
            this.player2 = new Player(true);
        }else{
            this.player1 = new Player();
        }  
    }








    public void run(){

        currentPlayer = randomizePlayer();

        while(true){

            pieces = 20;

            if(player1.getPoints() == 1 && player2.getPoints()!= 1){
                System.out.println("Game start. There are currently 20 pieces on the board. " + player1.getName() + " has 1 point. " + player2.getName() + " has " + player2.getPoints() + " points.");
            } else if(player1.getPoints() != 1 && player2.getPoints() == 1){
                System.out.println("Game start. There are currently 20 pieces on the board. " + player1.getName() + " has " + player1.getPoints() + " points. " + player2.getName() + " has 1 point.");
            } else if(player1.getPoints() == 1 && player2.getPoints() == 1){
                System.out.println("Game start. There are currently 20 pieces on the board. " + player1.getName() + " has 1 point. " + player2.getName() + " has 1 point.");
            } else {
                System.out.println("Game start. There are currently 20 pieces on the board. " + player1.getName() + " has " + player1.getPoints() + " points. " + player2.getName() + " has " + player2.getPoints() + " points. ");
            }

            while(pieces > 0){

                pieces -= getIntInput(pieces, currentPlayer);

                if(pieces != 1){
                    System.out.println("There are now " + pieces + " pieces on the board.");
                } else {
                    System.out.println("There is now 1 piece on the board.");
                }


                if(currentPlayer == player1){
                    player1 = currentPlayer;
                    currentPlayer = player2;
                }else if(currentPlayer == player2){
                    player2 = currentPlayer;
                    currentPlayer = player1;
                }

            }

            if(currentPlayer == player1){

                player1.addPoints(1);
                System.out.println(player1.getName() + " has won the round! They will receive one point, bringing their total score to " + player1.getPoints() + ".");
                
            }else if(currentPlayer == player2){

                player2.addPoints(1);
                System.out.println(player2.getName() + " has won the round! They will receive one point, bringing their total score to " + player2.getPoints() + ".");
                
            }

            System.out.println("Would you like to continue? Type Y (Yes) or any other key for No.");
            continuation = sc.nextLine();

            if(!continuation.toLowerCase().equals("y")){

                if(player1.getPoints() > player2.getPoints()){

                    if(player1.getPoints()!= 1){
                        System.out.println(player1.getName() + " has won, with " + player1.getPoints() + " points to their name!");
                    } else {
                        System.out.println(player1.getName() + " has won, with 1 point to their name!");
                    }  

                } else if(player1.getPoints() < player2.getPoints()){

                    if(player2.getPoints()!= 1){
                        System.out.println(player2.getName() + " has won, with " + player2.getPoints() + " points to their name!");
                    } else {
                        System.out.println(player2.getName() + " has won, with 1 point to their name!");
                    } 

                } else {

                    if(player1.getPoints()!= 1){
                        System.out.println("This session of Nim ends in a draw, with both players having " + player1.getPoints() + " points.");
                    } else {
                        System.out.println("This session of Nim ends in a draw, with both players having 1 point.");
                    }  
                    
                }
                System.out.println("We hope you enjoyed your time playing Nim!");
                break;

            } 
        }
    }










    public void runAgainstComp(int d){

        difficulty = d;

        while(true){

            pieces = 20;

            if(d == 3 || randomBool(0.5)){

                if(d == 3){
                    System.out.println("Game start. There are currently 20 pieces on the board. You have " + player1.getPoints() + " points. Due to the computer being invincible if it goes first, you will have the first turn.");
                } else {
                    System.out.println("Game start. There are currently 20 pieces on the board. You have " + player1.getPoints() + " points.");
                }

                while(pieces > 0){
                    
                    pieces -= getIntInput(pieces, player1);

                    if(pieces == 0){
                        System.out.println("You lost to the computer. You gained no points this round. You currently have " + player1.getPoints() + " points.");
                        break;
                    }

                    if(pieces != 1){
                        System.out.println("There are now " + pieces + " pieces on the board. \nIt is now the computer's turn.");
                    } else {
                        System.out.println("There is now 1 piece on the board. \nIt is now the computer's turn.");
                    }

                    pieces -= compAnswer(pieces, difficulty);

                    if(pieces == 0){
                        player1.addPoints(1);

                        if(player1.getPoints() != 1){
                            System.out.println("You won against the computer! You gained a point, putting you at " + player1.getPoints() + " points.");
                        } else {
                            System.out.println("You won against the computer! You gained a point, putting you at 1 point.");
                        }

                        break;
                    }
                    if(pieces != 1){
                        System.out.println("There are now " + pieces + " pieces on the board.");
                    } else {
                        System.out.println("There is now 1 piece on the board. It's your turn now.");
                    }
                    
                }

            } else {

                System.out.println("The computer will begin this round. This is chosen randomly.");
                pieces -= compAnswer(pieces, difficulty);

                while(pieces > 0){
                    
                    pieces -= getIntInput(pieces, player1);

                    if(pieces == 0){
                        System.out.println("You lost to the computer. You gained no points this round. You currently have " + player1.getPoints() + " points.");
                        break;
                    }

                    if(pieces != 1){
                        System.out.println("There are now " + pieces + " pieces on the board. \nIt is now the computer's turn.");
                    } else {
                        System.out.println("There is now 1 piece on the board. \nIt is now the computer's turn.");
                    }

                    pieces -= compAnswer(pieces, difficulty);

                    if(pieces == 0){
                        player1.addPoints(1);

                        if(player1.getPoints() != 1){
                            System.out.println("You won against the computer! You gained a point, putting you at " + player1.getPoints() + " points.");
                        } else {
                            System.out.println("You won against the computer! You gained a point, putting you at 1 point.");
                        }

                        break;
                    }
                    if(pieces != 1){
                        System.out.println("There are now " + pieces + " pieces on the board.");
                    } else {
                        System.out.println("There is now 1 piece on the board. It's your turn now.");
                    }
                    
                }
                
            }

                

            System.out.println("Would you like to continue? Type Y (Yes) or any other key for No.");
            continuation = sc.nextLine();

            if(!continuation.toLowerCase().equals("y")){

                System.out.println("We hope you enjoyed your time playing Nim!");
                break;

            } else if(continuation.toLowerCase().equals("y")){

                System.out.println("Would you like to change the difficulty? Type Y (Yes) or any other key for No.");
                
                //using continuation here because I didn't feel like making a new String variable every damn second
                continuation = sc.nextLine();
                if(continuation.toLowerCase().equals("y")){

                    System.out.println("What difficulty, from 1 to 3, would you like to change the computer to?");
                    while(true){
                        try{
    
                            intput = Integer.parseInt(sc.nextLine());
    
                            if(intput == 1 || intput == 2 || intput == 3){
                                
                                difficulty = intput;
                                System.out.println("Difficulty set to " + difficulty + ".");
                                break;

                            } else {

                                System.out.println("Please re-enter an integer from 1 to 3.");

                            }
    
                        } catch(Exception e) {
    
                            System.out.println("Sorry, that was not a valid input. Please retry.");
    
                        }
                    }
                    
                }
            }
        }
    }









    public int compAnswer(int currentPieces, int d){
        
        int piecesRemoved = 0;

        String storage = "";

        int half;
        if(currentPieces%2 == 1){
            half = currentPieces/2 + 1;
        } else {
            half = currentPieces/2;
        }

        if(currentPieces == 1 || currentPieces == 2){

            piecesRemoved = 1;

        } else if(currentPieces == 5 || currentPieces == 11){

            if(randomBool(d*0.3333333333)){
                piecesRemoved = (int) Math.random()*half + 1;
            } else {
                piecesRemoved = 1;
            }

        } else if(currentPieces == 3 || currentPieces == 6 || currentPieces == 12){

            if(randomBool(d*0.3333333333)){
                piecesRemoved = (int) Math.random()*half + 1;
            } else {
                piecesRemoved = 2;
            }

        } else if(currentPieces == 7 || currentPieces == 13){

            if(randomBool(d*0.3333333333)){
                piecesRemoved = (int) Math.random()*half + 1;
            } else {
                piecesRemoved = 3;
            }

        } else if(currentPieces == 8 || currentPieces == 14){

            if(randomBool(d*0.3333333333)){
                piecesRemoved = (int) Math.random()*half + 1;
            } else {
                piecesRemoved = 4;
            }

        } else if(currentPieces == 9 || currentPieces == 15){

            if(randomBool(d*0.3333333333)){
                piecesRemoved = (int) Math.random()*half + 1;
            } else {
                piecesRemoved = 5;
            }

        } else if(currentPieces == 10  || currentPieces == 4){

            piecesRemoved = (int) (Math.random()*half) + 1;

        } else if(currentPieces == 16){

            if(randomBool(d*0.3333333333)){
                piecesRemoved = (int) Math.random()*half + 1;
            } else {
                piecesRemoved = 6;
            }

        } else if(currentPieces == 17){

            if(randomBool(d*0.3333333333)){
                piecesRemoved = (int) Math.random()*half + 1;
            } else {
                piecesRemoved = 7;
            }

        } else if(currentPieces == 18){

            if(randomBool(d*0.3333333333)){
                piecesRemoved = (int) Math.random()*half + 1;
            } else {
                piecesRemoved = 8;
            }

        } else if(currentPieces == 19){

            if(randomBool(d*0.3333333333)){
                piecesRemoved = (int) Math.random()*half + 1;
            } else {
                piecesRemoved = 9;
            }

        } else if(currentPieces == 20){

            if(randomBool(d*0.3333333333)){
                piecesRemoved = (int) Math.random()*half + 1;
            } else {
                piecesRemoved = 10;
            }

        }

        if(piecesRemoved != 1){
            System.out.println("The computer has removed " + piecesRemoved + " pieces. Press any key to confirm.");
            storage = sc.nextLine();
        } else {
            System.out.println("The computer has removed 1 piece. Press any key to confirm.");
            storage = sc.nextLine();
        }
        return piecesRemoved;
    }










    public int getIntInput(int currentPieces, Player player){
        
        String storage = "";

        if(!isComp){
            System.out.println("It is currently " + player.getName() + "'s turn.");
        }

        int piecesRemoved = 0;
        int temp = 0;
        boolean isValid = false;

        int half;
        if(currentPieces%2 == 1){
            half = currentPieces/2 + 1;
        } else {
            half = currentPieces/2;
        }

        if(currentPieces > 2){
            System.out.println("How many pieces would you like to remove? Choose between " + half + " and 1");
            
            while(isValid == false){

                while(true){
                    try{

                        temp = Integer.parseInt(sc.nextLine());
                        break;

                    } catch(Exception e) {

                        System.out.println("Sorry, that was not a valid input. Please retry.");

                    }
                }

                if(temp > half){

                    System.out.println("Value is too high! Please enter a value between " + half + " and 1");

                } else if(temp <= 0){

                    System.out.println("Cannot enter a value of zero or below. Try again.");

                } else {

                    piecesRemoved = temp;
                    System.out.println("Successfully recorded entry! You've removed " + piecesRemoved + " pieces.");
                    isValid = true;
                    
                }
            }

        } else if(currentPieces == 2){
            System.out.println("You may only remove one piece this turn. This will be done automatically. Press any key to confirm.");
            storage = sc.nextLine();
            piecesRemoved = 1;

        } else if(currentPieces == 1){
            System.out.println("You must take the last piece. This will be done automatically. Press any key to confirm.");
            storage = sc.nextLine();
            piecesRemoved = 1;
        }

        return piecesRemoved;

    }






    public Player randomizePlayer(){
        double num = Math.random();
        if(num >= 0.5){
            return player1;
        } else {
            return player2;
        }
    }









    public boolean randomBool(double chance){
        double num = Math.random();
        if(num >= chance){
            return true;
        } else {
            return false;
        }
    }
}