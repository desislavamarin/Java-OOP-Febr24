package L02_Encapsulation.P04_FirstAndReserveTeam;

import java.text.DecimalFormat;

public class Person {

    private static final String TO_STRING_TEMPLATE = "%s %s gets %s leva";
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
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
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
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
