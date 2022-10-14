package labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* Modified version of Smit's Lab,
 * great work with the original!
 */

public class ProcessScore {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);// create a Scanner for user to input file name

        System.out.print("Enter the file name you created: ");
        String filename = input.next();
        // created scanner for file

        int total = 0;
        int count = 0;

        input.close();

        try (Scanner fileInput = new Scanner(new File("src/labs/" + filename))) {
            // The new File portion may throw a FileNotFoundException!

            if(!fileInput.hasNext()){
                System.out.println("Warning: The file is empty!");
            }

            while (true) {
                // When there are no more elements to get, the Scanner object
                // is said to be "exhausted" and throws the NoSuchElementException.
                total += fileInput.nextInt();
                count++;
            }

            // File file = new File("src/labs/" + filename)
            // System.out.println(file.exists());// here it returns true if there is a file
            // System.out.println(fileInput.hasNext());// return true if it is true

        }

        catch (FileNotFoundException e) {
            System.out.println("Could not find the file with the name: " + filename);
        } catch (NoSuchElementException e) { // Ideally this exception should be hit!
            System.out.println("Finished reading the file.");

            if (total == 0) {
                System.out.println("The file was empty!");
            } else {
                System.out.println("The total is: " + total);
                System.out.println("The average is: " + total / count);
            }
        } catch (Exception e) {
            System.out.println("An unknown error occured!");
            System.out.println(e.getMessage());
        }

    }

}
