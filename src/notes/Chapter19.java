package notes;

import java.util.ArrayList;

public class Chapter19 {
    /*
     * Chapter 19: Generics
     * 
     * Main Goals:
     * - To describe the benefits of generics.
     * - To use generic classes and interfaces.
     * - To define generic classes and interfaces.
     * - To explain why generic types can improve reliability
     * and readability.
     * - To define and use generic methods and bounded
     * generic types.
     * - To develop a generic sort method to sort an
     * array of Comparable objects.
     * - To use raw types for backwards compatibility.
     * - To explain why wildcard generic types are necessary.
     * - To describe generic-type erasure and list certain
     * restrictions and limitations on generic types caused
     * by type erasure.
     * - To describe and implement generic matrix classes.
     * 
     * Have we seen Generics Already? -----------------------------------------
     * 
     * Suppose the Comparable interface!
     * 
     * Prior to JDK 1.5 the first few lines of the Comparable interface
     * looked like so:
     * 
     * public interface Comparable{
     * --public int compareTo(Object o){
     * ............
     * --}
     * }
     * 
     * However, modern versions of the JDK (including and after JDK 1.5)
     * the interface adapted generics!:
     * 
     * public interface Comparable<T> {
     * --public int compareTo(T o){
     * ...........
     * --}
     * }
     * 
     * Why did the designers of Java make this change.
     * Well the key is thet <T> represents a formal generic type, which can be
     * replaced later (when we call the compareTo method in compile time)
     * with an actual concrete type.
     * 
     * Generic Instantiation: The process of replacing a generic type.
     * 
     * By convention a single capital letter ("E", "T") is used to denote
     * a formal generic type.
     * 
     * We use generics to detect possible errors during compile time instead of
     * runtime.
     * 
     * Ex.
     * Comparable c = new Date();
     * System.out.println(c.compareTo("red"))
     * 
     * The code above showed no errors when you typed it out prior to JDK 1.5!
     * 
     * However if we properly instantiate a Comparable type reference variable
     * today:
     * 
     * Comparable<Date> c = new Date();
     * System.out.println(c.compareTo("red"));
     * 
     * The code now will show an error immeadiately underlining the compareTo
     * method. The compiler expects the passed object
     * (in this case the String: "red") to be of type Date.
     * Generics can allow us to make sure the types passed via a type's
     * method match the generically instantiated type declared when making
     * the reference variable.
     * 
     * Let's look at the ArrayList class after JDK 1.5
     * 
     * |----------------------- java.util.ArrayList<E> ------------------------|
     * +ArrayList();
     * 
     * add(o: E): void
     * 
     * add(index: int, o: E): void
     * 
     * clear(): void
     * 
     * contains(o: Object): boolean
     * 
     * get(index: int): E
     * 
     * indexOf(o: Object): int
     * 
     * ...
     * |-----------------------------------------------------------------------|
     * 
     * Note how the add methods accept parameters of type E, which implies
     * that if we make an ArrayList<Integer> we can only add objects of type
     * Integer or its primitive equivalent
     * (rememember that if you declare Integer, you
     * can also add primitive ints).
     * 
     * In other words the generic type informs Java about what type of objects
     * it should expect to run its methods on. If we instantiated the generic
     * type as Object such that we declared an ArrayList<Object> then that array
     * list can hold ANY OBJECT SINCE OBJECT IS THE SUPERTYPE OF EVERY OBJECT
     * IN JAVA.
     * 
     * This is an example of how generics enable polymorphism within the
     * ArrayList class.
     * 
     * Without generics, and prior to JDK 1.5, casting was neccessary
     * cast the output of some methods:
     * 
     * Suppose:
     * ArrayList<String> list = new ArrayList<>();
     * list.add("Red")
     * 
     * Prior to JDK 1.5:
     * String s = (String)(list.get(0)); // Explicit casting
     * 
     * Now:
     * String s = list.get(0);
     * // get(index: int): E
     * // No explicit casting is needed when you call get();
     * 
     * Defining Generic Classes and Interfaces ---------------------------------
     * 
     * GenericStack<E>{
     * 
     * private java.util.ArrayList<E> list = new java.util.ArrayList<>();
     * 
     * public GenericStack(){
     * 
     * }
     * 
     * public GenericStack(ArrayList<E> list){
     * this.list = list;
     * }
     * 
     * public int getSize(){
     * return list.size();
     * }
     * 
     * public E peek(){
     * return list.get(getSize()-1);
     * }
     * 
     * public E pop(){
     * E o = list.get(getSize()-1);
     * list.remove(getSize()-1);
     * return o;
     * }
     * 
     * public void push(E o){
     * list.add(o);
     * }
     * 
     * }
     * 
     * Notice:
     * - The constructor's heading does not contain the generic type (<E>)
     * - We can construct the arrayList by passing an already populated list
     * of type E, but we also need to define the type while constructing the
     * list nonetheless. In other words:
     * GenericStack<String> stack = new GenericStack<>(ArrayList<String> list);
     * you CANNOT do
     * GenericStack stack = new GenericStack<>(ArrayList<String> list);
     * 
     * Generic Methods ---------------------------------------------------------
     * 
     * Just like how we can define generic interfaces and generic classes,
     * we can also use generic types to define generic methods.
     * 
     * This is not a generic method:
     * public E pop()
     * THIS IS A METHOD THAT RETURNS AN OBJECT BASED ON THE
     * GENERIC TYP OF THE CLASS.
     * 
     * A generic method is a method which accepts generic
     * parameters. To define a generic method we need to
     * put <E> directly prior to the return type of the method.
     * 
     * ex. public static <E> void print(E[] list);
     * 
     * We can also make both the return type E, and define the
     * method to accept parameters or type E:
     * 
     * ex. public static <E> E print(E[] list)
     * 
     * <E> is used to tell the compiler to accept a parameter which
     * has E in it. However the "E" must refer to the E in the class
     * header which is relevant for methods within object classes.
     * 
     * To invoke a generic method, prefix the method name with the
     * actual type in angle brackets.
     * 
     * For example:
     * <String>print(strings);
     * <Integer>print(ints);
     * 
     * However with newer versions of the Java, the compiler
     * can infer the type so you can simply do:
     * 
     * print(strings);
     * print(ints);
     * 
     * A generic type can be specified as the subtype of another type
     * by using the extends syntax within the definition!
     * 
     * public static <E extends GeometricObject> boolean equalArea(E object1, E
     * object2){
     * 
     * }
     * 
     * So why did we do this? Well if two objects of different
     * types share similar characteristics which are enforced
     * through the fact that both types are related children
     * of a common subtype, then we SHOULD do this be able
     * to compare related methods / fields.
     * 
     * Triangles and Circles both have areas, but without a method
     * that can compare an object of one type to another it would
     * be impossible to compare the area of a Circle and Triangle intuitively
     * via another method.
     * 
     * So instead we can make a static method that accepts 2 geometric objects
     * be them circles, triangles, or whatever else that appropriately extends
     * the geometric object class and allow them to be compared.
     * 
     * We can do this because ALL GEOMETRIC OBJECTS HAVE A DEFINED METHOD
     * to get THEIR AREA.
     * 
     * Raw Types and Backwards Compatibility -----------------------------------
     * 
     * A generic class when used without a type parameter is called a raw type.
     * I.E.
     * GenericStack stack = new GenericStack();
     * instead of
     * GenericStack<Integer> stack = new GenericStack<>();
     * 
     * Using raw types enables your code to have backwards compatibility with
     * prior versions of Java.
     * 
     * We could use Comparable instead of Comparable<E> but
     * Comparable is equivalent to Comparable<Object>
     *
     * Similarly:
     * GenericStack stack = new GenericStack();
     * is equivalent to
     * GenericStack<Object> stack = new GenericStack<>();
     * 
     * However, without the generic type parameter we are creating
     * unsafe declarations. If a method accepts two Comparable objects
     * then it is possible for both objects to be incomparable to 
     * one another. In other words, both may implement the Comparable
     * interface but they may not be able to compare to one another.
     * 
     * In the compiler this shows up as a unchecked exception however
     * your program only breaks when you try running it.
     * 
     * In other words: AVOID RAW TYPES IF POSSIBLE.
     * 
     * -------------------------------------------------------------------------
     * 
     * 
     */

