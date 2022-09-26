package notes;

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

    public String nInstances() {
        return (instances + " cars have been created.");
    }

    // #endregion

}
