package L05_Polymorphism.P02_Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        this.calculateArea();
        this.calculatePerimeter();
    }

    public final Double getRadius() {
        return radius;
    }

    protected void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * Math.PI * radius);
    }

    @Override
    protected void calculateArea() {
        setArea(Math.PI * Math.pow(radius, 2));
    }
}
