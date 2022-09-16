package notes;

public class InvalidRadiusException extends Exception {
    private double radius;

    /* Constructing an exception */
    public InvalidRadiusException(double radius) {
        super("Invalid radius :" + radius);
        // Constructor of Exception class accepts a string argument

        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
