package assignments.assignment2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {

        Random random = new Random();
        // Initializing random object

        int[] values = new int[100];
        // Creating an array for 100 elements

        for (int i = 0; i < 100; i++) {
            values[i] = random.nextInt(Integer.MAX_VALUE);
        }
        // Filling up the array with random elements

        try (Scanner input = new Scanner(System.in)) {
            // Scanner implements Closeable interface so it
            // can be used as a resource for a try block

            System.out.println("Enter an index to look for!");
            int index = input.nextInt();
            // Could throw InputMismatchException
            System.out.println("The value at index " + index + " is " + values[index]);
            // Could throw ArrayIndexOutOfBoundsException

        } catch (ArrayIndexOutOfBoundsException e) { // May be invoked from line 26
            System.out.println("Your index was out of range!");
        } catch (InputMismatchException e) { // May be invoked from line 28
            System.out.println("Your index was not an integer!");
        }

    }
}
