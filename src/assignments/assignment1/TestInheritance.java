package assignments.assignment1;

import java.util.ArrayList;
import java.util.Scanner;

/* Author: Kalpesh Chavan
 * Date: 10/03/2022
 * Prof Suero
 * CSC162 Assignment 1
 * Testing class
*/

public class TestInheritance {
    public static void main(String[] args) {

        System.out.println("Enter 10 integers (hit enter after last value): ");
        Scanner input = new Scanner(System.in);

        // Another way to take in the integers below--
        // ArrayList<Integer> arr = new ArrayList<Integer>();

        // for(int i = 0; i < 10; i++){
        // System.out.println("Enter integer no. "+(i+1));
        // int x = input.nextInt();
        // arr.add(x);
        // }

        String[] values = input.nextLine().split(" ");

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < values.length; i++) {
            arr.add(Integer.parseInt(values[i]));
        }

        Child child = new Child(arr); // Make the child object
        // Parent par = new Child(arr);

        // The printing to console and formatting happens in the method.
        child.removeDuplicates();

        // Implementation that returns the pure array list
        // child.removeDuplicates2();

        // Fast implementation (I think) with formatting
        // and printing required on the front side
        // child.fastRemoveDups();

        // System.out.println("The distinct integers are: ");

        // ArrayList<Integer> list = child.getList();

        // try {
        // for (int i = 0; i < list.size(); i++) {
        // System.out.print(list.get(i) + " ");
        // }
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // }

        input.close();

    }
}
