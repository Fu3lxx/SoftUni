package Polimorphism_Lab._2Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }


    @Override
    public Double calculatePerimeter() {
        return Math.PI * radius * radius;
    }

    @Override
    public Double calculateArea() {
        return radius * 2;
    }

    public final Double getRadius() {
        return radius;
    }
}