    public class GenericStack<E> {
        private ArrayList<E> list = new ArrayList<>();

        // #region Constructors

        public GenericStack() {

        }

        public GenericStack(ArrayList<E> list) {
            this.list = list;
        }

        // #endregion

        // #region Methods

        public int getSize() {
            return list.size();
        }

        public void push(E value) {
            list.add(value);
        }

        public E peek() {
            return list.get(getSize() - 1);
        }

        public E pop() {
            E value = peek();
            list.remove(getSize() - 1);
            return value;
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        @Override
        public String toString() {
            return "Stack: " + list.toString();
        }

        // #endregion
    }

    public static <E> void print(E[] list) {
        for (int i = 0; i < list.length; i++)
            System.out.println(list[i] + " ");
        System.out.println();
    }

    public static <E extends GeometricObject> boolean sameColor(E obj1, E obj2) {
        return obj1.getColor().equals(obj2.getColor());
    }

    public static <E extends Object> boolean sameClass(E obj1, E obj2) {
        return obj1.getClass() == obj2.getClass();
    }

    public static <E extends Comparable<E>> void sort(E[] list) {
        E currentMin;
        int currentMinIndex;

        for (int i = 0; i < list.length - 1; i++) {
            currentMin = list[i];
            currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }

        }

    }

    public static void main(String[] args) {
        Chapter19 ch = new Chapter19();
        // With nested classes you have to do this shit
        // Don't bother with this if your generic
        // stack is outside of your testing file.

        GenericStack<String> stack1 = ch.new GenericStack<>();
        // Pretend the ch. does not exist for the sake of consistency lol.

        stack1.push("Red");
        stack1.push("Orange");
        stack1.push("Yellow");
        stack1.push("Green");
        stack1.push("Blue");
        stack1.push("Indigo");
        stack1.push("Violet");

        System.out.println(stack1.toString());
        System.out.println("Deleting the last value: " + stack1.pop());
        System.out.println(stack1.toString());

    }

}
