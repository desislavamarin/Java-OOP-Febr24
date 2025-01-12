package L04_InterfacesAndAbstraction.P02_CarShopExtend;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("%nLeon sells for %f", this.getPrice());
    }
}
