package Ex03_Inheritance.P06_Animals;

import Ex03_Inheritance.P06_Animals.Animals.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        while (!"Beast!".equals(line)){
            try {
                switch (line){
                    case "Cat":
                        String[] input = scanner.nextLine().split("\\s+");
                        Cat cat = new Cat(input[0], Integer.parseInt(input[1]), input[2]);
                        System.out.println(cat);
                        break;
                    case "Frog":
                        input = scanner.nextLine().split("\\s+");
                        Frog frog = new Frog(input[0], Integer.parseInt(input[1]), input[2]);
                        System.out.println(frog);
                        break;
                    case "Dog":
                        input = scanner.nextLine().split("\\s+");
                        Dog dog = new Dog(input[0], Integer.parseInt(input[1]), input[2]);
                        System.out.println(dog);
                        break;
                    case "Kitten":
                        input = scanner.nextLine().split("\\s+");
                        Kitten kitten = new Kitten(input[0], Integer.parseInt(input[1]));
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        input = scanner.nextLine().split("\\s+");
                        Tomcat tomcat = new Tomcat(input[0], Integer.parseInt(input[1]));
                        System.out.println(tomcat);
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            line = scanner.nextLine();
        }
    }
}
