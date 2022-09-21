package Labs;

import java.util.Random;

public class Sept14_2022 {
    static void craps() {
        Random random = new Random();

        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        int sum = dice1 + dice2;

        System.out.println("Rolling the dice!");

        System.out.println("You rolled " + dice1 + " + " + dice2
                + " = " + sum);

        // If the initial roll loses
        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("You lose!");
            return;
        }

        // If the initial roll wins
        else if (sum == 7 || sum == 11) {
            System.out.println("You win!");
            return;
        }

        else {
            int newSum = 0;
            // Creating a newSum if the player did not initially win or lose.
            System.out.println("Your point is " + sum);

            while (newSum != 7 && newSum != sum) {
                // Loop executes until player loses (by rolling 7) or wins
                // by rolling values that sum to the original sum.

                dice1 = random.nextInt(6) + 1;
                dice2 = random.nextInt(6) + 1;

                newSum = dice1 + dice2;

                System.out.println("You rolled " + dice1 + " + " + dice2
                        + " = " + newSum);

            }

            if (newSum == 7) {
                // If the loop exited when newSum == 7, the user lost.
                System.out.println("You lose!");
            } else {
                // If the loop exited when newSum == sum, the user won.
                System.out.println("You win!");
            }
        }

        // Previous (commented) implementation was incorrect
        // Craps is a game that compares the INITIAL sum to
        // every proceeding sum.
        // However I mistakenly believed that Craps() compared
        // to consecutive sums which is incorrect!

        // // If the initial roll triggers a point!
        // else {
        // int newSum;
        // // Will compare newSum to original sum
        // boolean hi = true;
        // // Trigger variable for while loop
        // System.out.println("point is " + sum);

        // //
        // while (hi) {

        // dice1 = random.nextInt(6) + 1;
        // dice2 = random.nextInt(6) + 1;
        // newSum = dice1 + dice2;

        // System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + newSum);

        // if (sum == newSum) {
        // System.out.println("You win!");
        // hi = false;
        // } else if (newSum == 7) {
        // System.out.println("You lose!");
        // hi = false;
        // }

        // else {
        // System.out.println("point is " + newSum);
        // sum = newSum;
        // }
        // }

        // }

    }

    public static void main(String[] args) {
        craps();
    }

}