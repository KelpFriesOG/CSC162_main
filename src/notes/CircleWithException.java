package notes;

public class CircleWithException {
    private double radius;
    private static int numberOfObjects = 0;

    // #region Constructors

    public CircleWithException() {
        this(1.0);
    }

    public CircleWithException(double radius) {

    }

    // #endregion

    // #region Getters and Setters

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius)
            throws IllegalArgumentException {
        // this.radius = radius;
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        } else {
            this.radius = radius;
        }
        // Makes it so that the radius can only be set to
        // a positive value

    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    // #endregion

    // #region Methods

    public double findArea() {
        return radius * radius * Math.PI;
    }

    

    // #endregion
}
