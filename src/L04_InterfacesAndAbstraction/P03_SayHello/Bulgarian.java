package L04_InterfacesAndAbstraction.P03_SayHello;

public class Bulgarian implements Person{
    private String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String sayHello(){
        return "Здравей";
    }
}
