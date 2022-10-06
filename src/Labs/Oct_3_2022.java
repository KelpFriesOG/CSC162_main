package labs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Oct_3_2022 {
    public static void main(String[] args) {

        boolean errorFound = false;

        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Enter the first integer: ");
                int a = input.nextInt();

                System.out.println("Enter the second integer:");
                int b = input.nextInt();

                System.out.println(a + b);

                errorFound = false;

                input.close();

            } catch (InputMismatchException error) {

                System.out.println("Error found!");
                error.printStackTrace();
                errorFound = true;
            }

        
        } while (errorFound);

    }
}
