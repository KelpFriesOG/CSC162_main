package notes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class Chapter10 {
        /*
         * Chapter 10: Object Oriented Thinking
         * 
         * Overview:
         * - Applying abstraction in development
         * - Differentiate between procedural and OOP paradigms
         * - Discover relationships between classes
         * - Create objects with wrapper classes
         * - Utilizing BigInteger and BigDecimal classes
         * for computing large values with arbitrary precisions.
         * - Using String to process immutable strings
         * - Using StringBuilder and StringBuffer to process
         * mutable strings.
         * 
         * 
         * 
         * Class abstraction is a type of abstraction that splits
         * the process of defining a class's utilities, and that
         * class's actual implementation.
         * 
         * The constructors, fields, and methods accesible from outside the class
         * together with the description of those methods serve as the class contract.
         * 
         * The user does not need to know how the class in implemented.
         * Class encapsulation is the methodology of hiding the details of a class's
         * implementation behind the contract.
         * 
         * Class abstraction is the same concept.
         * 
         * As a user of class, you do not need to know an object's internal
         * implementation in order to use it.
         * 
         * The traditional procedural programming paradigm is action-driven, and data
         * are separated from actions. The object-oriented programming paradigm focuses
         * on objects, and actions are defined along
         * with the data in objects.
         * 
         * Procedural programming: action driven, data and actions are separate
         * OOP programming: tie all neecessary data into the object.
         * 
         * Example:
         * Instead of using static methods to solve problems for loan
         * computation, we can create a loan object with contains all
         * neccesarry data to create, work on, and delete a loan.
         * 
         * Immutable classes contain only private data fields and
         * have no setters and getters. In other words, these
         * classes' objects cannot be changed after instantiation.
         * 
         * Class Relationships ------------------------------------------
         * 
         * Association is a binary relationship between 2 classes.
         * Student takes a course, that would involve a relationship between
         * the Student and Course classes.
         * For a faculty member teaching the course, that would involve a
         * relationship between the Faculty and Course classes.
         * 
         * Take a look at the association relationship png to see how
         * associations are depicted in a UML diagram.
         * 
         * The diagram shows that a student takes a course, and a faculty
         * member teaches a course. 5-60 students may be assigned to one course,
         * but one student can take any number of courses.
         * 
         * Each faculty member may teach 0-3 courses, but each course is only
         * assigned to one faculty member.
         * 
         * I made class implementations to review!
         * 
         * 
         * Aggregation and Composition are terms used to describe ownership
         * between classes.
         * 
         * For an aggregation relationship:
         * Owner --> Subject
         * 
         * Aggregating Class --> Aggregated Class
         * instantiate...
         * Aggregating Object --> Aggregated Object
         * 
         * 
         * Composition is a type of sub-relationship which occurs when
         * the aggregated object is dependent on the aggregating object.
         * In other words the existence of the aggregated object is reliant
         * on the initiation of the aggregating object.
         * In other words all compositions are aggregations, but not
         * all aggregations are compositions.
         * 
         * Suppose the classes:
         * 
         * public class Name{
         * 
         * }
         * 
         * public class Address{
         * 
         * }
         * 
         * public class Student{
         * private Name name;
         * private Address address;
         * }
         * 
         * An aggregating relationship exists between the Name and Student classes,
         * and the Address and Student classes. A student has a name, and has an
         * address.
         * 
         * Interpretation of UML diagram (Composition&Aggregation.PNG):
         * 
         * 1 student has one name, and one name has one student.
         * 1 student has one address, but one address can belong to 1-3 students.
         * 
         * A name is dependent on the student, it cannot exist by itself (with any
         * meaning). However an address is independent of the student, especially
         * since multiple students can have the same address.
         * 
         * Student --> Address is an aggregation
         * Student --> Name is a composition
         * 
         * 
         * Primitive Data Type Wrappers
         * 
         * Although primitives such as ints, doubles, and booleans are not
         * considered objects, they can be treated as objects via their respective
         * wrapper methods. We have already seen String as an object denothed by
         * the upper letter at the beginning of the class name.
         * 
         * Similar "wrapper classes" exist called Integer, Double, Boolean, Character,
         * Float, Byte, Short, and Long.
         * 
         * Every wrapper class has methods for doubleValue(), floatValue(), intValue,
         * longValue(), shortValue(), and byteValue().
         * 
         * These are conversion methods that convert an object of the primitive
         * type associated with wrapper class into another type.
         * Note that wrapper objects can also be construed with
         * string representations of the type they represent
         * 
         * Example 1:
         * Integer value = 5;
         * byte b = value.byteValue();
         * 
         * Example 2:
         * Double value = "5.002";
         * byte b = value.byteValue();
         * 
         * Since the wrapper class accepts string representations,
         * both examples work equally effectively!
         * 
         * The wrapper methods can also be used statically
         * 
         * Example:
         * int value = 7
         * long l = Integer.longValue(value);
         * 
         * When creating a wrapper based object there are 3 approaches:
         * Integer x = new Integer("32")
         * Integer y = 32
         * Integer z = Integer.valueOf("32");
         * 
         * Now why are they different?
         * Well lets say it like this...
         * if given code
         * Integer a = new Integer("32")
         * a and x are two DISTINCT objects. They do not point to the
         * same location in memory. Therefore a == x will return false
         * because you need to remember that Integer is not a primitive
         * but an object onto itself.
         * 
         * However if given the code
         * Integer b = Integer.valueOf("32");
         * b == z will return true, because they are the same object
         * and point to the same location in memory.
         * So in fact when we declare b, we are not making a new object
         * but a new pointer to the same object!
         * y == z && y == b will also return TRUE!
         * Because declearing a wrapper class with a direct
         * representation is identical to using valueOf.
         * 
         * Regardless the preferred way of instantiating Wrapper classes is
         * .valueOf();
         * Ex.
         * Integer z = Integer.valueOf("32");
         * 
         * If you try running
         * Integer x1 = Integer.valueOf("128");
         * Integer x2 = Integer.valueOf("128");
         * 
         * And compare x1 to x2 via x1 == x2, it might return FALSE!
         * (based on your JDK version)
         * why????????????????
         * 
         * Because 128 is not in the range of well defined reused
         * Integer values in JDK11! When we use valueOf, we are pointing
         * to a sort of hardcoded numberline stored within the JDK libraries.
         * This numberline only stretches to cover what it considers most
         * used values. If we declare with a value outside of its
         * range it creates new objects which are distinct.
         * 
         * For JDK11 the range of most used integer values for the Integer
         * wrapper's valueOf class was -128 to 127!
         *
         * Besides these little quirks, wrapper classes also have many,
         * many useful methods which are tested in actual code below.
         * 
         * 
         * The BigInteger and BigDecimal classes can be used to represnt
         * integers and decimal numbers of any size and precision.
         * They are located in the java.math library.
         * If you want to perform arithmetic on BigIntegers and decimals
         * you need to use custom add(), subtract(), multiply(),
         * and divide() methods.
         * 
         * Example:
         * BigInteger a = new BigInteger("99999999988888888887312367324");
         * BigInteger b = new BigInteger(3);
         * 
         * BigInteger c = a.multiply(b);
         * 
         * The precision of the BigDecimal object can be any length
         * as long as it is finite. If the result to a divide() operation
         * is irrational, an ArithmeticException will be thrown.
         * 
         * However, you can use the overloaded divide() method to account
         * for irrationality via different rounding methodologies.
         * 
         * Overloaded divide paramaters:
         * divide(BigDecimal d, int scale, RoundingMode roundingMode)
         * scale is the maximum number of digits after the decimal
         * rounding mode is an object starting with
         * RoundingMode. and examples include: RoundingMode.HALF_UP
         * , RoundingMode.HALF_DOWN.
         * 
         * BigDecimal class can be initializing with a string
         * representation or a double represenatation.
         * i.e. BigDecimal d = new BigDecimal(2.903244434)
         * or BigDecimal d = new BigDecimal("2.9032444434");
         * 
         * 
         * The String class has been ubiquitiously used in previous
         * Java topics, but in essence is simply a char array with
         * some extra utility methods!
         * 
         * Since strings are immutable, they cannot be changed.
         * So then why does this example below not give errors?
         * 
         * String alpha = "Welcome to Java"
         * alpha = "Kelpy"
         * 
         * Well this works, but just makes the prior assignment
         * "Welcome to Java" inaccesible. Initially, alpha is
         * a reference variable that points to a string
         * "Welcome to Java", when we say:
         * alpha = "Kelpy" we are infact creating a new
         * String elsewhere in the memory and now assigning
         * the reference variable to point to this new chunk
         * of memory! Now this means that the original string
         * is "unreferenced". Since Java is compiled,
         * unreferenced variables are dealt with under the hood!
         * 
         * 
         * Furthermore the reason Java prefers to make
         * unique instance variables when we assign Strings
         * without a new keyword.
         * 
         * Therefore take this code:
         * String s1 = "Kelpy is epic!"
         * String s2 = new String("Kelpy is epic!")
         * String s3 = "Kelpy is epic!"
         * String s4 = new String("Kelpy is epic")
         * 
         * Is s1 == s2? no! s1 is an interned string
         * which is a unique instance for the character sequence
         * 
         * Is s1 == s3? yes! s1 and s3 point to the same
         * character array, which was created
         * when we declared String s1. Both point
         * to the same interned string object!
         * 
         * Is s1 == s4? no! same explanation
         * as s1 == s2, s4 is a String object
         * which is separately stored from the interned
         * String.
         * 
         * Is s2 == s4? No, they are two separate
         * distinctly created objects using the new
         * keyword.
         * 
         * Consequently, methods associated with the String
         * class do not modify the String object but
         * rather return a new String object with the
         * appropriate modifications.
         * 
         * If used to replace strings, this creates
         * a lot of unreferenced data but this is by design.
         * 
         * String methods such as replace(),
         * replaceAll(), replaceFirst(), split()
         * , matches(), equals(), and more will
         * be coded in the main method.
         * 
         * 
         * 
         * 
         * 
         * 
         */
        public static void main(String[] args) {

                // Testing interconnected classes: Faculty, Course, and Student
                Faculty kim = new Faculty("Kim Petras");

                Course course1 = new Course("Data Structures", kim);

                Student sam = new Student("Sam Jinx");

                course1.addStudent(sam);
                course1.addStudent(new Student("Jambo Slam"));

                System.out.println("The teacher for Data Structures is " + course1.getFaculty());
                System.out.println("Students in Data Structures are: " + course1.getStudents());

                // Testing StackOfIntegers class
                StackOfIntegers stack = new StackOfIntegers();

                for (int i = 10; i > 0; i--) {
                        stack.push(i);
                }

                while (!stack.empty())
                        System.out.print(stack.pop() + " ");

                System.out.println("\n\nMIN_VALUE and MAX_VALUE methods ---------");

                System.out.println("\n-----------------------------------------");
                System.out.println("The minimum byte value is " + Byte.MIN_VALUE);
                System.out.println("The maximum byte value is " + Byte.MAX_VALUE);
                System.out.println("-----------------------------------------");
                System.out.println("The minimum short value is " + Short.MIN_VALUE);
                System.out.println("The maximum short value is " + Short.MAX_VALUE);
                System.out.println("-----------------------------------------");
                System.out.println("The minimum int value is " + Integer.MIN_VALUE);
                System.out.println("The maximum int value is " + Integer.MAX_VALUE);
                System.out.println("-----------------------------------------");
                System.out.println("The minimum long value is " + Long.MIN_VALUE);
                System.out.println("The maximum long value is " + Long.MAX_VALUE);
                System.out.println("-----------------------------------------");
                System.out.println("The minimum positive float value is " + Float.MIN_VALUE);
                System.out.println("The maximum positive float value is " + Float.MAX_VALUE);
                System.out.println("-----------------------------------------");
                System.out.println("The minimum positive double value is " + Double.MIN_VALUE);
                System.out.println("The maximum positive double value is " + Double.MAX_VALUE);
                System.out.println("-----------------------------------------");

                System.out.println("\nConversion methods ----------------------");

                Double d = Double.valueOf("4.269");

                System.out.println("\nSuppose a double with the value of 4.269! ");
                System.out.println("\nIts short value is: " + d.shortValue());
                System.out.println("Its byte value is: " + d.byteValue());
                System.out.println("Its int value is: " + d.intValue());
                System.out.println("Its float value is: " + d.floatValue());
                System.out.println("Its double value is: " + d.doubleValue());

                System.out.println("\n-----------------------------------------");

                System.out.println("\ncompareTo methods -----------------------");

                Double a = Double.valueOf("12.0");
                Double b = Double.valueOf("11.99");
                Double c = Double.valueOf("12.45");
                d = Double.valueOf("12.45");
                Float e = Float.valueOf("12.45");

                System.out.println("\nConsider these values:");
                System.out.println("a = " + a + ", b = " + b + ", c = " + c +
                                ", d = " + d + ", e = " + e + "\n");

                System.out.println("Using the compareTo method on a and b returns:"
                                + a.compareTo(b));
                System.out.println("Using the compareTo method on a and c returns:"
                                + a.compareTo(c));
                System.out.println("Using the compareTo method on c and d returns:"
                                + c.compareTo(d));
                System.out.println("You cannot compare e to any doubles, since " +
                                "e is a float!");

                System.out.println("\n-----------------------------------------");

                System.out.println("\nParsing methods -------------------------");

                System.out.println("\nThe value \"4\" parsed as an int is " +
                                Integer.parseInt("4"));
                System.out.println("The value \"42.69\" parsed as a double is " +
                                Double.parseDouble("42.69"));
                System.out.println("The value \"6.9\" parsed as a float is " +
                                Float.parseFloat("6.9"));
                System.out.println("The value \"32767\" parsed as a short is " +
                                Short.parseShort("32767"));
                System.out.println("The value \"400000000000\" parsed as a long is "
                                + Long.parseLong("400000000000"));

                System.out.println("\nKeep in mind that when we parse, if we try" +
                                "parsing a double or \nfloat via parseInt we get" +
                                " an error!");
                System.out.println("\nAlso: ranges apply so parseShort has a " +
                                "range\nfrom -32768 to 32767 similarly ranges" +
                                " apply to all parse methods.\n");

                System.out.println("-----------------------------------------");

                System.out.println("\nLarge factorials with BigInteger class---");

                System.out.println("\nSuppose the value of 42!. It is so large that" +
                                " the long type cannot contain it! ");

                // Computing 42!
                BigInteger result = BigInteger.ONE;
                for (int i = 1; i <= 42; i++) {
                        result = result.multiply(new BigInteger(i + ""));
                }

                System.out.println("\n42! is : " + result);

                System.out.println("\n-----------------------------------------");

                System.out.println("\nUsing the BigDecimal class---------------");

                BigDecimal dvalue = new BigDecimal("3.141");
                System.out.println("\nSuppose we define a function  y = cos(xpi)");

                System.out.println("Then we can construct a chart with x = 0, 1," +
                                "... given the approximation of PI as 3.141 ");

                System.out.println("\nx\t\ty");
                for (int i = 0; i < 3; i++) {
                        System.out.println(i + "\t\t"
                                        + Math.cos((dvalue.multiply(
                                                        new BigDecimal(String.valueOf(i)))).doubleValue()));
                }

                System.out.println("\n-----------------------------------------");

                System.out.println("\nBehavior of the String class-------------");

                System.out.println("\nSuppose gamma = \"Kelpie\" and" +
                                " ro = \"is bad at Java\"");

                // A string can be created with a literal or by literal assignment
                String gamma = new String("Kelpie");
                String ro = "is bad at Java";

                System.out.println("\ngamma was initialized to the object \"Kelpie\" ");
                gamma = "Kelp";
                System.out.println("After the line: gamma = Kelp, gamma now" +
                                " points to \"" + gamma + "\"");
                System.out.println("\nAlthough strings are immutable, we did not " +
                                "change \nthe string object, but created a new String"
                                + "\nobject for the variable gamma to point to!");

                ro = "Kelp";
                System.out.println("\nThe value of ro is also changed to \"" + ro + "\".");

                if (ro == gamma) {
                        System.out.println("The execution of this code implies that" +
                                        " ro and gamma are now equivalent or ==");
                        System.out.println("\nProof: ");
                        System.out.println("The memory location gamma points to " +
                                        gamma.hashCode());
                        System.out.println("The memory location of ro points to " +
                                        ro.hashCode());
                }

                System.out.println("\nString are often reused and as a result when" +
                                "\nthe same string literal is assigned to two " +
                                "\nidentical variables in the same runtime, they point" +
                                "\nto the same underlying object. (Until either changes)");

                System.out.println("\nThe JVM does this to save memory!");

                System.out.println("\nIf we want to avoid this default behavior" +
                                "\nwe can use the new keyword on both string objects" +
                                "\nto classify them as distinct objects with" +
                                "\ndistinct locations!");

                System.out.println("\n-----------------------------------------");

                System.out.println("\nString class methods---------------------");

                System.out.println("\nSuppose gamma = \"Kelpie\" and" +
                                " ro = \"is bad at Java\"");

                gamma = "Kelpie";
                ro = "is bad at Java";

                System.out.println("\nWe can use the replaceAll() method on ro" +
                                "\nto replace the word \"bad\" with \"good\".");

                ro = ro.replaceAll("bad", "good");

                System.out.println("\nThe resulting string is: " + ro);
                System.out.println("\nKeep in mind we had to reassign ro " +
                                "to a new calculated string object!");
                System.out.println("This means we are not changing the string" +
                                " itself, \nbut rather reassigning it to a string"
                                + " based on changes to the original.");

                System.out.println("\nreplace() and replaceAll() have similar"
                                + " functionality but replaceAll \ncan"
                                + " accept regex!");

                System.out.println("Regex can also be used in functions" +
                                "such as matches()");

                System.out.println("\nDoes \"Java is fun\" match \"Java.*\" ?");
                System.out.println("Java is fun".matches("Java.*"));

                System.out.println("\nDoes \"440-02-4534\" match"
                                + " \"\\d{3}-\\d{2}-\\d{4}\" ");
                System.out.println("(Each backslash \'\\' corresponds with " +
                                "two backslashes!) ");
                System.out.println("440-02-4534".matches("\\d{3}-\\d{2}-\\d{4}"));

                System.out.println("\n-----------------------------------------");

                System.out.println("\nConverting between Strings and Arrays----");

                System.out.println("\nEvery string can be represented as " +
                                "an array of characters and vice versa! ");

                System.out.println("\nThe toCharArray() method converts a " +
                                "string to a character array. ");
                System.out.println("The getChars method takes in a starting" +
                                " index a final index,\na char array, and" +
                                " another starting index!");

                System.out.println("\nSuppose the character array: kai = " +
                                "{'K', 'e', 'l', 'p', 'f', 'r', 'i', 'e', 's'}");

                char[] kai = "Kelpfries".toCharArray();

                System.out.println("\nAnd the string : hai = " +
                                "\"C32PO\"");
                String hai = "C32PO";

                System.out.println("When we call hai.getChars(2, 5, kai, 4)");
                hai.getChars(2, 5, kai, 3);
                System.out.println("We get : " + Arrays.toString(kai));

                System.err.println("\nWe took the values from index 2 to " +
                                "(5-1) 4 from hai and \nwrote them into kai" +
                                " starting from index 4 to index 6.");

                System.out.println("\n-----------------------------------------");

                System.out.println("\nThe StringBuilder and StringBuffer-------");

                System.out.println("\nWe know Strings are immutable, but what" +
                                " if we really want to consistently change a " +
                                "string?\nWe use the StringBuilder class!");

                StringBuilder sb = new StringBuilder();
                sb.append("Kelp is horrible at");
                sb.append(' ');
                sb.append("Java :(");

                System.out.println("\nSuppose we have a StringBuilder object " +
                                "initialized as \"Kelp is horrible at Java :(\"");

                System.out.println("\nWhen we call .reverse() it returns : " +
                                sb.reverse());

                System.out.println("The value of the StringBuilder object " +
                                "also changed to: " + sb);

                System.out.println("\nWhen we call StringBuilder methods, " +
                                "the value of the object changes and the object" +
                                " is returned. \nThe only exception is" +
                                " setCharAt which does not return the value. ");

                System.out.println("\nNow lets reverse the string once more " +
                                "to get our original string :\n" +
                                sb.reverse());

                System.out.println("\nWe call sb.replace(20, 24, \"Python\")" +
                                "\nto get: " + sb.replace(20, 24, "Python"));

                System.out.println("\nThen we call sb.delete(5,8) " +
                                "\nto get: " + sb.delete(5, 8));

                System.out.println("\nThere are many more methods, but these " +
                                "are the basics!\nYou can also chain methods" +
                                " on a StringBuilder object\nto make more" +
                                " efficent code! ");

                System.out.println("\n-----------------------------------------");

        }
}
