package Ex01_WorkingWithAbstraction.P05_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        Galaxy galaxy = new Galaxy(dimensions[0], dimensions[1]);
        JediMovements jediMovements = new JediMovements(galaxy);

        String command = scanner.nextLine();
        long sum = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] playerPositions = Arrays.stream(command.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] enemyPositions = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            jediMovements.destroyStars(enemyPositions);
            sum += jediMovements.sumOfStars(playerPositions);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }
}
