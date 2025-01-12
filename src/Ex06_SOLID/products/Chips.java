package Ex06_SOLID.products;

import Ex06_SOLID.Food;
import Ex06_SOLID.Product;

public class Chips implements Product, Food {
    public static final double CALORIES_PER_100_GRAMS = 529;
    private double grams;

    public Chips(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double amountOfCalories() {
        return CALORIES_PER_100_GRAMS / 100 * getGrams();
    }

    @Override
    public double amountOfFood() {
        return getGrams() / 1000;
    }
}
