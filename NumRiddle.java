public class NumRiddle{

    public static void main(String[] arg){

        final double startingNum = -1.5;

        double operatingNum = startingNum;

        System.out.println("The starting number is: " + startingNum);

        operatingNum *= 2;

        System.out.println("Double: " + startingNum + " x 2 = " + operatingNum);

        operatingNum += 6;

        System.out.println("Add 6: " + startingNum*2 + " + 6 = " + operatingNum);

        operatingNum /= 2;

        System.out.println("Halve: " + (startingNum * 2 + 6) + " / 2 = " + operatingNum);

        operatingNum -= startingNum;

        System.out.println("Subtract by starting number: " + (startingNum * 2 + 6) / 2 + " - " + startingNum + " = " + operatingNum);

        System.out.println("The final number is 3, as expected.");
    }
}