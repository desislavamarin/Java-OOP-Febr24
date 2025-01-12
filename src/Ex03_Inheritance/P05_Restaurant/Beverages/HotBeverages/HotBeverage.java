package Ex03_Inheritance.P05_Restaurant.Beverages.HotBeverages;

import Ex03_Inheritance.P05_Restaurant.Beverages.Beverage;

import java.math.BigDecimal;

public class HotBeverage extends Beverage {
    public HotBeverage(String name, BigDecimal price, double milliliters) {
        super(name, price, milliliters);
    }
}
