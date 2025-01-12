package Ex05_Polymorphism.P02_VehiclesExtension;

public class Car extends VehicleImpl {
    public Car(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption + 0.9, tankCapacity);
    }
}
