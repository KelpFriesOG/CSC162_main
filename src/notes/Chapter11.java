package notes;

import java.util.Date;
import java.lang.Object;

public class Chapter11 {
    /*
     * Chapter 11: Inheritance and Polymorphism
     * 
     * For these concepts you learn more by doing then by
     * writing up notes! So that is exactly what I will strive
     * to show!
     * 
     * Our example secenarios for both will include the
     * typical Animal layout, Vehicle layout, but also
     * an expanded Government Layout!
     * 
     * Inheritance allows you to define a general superclass
     * and use that class to define more specialized
     * subclasses.
     * 
     * Specialized classes can inherit methods and properties
     * from the general class.
     * 
     * The private datafields of the superclass are inaccesible
     * via the subclasses unless we utilize setters and getters.
     * If we do not want to go through the hassle of calling
     * each setter for each initialized variable we can use the super()
     * keyword at the top of the constructor to call the parent
     * constructor and initialize it with the variables it requires
     * 
     * This is called Constructor overloading!
     * 
     * If a subclass has no constructor the line super() is
     * implicitly called by the compiler to call a no-arg constructor
     * of the superclass!
     * 
     * If the superclass has no constructor, it is given a no-arg constructor
     * at compile time.
     * 
     * HOWEVER suppose that a superclass has a parameterized constructor,
     * but its subclass is constructor less!
     * 
     * Imagine the classes looking as such:
     * 
     * public class Child extends Parent{
     * 
     * }
     * 
     * public class Parent{
     * public Parent(String lastname){
     * 
     * }
     * }
     * 
     * When we call the Child class it will invoke the no-arg
     * super() keyword which will then attempt to find the same
     * no arg super() line or no-arg constructor in the Parent class.
     * However, no such constructor exists! Therefore it will return an error.
     * 
     * In other words to avoid super() keyword mismatches, we should
     * get in the habit of always creating no-arg constructors to
     * make it easier to extend classes (inheritance) in the future.
     * 
     * The super keyword can also be used to override methods!
     * 
     * For example suppose we have a toString method in the parent class:
     * public String toString(){
     * return "1) Calling the parent class!"
     * }
     * 
     * Then we could use the super keyword to mutate the subclass method based
     * on the results of the superclass's identical method (overriding) ! :
     * public String toString(){
     * return super.toString + "2) Calling the child class!"
     * }
     * 
     * Keep in mind that if we had a subclass of the Child class, suppose
     * Grandchild, doing super.super.toString within the class
     * would not reference the String method of the Parent class
     * (it would spit a syntax error!)
     * 
     * When overriding a method with the super keyword, keep in mind:
     * 1) The overriding method must have the same signature as the
     * overriden method and a similar or compatible return type!
     * The overriding method's return type must be the same or a subtype
     * of ther overriden method's return type.
     * 
     * 2) An instance method can only be overriden if its accessible!
     * If a method is private in the superclass, it cannot be overriden in
     * the subclass! Consequently if a subclass contains a public method
     * which has the same name of a superclass's private method, both methods
     * cannot be connected (they are unrelated and separate) !
     * 
     * 3) Static methods can also be inherited. However, a static method
     * CANNOT BE OVERRIDDEN! If a static method defined in a superclass is
     * redefined in the subclass, the method in the superclass is hidden.
     * In other words, invoking the static method would result in calling
     * the subclass's method (which is completely detached from the superclass
     * 's static method). You can invoke the hidden static method by
     * calling : SuperClassName.staticMethodName
     * 
     * Rememeber that this is possible because static methods are
     * attached to the class itself rather than any attributes of the
     * class's particular objects.
     * 
     * We can override methods, but we can also perform
     * method overloading between classes. If a subclass
     * contains a method with the same name but different
     * paramaters than the parent class's methods, then we
     * can call both methods from an
     * object of the subclass depending on which parameters
     * we pass.
     * 
     * Rememember:
     * 1) Overriden methods are in different classes related by inheritance
     * but overloaded methods can either be in the same class or
     * different classes related by inheritance!
     * 
     * 2) Overriden methods have the same signature (same parameters) as
     * the methods they override, but overloaded methods have different
     * parameters! (Both carry over the same names as the methods they are
     * overloading or overriding)
     * 
     * If you plan on creating a Overriding method, using the
     * 
     * @Override
     * tag avoids errors that would otherwise be uncaught!
     * In order for the method to override as intended, it needs
     * to have the same signature and parameter types as the method
     * it is overriding from (in the parent class). The override
     * tag checks to make sure these requirements are fulfilled,
     * because while they won't trigger a compiler error by default
     * the tag will understand your intentions.
     * 
     * Some key takaways:
     * Overriding:
     * A method in a subclass has the same signature as a method in
     * its superclass with eth same return type.
     * Overloading:
     * A method in a subclass has the same name as a method in its
     * superclass, but has different parameter types.
     * (return type can be same or different, it does not matter)
     * 
     * If you have a method in the subclass with the same signature
     * (parameters and name) as the method in its superclass but
     * has a different return type, the COMPILER WILL BREAK!
     * 
     * Rememeber that for method overriding the two requirements are:
     * - identical signature
     * - identical return type
     * For overloading we NEED:
     * - different parameters
     * - same name
     * 
     * In other words the scenario above does not fall into either case
     * and will break the compiler!
     * 
     * When a declared class has no inheritance (it extends from nothing):
     * then by default it extends from Java's Object class.
     * 
     * In other words
     * public class Kelp{
     * 
     * }
     * 
     * is equivalent to
     * 
     * public class Kelp extends Object{
     * 
     * }
     * 
     * Since every class in Java (apart from Object) is a derivation or
     * inherited from the Object class, the toString method in the Object class
     * is accessible by every other Java class.
     * 
     * The toString method provided by the Object class is not too helpful
     * but provides a memory address that correponds with the object's location
     * in memory. This is useful in comparing Objects later on!
     * 
     * Ex.
     * Loan loan = new Loan();
     * loan.toString()
     * 
     * Loan.toString() would return some string like Loan@15037e5
     * 
     * This is why the toString is often overriden by our own toString
     * implementations. Take a look at the GeometricObject's toString()
     * method as an example.
     * 
     * 
     * Polymorphism allows to take advantage of the definition of
     * super and subclasses. Since every instance of a class calls
     * an instance of its superclass. We can pass subclasses in
     * place of their superclasses and our compiler can infer that
     * the subclass contains all the relevant information for the call!
     * 
     * Polymorphism works by understanding that if you pass a
     * subclass in place of its superclass, the subclass
     * will still contain all the properties and methods
     * of the superclass (If the subclass lacks a particular
     * method, the superclass's method is called in its stead)!
     *
     * 
     * Dynamic Binding is the compiler's methodology of deciding
     * which implemented method is actually invoked during the
     * chain of inheritance!
     * 
     * The word Dynamic is interchangeable with "runtime" which
     * gives us a more literal idea of what this concept addresses.
     * 
     * If you imagine super and sub classes as a triangle,
     * with subclasses being at the base, dynamic binding is the
     * technique the compiler uses during runtime to climb up the triangle
     * until it finds the first implementation of the called method.
     * 
     * 
     * 
     * Suppose the class hierarchy:
     * Animal --> c1 --> Mammal --> c2 --> c3 --> Human
     * 
     * Scenario 1: There is a toString method in the Mammal class,
     * and a toString method in the Object class (by default).
     * We have a human object h1.
     * 
     * When we call toString on a human object, h1, the compiler
     * realizes there is no toString method in the Human class
     * and works its way up to find the toString class in the
     * Mammal class then calls that method!
     * 
     * Scenario 2: There is a toString method in the Mammal class,
     * and a toString method in the Object class (by default).
     * We have an object of type c1: alpha.
     * 
     * When we call c1 on alpha, the class c1 does not contain
     * a toString method, and neither does the Animal class,
     * so the compiler works up through c1, and Animal,
     * and hits the base Object class and utilizes its
     * toString method!
     * 
     * Note that we did not care about the toString method
     * in the mammal class because c1 is a superclass of the
     * Mammal class, (it is above it on the figurative triangle).
     * We only check the class and it's superclasses because
     * that is what is allowed by the compiler and the
     * declared type of the object (c1) does not have to
     * contain all the methods in the Mammal class and therefore
     * should not be treated as a polymorphic extension of
     * the Mammal class.
     * 
     * 
     * KEEP IN MIND:
     * Method matching and method binding are two separate things.
     * Method matching refers to how the declared type determines
     * what method to match or look for during COMPILE TIME.
     * 
     * When we perform method overloading (create methods with
     * differing parameters but same names) which of the overloaded
     * methods to execute is determined at compile time
     * when the compiler analyzes parameter types, number
     * or parameters, and the order of parameters! THIS
     * compile time checking is what creates errors in the code
     * before running it!
     * 
     * Method overriding occurs in the process of method binding
     * A method may be implemented by several classes in the
     * inheritance chain, but dynamic binding prioritizes
     * the executing the method associated with the actual type
     * or the method of its closest superclass which also
     * contains the same method with the same signature.
     * 
     * Student std = new Graduate();
     * ---^------------------^------
     * Declared type |---| Actual Type
     * 
     * Methods called on the std object during runtime
     * will start being searched for from the basis of the Graduate
     * class. In other words the overriding methods
     * of the graduate class will be executed instead of
     * the overriden methods in the declared type or its superclass(s)!
     * 
     * 
     * Casting is traditionally the process of converting between
     * two types of objects i.e. casting from double to int.
     * 
     * Explicit casting between objects works as you would expect:
     * Student b = (Student) o
     * where o is a superclass
     * 
     * 
     * However casting can also be done implicitly during
     * the declaration of an object in the code.
     * 
     * Suppose:
     * Object alpha = new Student();
     * 
     * This works because an instance of a Student is
     * also an instance of an Object (a student IS a object).
     * 
     * This is fairly straightforward because we are casting
     * a subclass (Student) upto a superclass (Object). This
     * is called upcasting (subclass casted to superclass).
     * 
     * Recall that a superclass cannot contain more callable properties
     * or methods than its subclass becuase it is by definition
     * a more generalized version of the subclass.
     * 
     * This means its easy to perform implicit casting since
     * the Object class truncates the functionality of the Student
     * object rather than attempting to expand it unknowingly.
     * 
     * On the other hand take:
     * Student b = (Student) o
     * 
     * This is down casting as we are casting the superclass (Object)
     * into an object of the subclass (Student). If we tried doing
     * this implicitly it would look like:
     * 
     * Student b = new Object();
     * 
     * Now we have a problem! The declared type (Student) is
     * more limiting than the actual type (Object) which
     * means that if a student is not an instance of an object,
     * (Student does not inherit the Object class) then the compiler
     * will start messing up!
     * 
     * Consequently, implicit casting can only be performed for
     * upcasting, it is impossible to downcast via implicit casting.
     * 
     * Instead, for downcasting from any type other than the Object
     * type (which is the superclass for ALL types in Java), it is
     * important to check that the type you are casting down
     * to is in fact "underneath" or an instance of the source type
     * and then proceed to cast explicitly
     * 
     * So what we could do is:
     * if(b instanceof Object){
     * // Perform casting and then do Object method
     * System.out.println((Object) b.toString())
     * }
     * 
     * While this appears trivial for the object class, it is
     * important for all other classes. Suppose we had two
     * hierarchies:
     * Animal -> Mammal -> Human
     * Animal -> Fish -> Dolphin
     * 
     * void someMethod(Object myObject){
     * if(myObject instanceof Fish){
     * ((Fish) myObject).swimspeed()
     * // Calls the swimspeed method by casting to class Fish!
     * }
     * }
     *
     * 
     * If we tried calling the method with a Mammal object
     * we would avoid the if statement and code failure altogether!
     * Furthermore if we called the method on a simple Object class
     * the Object would not be an instance of Fish, and we would
     * avoid the if statement.
     * 
     * We parameterize the method to accept any class by allowing
     * it to accept any Object (includes Animals and anything under it!)
     * And then we essentially type check the object to make sure
     * we can call the method we need on it!
     * 
     * Rememeber to put casting in parentheses as the member
     * access operator '.' has a higher precedence than
     * the casting!
     * 
     * You want : ((classType) obj).method1();
     * and not: (classType) obj.method1();
     * 
     * Fun Fact: Internally casting a primitive type and
     * casting an object are not the same.
     * 
     * Suppose,
     * Scenario A:
     * int age = 15
     * int newAge = (long) age
     * 
     * Scenario B:
     * Object obj = new Circle();
     * Circle c = (Circle) o
     * 
     * In scenario A, two pieces of data are created and stored
     * independently, whereas in b, Circle c and Object obj point
     * to the same location in memory!
     * 
     * Key takeaway:
     * You can always successfully cast an instance of a subclass
     * to a superclass (upcasting)'
     * But downcasting from a superclass to a subclass requires
     * you to check that the subclass is in fact an instance
     * of the superclass.
     * 
     * 
     * Dynamic Dispatch is the idea that the declared type
     * is a static limiter on what methods an object can access.
     * The actual type which the object is assigned to may
     * be the same type or a subtype but the superclass and
     * subclasses in the heirarchy determine the
     * functionality of the object during runtime.
     * 
     * Take these 3 statements:
     * 1) Human kelp = new Human();
     * 2) Mammal kelp2 = kelp;
     * 3) Animal kelp3 = kelp;
     * 
     * The declared type is the type we statically assign at the
     * beginning of each line.
     * For each statement the declared types are: Human, Mammal, and Animal
     * respectively.
     * The actual type is the type determined at runtime based
     * on the right hand assignment in all 3 instances the actual
     * type is Human, but know that Human is an instance of Animal
     * and Mammal classes for later.
     * 
     * Suppose we know the class hierarchy is:
     * Animal --> Mammal --> Human
     * 
     * Since kelp2's declared type is mammal, it can
     * ONLY ACCESS METHODS IN THE ANIMAL AND MAMMAL classes.
     * This is inspite the fact that kelp2's actual type is Human!
     * 
     * Similarly, kelp3 can ONLY ACCESS METHODS in the ANIMAL class.
     * 
     * If the Human class contained a method that overrides
     * a method in the mammal class, then kelp2, although
     * its declared type is Mammal, it chooses to activate
     * the method based on its actual type (Human) and
     * activates the overridden method in the Human class!
     * 
     * This is why method overriding is often called
     * runtime polymorphism. The runtime type (actual type)
     * allows method overriding to occur!
     * 
     * Lets go back to the hierarchy:
     * Animal --> Mammal --> Human
     * kelp3 ---- kelp2 ---- kelp
     *
     * Why is kelp2 restricted to only methods in the Animal and Mammal class?
     * Well its declared type, Mammal, means that in the future kelp2
     * could be reassigned to a Mammal object or another mammal (aside from the
     * human subclass). Now if the same object attempted to call methods
     * in the Human class, we would crash since the object's actual type
     * would be Mammal or something else like ... Penguin.
     * 
     * You can think of the declared type of a sort of net that
     * restricts an object to the methods of that type's class or
     * that class's superclasses.
     * 
     * Now when declaring and assigning this can get super tricky!
     * When assigning one object to another, the DECLARED TYPE is what matters!
     * 
     * Suppose:
     * Mammal m;
     * Animal h = new Human();
     * m = h
     * 
     * Now while the Human() class is a subclass of the Mammal class,
     * that will not matter! What matters is whether or not the declared type
     * (Animal) is a subclass of Mammal. Is it? NO, so this code will not
     * compile!
     * 
     * The compiler is cautious and since h could (before runtime) carry
     * an Animal object (based on the declared type) it will not assign
     * A variable of declared type Mammal, to a variable of declared type
     * Animal.
     * 
     * However:
     * Mammal m;
     * Human h = new Human();
     * m = h
     * 
     * Will work just fine since h can at most hold an object of type Human.
     * And all humans will be subclasses of a mammal object. In other words
     * the Human object can handle all the methods the Mammal can. Furthermore
     * after the last line, the actual type of m will be _______. (Human)
     * Even if h was a subclass of human suppose: Human h = new Student();
     * where Student is a subclass of Human, we know that the Student object
     * could handle every method in the Human class and consequently every
     * method in the Mammal class.
     * 
     * This whole discussion can be expanded to Interfaces and their
     * implemented classes as well!
     * 
     * Remember that the methods will be restricted based on the
     * actual type of the object. Meaning that if we declare an
     * object in this way:
     * Mammal m = new Human()
     * 
     * And then called a method that existed in both the Human and
     * Mammal class (the method was overriden in the Human class),
     * the method in the Human class would be called appropriately.
     * This is runtime binding!
     * 
     * The compiler may not know what type of mammal we have
     * but when we call methods they can give us a hint as
     * to the actual type of the object held in the Mammal handle.
     * 
     * 
     * 
     * The equals() method is baked into the Object class in Java
     * and has the implementation of:
     * 
     * public boolean equals(Object obj){
     * return this == obj;
     * }
     * 
     * The == operator is used to compare primitives but
     * can be used to compare objects as well!
     * 
     * When we compare 2 objects via equals(), if these objects
     * do not have a overriding equals() method that overrides the
     * Object class's methods, equals() checks if both reference
     * variables point to the same object in memory.
     * 
     * Student s1 = new Student("Johnny");
     * Student s2 = new Student("Johnny");
     * 
     * If the equals() method from the Object class is
     * called such that we run s1.equals(s2), it WILL RETURN FALSE.
     * This is because the new operator shows us that s1 and s2
     * are two distinct objects.
     * 
     * However suppose:
     * Student s1 = new Student("Kelpie")
     * Student s2 = s1;
     * 
     * At runtime, s2 simply points to the same location in memory as s1
     * until we change s2's contents. Therefore running
     * s2.equals(s1) or s1.equals(s2) WILL RETURN TRUE.
     * 
     * Now if we want to specifically compare the two objects
     * based on the contents we would need to create an overriding
     * method in the Student class or any of its superclasses
     * (apart from Object).
     * 
     * For example:
     * public boolean equals(Student s){
     * if(this.name == s.name){
     * return true;
     * }
     * else{
     * false
     * }
     * }
     * 
     * Now suppose you have this equals method with this scenario:
     * Student s1 = new Student("Johnny");
     * Student s2 = new Student("Johnny");
     * 
     * s1.equals(s2) // Returns true
     * 
     * If you now still want to make a strong comparison
     * (identify if two variables point to the same object)
     * 
     * you can try s1 == s2 and it will return FALSE.
     * 
     * 
     * Arraylists are the ideal way of working on lengthy lists
     * of objects! These are a few shortcuts for ArrayList class
     * 
     * Examples:
     * 
     * // Converting from array to ArrayList:
     * String[] array = {"red","green","blue"};
     * ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
     * 
     * // Converting from ArrayList to array:
     * String array1 = new String[list.size()]
     * list.toArray(array1);
     * 
     * // Sorting an array
     * Integer[] array2 = {3, 5, 95, 4, 15, 34, 3, 6, 5};
     * ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(array2));
     * Collections.sort(list1)
     * System.out.println(list1)
     * 
     * Visibility modifiers are crucial in creating intentionally
     * designed inheritance schemes. In order of least to most
     * visible the modifiers are:
     * 
     * private, default (no modifier), protected, public
     * 
     * Private class members can only be accessed within the class!
     * Default class members can be accessed throughout the package.
     * Proiected class members can be accessed in the class, in the package,
     * and in subclasses in different packages.
     * Public class members can be accessed across all other packages.
     * 
     * The final keyword in used on variables to prevent changing
     * the value of the variables. Furthermore, it can be used in
     * method headers to prevent method overriding from inheriting
     * classes.
     * 
     * A class can also be declared final to prevent the class
     * from being extended.
     * 
     */

