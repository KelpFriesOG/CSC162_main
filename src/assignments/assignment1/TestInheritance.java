package assignments.assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class TestInheritance {
    public static void main(String[] args) {

        System.out.println("Enter 10 integers: ");
        Scanner input = new Scanner(System.in);

        String[] values = input.nextLine().split(" ");

        ArrayList<Integer> arr = new ArrayList<Integer>();

        try {
            for (int i = 0; i < values.length; i++) {
                arr.add(Integer.getInteger(values[i]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Child.removeDuplicates(arr);

        System.out.println("The 10 distinct integers are: ");

        try {
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i) + " ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        input.close();

    }
}
