package L04_InterfacesAndAbstraction.P01_CarShop;

public interface Car {
    int TIRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}
