package labs;

import notes.GeometricObject;

public class Triangle extends GeometricObject {

    /*
     * Note that the triangle object is IMMUTTABLE
     * because it contains not getters, setters, or
     * other methods that change its given values
     * in the constructor!
     */

    // #region Class Members

    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    // #endregion

    // #region Constructors

    public Triangle() {
        super();
        // Java implements this implicitly
        // if no other constructor is specified.
        // Its good practice nonetheless.
    }

    public Triangle(double side1, double side2, double side3,
            String color, boolean filled) throws IllegalTriangleException {
        super(color, filled);
        // Calls parent geometric object class
        // to pass these two values (you didn't need this for the lab.)

        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException();
        } else {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
    }

    // #endregion

    // #region Methods

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

    // #endregion
}
