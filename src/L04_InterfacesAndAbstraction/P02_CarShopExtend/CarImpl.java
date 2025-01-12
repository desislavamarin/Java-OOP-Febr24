package L04_InterfacesAndAbstraction.P02_CarShopExtend;

public class CarImpl implements Car {

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduces;

    public CarImpl(String model, String color, Integer horsePower, String countryProduces) {
        this.setModel(model);
        this.setColor(color);
        this.setHorsePower(horsePower);
        this.setCountryProduces(countryProduces);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String getCountryProduced() {
        return this.countryProduces;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    private void setCountryProduces(String countryProduces) {
        this.countryProduces = countryProduces;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",
                this.model,
                this.countryProduces,
                Car.TIRES);
    }
}
