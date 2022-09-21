package notes;

public class Car {
    private String name;
    private String brand;
    private int yearOfProd;


    public Car(){ // Default constructor
        this.name = "Undefined";
    }

    public Car(String name){ // Overloaded constructor
        this.name = name;
    }

    public Car(String brand, int year, String name){ // Overloaded constructor
        this.brand = brand;
        this.yearOfProd = year;
        this.name = name;
    }

}
