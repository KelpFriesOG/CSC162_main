package assignments.assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class TestInheritance {
    public static void main(String[] args) {

        System.out.println("Enter 10 integers (hit enter after last value): ");
        Scanner input = new Scanner(System.in);

        String[] values = input.nextLine().split(" ");

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < values.length; i++) {
            arr.add(Integer.parseInt(values[i]));
        }

        Child child = new Child(arr);

        child.removeDuplicates();

        input.close();

    }
}
