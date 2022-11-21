package notes;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Chapter12 {
    /*
     * Chapter 12: Exception Handling and I/O
     * 
     * Main Goals:
     * - Advantages of Exception handling
     * - Differentiating between exceptions and errors
     * - Declaring Exceptions in method signatures
     * - Throwing exceptions in methods
     * - Implementing try-catch blocks
     * - Use finally() in tandem with t-c blocks
     * - Rethrowing exceptions from a catch block
     * - Creating custom exceptions
     * - Chaining exceptions
     * - Deleting/Renaming files and creating directories
     * - Writing data to a file with PrintWriter
     * - Using try-with blocks to ensure resources are closed
     * - Reading from a file with Scanner
     * - Creating a program that replaces text within a file
     * - Developing a web crawler
     * 
     * Basics of try-catch--------------------------------------
     * 
     * A try-catch block is a way to catch exceptions which
     * may occur due to unexpected calculations.
     * 
     * A good example is the arithmetic error that occurs
     * if you attempt to divide a number by 0.
     * Instead of letting the error stop your program,
     * you can anticipate it using and if-else statement
     * or better yet a try catch block!
     * 
     * You can also integrate this process into methods
     * by throwing an error instead of continuing flow
     * to the error. So you can create a control flow
     * to anticipate the conditions of the error
     * (in this case the divisor being 0) and then
     * throw an ArithmeticException instead of returning
     * a value.
     * 
     * In the main method you can "catch" the thrown
     * exception using a try-catch block and then
     * print the appropriate message and carry on with
     * the program!
     * 
     * -------------------------------------------------------------------------
     * 
     * Types of Exceptions------------------------------------------------------
     * 
     * Class Heirarchy
     * 
     * ___________________Exception
     * Object---Throwable---|
     * ___________________Error
     * 
     * There are multiple types of exceptions, the ones that
     * occur most frequently for now are:
     * - ClassNotFoundException
     * - IOException
     * - RuntimeException
     * 
     * RuntimeExceptions include but are not limited to:
     * ArithmeticException, NullPointerException, IndexOutOfBoundsException,
     * and IllegalArgumentException
     * 
     * Exceptions are objects, which means they are instances of
     * the aforementioned classes of errors.
     * 
     * You can create a custom Exception by extending the Exception
     * class or one of its subclasses!
     * 
     * Errors are broadly considered exceptions but they are nothing alike.
     * Errors will halt your program due to some JVM internal failure,
     * which you can likely do nothing about. When an error occurs
     * the most you can do is exit from the execution
     * as gracefully as possible.
     * 
     * Exceptions on the other hand are caused by your program or
     * external circumstances on the program. These can be caught,
     * processed, and sometimes passed through.
     * 
     * Runtime exceptions are a subclass of the Exception class and
     * describe specific code errors such as bad casting, illegal accessing,
     * and numeric errors. These are 100% user errors caused by
     * faulty programming which must be dealt with.
     * 
     * Runtime exceptions and Errors and their subclasses are unchecked
     * exceptions: the compiler does not need you to check them via a
     * try-catch block, it just deals with it. All other exceptions
     * are checked exceptions that require handling via a try-catch block
     * to allow further program execution! (You could also declare
     * them in your method header... we get to that later)
     * 
     * -------------------------------------------------------------------------
     * 
     * Declaring and Catching Exceptions----------------------------------------
     * 
     * Every method has the ability to state the type of exceptions it
     * may throw. Unchecked exceptions are implicitly declared in each
     * method, but for all other exceptions you need to explicitly declare
     * that the method can throw that exception!
     * 
     * Suppose:
     * public void myMethod()
     * throws IOException, ClassNotFoundException {}
     * 
     * This indicates that the method MAY THROW an IOException or a
     * ClassNotFoundException.
     * 
     * When the method finds an error (exception) it can create an instance
     * of the appropriate exception type and throw it.
     * 
     * The program can generate an error, based on what it found
     * by running something like:
     * 
     * throw new IllegalArgumentException("Wrong Argument")
     * *Note that you have to write this line :)
     * 
     * Keep in mind that the keyword throws is used to declare an error,
     * whereas the keyword throw is used to throw an exception.
     * 
     * -------------------------------------------------------------------------
     * 
     * The finally() clause-----------------------------------------------------
     * 
     * If you want your code to be executed regardless of whether or not an
     * exception occurs, use the finally clause!
     * 
     * Suppose:
     * 
     * try{
     * // Some statement1
     * // Some statement2
     * // Some statement3
     * }
     * catch(Exception e){
     * // Catching the pesky exception! (statement4)
     * }
     * finally{
     * // final statements! (statement5)
     * }
     * statement6
     * 
     * If no execption occurs statements 1, 2, 3, 5, and 6 are executed in
     * that order!
     * Now if the exception occurs on statement1, then statements 1, 4, 5, and
     * 6 are executed in that order!
     * If an exception occurs on statement2, then statements 1, 2, 4, 5, and
     * 6 are executed in that order.
     * 
     * 
     * -------------------------------------------------------------------------
     * 
     * Custom Exceptions--------------------------------------------------------
     * 
     * Custom exceptions can be implemented by extending the Exception class for
     * the class relating to the error. Take for example we want an error
     * that prevents the user from initializing a Circle object with a negative
     * radius!
     * 
     * We can create the custom exception class InvalidRadiusException or
     * NegativeRadiusException which extends Exception. This class
     * would contain a constructor with the radius and we would use the
     * super keyword within the constructor to create an exception with
     * a custom string message with the help of the passed radius.
     * 
     * To use the error class in the Circle class, we would first
     * demonstrate that our constructor and setRadius method
     * can call the custom extension by using the keyword throws
     * in the method header.
     * 
     * Next we would create if else logic that would determine
     * the circumstances which would cause the error to generate!
     * 
     * Implementation can be found in
     * Circle.java
     * and
     * InvalidRadiusException.java
     * files. :)
     * 
     * -------------------------------------------------------------------------
     * 
     * The File Class-----------------------------------------------------------
     * 
     * A File object is a representation of the properties of a file or path
     * but does not contain any methods to read or write data from or into
     * a file. In other words we need separate classes to work on File I/O.
     * 
     * We can write data into file using the PrintWriter class. Methods within
     * the PrintWriter class mimic the syntax of System.out methods, and
     * include: print, println, and printf.
     * 
     * We can read data from a file using the Scanner class we have used for
     * user input thus far. All we need to do is substitute the System.in
     * argument from the File object and we can start reading the file.
     * 
     * Syntactically, there can be a plethora of errors that occur when
     * using the PrintWriter or Scanner classes on File objects
     * so it becomes neccessary to use them with try-catch blocks
     * to avoid errors for missing or already created files.
     * 
     * The best way to setup AutoCloseable classes such as Scanner and
     * PrintWriter that suggest you to close the object before ending
     * the program is to use them as resources within a try catch block.
     * 
     * Example:
     * try(PrintWriter pw = new PrintWriter(file)){
     * // Write into file
     * }
     * catch(Exception e){
     * 
     * }
     * 
     * When we use a resource, the try-catch block expects and accepts
     * objects from a subtype of the AutoCloseable class. That way
     * the try block can internally run the line pw.close() without user
     * interventation at the end of the try block or when exiting the block
     * due to an exception.
     * 
     * -------------------------------------------------------------------------
     * 
     * Reading Data from the Web------------------------------------------------
     * 
     * Any website on the internet is accesible via a URL
     * (Universal Resource Locator). We can use Java's built-in URL class
     * to pass a website's URL and read its contents as a file.
     * 
     * Because a website on the internet is at its core just a hosted file!
     * 
     * An exception class called the MalformedURLException helps us catch
     * any syntactical errors in the URL string we want to pass
     * 
     * Suppose:
     * try{
     * URL url = new URL("http://wwww.google.com/index.html")
     * }
     * catch(MalformedURLException e){
     * e.printStackTrace();
     * }
     * 
     * The string "http:wwww.google.com/index.html"
     * would throw a MalformedURLException!
     * 
     * To read the contents of a URL we act on it similar to a file using
     * a Scanner class (more complex classes for more complex use cases do
     * exist but the Scanner class works).
     * 
     * Extending the last example:
     * Scanner input = new Scanner(url.openStream)
     * 
     * -------------------------------------------------------------------------
     * A little bonus question:
     * 
     * Suppose that statement2 causes an exception in the following code.
     * 
     * try {
     * statement1;
     * statement2;
     * statement3;
     * }
     * catch (Exception1 ex1) {
     * }
     * catch (Exception2 ex2) {
     * throw ex2;
     * }
     * finally {
     * statement4;
     * }
     * statement5;
     * 
     * If no exception occurs so will both statement4 and statement5 be executed.
     * 
     * If the exception is of type Exception1 so will both statement4 and statement5
     * be executed.
     * 
     * If the exception is of type Exception2 so will statement4 be executed but
     * statement5 will not be executed.
     * 
     * If the exception is not Exception1 nor Exception2, so will statement4 be
     * executed but statement5 will not be executed.
     * 
     * -------------------------------------------------------------------------
     * 
     * In-Class Notes-----------------------------------------------------------
     * 
     * An exception is an error that happens in the code.
     * Ex. If you have an array of size 5, but you try to access the 6th index,
     * you will get an ArrayIndexOutOfBounds Exception.
     * 
     * Errors are fixable, but fixing the error with an if-else block
     * is not the best way to handle an exception. The best way is try
     * catch blocks
     * 
     * If the user does not enter the expected data type.
     * If the user enters a string but the computer wants an int,
     * an error called InputMismatchException is thrown.
     * 
     * If you put a try-catch block within a while loop,
     * the computer will always try to understand the input
     * (and throw the appropriate exception)
     * until an iteration occurs when no error is thrown.
     * 
     * You use a try catch block to handle user input edge cases, in other words
     * you assume the user is stupid and will try inputting anything!
     * 
     * Whenever you try to get data from a database you should expect to handle
     * NullPointerExceptions if the data is missing.
     * 
     * Exception is a class from which all other type of Exceptions
     * are extended.
     * 
     * The Throwable class has two child class, Exception and Error.
     * Under each exists the plethora of types of Exceptions and errors.
     * The RuntimeException class has subclasses that represent exceptions
     * that occur during runtime (ex. IndexOutOfBounds, IllegelArgumentException).
     * 
     * Exceptions are caused by your program and external circumstances,
     * but Errors occur due to Internal errors that you as a developer
     * rarely have the tools to resolve (other than reinstalling or updating
     * your compiler).
     * 
     * Runtime errors as known as unchecked exceptions,
     * all other errors checked exceptions.
     * 
     * Whenever you make your own method, it can throw
     * an exception if you declare the header appropriately.
     * The exception can then be handled by the program which calls the
     * method.
     * 
     * Exceptions cannot be returned, its more appropriate to throw them.
     * 
     * Often times the finally portion of the try-catch statement is
     * excluded. The finally block is the last part of a try-catch statement
     * that is always executed regardless of whether or not you run into an
     * exception in the the try block.
     * 
     * This is usually used to close streams of data after reading up
     * and processing the data in the try portion of the try-catch block.
     * 
     * You can replace simple exception handling with if-else statements,
     * but try-catch blocks are better for complex cases in which we do not
     * know what exception we will have to handle.
     * 
     * 
     * 
     * 
     * -------------------------------------------------------------------------
     * 
     * 
     */

    // #region Exception Throwing Examples
    public static int quotient(int n1, int n2) {
        if (n2 == 0) {
            throw new ArithmeticException("Divisor cannot be 0");
        }
        return n1 / n2;
    }

    public static void method1(int n) {
        try {
            method2(n / 2);
        } catch (Exception e) {
            // All exceptions will be caught by this point since
            // Exception is a superclass of all exceptions!
            System.out.println(e.getMessage());
            System.out.println("Exception caught in method 1");
        }
    }

    public static void method2(int n) {
        try {
            method3(n);
        } catch (ArithmeticException e) { // This catch is ignored!
            System.out.println(e.getMessage());
            System.out.println("Exception caught in method 2");
        }
    }

    public static void method3(int n) throws ArithmeticException {
        throw new ArithmeticException("Exception from method 3");
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // #endregion

    @SuppressWarnings("all")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // #region Try-Catch block examples
        int bobo = 0;
        // Prompting user for two ints
        System.out.println("Enter two integers: ");
        int number1 = input.nextInt();
        int number2 = input.nextInt(); // Exception

        try {
            int result = quotient(number1, number2);
            System.out.println(number1 + " / " + number2 +
                    " is " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println("Caught some exception.");
            // This catch block is like an else statement in
            // the sense that if our specific exception is not
            // found but some other exception pops up,
            // this line will account for it!

            // Switching the order of the catch blocks will
            // throw an error! Since Exception is a superclass
            // of any other exception it needs to be checked for
            // last in any chain of catch blocks!
        }

        // #endregion

        // #region Exception parsing through methods

        method1(4);

        // #endregion

        // #region Getting information from exceptions

        try {
            System.out.println(sum(new int[] { 1, 2, 3, 4, 5 }));
            // The sum method will try to find a 6th element and
            // run into an exception.
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n" + e.getMessage());
            System.out.println("\n" + e.toString());

            System.out.println("\nTrace Information from getStackTrace");
            StackTraceElement[] traceElements = e.getStackTrace();
            for (int i = 0; i < traceElements.length; i++) {
                System.out.print("method :" +
                        traceElements[i].getMethodName());
                System.out.print("(" + traceElements[i].getClassName() + ":");
                System.out.println(traceElements[i].getLineNumber() + ")");
            }

        }

        System.out.println("\nContinuing the program!");

        System.out.println("---------------------------------------------------");

        // #endregion

        // #region The finally() clause and try-catch-finally flow

        int a = 0;
        int[] arr = { 1, 2, 4, 8 };

        System.out.println("Example 1---------------------------------");

        try {
            int c = a + 5; // This line is executed first
            int d = 4 / a; // First error occurs here! (EXECUTED 2nd)
            System.out.println(d); // NOT EXECUTED
            int e = a + c; // NOT EXECUTED
        } catch (Exception e) {
            System.out.println(e.getMessage()); // EXECUTED 3rd
        } finally {
            System.out.println("This line should always print!\n");
            // EXECUTED 4th
        }

        System.out.println("Example 2---------------------------------");

        try {
            int c = a + 5; // This line is executed first
            int d = 4 / a; // EXECUTED 2nd
            // First error occurs here but is ignored for now
            // because it is unchecked arithmetic error!(EXECUTED 2nd)
            sum(arr); // WE DON'T EXECUTE THIS LINE

        } catch (IndexOutOfBoundsException e) { // We have an error
            // but not this error
            e.getMessage(); // SKIPPED CATCH BLOCK
            System.out.println("Hit first catch block!"); // SKIPPED CATCH BLOCK
        } catch (ArithmeticException e) { // We have this error!
            e.getMessage(); // EXECUTED 3d
            System.out.println("Hit second catch block!"); // EXECUTED 4th
        }

        finally { // HIT THE FINALLY BLOCK
            System.out.println("This line should always print!\n");
            // EXECUTED 5th
        }

        System.out.println("Example 3---------------------------------");

        try {
            sum(arr); // EXECUTED 1st (triggers exception)
            int d = 4 / a;
        } catch (ArithmeticException e) { // Not this error
            System.out.println(e.getMessage());
            System.out.println("Hit first catch block!");
        } catch (IndexOutOfBoundsException e) { // yes!
            System.out.println(e.getMessage()); // EXECUTED 2nd
            System.out.println("Hit second catch block!"); // EXECUTED 3rd
        } catch (Exception e) {
            // Not hit since only one catch block
            // is triggered per try statement. This catch block
            // would be reccommended nonetheless since it catches any
            // exception that may be unaccounted for by the previous
            // catch blocks
            System.out.println(e.getMessage());
            System.out.println("Hit third catch block");
        }

        finally {
            System.out.println("This line should always print!");
            // EXECUTED 4th
        }

        System.out.println("Handled some errors!\n");
        System.out.println("---------------------------------------------------");
        // #endregion

        // #region Custom exceptions with Circle class

        try {
            new Circle(5);
            new Circle(0);
            new Circle(-5); // This line should trigger custom error!
        } catch (InvalidRadiusException e) {
            System.out.println(e.getMessage());
            System.out.println(Circle.getNumberOfObjects() +
                    " circles were initialized!");
        }

        System.out.println("---------------------------------------------------");

        // #endregion

        // #region Writing to a File object representation

        File file = new File("scores.txt");

        // Creating the file
        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Writing to the file
        // PrintWriter discards the existing contents
        // of a file if it is exists, so if scores.txt exists.
        // its content will be replace in whole by
        // what we specify to PrintWriter!
        // We could also call PrintWriter with a non-existing
        // file and it would create it for us.
        // (Based on the path specified by the file object)
        try (PrintWriter output = new PrintWriter(file)) {
            output.print("Kalpes Chavan ");
            output.println(90);
            output.print("Henry Ford ");
            output.println(70);
            // output.close();
            // Since we are using a PrintWriter object as a
            // resource in the try-catch block, it closes automatically!
            // Any resource of a tryblock must be a subtype of
            // AutoCloseable class
            System.out.println("Wrote to the file");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("---------------------------------------------------");

        // #endregion

        // #region Reading from a file object representation
        File registrar = new File("src/notes/registrar.txt");

        try (Scanner filereader = new Scanner(registrar)) {
            while (true) {
                String firstName = filereader.next();
                String mi = filereader.next();
                String lastName = filereader.next();
                int score = filereader.nextInt();

                System.out.println(firstName + " " + mi + " " +
                        lastName + " SCORE: " + score);
            }

        } catch (NoSuchElementException e) {
            System.out.println("Finished reading the file!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------------------------");

        // #endregion

        // #region Reading a Website URL

        try {
            URL url = new URL("https://youtu.be/TF21AsQZWDU");
            Scanner webreader = new Scanner(url.openStream());
            int count = 0;
            while (webreader.hasNext()) {
                String line = webreader.nextLine();
                count += line.length();
            }

            System.out.println("The URL file size is : " + count +
                    " characters!");
            webreader.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        // #endregion

        input.close();
    }
}
