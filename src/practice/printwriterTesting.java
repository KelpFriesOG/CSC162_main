package practice;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class printwriterTesting {
    public static void main(String[] args) throws IOException {
        // variables
        String inputFileName;
        String outputFileName;
        String item;
        int quantity;
        float price;

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter input file name: ");
        inputFileName = kb.nextLine();

        File myfile = new File("src/practice/" + inputFileName + ".txt");
        Scanner inFile = new Scanner(myfile);

        System.out.println("Enter output file name: ");
        outputFileName = kb.nextLine();

        PrintWriter outFile = new PrintWriter("src/practice/" + outputFileName);

        float total = 0;
        while (inFile.hasNextLine()) {
            item = inFile.nextLine();
            quantity = inFile.nextInt();
            price = inFile.nextFloat();
            
            if (inFile.hasNextLine()) {
                inFile.nextLine();
            }

            total = quantity * price;

            System.out.println(item + "  " + quantity + "  " + "  " + price + "  " + total);
        }

        inFile.close();
        outFile.close();

    }
}