    // #region Inheritance examples

    public class GeometricObject {
        private String color = "white";
        private boolean filled = false;
        private Date dateCreated = new Date();

        // #region Constructors

        public GeometricObject() {

        }

        public GeometricObject(String color, boolean filled) {
            this.color = color;
            this.filled = filled;
        }

        // #endregion

        // #region Getters and Setters

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isFilled() {
            return filled;
        }

        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        public Date getDateCreated() {
            return dateCreated;
        }

        // #endregion

        // #region Methods

        public String toString() {
            String reprString = "A geometric object, colored "
                    + color + " that is " + (filled ? "filled in." : "not filled in.");
            return reprString;
        }

        // #endregion

    }

    // Subclass extends superclass
    // The methods getColor, setColor, isFilled, setFilled, and toString
    // are inherited.

    public class Circle extends GeometricObject {
        private double radius;

        // #region Constructors

        public Circle() {

        }

        public Circle(double radius) {
            this.radius = radius;
        }

        public Circle(double radius, String color, boolean filled) {
            super(color, filled);
            // The properties of the superclass MUST be changed via
            // access to the getter and setter methods for said class
            // super() does this for us automatically or we could
            // call each method independently!
            // writing this.color = color would give us an error!
            this.radius = radius;
        }
        // #endregion

