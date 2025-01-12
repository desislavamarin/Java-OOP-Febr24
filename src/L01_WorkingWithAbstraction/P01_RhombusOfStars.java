package L01_WorkingWithAbstraction;

import java.util.Scanner;

public class P01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            printRow(n, i);
        }
        for (int i = n - 1; i >= 1 ; i--) {
            printRow(n, i);
        }
    }

    static void printRow(int figureSize, int countStars) {
        for (int spaces = 0; spaces < figureSize - countStars; spaces++) {
            System.out.print(" ");
        }
        for (int stars = 1; stars < countStars; stars++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
