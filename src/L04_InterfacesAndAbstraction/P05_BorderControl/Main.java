package L04_InterfacesAndAbstraction.P05_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> robots = new ArrayList<>();
        List<Identifiable> citizens = new ArrayList<>();

        String line = scanner.nextLine();
        while (!"End".equals(line)) {
            String[] input = line.split("\\s+");
            if (input.length == 2) {
                Robot robot = new Robot(input[1], input[0]);
                robots.add(robot);
            } else {
                Citizen citizen = new Citizen(input[0], Integer.parseInt(input[1]), input[2]);
                citizens.add(citizen);
            }

            line = scanner.nextLine();
        }

        String lastDigit = scanner.nextLine();

        printFakeId(robots, lastDigit);
        printFakeId(citizens, lastDigit);
    }

    private static void printFakeId(List<Identifiable> list, String lastDigit) {
        for (Identifiable element : list) {
            if (element.getId().endsWith(lastDigit)) {
                System.out.println(element.getId());
            }
        }
    }
}
