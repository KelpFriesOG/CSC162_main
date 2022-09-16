package notes;

public class Chapter13 {
    /*
     * Chapter 13: Abstract Classes and Interfaces
     * 
     * Main Goals:
     * - Design and implement abstract classes
     * - Use the abstract Number class
     * - Processing a calendar using the Calendar and GreogrianCalendar classes
     * - Specify common behaviors for objects via interfaces
     * - Use the Comparable interface
     * - Use the Cloneable interface
     * - Compare and contrast the utility between concrete classes,
     * abstract classes, and interfaces.
     * - Use the Rational class for processing rational numbers.
     * - Understand class design guidelines and implement them.
     * 
     * 
     * An interface is for defining common behavior between classes
     * (regardless of whether or not they are related).
     * 
     * Abstract Classes---------------------------------------------------------
     * 
     * 
     * Abstract classes are abstract as opposed to concrete classes.
     * This means that they cannot be used to initialize objects but
     * rather act as blueprints for concrete classes that choose
     * to extend (inherit) them.
     * 
     * Oftentimes, a superclass of an object may be abstract and
     * therefore it would be impossible to implement an object of that
     * class's type.
     * 
     * What is the benefit of inheriting a abstract class as opposed
     * to a regular class?
     * 
     * Specifying that a class is abstract allows us to create
     * abstract methods within the class.
     * Abstract methods do not have to have any code beyond the header,
     * you can think of them as contracts that any extending
     * class bears the responsibility of implementing.
     * 
     * Example:
     * class GeometricObject{
     * private String color = "white"
     * ...
     * 
     * protected GeometricObject{
     * dateCreated = new java.util.Date
     * }
     * protected GeometricObject(String color, boolean filled){
     * this.color = color;
     * this.filled = filled;
     * }
     * // Getter and setters
     * ...
     * // Methods
     * public abstract double getArea();
     * public abstract double getPerimeter();
     * 
     * }
     * 
     * Note how the abstract methods can be defined with no implementation!
     * A class that contains abstract methods MUST be an ABSTRACT CLASS.
     * 
     * The constructor is defined as protected because it is intended to
     * only be used by GeometricObject 's subclasses. (it'll work fine if
     * protected was replaced with public, but protected is the better choice
     * for data safety).
     * 
     * Why should we have abstract methods?:
     * Well instead of overriding methods, abstract methods give us
     * the chance to start out with a clean slate when we do not
     * know how further subclasses or even the one extended class needs
     * to calculate the results of the method.
     * 
     * So think of it like declaring this is what you want the subclass to do
     * ahead of time, when you have no idea yet lol.
     * 
     * These abstract methods WILL for A FACT BE OVERRIDEN by inheriting
     * subclasses which have their own unique ways of calculating the
     * intended values. The formula for a Circle's area is different than
     * that of a Rectangle object.
     * So they both override the getArea() method a little differently.
     * 
     * Remember that dynamic binding ensures that the appropriate
     * method is called even if declare objects like so:
     * GeometricObject o1 = new Circle(5);
     * GeometricObject o2 = new Rectangle(5, 4);
     * 
     * If we wanted to compare the area between two classes we could
     * create a static method, either in any class (preferably in the
     * same class as the main method or the Geometric object class) to
     * take in two GeometricObject parameters and compare each
     * based on their getArea methods
     * 
     * Ex.
     * public static boolean equalArea(GeometricObject g1, GeometricObject g2){
     * return g1.getArea() == g2.getArea();
     * }
     * 
     * This would only work if both objects and by extension the GeometricObject
     * class has the getArea method (even if the method is abstract).
     * 
     * Some facts on Abstraact classes:
     * - Abstract methods CANNOT be contained in non-abstract classes.
     * - If a subclass of an abstract class does not want to implement
     * the parent's methods, it must still create the abstract method
     * for implementation further down the inheritance chain. Note
     * that this means that this subclass MUST ALSO BE ABSTRACT to
     * accomodate for the abstract method.
     * - As an extension of the previous point, a non-abstract subclass
     * of an abstract parent class MUST implement all abstract methods
     * defined in its superclass.
     * - Abstract classes can be defined with no abstract methods,
     * this is totally acceptable.
     * - This is highly unusual but a subclass can override a concrete
     * method from its parent class and make it abstract within its own
     * implementation. This is useful when a method implementation works
     * in the superclass but does not make any sense to have work in the
     * subclass. You are basically overriding for the purposes of avoiding
     * the parent's method in the child class.
     * - As an extension of the previous point, this also means that a
     * concrete class can have abstract subclasses!
     * - An abstract class cannot be created as an object but can
     * still be used as a datatype,
     * for example:
     * GeometricObject[] objects = new GeometricObject[10];
     * objects[0] = new Circle();
     * 
     * Where GeometricObject is an abstract class
     * 
     * Note how we are declaring that the array can contain any object of
     * type GeometricObject not including objects of the GeometricObject class
     * itself. That allows us to fill the array with objects of type Circle
     * or Rectangle (but something like objects[1] = new GeometricObject()
     * would throw an error).
     * 
     * Remember:
     * If a method is not abstract you need an implementation
     * (e.g. curly braces and internal code).
     * 
     * -------------------------------------------------------------------------
     * 
     * Have not covered Case Studies regarding Number and Calendar classes.
     * WIP
     * 
     * Interfaces---------------------------------------------------------------
     * 
     * Interfaces are very similar to abstract classes but intend to specify
     * common behavior between related or even unrelated classes.
     * 
     * You can use an interface similarly to how you
     * would use an abstract class. You can use it as a type for a reference
     * variable, as the result of casting, and most else. Similar
     * to an abstract class you cannot create instances of an interface
     * with the new operator (creating interface objects NOT allowed).
     * 
     * Interfaces are IMPLEMENTED as opposed to classes that are EXTENDED.
     * Both keywords illustrate the same attributes of inheritance, but
     * interfaces are meant to imply some sort of behavior or traits of
     * an object.
     * 
     * For Example:
     * public interface Edible{
     * public abstract String howToEat();
     * }
     * 
     * abstract class Animal{
     * private double weight;
     * 
     * public double getWeight(){
     * return weight;
     * }
     * 
     * public abstract String sound();
     * 
     * }
     * 
     * class Chicken extends Animal implements Edible{
     * 
     * }
     * 
     * class Apple extends Fruit implements Edible{
     * 
     * }
     * 
     * The Chicken class IS an Animal and IS Edible.
     * The Apple class IS a Fruit and IS Edible.
     * 
     * Even though the Chicken and Apple class are part of distinct
     * inheritance schemes, both of them will be an instance of the Edible
     * interface and therefore both classes will need to implement
     * the howToEat method!
     * 
     * If we wanted to check if either was in fact edible we could try:
     * Fruit a = new Apple();
     * if(a instanceof Edible){
     * a.howToEat();
     * }
     * 
     * That should run fine given that howToEat() is implemented in the Apple
     * class. We could also modify the header of the Fruit class
     * abstract class Fruit implements Edible{
     * 
     * }
     * And since the class is abstract it could choose to leave edible
     * unimplemented which would force us to implement it in the subclass
     * Apple. Or it could be implemented in Fruit and left out
     * of the Apple class.
     * 
     * Well we know that a method in an abstract class can have a body,
     * and the same goes for interfaces. In fact, methods in interfaces
     * can be static, abstract, and/or concrete (in the form of default
     * methods). But static methods and default methods for interfaces
     * were only introduced in JVM 8
     * 
     * YOU HAVE TO IMPLEMENT ALL METHODS FROM THE INTERFACE WITHIN
     * ITS SUBCLASSES. unless...
     * 
     * Prior to JVM8:
     * 
     * If you end up with a situation where one interface is inherited
     * by many classes and now you want to add one method to the interface
     * you would need to fulfill that contract across all of the classes. In
     * other words you would need to go through the cumbersome process of
     * implementing the method across each subclass!
     * 
     * With JVM 8:
     * 
     * You can declare default methods in interfaces that can contain bodies
     * and parameters which will be useable throughout subclasses. Note
     * that the default methods are PUBLIC unless you
     * add modifiers that imply otherwise. They are also not abstract methods!
     * 
     * You also have the option of creating static methods that are associated
     * with any class that implements the interface. This means if two
     * classes inherit the same interface they share access to the static
     * method.
     * 
     * Note that you can create instance variables for any interface but
     * they are static and final by default because interfaces can never
     * be instantiated and by proxy, the values of their variables can never
     * change! The keyword final ensures that the value of these variables
     * cannot be tampered by any inheriting subclasses.
     * 
     * Basically, there is little need to have constants in interfaces
     * but if you want them, you can use them outside of the interface,
     * without the ability to change them or initialize them to begin with.
     * (Think of constants like Math.PI)
     * 
     * -------------------------------------------------------------------------
     * 
     * Comparable Interface-----------------------------------------------------
     * 
     * When comparing two objects maybe you want to determine which is larger,
     * greater, older, younger, bigger, wider, warmer, or anything else.
     * The comparable interface provides a neat way to calculate this!
     * 
     * The comparable interface is implemented in the java.lang library:
     * 
     * public Interface Comparable<E>{
     * public int compareTo(E o);
     * }
     * 
     * These classes implement Comparable, and therefore have a compareTo()
     * method: Byte, Short, Integer, Long, Float, Double, Character, BigInteger,
     * BigDecimal, Calendar, String, and Date. (some more maybe)
     * 
     * Since Comparable is a generic interface, it accepts a type argument
     * E, that corresponds with E within the method header.
     * 
     * This means:
     * public final class Integer extends Number
     * implements Comparable<Integer>{
     * 
     * @Override
     * public int compareTo(Integer o){
     * // Implementation
     * }
     * }
     * 
     * Since Comparable<Integer> is implemented the compareTo method must
     * accept a parameter of type Integer to fulfill the Comparable interface
     * contract!
     * 
     * In all these cases, the compareTo method returns an int that
     * corresponds to the evaluation!
     * The method returns a negative value if the first argument is
     * less than the second argument, positive value if the first argument
     * is more than the second argument, and 0 IF BOTH VALUES ARE EQUAL.
     * 
     * Now how do we know if one String is "less" or "more" than another?
     * Well honestly, you look at the implementation in the String class,
     * but with Strings and many other non-numeric data types you just want
     * to know if the two values are equal, and IF THE VALUES ARE EQUAL
     * THE COMPARETO METHOD SHOULD ALWAYS RETURN 0.
     * 
     * An array of a base data type (or any comparable datatype) can be
     * sorted. If you can compare objects you can sort them! This is why
     * if you create an array of Strings, you can actually sort them.
     * However you cannot sort an array of rectangles unless you implement
     * Comparable and jointly implement the compareTo method in the
     * Rectangle class.
     * 
     * Once we do that we can see what happens if we use Arrays.sort() on
     * a list of rectangles and voila it works like magic!
     * 
     * -------------------------------------------------------------------------
     * 
     * Cloneable Interface------------------------------------------------------
     * 
     * What if you want to create a clone of an object similar to
     * how you can use Arrays.copy() to copy an array. Well we can
     * implement the Cloneable interface!
     * 
     * Many classes such as the Calendar class already implement the
     * Cloneable interface. And therefore they have an implementation
     * of the .clone() method which returns a copy of the Calendar object.
     * 
     * -------------------------------------------------------------------------
     * 
     * Interfaces vs Abstract Classes-------------------------------------------
     * 
     * You cannot use constructors within either interfaces or abstract
     * classes. As a result neither of them can be instantiated using the
     * new keyword. There are no restrictions for variables within an
     * abstract class, but variables within an interface must be
     * public static final!
     * 
     * Abstract classes can have any types of methods but interfaces must
     * contain public abstract, public default, or public static methods.
     * 
     * One class can implement multiple interfaces to show multiple
     * behaviors (this explains why Calendar class is Cloneable and
     * Comparable). However a class cannot extend multiple classes
     * (abstract or otherwise).
     * 
     * All classes share the root class of the Object class. But interfaces
     * have no such root interface. This allows one interface to implement
     * another or extend a different class. A variable within an interface
     * can reference any instance of a class that implements the interface.
     * The interface behaves like a superclass for all the classes that
     * implement it.
     * 
     * Interfaces are generally preferred to abstract classes because
     * they can relate unrelated classes via a weak "is-a" relationship.
     * This simply means that classes that implement an interface
     * possess a certain property / behavior. howToEat may be an
     * interface for multiple types of classes such as Animal,
     * Fruit, Flower and e.t.c. Whereas an abstract class could
     * would likely have to be defined at least 3 separate times
     * to accomodate for the three superclasses.
     *
     * -------------------------------------------------------------------------
     *
     * Class Design Guidelines--------------------------------------------------
     * 
     * Cohesion:
     * A class should define a single entity and its operations should logically
     * fit together with operations on the class members. A student and staff
     * should not be defined in the same class as they are distinct entities.
     * A single entity with more than 1 purpose can be broken into several
     * classes to deal with each indiviual application. In cases such as
     * this it is neccessary to apply principles of inheritance or composition
     * to avoid repeating code. For example a Student could have an extended
     * definition as in the class StudentRepresentative. This class could
     * inherit from the student class and add further responsibilities!
     * 
     * A good internal JVM example of cohesion is the String, StringBuilder,
     * and StringBuffer classes. The String class is responsible for creating
     * immutable strings, the StringBuilder creates objects which are
     * mutable strings, and the StringBuffer emulates the StringBuilder but
     * contains synchronized methods for changing strings.
     * 
     * Consistency:
     * Follow standard JVM naming conventions for naming classes,
     * variables, and methods. When inside a class a common convention
     * is to place data declarations (class variables) first, then
     * the constructor, and then follow up with methods. It may
     * also be useful to separate the accessor and mutator
     * (getter and setter) methods from the rest of the methods.
     * 
     * Make sure that method names are concise and consistent as well.
     * For example, the length() has the same functionality across
     * the String, ArrayList, StringBuilder, and StringBuffer classes.
     * Keeping consistent names and implementations
     * avoids the hassle of unexpected method evaluations.
     * 
     * Generally provide a no-arg public constructor for constructing
     * a default instance of any class. If the class does not support
     * a no-arg constructor, document the reason via comments.
     * 
     * If you want users to not be able to create an instance of
     * a class, just create a private constructor, (which can only
     * be accessed in subclasses).
     * 
     * Encapsulation:
     * The private modifier should be used liberally to prevent
     * direct data access by clients (we use accessors and mutators to
     * selectively choose if and when data can be modified).
     * 
     * Clarity:
     * Make sure to design your class intuitively and test it as a user.
     * A class can have multiple contracts, and thus we should try not
     * to limit what contexts a class can be used in. The methods should
     * be function independently of their order of occurence.
     * (If one method calls another their order in the class should not
     * matter!)
     * 
     * Methods should have intuitive parameters and implementation,
     * a good counterexample is the .substring() method of the String
     * class. .substring takes in a beginIndex and endIndex parameters,
     * but gets the portion of the string from beginIndex (inclusive)
     * to endIndex-1 (inclusive). So the implementation
     * is not what you would intuitively expect, and will infact
     * not give you the entire string unless you use the length of
     * the string as the endIndex. One could argue this makes
     * the method more intuitive but most would call it a hassle.
     * 
     * Good class design should avoid defining data fields that
     * can easily be dereived from other data fields.
     * 
     * 
     * -------------------------------------------------------------------------
     */
}
