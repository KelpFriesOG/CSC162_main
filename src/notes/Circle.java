package notes;

public class Circle {
    private double radius;
    private static int numberOfObjects = 0;

    public Circle() throws InvalidRadiusException {
        this(1.0);
    }

    public Circle(double radius)
            throws InvalidRadiusException {
        if (radius >= 0) {
            this.radius = radius;
            numberOfObjects++;
        } else
            throw new InvalidRadiusException(radius);

    }

    public void setRadius(double radius)
            throws InvalidRadiusException {
        if (radius >= 0)
            this.radius = radius;
        else
            throw new InvalidRadiusException(radius);
    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    public double findArea() {
        return radius * radius * Math.PI;
    }

}
