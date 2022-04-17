package Polymorphism.Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public Double getPerimeter() {
        if (perimeter==null) {
            calculatePerimeter();
        }
        return perimeter;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getArea() {
        if (area == null) {
            calculateArea();
        }
        return area;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

  protected   abstract void calculatePerimeter();
   protected abstract void calculateArea();
}
