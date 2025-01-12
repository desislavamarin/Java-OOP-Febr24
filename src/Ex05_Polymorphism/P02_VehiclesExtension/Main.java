package Ex05_Polymorphism.P02_VehiclesExtension;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carTokens = scanner.nextLine().split("\\s+");
        String[] truckTokens = scanner.nextLine().split("\\s+");
        String[] busTokens = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carTokens[1]),
                Double.parseDouble(carTokens[2]),
                Integer.parseInt(carTokens[3]));

        Truck truck = new Truck(Double.parseDouble(truckTokens[1]),
                Double.parseDouble(truckTokens[2]),
                Integer.parseInt(truckTokens[3]));

        Bus bus = new Bus(Double.parseDouble(busTokens[1]),
                Double.parseDouble(busTokens[2]),
                Integer.parseInt(busTokens[3]));

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, VehicleImpl> vehicleMap = Map.of("Car", car, "Truck", truck, "Bus", bus);

        for (int i = 0; i < n; i++) {
            try {
                String[] tokens = scanner.nextLine().split("\\s+");
                switch (tokens[0]){
                    case "Drive":
                        VehicleImpl vehicle = vehicleMap.get(tokens[1]);
                        vehicle.setEmpty(false);
                        String driveResult = vehicle.drive(Double.parseDouble(tokens[2]));
                        System.out.println(driveResult);
                        break;
                    case "DriveEmpty":
                        vehicle = vehicleMap.get(tokens[1]);
                        vehicle.setEmpty(true);
                        driveResult = vehicle.drive(Double.parseDouble(tokens[2]));
                        System.out.println(driveResult);
                        break;
                    case "Refuel":
                        vehicleMap.get(tokens[1]).refuel(Double.parseDouble(tokens[2]));
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
