package L02_Encapsulation.P02_SalaryIncrease;

import java.text.DecimalFormat;

public class Person {

    private static final String TO_STRING_TEMPLATE = "%s %s gets %s leva";
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() < 30) {
            this.salary += this.getSalary() * bonus / 200;
        } else {
            this.salary += this.getSalary() * bonus / 100;
        }
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.0##");
        String template = TO_STRING_TEMPLATE;
        return String.format(template, getFirstName(), getLastName(), format.format(this.salary));
    }
}
