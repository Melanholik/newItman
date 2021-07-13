package lessonTicTacToe;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] chars = new int[3][3];

        chars = new int[][]{{1, 1, 2}, {1, 2, 0}, {2, 0, 0}};
        System.out.println(determineWinner(chars));



        int player = 1;
        print(chars);
        System.out.println("Player " + player + " (X) turn. Enter column and row (between 1 and 3):");
        System.out.println();

        while (scanner.hasNextInt()) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (player == 1) {
                chars[a - 1][b - 1] = 1;
                player++;
            } else {
                chars[a - 1][b - 1] = -1;
                player--;
            }
            print(chars);
            if (player == 1) {
                System.out.println("Player " + player + " (X) turn. Enter column and row (between 1 and 3):");
            } else {
                System.out.println("Player " + player + " (0) turn. Enter column and row (between 1 and 3):");
            }
            System.out.println();
        }
        System.out.println("Draw");
    }


    /*public static void printArray(int[][] ints) {
        for (int[] anInt : ints) {
            for (int j = 0; j < ints[0].length; j++) {
                if (anInt[j] == 0) {
                    System.out.print(" ");
                } else if (anInt[j] == 1) {
                    System.out.print("X");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        System.out.println();
    }*/

    public static void print(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("   ");
                } else  if (grid[i][j] == 1){
                    System.out.print(" X ");
                } else  {
                    System.out.print(" 0 ");
                }
                if (j != grid[i].length - 1) {
                    System.out.print("┃");
                }
            }
            System.out.println();
            if (i != grid.length - 1){
                for (int j = 0; j < grid[i].length; j++) {
                    System.out.print("━━━");
                    if (j != grid[i].length - 1) {
                        System.out.print("╋");
                    }
                }
            }
            System.out.println();
        }
    }

    public static int determineWinner(int[][] grid){
        boolean isFirstWin = true;
        boolean isSecondWin = true;
        boolean HaveFirst = false;
        boolean HaveSecond = false;

        boolean itIsDrow = true;

        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1){
                    HaveFirst = true;
                    isSecondWin = false;
                } else if (grid[i][j] == 2){
                    isFirstWin = false;
                    HaveSecond = true;
                } else {
                    isFirstWin = false;
                    isSecondWin = false;
                }
            }
            if (isFirstWin){
                return 1;
            } else if (isSecondWin){
                return 2;
            }
            if (!HaveFirst || !HaveSecond) {
                itIsDrow =false;
            }
            isFirstWin = true;
            isSecondWin = true;
            HaveFirst = false;
            HaveSecond = false;
        }

        for (int j = 0; j < grid[0].length ; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1){
                    HaveFirst = true;
                    isSecondWin = false;
                } else if (grid[i][j] == 2){
                    isFirstWin = false;
                    HaveSecond = true;
                } else {
                    isFirstWin = false;
                    isSecondWin = false;
                }
            }
            if (isFirstWin){
                return 1;
            } else if (isSecondWin){
                return 2;
            }
            if (!HaveFirst || !HaveSecond) {
                itIsDrow =false;
            }
            isFirstWin = true;
            isSecondWin = true;
            HaveFirst = false;
            HaveSecond = false;
        }

        for (int i = 0; i < grid.length ; i++) {
            if (grid[i][i] == 1) {
                HaveFirst = true;
                isSecondWin = false;
            } else if (grid[i][i] == 2) {
                isFirstWin = false;
                HaveSecond = true;
            } else {
                isFirstWin = false;
                isSecondWin = false;
            }
        }
            if (isFirstWin){
                return 1;
            } else if (isSecondWin){
                return 2;
            }
            if (!HaveFirst || !HaveSecond) {
                itIsDrow =false;
            }
            isFirstWin = true;
            isSecondWin = true;
            HaveFirst = false;
            HaveSecond = false;

        for (int i = grid.length -1; i > -1 ; i--) {
            if (grid[i][grid.length -1-i] == 1) {
                HaveFirst = true;
                isSecondWin = false;
            } else if (grid[i][grid.length -1-i] == 2) {
                isFirstWin = false;
                HaveSecond = true;
            } else {
                isFirstWin = false;
                isSecondWin = false;
            }
        }
            if (isFirstWin){
                return 1;
            } else if (isSecondWin){
                return 2;
            }
            if (!HaveFirst || !HaveSecond) {
                itIsDrow =false;
            }
            isFirstWin = true;
            isSecondWin = true;
            HaveFirst = false;
            HaveSecond = false;

        if (itIsDrow) {
            return -1;
        } else  return 0;

    }

}