package WorkingWithAbstraction.PointInRectangle;

import Input.Reader;

public class Main {
    public static void main(String[] args) {
        int[] rectanglePoints = Reader.readIntArray("\\s+");
        Point A = new Point(rectanglePoints[0], rectanglePoints[1]);
        Point B = new Point(rectanglePoints[2], rectanglePoints[3]);

        Rectangle rec = new Rectangle(A, B);
        int count = Reader.readIntArray("\\s+")[0];

        for (int i = 1; i <= count ; i++) {
            int[] singlePoint = Reader.readIntArray("\\s+");
            Point P  = new Point(singlePoint[0], singlePoint[1]);
           boolean isInRectangle = rec.contains(P);

            System.out.println(isInRectangle);
        }
    }
}
