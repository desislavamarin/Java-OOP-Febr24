package Ex03_Inheritance.P05_Restaurant.Food;

import java.math.BigDecimal;

public class Cake extends Dessert{
    private final static double CAKE_GRAMS = 250;
    private final static double CAKE_CALORIES = 1000;
    private final static BigDecimal CAKE_PRICE = new BigDecimal(5);
    public Cake(String name) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }
}
