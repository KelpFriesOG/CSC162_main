package notes;

import java.io.Serializable;

public class Car {

    // #region Class variables

    private String name;
    private String brand;
    private int yearOfProd;
    private static int instances = 0;
    // Static variables are carried through all instances of the class

    // #endregion

    // #region Constructors

    public Car() { // Default constructor
        this.name = "Undefined";
        this.brand = "Undefined";
        this.yearOfProd = 0000;
        instances++;
    }

    public Car(String name) { // Overloaded constructor
        this.name = name;
        instances++;
    }

    public Car(String brand, int year, String name) { // Overloaded constructor
        this.brand = brand;
        this.yearOfProd = year;
        this.name = name;
        instances++;
    }

    // #endregion

    // #region Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfProd() {
        return yearOfProd;
    }

    public void setYearOfProd(int yearOfProd) {
        this.yearOfProd = yearOfProd;
    }

    // #endregion

    // #region Methods

    public void accel() {
        System.out.println("Vroom vroom!!!");
    }

    public boolean equals(Car car) {

        boolean isIdentical = car.getBrand() == this.brand &&
                car.getName() == this.name &&
                car.getYearOfProd() == this.yearOfProd;

        return isIdentical;
    }

    public static String nInstances() {
        return (instances + " cars have been created.");
    }

    public String toString() {
        String message = "Car specs: \nName: " + this.name +
                "\nBrand: " + this.brand +
                "\nYear: " + this.yearOfProd;
        return message;
    }

    // #endregion

    public static void main(String[] args) {
        Car hondaCar = new Car();
        Car mercedesCar = new Car();
        // Tesla myTesla = new Tesla();

        System.out.println("Are the two cars identical? : " + hondaCar.equals(mercedesCar));

        hondaCar.setBrand("Honda");
        mercedesCar.setBrand("Mercedes");

        System.out.println("Are the two cars identical? : " + hondaCar.equals(mercedesCar));

        System.out.println(Car.nInstances());

    }
}
