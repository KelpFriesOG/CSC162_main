package practice.triangles;

public class Triangle {
    private double side1 = 1.0, side2 = 1.0, side3 = 1.0;

    public Triangle() {

    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(double side1, double side2, double angle, boolean degreeOrRad) {
        this.side1 = side1;
        this.side2 = side2;

        if (degreeOrRad) {
            this.side3 = Math.sqrt(Math.pow(side1, 2) +
                    Math.pow(side2, 2) - 2 * side1 * side2 * Math.cos(angle));
        } else {
            this.side3 = Math.sqrt(Math.pow(side1, 2) +
                    Math.pow(side2, 2) - 2 * side1 * side2 * Math.cos(Math.toRadians(angle)));
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
