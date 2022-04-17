package Polymorphism.Shapes;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;

    }

    public Double getRadius() {
        return radius;
    }

    @Override
   public void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
   public void calculateArea() {
        super.setArea( Math.PI * Math.pow(this.radius, 2));
    }
}
