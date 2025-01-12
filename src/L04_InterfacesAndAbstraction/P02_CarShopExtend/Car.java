package L04_InterfacesAndAbstraction.P02_CarShopExtend;

public interface Car {
    int TIRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String getCountryProduced();
}
