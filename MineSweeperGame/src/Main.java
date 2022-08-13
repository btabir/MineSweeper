import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("--- Welcome to the Mine Sweeper Game ---");

        System.out.print("Please enter the row lenght : ");
        int rowNumber = input.nextInt();

        System.out.print("Please enter the column lenght : ");
        int colNumber = input.nextInt();


        MineSweeper ms = new MineSweeper(rowNumber,colNumber);
        ms.run();

    }
}
