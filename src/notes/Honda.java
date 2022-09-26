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

    /*
     * This method DOES NOT exist in the parent class. Even if it existed
     * in the parent class, the compiler will check the child class first
     * and use the method from the child class.
     * 
     * This is method overriding.
     * 
     * Method overriding occurs when method names and parameters are identical
     * but one method belongs in a class whereas the other method
     * exists in a superclass of the original class.
     * 
     * Method overriding is useful for overwriting methods which are augmented
     * by the subclass to reflect an implementation more specific to the
     * subclass.
     * 
     * Having the original method in the superclass also means that you do
     * not have to write the same method twice, you can just exclude it 
     * and the method from the superclass will be called.
     * 
     * If you created a Car object and tried calling drive(),
     * it would throw an error.
     * 
     * If you created a Honda object and tried calling the drive()
     * method you would be calling Honda's drive method.
     * 
     */
    public static void drive() {

    }
}