        // #region Getters and Setters

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        // #endregion

        // #region Methods

        public double getArea() {
            return radius * radius * Math.PI;
        }

        public double getDiameter() {
            return 2 * radius;
        }

        public double getPerimeter() {
            return getDiameter() * Math.PI;
        }

        public String toString() {
            return "The circle was created on: " + super.getDateCreated() +
                    ", and the radius is: " + radius;
            // The super keyword is not neccessary here since the
            // getDateCreated() method is inherited!

            // However we could user super.toString() to override the
            // toString method of the GeometricObject by using that
            // same method!
        }

        // #endregion
    }

    public class Rectangle extends GeometricObject {
        private double width;
        private double height;

        // #region Constructors

        public Rectangle() {

        }

        public Rectangle(double width, double height) {

            this.width = width;
            this.height = height;

        }

        public Rectangle(double width, double height, String color,
                boolean filled) {

            super(color, filled);
            this.width = width;
            this.height = height;

        }

        // #endregion

        // #region Getters and Setters

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        // #endregion

        // #region Methods

        public double getArea() {
            return width * height;
        }

        public double getPerimeter() {
            return 2 * (width + height);
        }

        // #endregion

    }

    // #endregion

    // #region Constructor chaining examples
    // The code below illustrates the process of constructor
    // chaining!

