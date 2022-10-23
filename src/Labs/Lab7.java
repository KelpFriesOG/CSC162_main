package labs;

import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        ISBN13 isbn = new ISBN13();

        boolean incorrectInput = true;

        while (incorrectInput) {
            try {
                System.out.println("Enter the first 12 digits of an ISBN-13 number as a number:");
                String number = kbd.next();
                isbn.calculateISBN(number);
                incorrectInput = false;
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("The user entered value was too short!");
                kbd.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("The string has an invalid, non-numeric, character!");
                kbd.nextLine();
            }
        }

        kbd.close();

    }
}
