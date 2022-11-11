package labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingTheGettysburg {
    public static void main(String[] args) {

        try {

            Scanner reader = new Scanner(new File("src/labs/gettysburgaddress.txt"));
            // Initializing scanner object to read a file.

            int count = 0;
            // Initializing a count variable.

            while (reader.hasNext()) {
                // This loop runs as long as we have a
                // token to read after each iteration.
                reader.next();
                // We call reader.next() to get the next
                // whole continuous string token. This line also
                // returns the value of the token,
                // but we don't do anything with it.
                count += 1;
                // We increment the count for each word we hit.

                /*
                 * The strict definition of a word in this context
                 * is a countinous string which is separated on
                 * both sides with a whitespace.
                 * 
                 * This means that if the string "19" is encountered
                 * we still count it as a word. If we wanted to
                 * avoid this for some reason we could could
                 * try using a try-catch with Integer.parseInt()
                 * 
                 * Furthermore it would be possible for punctuation
                 * to accidently count as a word if both sides of the
                 * symbol were separated by a whitespace.
                 * 
                 * Example:
                 * "Kalpesh is a , student"
                 * The line above will have 5 words,
                 * because the comma will be counted as a token.
                 * 
                 */
            }

            System.out.println("The length of the file was: " + count + " words!");

        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        } catch (Exception e) {
            System.out.println("ERROR:");
            System.out.println(e.getMessage());
        }
    }
}
