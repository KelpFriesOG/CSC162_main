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
     * Car honda = new Car(); // the "new" allocates memory for the instance.
     * Scanner kbd = new Scanner(System.in); // This follows the format.
     * honda.accel(); // The . (member access operator) allows to call methods
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
     * Data fields can be of reference types. A good example
     * is the String type.
     * 
     * ex.
     * public class Student{
     * 
     * String name; // Default value of null
     * int age; // Default value of 0
     * boolean isScienceMajor; // Default value of false.
     * char grade; // Default value of '\u0000'
     * 
     * }
     * 
     * If we construct the class without changing the properties
     * and call the name, we will get a NullPointerException.
     * 
     * ---------------------------------
     * 
     * Primitive data types do not need a reference pointer.
     * 
     * ex.
     * int i = 1; // value of i == 1
     * Circle c = new Circle(); // Points to the entore Circle class instance
     * 
     * If you try to make two objects equal to one another, you are
     * moving references.
     * 
     * ex.
     * Circle c1 = new Circle();
     * Circle c2 = new Circle();
     * c1 = c2 // c1 now points to c2, which points to an object instance
     * 
     * ---------------------------------
     * 
     * The Date() class
     * 
     * Date
     * +Date()
     * +Date(elapseTime: long)
     * 
     * 
     * ---------------------------------
     * The toString method is provided to almost every
     * Java builtin class to provide a quick definition
     * of the object it is called on.
     * 
     * We should also create a toString method to document
     * our classes / objects.
     * ---------------------------------
     * 
     * Objects cannot be compared in the same way as
     * primitives, we need to use a custom method
     * to compare two Objects.
     * 
     * Consider the String class.
     * We will encounter
     * 
     * ---------------------------------
     * 
     * Static variables are shared by all instances of a class.
     * 
     * -> Static methods are not tied to a specific object,
     * you can call the method without an instance of the class.
     * -> Static constants are final variables shared by all
     * instances of the class.
     * 
     * ---------------------------------
     * 
     * Public classes, data or methods are visible to any class in any
     * package.
     * 
     * Private data and methods can only be accessed by the declaring class.
     * -> Getters and setters are used to expose the private methods to
     * read and modify private variables outside of the class.
     * 
     * Typically setter:
     * public void setAge(int age){
     * this.age = age // Left side refers to internal member
     * // Right side referers to the passed age.
     * }
     * 
     * Typically getter (almost always no parameters need to be passed):
     * public int getAge(){
     * return this.age;
     * }
     * 
     * ---------------------------------
     * 
     * Data should be private to increase security
     * and enable easy maintainence.
     * 
     * ---------------------------------
     * 
     * When we pass parameters we can also pass whole
     * objects via methods.
     * -> When we pass objects we pass the reference variable
     * for the object.
     * 
     * ---------------------------------
     * 
     * When you create an arry of objects you are actually
     * creating an array of reference variables.
     * 
     * Ex. Circle[] cArray = new Circle[10]
     * If we invoke cArray[1].getArea() it involves two levels of
     * referencing. cArray references the entire array,
     * cArray[1] refers to the second value in the array which itself
     * is a reference to a Circle() object.
     * 
     * ---------------------------------
     * 
     * Immutable objects and classes cannot be changed.
     * 
     * If the class is private it is immutable, you cannot create
     * objects of the class. The private class must have only private
     * variables and methods.
     * 
     * If an object is immutable we cannot index it or modify
     * its contents with traditional methods.
     * 
     * ---------------------------------
     * 
     * Passing information between classes by making an object
     * of a class a member of another class is a practice called composition.
     * 
     * 
     * 
     * ---------------------------------
     * 
     * The scope of instance and static variables is anywhere within
     * the class.
     * -> The scope of a local variable starts from its declaration and
     * continues to the end of the block that contains the variable. A local
     * variable must be initialized explicitly before being used.
     * 
     * ---------------------------------
     */

    public static void main(String[] args) {

    }

}
