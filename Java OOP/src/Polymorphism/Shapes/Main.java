package Polymorphism.Shapes;

public class Main {
    public static void main(String[] args) {
        Shape rect = new Rectangle(3D, 5D);
        Shape circ = new Circle(5D);
        System.out.println(rect.getArea());
        System.out.println(rect.getPerimeter());
        System.out.println(circ.getArea());
        System.out.println(circ.getPerimeter());
    }
}
