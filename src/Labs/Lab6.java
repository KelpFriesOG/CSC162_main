package labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab6 {
    public static double total(File file) {

        double total = 0;

        try {
            Scanner input = new Scanner(file);
            while (input.hasNextDouble()) {
                double data = input.nextDouble();
                total += data;
            }
            input.close();
            // If you wanted to avoid writing the while loop
            // remember that a EOF Exception (End of File)
            // occurs when you no longer have a nextDouble or any
            // next token to use.
            // We can detect this exception in the catch block to stop
            // the loop
            // However hasNextDouble accomplishes the same thing
            // without having to specify catching an EOF exception.
        } catch (FileNotFoundException e) {
            System.out.println("File was not found, make sure file" +
                    " name \nends with .txt and that the search directory is correct");
            e.printStackTrace();
        }

        return total;
    }

    public static double average(File file) {

        ArrayList<Double> result = new ArrayList<Double>();

        try {
            Scanner input = new Scanner(file);
            while (input.hasNextDouble()) {
                double data = input.nextDouble();
                result.add(data);

            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found, make sure file" +
                    " name \nends with .txt and that the search directory is correct");
            e.printStackTrace();
        }

        return total(file) / result.size();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###.###");
        // DecimalFormat is kind of unneccesary to get the right values,
        // I just used it on the avg calculation to
        // round an answer like 79.27982789 to something more legible.

        System.out.println("Enter the file name");
        System.out.println("(make sure the file is in the same folder and your input ends with .txt): ");
        String filename = input.next();

        File file = new File("src/labs/" + filename);
        // Modify this line based on your folder structure.
        // Everyone should have a src folder ideally if they
        // are working from an eclipse project.
        // Just modify the first string

        // The inputted filename SHOULD END WITH .txt
        // Then this line correctly searches for the scores.txt file

        System.out.println("The total of scores is: " + total(file));
        System.out.println("The average of scores is: " + df.format(average(file)));

        input.close();

    }

}
