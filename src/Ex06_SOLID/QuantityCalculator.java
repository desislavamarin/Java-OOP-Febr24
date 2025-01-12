package Ex06_SOLID;

import java.util.List;

public class QuantityCalculator implements Calculator{

    @Override
    public double sum(List<Food> products) {
        return products.stream().mapToDouble(Food::amountOfFood).sum();
    }

    @Override
    public double average(List<Food> products) {
        return sum(products) / products.size();
    }
}
