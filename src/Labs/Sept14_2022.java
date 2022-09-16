package Labs;

import java.util.Random;

public class Sept14_2022 {
    static void craps() {
        Random random = new Random();

        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        int sum = dice1 + dice2;

        System.out.println("Rolling the dice!");

        System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + sum);

        // If the initial roll loses
        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("You lose!");
        }

        // If the initial roll wins
        else if (sum == 7 || sum == 11) {
            System.out.println("You win!");
        }

        // If the initial roll triggers a point!
        else {
            int newSum;
            // Will compare newSum to original sum
            boolean hi = true;
            // Trigger variable for while loop
            System.out.println("point is " + sum);

            //
            while (hi) {

                dice1 = random.nextInt(6) + 1;
                dice2 = random.nextInt(6) + 1;
                newSum = dice1 + dice2;

                System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + newSum);

                if (sum == newSum) {
                    System.out.println("You win!");
                    hi = false;
                } else if (newSum == 7) {
                    System.out.println("You lose!");
                    hi = false;
                }

                else {
                    System.out.println("point is " + newSum);
                    sum = newSum;
                }
            }

        }

    }

    public static void main(String[] args) {
        craps();
    }

}