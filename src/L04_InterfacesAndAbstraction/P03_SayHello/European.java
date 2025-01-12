package L04_InterfacesAndAbstraction.P03_SayHello;

public class European implements Person{
    private String name;

    public European(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
