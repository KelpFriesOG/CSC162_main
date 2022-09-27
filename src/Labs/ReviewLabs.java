package labs;

import java.util.Scanner;

@SuppressWarnings("resource")
public class ReviewLabs {

    // #region Question 1 (Palindrome integer)
    static void Question1() {

        Scanner input = new Scanner(System.in);
        // Initializing the scanner object

        System.out.println("Enter a three-digit integer: ");
        int val = Math.abs(input.nextInt());
        int fdigit = val / 100;
        int sdigit = (val - fdigit * 100) / 10;
        int ldigit = val - (fdigit * 100 + sdigit * 10);
        // Getting input integer and processing its digits

        if (val >= 0 && fdigit == ldigit) {
            System.out.println("Number is a palindrome!");
        } else {
            System.out.println("Number is not a palindrome!");
        }
        // If the first and last digit are identical the number
        // is a palindrome (for a three digit number).
        // Otherwise it is not.

    }

    // #endregion

    // #region Question 2 (Use the &&, || and ^ operators)

    static void Question2() {

        Scanner input = new Scanner(System.in);
        // Initializing the scanner object.

        System.out.println("Enter an integer: ");
        int val = input.nextInt();
        // Getting user input

        System.out.println("Is " + val + " divisible by 5 and 6? " +
                (val % 5 == 0 && val % 6 == 0));
        System.out.println("Is " + val + " divisible by 5 or 6? " +
                (val % 5 == 0 || val % 6 == 0));
        System.out.println("Is " + val + " divisible by 5 or 6, but not both? " +
                (val % 5 == 0 ^ val % 6 == 0));
        // Determining divisibility via boolean logic
        // (AND, OR, XOR)

    }

    // #endregion

    // #region Question 3 (Vowel or consonant?)

    static void Question3() {

        Scanner input = new Scanner(System.in);
        // Initialzing the scanner object

        System.out.println("Enter a letter: ");
        String rawinput = input.next();
        char letter = rawinput.toLowerCase().charAt(0);
        // Getting and processing user inputted letter
        // We format it to be lowercase for easy comparison

        boolean isLetter = (int) letter >= 97 && (int) letter <= 122;
        // (int) letter >= 65 && (int) letter <= 90) would also
        // need to be checked if the character was not formatted.
        // If the user char is not a letter than it cannot be
        // a vowel or a consonant

        boolean isVowel = letter == 'a' || letter == 'i' ||
                letter == 'e' || letter == 'o' || letter == 'u';

        if (isVowel && isLetter) {
            System.out.println(rawinput.charAt(0) +
                    " is a vowel!");
        } else if (!isLetter) {
            System.out.println(rawinput.charAt(0) +
                    " is an invalid input!");
        } else {
            System.out.println(rawinput.charAt(0) +
                    " is a consonant!");
        }
        // First condition checks if the user input was a vowel
        // and if it was a letter.
        // Second condition checks if the input was a letter
        // If the input is a letter but not a vowel,
        // then the only possible thing it can be is a consonant.

    }

    // #endregion

    // #region Question 4 (Conversion from kilograms to pounds)

    static void Question4() {

        final double KILO_TO_POUNDS = 2.2;
        // Constant value to use for table generation

        int i = 0;
        while (i < 200) {
            if (i == 0) {
                System.out.println("Kilograms\tPounds");
                i++;
            }
            System.out.printf("%-15d %.1f \n", i, i * KILO_TO_POUNDS);
            i += 2;
        }
        // Loop makes the table for every 2 entries
        // beginning with kg = 1 and going to 200

    }

    // #endregion

    // #region Question 5 (Reverse a string)

    static void Question5() {

        Scanner input = new Scanner(System.in);
        // Initializing the scanner object

        System.out.println("Enter a string: ");
        char[] word = input.next().toCharArray();
        // Taking in user input

        System.out.print("The reversed string is: ");

        for (int i = word.length - 1; i >= 0; i--) {
            System.out.print(word[i]);
        }
        // Constructing and printing the reversed string.

    }

    // #endregion

    // #region Question 6 (Display an integer reversed)

    static void reverse(int number) {

        int reverseVal = 0;
        // Initializing reversed int (to be returned)

        while (number != 0) {
            reverseVal = reverseVal * 10 + (number % 10);
            // Adding (incrementing the reverse value)
            // we start with the one's place, then the ten's
            // place and continuing to the first digit.
            number /= 10;
            // Truncating the original number!
        }

        System.out.print(reverseVal);
    }

    static void Question6() {

        Scanner input = new Scanner(System.in);
        // Initializing the scanner object.

        System.out.println("Enter an integer: ");
        int insertion = input.nextInt();
        // Taking user input.

        System.out.println("The reversed integer is: ");
        reverse(insertion);
        // Calling helper function to reverse the integer.

    }

    // #endregion

    // #region Question 7 (Occurences of a specified character)

    static int count(String str, char a) {

        char[] word = str.toCharArray();
        // Converting input string to char array

        int count = 0;

        for (int i = 0; i < word.length; i++) {
            if (word[i] == a) {
                count++;
            }
        }
        // If the letter at any point in the array
        // matches the user specified letter,
        // we increment the count.

        return count;
        // returning number of instances of specified
        // character.
    }

    static void Question7() {

        Scanner input = new Scanner(System.in);
        // Initializing the scanner object.

        System.out.println("Enter a string: ");
        String str = input.nextLine();
        System.out.println("Enter a char to match against: ");
        char checkChar = input.next().toCharArray()[0];
        // Getting and processing user input for the count()

        System.out.println("The char: " + checkChar + ", occurs "
                + count(str, checkChar) + " times in the string.");
        // Calling the count() function with user input.

    }

    // #endregion

    // #region Question 8 (Find the smalled element)

    public static double min(double[] array) {

        double minimum = array[0];
        // Initializing the value of the minimum

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
            }
        }
        // Checking every value in the array
        // (Except the first value which is the
        // defacto minimum)
        // If any array value is smaller than
        // the current minimum it becomes
        // the value of the new minimum.

        return minimum;
        // Returning the minimum

    }

    static void Question8() {

        Scanner input = new Scanner(System.in);
        // Initializing the scanner object.

        System.out.println("Enter 10 numbers (hit enter after each value): ");
        double[] arr = new double[10];
        // Initializing the array.

        for (int i = 0; i < 10; i++) {
            arr[i] = input.nextDouble();
        }
        // Inputting 10 values into the array sequentially
        // value1 hit enter... value2 hit enter...

        System.out.println("The minimum number is " +
                min(arr));
        // Calling the minimum function with the filled
        // array.

    }

    // #endregion

    public static void main(String[] args) {
        // Uncomment code below line by line
        // to test the corresponding question.

        // Question1();
        // Question2();
        // Question3();
        // Question4();
        // Question5();
        // Question6();
        // Question7();
        // Question8();

    }
}