    public class Person {
        public Person() {
            System.out.println("1) Called the Person constructor!");
        }

        public String toString() {
            return "Found in Person class!";
        }
    }

    public class Student extends Person {
        public Student() {
            this("2) Invoking student's overloaded constructor!");
            System.out.println("3) Called the Person constructor!");
        }

        public Student(String s) {
            System.err.println(s);
        }

        public String toString() {
            return "Found in the Student class";
        }
    }

    public class TeachingAssistant extends Student {
        public TeachingAssistant() {
            System.out.println("4) Called the TeachingAssistant constructor!");
        }
    }

    // #endregion

    // #region Overriding vs Overloading examples

    class A {
        public void p(double i) {
            System.out.println(i * 2);
        }
    }

    class B extends A {
        // Example of method overriding
        // If we call an object of type B with p(10.0)
        // We get 30.0, not 20.0.
        // If we call the same object with p(10)
        // We get 30.0

        // This is runtime polymorphism
        public void p(double i) {
            System.out.println(i * 3);
        }
    }

    class C extends A {
        // Example of method overloading
        // If we call an object of type C with p(10.0)
        // we get 20.0
        // If we call the same object with p(10)
        // we get 10 (from the parent's method)

        // This is compile time polymorphism
        public void p(int i) {
            System.out.println(i);
        }
    }

