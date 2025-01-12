package Ex02_Encapsulation.P03_ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Person> people = new LinkedHashMap<>();
        Map<String,Product> products = new LinkedHashMap<>();

        try {
            Arrays.stream(scanner.nextLine().split(";"))
                    .forEach(p -> {
                        String[] tokens = p.split("=");
                        Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                        people.put(person.getName(), person);
                    });

            Arrays.stream(scanner.nextLine().split(";"))
                    .forEach(p -> {
                        String[] tokens = p.split("=");
                        Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                        products.put(product.getName(), product);
                    });
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String line = scanner.nextLine();
        while (!"END".equals(line)) {
            String[] input = line.split("\\s+");
            String personName = input[0];
            String productName = input[1];
            Person person = people.get(personName);
            Product product = products.get(productName);
            try {
                person.buyProduct(product);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            line = scanner.nextLine();
        }

        people.values().forEach(p -> {
            System.out.printf("%s - ",p.getName());
            if (p.getProducts().size() == 0) {
                System.out.printf("Nothing bought", p.getName());
            } else {
                String productName = p.getProducts()
                        .stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", "));
                System.out.println(productName);
            }
        });
    }
}
