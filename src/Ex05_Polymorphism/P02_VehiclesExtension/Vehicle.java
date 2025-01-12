package Ex05_Polymorphism.P02_VehiclesExtension;

public interface Vehicle {
    String drive (double distance);
    void refuel(double liters);
    default void setEmpty(boolean empty){

    }
}
