package Ex05_Polymorphism.P01_Vehicles;

public class Truck extends VehicleImpl{
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
