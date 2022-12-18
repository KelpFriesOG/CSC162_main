package assignments.assignment4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestingClass {
    public static void main(String[] args) {

        Scanner kbd = new Scanner(System.in);
        Random rand = new Random();
        // Initializing scanner and random objects.

        System.out.println("How many Characters do you want in the 1st array?: ");
        int nChars = kbd.nextInt();
        // Prompting user for number of values to put into Character ArrayList.

        System.out.println("How many Integers do you want in the 2nd array?: ");
        int nInts = kbd.nextInt();
        // Prompting user for number of values to put into Integer ArrayList.

        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < nChars; i++) {
            list.add((char) (rand.nextInt(26) + 'a'));
        }
        // Populating Character ArrayList.

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < nInts; i++) {
            list2.add(rand.nextInt(10));
        }
        // Populating Integer ArrayList.

        // #region Object methods on Characters

        /*
         * Creating objects and executing methods based on Character class
         * substitution for generic type.
         */

        ChildRemoveDuplicates<Character> removeDupsObj1 = new ChildRemoveDuplicates<Character>(list);
        ChildMax<Character> maxObj1 = new ChildMax<Character>(list);

        System.out.println("--- Results of Character Array ---\n");

        System.out.println("Original Array: ");
        System.out.println(list);
        System.out.println("Max in array: ");
        System.out.println(maxObj1.max());
        System.out.println("Array with duplicates removed: ");
        System.out.println(removeDupsObj1.removeDuplicates() + "\n");

        // #endregion

        // #region Object methods on Integers

        /*
         * Creating objects and executing methods based on Integer class
         * substitution for generic type.
         */

        ChildRemoveDuplicates<Integer> removeDupsObj2 = new ChildRemoveDuplicates<Integer>(list2);
        ChildMax<Integer> maxObj2 = new ChildMax<Integer>(list2);

        System.out.println("--- Results of Integer Array ---\n");

        System.out.println("Original Array: ");
        System.out.println(list2);
        System.out.println("Max in array: ");
        System.out.println(maxObj2.max());
        System.out.println("Array with duplicates removed: ");
        System.out.println(removeDupsObj2.removeDuplicates() + "\n");

        // #endregion

        kbd.close();

    }
}
