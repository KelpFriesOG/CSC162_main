package notes;

import java.util.Scanner;

public class JavaReviewNotes {

    /*
     * Author: Kalpesh Chavan
     * Date: 12 Sept 2022
     * 
     * In-class review notes will be on paper, example code will
     * be put in the main method or other static methods. This is being
     * done such that the notes can be used on tests later into the course.
     * 
     * 
     * The similarities between Java and Python are very very similar.
     * I have already taken notes on half of the forthcoming material,
     * so if you need or want access to that let me know.
     * 
     * Midterms can have up to 3 cheat sheets.
     * There is a lot of coding.
     * 
     * 
     * Review 2 Notes (Chapters 4, 7):
     * 
     * The Math class provides useful functions for
     * performing common mathematical operations.
     * 
     * Math class constants:
     * - PI
     * - E
     * 
     * Class methods:
     * - Trig methods,
     * - Exponent methods,
     * - min, max, abs, and random methods
     * 
     * Most often we will use these functions:
     * exp()
     * - returns e returned to the power of a
     * log()
     * - returns the natural logarithm of a.
     * log10()
     * - returns the 10-based log of a.
     * pow()
     * - returns a raised to the power of b.
     * sqrt()
     * - returns the sqrt of a
     * 
     * ceil()
     * - returns x rounded up to its nearest int.
     * - returns a double
     * floor()
     * - x is rounded down to its nearest int.
     * - returns a double
     * 
     * random()
     * - returns a random double value in the range
     * of [0.0, 1.0)
     * 
     * 
     * 
     */

    static void ElementaryProgram() {
        Scanner kbd = new Scanner(System.in);
        System.out.println("Enter a radius");
        double radius = kbd.nextDouble();
        System.out.println("The area of a circle with a radius of" +
                radius + " is : " + Math.pow(radius, 2) * Math.PI);
        kbd.close();

    }

    public static void main(String[] args) {
        ElementaryProgram();
    }

}
