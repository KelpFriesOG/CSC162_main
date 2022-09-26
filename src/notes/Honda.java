package notes;

public class Honda extends Car {

    /* If we create a Honda, it calls the Car constructor. */

    public void accel() {
        // This method overrides the method from the parent Car class.
        /*
         * This accel method is called for a Honda object instead of the
         * Car's method. If the this class did not have the accel method,
         * then an object of this class would call the accel method from
         * the parent class.
         */
        System.out.println("Vroom! Vrooom!! its a Honda.");
    }
}
