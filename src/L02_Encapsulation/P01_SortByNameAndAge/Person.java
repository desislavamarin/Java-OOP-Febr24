package L02_Encapsulation.P01_SortByNameAndAge;

public class Person {
    private static final String TO_STRING_TEMPLATE = "%s %s is %d years old.";
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    @Override
    public String toString() {
        String template = TO_STRING_TEMPLATE;
        return String.format(template, getFirstName(), getLastName(), getAge());
    }
}
