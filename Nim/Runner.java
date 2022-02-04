import java.util.Scanner;

public class Runner {
    
    public static String input = "";
    public static int intput = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("Would you like to play against the computer or against a friend today? Enter Y for computer and N for friend.");

        while(true){
            input = sc.nextLine();

            if(input.toLowerCase().equals("y")){

                NimLogic nimLogic = new NimLogic(true);

                System.out.println("Enter a difficulty from 1 to 3, with 1 being normal and 3 being invincible if you make a mistake.");

                while(true){
                    try{

                        intput = Integer.parseInt(sc.nextLine());

                        if(intput == 1 || intput == 2 || intput == 3){

                            nimLogic.runAgainstComp(intput);
                            break;

                        } else {
                            System.out.println("Please re-enter an integer from 1 to 3.");
                        }

                    } catch(Exception e) {

                        System.out.println("Sorry, that was not a valid input. Please retry.");

                    }
                }
                
                break;

            } else if(input.toLowerCase().equals("n")){
                NimLogic nimLogic = new NimLogic(false);
                nimLogic.run();
                break;

            } else {

                System.out.println("Please enter a valid input.");

            }
        }
    }
}
