package assignments.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        String target = args[0]; // Used "Star"
        String replacement = args[1]; // Used "car"
        String filename = args[2]; // Used starwars (.txt is appended for you)

        File file = new File("src/assignments/assignment2/" + filename + ".txt");
        // Replace the first half the filename with your appropriate directory!

        replaceWords(file, target, replacement);

    }

    // #region Replacement method

    public static void replaceWords(File file, String target, String replacement) {

        try {
            ArrayList<String> contents = readMe(file);
            // Could throw FileNotFoundException

            // We first read the file into an arraylist!
            for (int i = 0; i < contents.size(); i++) {
                contents.set(i, contents.get(i).replaceAll(target, replacement));
            }

            // We use arraylist .set() functionality to replace each line,
            // with a regex filtered version of the same line via replaceAll!

            writeMe(file, contents);

        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found");
            return;
        }

        // Another way to do this would be to use Files.readAllBytes()
        // and Files.write() with the appropriate chars and path.
        // We could read the file into a StringBuilder object
        // and then use the replaceAll functionality there as well,
        // and proceed to copy it over with the write method().

    }

    // #endregion

    // #region Assistant methods

    public static ArrayList<String> readMe(File file) throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<String>();

        try (Scanner reader = new Scanner(file)) {
            while (true) {
                String data = reader.nextLine();
                result.add(data);
            }
        } catch (NoSuchElementException e) {
            // If this exception is hit we are done reading the file!
        }

        return result;
        // If FNF exception was hit we throw it to the caller
        // Otherwise we deal with the NoSuchElementException
        // to keep track of when we reached the end of the file.
    }

    public static void writeMe(File file, ArrayList<String> contents) {

        // File writer writes to a file, (effectively overwritting all
        // content in the pre-existing file)

        try (FileWriter writer = new FileWriter(file)) {
            for (int i = 0; i < contents.size(); i++) {
                writer.write(contents.get(i) + "\n");
            }
        } catch (IOException e) { // Ideally this exception should never be triggered...
            System.err.println("The file specified was a directory, or could not be created!");
        }

    }

    // #endregion

}
