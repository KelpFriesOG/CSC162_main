package assignments.assignment3;

import java.util.Scanner;

public class TestingClass {
    public static void main(String[] args) {

        System.out.println("\nAssignment 3: Recursive count() and reverseDisplay methods!");
        Scanner input = new Scanner(System.in);

        // For question 1, a constructor that passes a character and a string
        // is used.
        // For question 2, a constructor that passes a single String variable
        // is used.

        // #region Question 1

        try {

            boolean validInput = false;
            char findMe;
            // Initializing auxillary variables
            // validInput will control loop flow until user puts in valid
            // single character.
            // findMe is where the letter will be stored but is initialized here.

            System.out.println("\nPlease enter a string: ");
            String value = input.nextLine();
            // Taking in user inputted string

            while (!validInput) {
                System.out.println("\nEnter a character to search for: ");
                String target = input.nextLine();
                if (target.length() == 1) {

                    findMe = target.charAt(0);
                    validInput = true;
                    // The loop will only break when validInput is true,
                    // this will happen if the given string is of length 1!

                    ChildCount childObj = new ChildCount(value, findMe);
                    // We call the ChildString and consequently the ParentString classes'
                    // overloaded constructors for question 1!
                    // We make a childObj with the user inputted values and letter.

                    System.out.println("\nThere are " + childObj.count() +
                            " instances of the character '" + findMe
                            + "' in the string!");
                    // count() is called and does not need parameters since object
                    // has everything it needs.

                } else {
                    System.out.println("The input needs to be a single character"
                            + ", try again!");
                    // Or else we show a message and continue the loop
                }

            }

            System.out.println("\n-----------------------------------------");

        } catch (Exception e) {
            System.out.println("An exception has occurred!");
            e.printStackTrace();
        }

        // #endregion

        // #region Question 2

        try {

            System.out.println("Please enter a string: ");
            String value = input.nextLine();
            // Taking in user inputted string

            ChildReverse childObj = new ChildReverse();
            // Creating child object with string

            System.out.println("\nThe reversed string is: ");
            childObj.reverseDisplay(value);
            // Calling reverseDisplay method which prints the string in reverse!

        } catch (Exception e) {
            // Should ideally never get an exception
            // but just in case!
            System.out.println("An exception has occurred!");
            e.printStackTrace();
        }

        // #endregion

        input.close();
        // Closing the scanner object

    }
}
