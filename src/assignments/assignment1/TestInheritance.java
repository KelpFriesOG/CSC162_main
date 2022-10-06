package assignments.assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class TestInheritance {
    public static void main(String[] args) {

        System.out.println("Enter 10 integers (hit enter after last value): ");
        Scanner input = new Scanner(System.in);

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

        child.removeDuplicates();

        input.close();

    }
}
