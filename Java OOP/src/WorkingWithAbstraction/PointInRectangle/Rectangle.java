package WorkingWithAbstraction.PointInRectangle;

public class Rectangle {
    private final Point A;
    private final Point B;


    public Rectangle(Point a, Point b) {
        this.A = a;
        this.B = b;
    }

    public boolean contains(Point P) {
        return P.greaterOrEqual(A) && P.lessOrEqual(B);
    }
}
