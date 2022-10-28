package assignments.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Abdul {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String fileName = "gibberish";
        String str;
        String input;
        Scanner fileReader;
        File file;

        System.out.println("Enter the phrase or word followed by the name of the text file: ");
        input = scn.nextLine();
        str = input.substring(0, input.lastIndexOf(" "));
        fileName = input.substring(input.lastIndexOf(" ") + 1);

        String fileString = "";
        try {

            file = new File("src/assignments/assignment2/" + fileName + ".txt");
            fileReader = new Scanner(file);
            // Initializing the file

            while (fileReader.hasNext()) {
                fileString += fileReader.nextLine() + "\n";
            }
            // Reading contents of file into fileString

            System.out.println(fileString);

            fileString = fileString.replaceAll(str, "");

            // String[] arr = fileString.split(" ");
            // for (int i = 0; i < arr.length; i++) {

            // if (arr[i].contains(str)) {
            // arr[i] = "";
            // }
            // }

            // String out = "";
            // for (String val : arr) {
            // out += val + " ";
            // }

            System.out.println(fileString);
            // Comparing original string with replacement string!

            PrintWriter pw = new PrintWriter(file);
            pw.write(fileString);
            // Rewriting the file.
            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // write
        // try (PrintWriter pw = new PrintWriter(
        // new File("src/assignments/assignment2/" + fileName + ".txt"))) {

        // } catch (Exception e) {

        // }
        scn.close();
    }
}
