package assignments.assignment2;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Abhinav {
    public static void main(String args[]) {

        File file = new File("src/assignments/assignment2/starwars.txt");

        if (file.exists() == false) {
            System.out.println("Please check Path your current path is:" + file.getAbsolutePath());
            // System.exit(0);
            return;
        }

        try {
            Scanner scanner = new Scanner(file);
            Scanner input = new Scanner(System.in);
            // String[] name = new String[10];
            // You were doing nothing with the line above
            File tempFile = new File("src/assignments/assignment2/starwarsMODIFIED.txt");
            PrintWriter writer = new PrintWriter(tempFile);

            System.out.println("Please Enter the text you want to remove from: ");
            String remove = input.nextLine();
            // So KEY IS THIS
            // YOU NEED TWO SCANNER OBJECTS
            // ONE FOR THE FILE, ONE FOR USER INPUT!

            while (scanner.hasNextLine()) {
                String tempe = scanner.nextLine();
                // System.out.println(tempe);
                // Debug instead of printing to console (just good practice!)
                String tempr = tempe.replaceAll(remove, "");
                writer.println(tempr);
                System.out.println(tempr);
                // Debug instead of printing to console (just good practice!)
            }

            writer.close();
            scanner.close();
            input.close();

            file.delete();
            tempFile.renameTo(file);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        /*
         * Feedback:
         * 
         * This was the cleanest code I received in terms of the approach to
         * the problem. The biggest thing you were missing was the try catch
         * block to address possible exceptions that may pop up when
         * creating the Scanner and PrintWriter objects with a File object!
         * 
         * Otherwise, the only other minor flaw was that you forgot to
         * initialize a second Scanner object for user input (as opposed to the
         * Scanner object you already made for reading the file).
         * 
         * Without the new Scanner object your user input code was mistakenly
         * looking into the file for user input. But the error is honestly
         * simple to overlook (it happens to me once in a blue moon).
         * 
         * The only thing you should do now is have a more specific catch block
         * or potentially more catch blocks to have a unique print statement
         * that addresses each possible error.
         * 
         * Also try test your program with various scenarios (try breaking it!)
         * Here are some suggestions
         * 
         * Make a file with many instances of one word as part of a substring
         * of other words!
         * Ex. Suppose file contains: John Johnny Johnson Mc-John
         * try deleting John and see how your program reacts (and ask yourself
         * if that is what it should do!)
         * 
         * Test if capitalization matters, if you wanted to make sure
         * it doesn't matter how would you modify your code?
         * 
         * And there's a lot more hypotheticals, but honestly
         * the code you gave me would probably get a 75, and with the try-catch
         * fully fleshed out here, I would give you a 100!
         * 
         * 
         */

    }// static
}
