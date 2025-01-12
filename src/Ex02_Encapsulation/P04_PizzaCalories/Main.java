package Ex02_Encapsulation.P04_PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaTokens = scanner.nextLine().split("\\s+");
        String[] doughTokens = scanner.nextLine().split("\\s+");

        Pizza pizza;
        try {
            int numberOfTopping = Integer.parseInt(pizzaTokens[2]);
            pizza = new Pizza(pizzaTokens[1], numberOfTopping);

            Dough dough = new Dough(doughTokens[1], doughTokens[2], Double.parseDouble(doughTokens[3]));

            pizza.setDough(dough);
            while (numberOfTopping > 0) {
                String[] toppingTokens = scanner.nextLine().split("\\s+");
                Topping topping = new Topping(toppingTokens[1], Double.parseDouble(toppingTokens[2]));
                pizza.addTopping(topping);

                numberOfTopping--;
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return;
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
