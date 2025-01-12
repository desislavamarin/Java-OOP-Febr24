package L04_InterfacesAndAbstraction.P03_SayHello;

public class Chinese implements Person{
    private String name;

    public Chinese(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String sayHello() {
        return "Djydjybydjy";
    }
}
