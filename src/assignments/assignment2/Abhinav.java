package assignments.assignment2;

import java.io.File;
import java.util.Scanner;

public class Abhinav {
    public static void main(String[] args) {
        String a;
        a = "jhon jhon playing and dancing is playing";

        File file = new File("src/assignments/assignment2/starwar.txt");

        try {
            Scanner scanner = new Scanner(file); // May throw error
            Scanner input = new Scanner(System.in);

            System.out.println("Please Enter the text you want to remove from: " + a);
            String value = input.nextLine();
            String g = "";

            a += scanner.nextLine();

            String newa = a.replaceAll(value, g);

            System.out.println(newa);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