    // #endregion

    // #region Polymorphism examples
    // This method can be called with any GeometricObject g
    // Or any object instance of its subclasses in place of g.
    public static void displayObject(GeometricObject g) {
        System.out.println("Created on: " + g.getDateCreated() +
                ".\nThe color is " + g.getColor() +
                ".\nIs the object filled?: " + g.isFilled());
    }

    // #endregion

    // #region Dynamic Binding examples

    public class Graduate extends Student {

    }

    // #endregion

    // #region Casting examples

    static void castGeo(Object myObj) {
        if (myObj instanceof GeometricObject) {
            System.out.println("This is a geometric object!");
        } else {
            System.out.println("This is not a geometric object");
        }
    }

    static void castStudent(Object myObj) {
        if (myObj instanceof Person) {
            System.out.println("This is a person!");
        } else {
            System.out.println("This is not a person :(");
        }
        if (myObj instanceof Student) {
            System.out.println("This person is a student!");
        }
    }

    // #endregion

    // #region Equals method examples

    public class Worker {
        String name;
        boolean employed;
        int dailyHours;
        double rate;

        public Worker(String name, boolean employed, int dailyHours,
                double rate) {
            this.name = name;
            this.employed = employed;
            this.dailyHours = dailyHours;
            this.rate = rate;
        }

