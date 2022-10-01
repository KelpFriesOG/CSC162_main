package practice;

import java.util.Scanner;

/* Programming Exercise 12.1 from textbook 12.1 */

public class Calculator {

    static double calculate(double a, String operand, double b)
            throws IllegalArgumentException {
        if (operand.equals("+")) {
            return a + b;
        } else if (operand.equals("-")) {
            return a - b;
        } else if (operand.equals("*")) {
            return a * b;
        } else if (operand.equals("/")) {
            return a / b;
        } else {
            throw new IllegalArgumentException("Invalid operand");
        }
    }

    @SuppressWarnings("resource")
    static void withErrorHandling() {
        System.out.println("Enter your prompt");
        Scanner input = new Scanner(System.in);

        String[] prompt = input.nextLine().split(" ");

        try {
            Integer.parseInt(prompt[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + prompt[0]);
        }

        try {
            Integer.parseInt(prompt[2]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + prompt[2]);
        }

        int a = Integer.parseInt(prompt[0]);
        int b = Integer.parseInt(prompt[2]);

        System.out.println(calculate(a, prompt[1], b));

    }

    @SuppressWarnings("resource")
    static void withoutErrorHandling() {
        System.out.println("Enter your prompt");
        Scanner input = new Scanner(System.in);

        String[] prompt = input.nextLine().split(" ");

        int a = Integer.parseInt(prompt[0]);
        int b = Integer.parseInt(prompt[2]);

        System.out.println(calculate(a, prompt[1], b));

    }

    public static void main(String[] args) {
        withErrorHandling();
        withoutErrorHandling();
    }
}
