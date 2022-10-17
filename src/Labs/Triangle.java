package labs;

import notes.GeometricObject;

public class Triangle extends GeometricObject {
    private double side1 = 1.0, side2 = 1.0, side3 = 1.0;

    public Triangle() {
        super(); // Java implements this implicitly
    }

    public Triangle(double side1, double side2, double side3,
            String color, boolean filled) throws IllegalTriangleException {
        super(color, filled);

        if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1) {
            throw new IllegalTriangleException();
        } else {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
    }

    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - side1) *
                (semiPerimeter - side2) * (semiPerimeter - side3));
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = "
                + side2 + " side3 = " + side3;
    }
}
