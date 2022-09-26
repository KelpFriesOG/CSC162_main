package notes;

public class Tesla extends Car {

    public boolean isElectric = true;
    public double battery = 100;

    /* If we create a Tesla, it calls one of the Tesla constructors. */
    public Tesla(String brand, int year, String name, double battery) {
        super(brand, year, name);
        this.battery = battery;
    }

    public Tesla() {
        // super();
        // The super constructor is called implicitly via the compiler.
    }

    public void accel() {
        /*
         * This accel method is called for a Tesla object instead of the
         * Car's method. If the this class did not have the accel method,
         * then an object of this class would call the accel method from
         * the parent class.
         */
        System.out.println("This is an electric car, its silent.");
    }

    public double getBettery() {
        return battery;
    }

    public void chargeBattery() {
        this.battery = 100;
    }

    /*
     * Note how this toString method overrides the toString method
     * in the Car class and makes use of the Car class's toString
     * method (by using super constructor) and simply appends to it.
     */
    public String toString() {
        return super.toString() + "\n This is also an electric car!";
    }

}
