import java.util.Scanner;

import java.util.Random;



public class MineSweeper {

    int[][] map;
    int[][] board;
    int rowNumber;
    int colNumber;
    int size;
    boolean game = true;

    Scanner input = new Scanner(System.in);
    Random random = new Random();

    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber * colNumber;
    }

    public void run() {
        int whichRow, whichCol,success = 0;
        minePlacement();
        print(map);
        System.out.println("--------------------------------");
        while (game) {
            print(board);
            System.out.println();
            System.out.print("Row : ");
            whichRow = input.nextInt();
            System.out.print("Col : ");
            whichCol = input.nextInt();

            if (whichRow < 0 || whichRow >= rowNumber){
                System.out.println("You have entered an invalid number!");
                break;
            }
            if (whichCol < 0 || whichCol >= colNumber){
                System.out.println("You have entered an invalid number!");
                break;
            }

            if (map[whichRow][whichCol] != -1) {
                isCheck(whichRow, whichCol);
                success ++;
                if (success == (this.size - (this.size/4))){
                    System.out.println(" * - * Congrulations! You won the game * - * ");
                    break;
                }
            } else {
                game = false;
                System.out.println("--- G A M E  O V E R ---");
            }
        }
    }

    public void isCheck(int r, int c) {

        if (map[r][c] == 0) {
            if ((c < colNumber - 1) && (map[r][c + 1] == -1)) {
                board[r][c]++;
            }
            if ((c > 0) && map[r][c - 1] == -1) {
                board[r][c]++;
            }
            if ((r > 0) && map[r - 1][c] == -1) {
                board[r][c]++;
            }
            if ((r < rowNumber - 1) && map[r + 1][c] == -1) {
                board[r][c]++;
            }
            if ((r > 0) && (c > 0) && map[r - 1][c - 1] == -1) {
                board[r][c]++;
            }
            if ((r > 0) && (c < colNumber - 1) && map[r - 1][c + 1] == -1) {
                board[r][c]++;
            }
            if ((r < rowNumber - 1) && (c > 0) && map[r + 1][c - 1] == -1) {
                board[r][c]++;
            }
            if ((r < rowNumber - 1) && (c < colNumber - 1) && map[r + 1][c + 1] == -1) {
                board[r ][c]++;
            }
            if (board[r][c] == 0){
                board[r][c] = -2;
            }
        }

    }



    public void minePlacement() {
        int randomRow, randomCol, count = 0;

        while (count != this.size / 4) {
            randomRow = random.nextInt(rowNumber);
            randomCol = random.nextInt(colNumber);
            if (map[randomRow][randomCol] != -1) {
                map[randomRow][randomCol] = -1;
                count++;
            }
        }
    }

    public void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
