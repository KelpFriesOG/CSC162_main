package practice;

import java.util.Random;
import java.util.Scanner;

/* Programming Exercise 12.3 */

public class ArrayExceptions {

    static void isIndexOutOfBounds() {
        int[] arr = new int[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            arr[i] = rand.nextInt(1000);
        }

        System.out.println("Enter the array index you want to retrieve!: ");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();

        try {
            int value = arr[index];
            System.out.println("The value at index " + index + " was " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of bounds");
        } finally {
            input.close();
        }
    }

    public static void main(String[] args) {
        isIndexOutOfBounds();
    }
}
