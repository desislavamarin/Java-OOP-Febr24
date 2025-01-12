package Ex05_Polymorphism.P01_Vehicles;

import Ex05_Polymorphism.P01_Vehicles.Vehicle;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public VehicleImpl(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String drive(double distance) {
        DecimalFormat df = new DecimalFormat("#.##");
        double neededFuel = this.fuelConsumption * distance;
        String result = String.format("%s needs refueling", this.getClass().getSimpleName());
        if (this.fuelQuantity >= neededFuel) {
            result = String.format("%s travelled %s km", this.getClass().getSimpleName(),
                    df.format(distance));
            this.fuelQuantity -= neededFuel;
        }
        return result;
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
