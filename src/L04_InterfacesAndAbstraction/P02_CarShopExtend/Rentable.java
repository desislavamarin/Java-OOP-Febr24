package L04_InterfacesAndAbstraction.P02_CarShopExtend;

public interface Rentable extends Car{

    Integer getMinRentDay();
    Double getPricePerDay();
}
