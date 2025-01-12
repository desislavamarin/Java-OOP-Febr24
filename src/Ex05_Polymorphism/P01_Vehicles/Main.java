package Ex05_Polymorphism.P01_Vehicles;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carTokens = scanner.nextLine().split("\\s+");
        String[] truckTokens = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carTokens[1]),
                Double.parseDouble(carTokens[2]));
        Truck truck = new Truck(Double.parseDouble(truckTokens[1]),
                Double.parseDouble(truckTokens[2]));

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, VehicleImpl> vehicleMap = Map.of("Car", car, "Truck", truck);

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]){
                case "Drive":
                    String driveResult = vehicleMap.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
                    System.out.println(driveResult);
                    break;
                case "Refuel":
                    vehicleMap.get(tokens[1]).refuel(Double.parseDouble(tokens[2]));
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
