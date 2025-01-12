package Ex06_SOLID;

import java.util.List;

public class CalorieCalculator implements Calculator{

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";


    public double sum(List<Food> products) {
        return products.stream().mapToDouble(Product::amountOfCalories).sum();
    }

    public double average(List<Food> products) {
        return sum(products) / products.size();
    }
}