package notes;

public class Chapter9 {
    /*
     * Chapter 9: Objects and Classes
     * 
     * Objectives:
     * - To describe objects and classes, and use classes to model objects.
     * - To use UML graphical notation to describe classes and objects.
     * - To demonstrate how to define classes and create objects.
     * - To create objects via constructors.
     * - To define a reference variable using a reference type and
     * access objects via object reference variables.
     * - To access an object's data and methods using the object member
     * access operator ( '.' )
     * - To define data fields of reference types and assign default
     * values for an object's data fields.
     * - To distinguish between object reference variables and primitive
     * data variables.
     * - Learn to use Date, Random, and Point2D classes.
     * - To distinguish between instance and static variables and methods.
     * - To define private data fields with appropriate getter and setter
     * methods. (Encapsulation)
     * - To encapsulate data fields to make classes easy to maintain.
     * - To develop methods with object arguments and differentiate between
     * primitive type arguments and object type arguments.
     * - To store in and process arrays.
     * - To create immutable objects from immutable classes to protect
     * object contents.
     * - To determine the scope of variables in the context of the class.
     * - To use the keyword this to refer to the calling object itself.
     * 
     * 
     * Classes are nouns, attributes are the state (descriptors) and
     * methods are verbs (actions).
     * 
     * 
     * primitive data types begin with a lowercase letter by convention,
     * but object reference variables begin with a capital letter.
     * 
     * Ex.
     * 
     * Car honda = new Car(); // the "new" helps allocates memory for the instance.
     * Scanner kbd = new Scanner(System.in); // Notice how this follows the format.
     * honda.accel(); // The . (member access operator) allows us to call methods
     * 
     * ---------------------------------
     * 
     * When you create a class you need to create a constructor within it,
     * if you plan on making objects with the class.
     * 
     * Constructors have the same name as the class
     * 
     * - If you want to create an object with no parameters
     * you don't need to specify any constructor, Java just
     * provides an invisible default constructor.
     * 
     * - If you create your own constructors to explicitly pass
     * parameters, then you should create an default constructor,
     * if you still want the ability to instantiate the class with
     * no parameters. JAVA DOES NOT PROVIDE YOU A DEFAULT
     * CONTRUCTOR IF YOU CREATE AN OVERLOADED ONE.
     * 
     * Based on how you create the object, Java dynamically chooses
     * if there is an appropriate constructor to call. We will talk
     * about dynamic binding later.
     * 
     * TLDR: Empty constructor is given by default if no other constructor
     * is specified. The empty constructor is known as the default or
     * no-arg constructor.
     * 
     * ex.
     * 
     * public Car(int year, String model, String brand){
     * this.year = year; //
     * this.model = model;
     * this.brand = brand;
     * }
     * 
     * To instantiate:
     * Car honda = new Car(2002, "Civic", "Honda");
     * 
     * ---------------------------------
     * 
     * An object has a state and a behavior, the state consists of properties,
     * the behavior is what it can do.
     * 
     * -> Classes are constructs that define objects of the same type.
     * Ex. A goose egg and a chicken egg are both Eggs.
     * The Egg class can define both types of eggs.
     * 
     * ---------------------------------
     * 
     * UML Diagrams are drawn as a way of planning how you want
     * to implement your class. You are basically blueprinting a class
     * prior to implemeneting it for the purposes of documenting it.
     * 
     * ex.
     * 
     * TV
     * ------------------------------------------------
     * channel: int ___________________________________|
     * volumeLevel: int _______________________________| ATTRIBUTES
     * on: boolean ____________________________________|
     * ------------------------------------------------
     * +TV() <--- Constructor
     * +turnOn(): void ________________________________|
     * +turnOff(): void _______________________________| METHODS
     * +setChannel(newChannel: int): void _____________|
     * ------------------------------------------------
     * 
     * ---------------------------------
     * 
     * 
     * 
     * ---------------------------------
     */

    public static void main(String[] args) {

    }

}