        public boolean equals(Worker w) {
            if (w.name == this.name && w.employed == this.employed
                    && w.dailyHours == this.dailyHours &&
                    w.rate == this.rate) {
                return true;
            } else {
                return false;
            }
        }
    }

    // #endregion

    public static void main(String[] args) {

        // #region Testing the Geometric object and its subclasses
        Chapter11 ch = new Chapter11();
        Circle c = ch.new Circle(1);
        // We need to bind an instance of the current file
        // because we are testing within the same file the
        // classes are declared in!
        // Normally the line would be: Circle c = new Circle(1)
        System.out.println("A circle: " + c.toString());
        System.out.println("The color is " + c.getColor());
        System.out.println("Is the circle filled? : " + c.isFilled());
        System.out.println("The radius is " + c.getRadius());
        System.out.println("The diameter is " + c.getDiameter());
        System.out.println("The area is " + c.getArea());

        Rectangle rect = ch.new Rectangle(5, 10, "hazel",
                true);
        System.out.println("A rectangle: " + rect.toString());
        // Note that Rectangle() does not have its own toString method
        // So it calls the superclass's toString() method instead!
        System.out.println("The color is " + rect.getColor());
        System.out.println("Is the rectangle filled? : " + rect.isFilled());
        System.out.println("The width is : " + rect.getWidth());
        System.out.println("The height is : " + rect.getHeight());
        System.out.println("The perimeter is " + rect.getPerimeter());
        System.out.println("The area is " + rect.getArea());

        // #endregion

        // Illustrating the process of contructor chaining!
        ch.new TeachingAssistant();

        // #region Illustrating Overloading vs Overriding

        B overr = ch.new B();
        C overl = ch.new C();

        System.out.println("Calling an instance of B with 10 gets: ");
        overr.p(10);
        System.out.println("(Invokes the method in B)\n");

        System.out.println("Calling an instance of B with 10.0 gets: ");
        overr.p(10.0);
        System.out.println("(Invokes the method in B)\n");

        System.out.println("Calling an instance of C with 10 gets: ");
        overl.p(10);
        System.out.println("(Invokes the method in C)\n");

        System.out.println("Calling an instance of C with 10.0 gets: ");
        overl.p(10.0);
        System.out.println("(Invokes the method in A)\n");

        // #endregion

        // #region Illustrating Polymorphism

        // The subclass objects can be used in place of the
        // super class parameter, because a subclass
        // is guareenteed to have the superclass's properties!
        displayObject(ch.new Circle(1, "red", false));
        System.out.println("");
        displayObject(ch.new Rectangle(5, 4, "silver",
                true));

        // #endregion

        // #region Illustrating Dynamic Binding
        System.out.println("---------------------------");
        System.out.println(ch.new Graduate().toString());
        // Found the uppermost toString method in the Student class
        System.out.println("---------------------------");
        System.out.println(ch.new Student().toString());
        // Found the uppermost toString method in the Student class
        System.out.println("---------------------------");
        System.out.println(ch.new Person().toString());
        // Found the uppermost toString method in the Person class
        System.out.println("---------------------------");
        System.out.println(new Object().toString());
        // Found the uppermost toString method in the Object class
        System.out.println("---------------------------");

        // #endregion

        // #region Illustrating Casting and instanceof Operator

        Object kelpie = ch.new Graduate();
        Person kelpie2 = ch.new Person();
        Object gObject = ch.new Circle();
        GeometricObject gObject2 = ch.new GeometricObject();
        System.out.println("-------------");
        castStudent(kelpie);
        System.out.println("-------------");
        castStudent(kelpie2);
        System.out.println("-------------");
        castGeo(kelpie);
        System.out.println("-------------");
        castGeo(gObject);
        System.out.println("-------------");
        castGeo(gObject2);

        // #endregion

        // #region Demonstrating the equals method

        Student josh = ch.new Student();
        Object jake = josh;

        System.out.println("-------------------------------------------");
        System.out.println("Does jake == josh?: " + jake.equals(josh));
        System.out.println("\nThey point to the same memory address!" +
                "\nWhen we create jake we are not creating a new object but " +
                "\nrather a reference object that points to the same " +
                "\nlocation as josh.\n");

        Worker w = ch.new Worker("Drake", true,
                9, 35.0);
        Worker w2 = ch.new Worker("Drake", true,
                9, 35.0);
        Worker w3 = ch.new Worker("Nick", true,
                9, 35.1);

        System.out.println("If we want to compare the contents of two" +
                " objects,\nwe need to override the Object class's equals() " +
                "method.\n");

        System.out.println("Does w contain the same contents as w2?: " +
                w.equals(w2));
        System.out.println("Does w2 contain the same contents as w3?: " +
                w2.equals(w3));

        System.out.println("-------------------------------------------");

        // #endregion

    }

}
