package Ex03_Inheritance.P05_Restaurant.Food;

import java.math.BigDecimal;

public class Dessert extends Food{
    private double calories;
    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }
}
