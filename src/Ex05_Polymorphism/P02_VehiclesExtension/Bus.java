package Ex05_Polymorphism.P02_VehiclesExtension;

public class Bus extends VehicleImpl{
    private static final boolean DEFAULT_IS_EMPTY = true;
    private static final boolean DEFAULT_IS_AC_ON = false;
    private boolean isEmpty;
    private boolean isAcOn;

    public Bus(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = DEFAULT_IS_EMPTY;
        this.isAcOn = DEFAULT_IS_AC_ON;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public String drive(double distance) {
        if (isAcOn) {
            super.setFuelConsumption(super.getFuelConsumption() - 1.4);
            isAcOn = false;
        }
        if (!isEmpty) {
            super.setFuelConsumption(super.getFuelConsumption() + 1.4);
            this.isAcOn = true;
        }
        return super.drive(distance);
    }
}
