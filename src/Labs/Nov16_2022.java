package labs;

import java.util.ArrayList;

public class Nov16_2022 {

    // Version 1: Uses array to keep track of all permutations
    // Has two for loops, one to get all consecutive increasing permutations
    // One to get the maximum length permutation from the array of possible
    // results.
    static String maxConsecutiveString(String str) {

        String permutation = "" + str.charAt(0);
        ArrayList<String> possibleStrings = new ArrayList<String>();

        for (int i = 1; i < str.length(); i++) { // Complexity = O(n)

            if (str.charAt(i) > permutation.charAt(permutation.length() - 1)) {
                permutation += str.charAt(i);
            } else {
                possibleStrings.add(permutation);
                permutation = "" + str.charAt(i);
            }

            if (i == str.length() - 1) {
                possibleStrings.add(permutation);
            }

        }

        String result = "";

        int maxLength = 0;

        for (String value : possibleStrings) { // Complexity = O(n)
            if (value.length() > maxLength) {
                maxLength = value.length();
                result = value;
            }
        }

        return result;

    }
    // Complexity = O(n), technically with a coefficent of 2

    // Version 2: Only keeps track of a running result and a running permutation.
    // The result is changed if a terminated permutation has a greater length
    // than the pre-existing result.
    static String maxConsecutiveString2(String str) {

        String permutation = "" + str.charAt(0);
        String currentResult = "";

        for (int i = 1; i < str.length(); i++) { // Complexity = O(n)

            if (str.charAt(i) > permutation.charAt(permutation.length() - 1)) {
                // If the current character at index i, is greater than the last
                // character put into the permutation, then we append the character
                // at i to the end of the permutation.
                permutation += str.charAt(i);
            } else if (permutation.length() > currentResult.length()) {
                // If the current character does not continue to add to the permutation
                // then we check if our now completed permutation is longer than
                // the perviously tracked permutation.
                currentResult = permutation;
                // If our permutation is longer than the running result then we
                // set the running result to the permutation.
                permutation = "" + str.charAt(i);
                // We also reset our permutation to start it at the current index.

            }

        }

        return permutation.length() > currentResult.length()
                ? permutation
                : currentResult;
        // I wrote this statement to remedy a situtation where
        // the the longest permutation happens include the last character
        // of the string. If this was the case, then the permutation
        // will be changed but the currentResult would not be updated
        // because the first if statement executes but the else if
        // statement that logs the permutation into the current result
        // will be ignored.
    }
    // Complexity = O(n), techincally with a coefficent of 1

    // I could not think of a solution faster than O(n) complexity!
    // I think the second implementation may be slightly faster because
    // it has a single for loop instead of two for loops (it also
    // avoids initializing an array of potential results).

    // A questions I thought someone may ask:
    // 1) Why, when comparing characters do I say: str.charAt(i) >
    // permutation.charAt(permutation.length() - 1)?
    // Why not make it >=?
    // Because we are looking for the longest increasing sequence of characters,
    // not the longest non-decreasing sequence.

    public static void main(String[] args) {

        System.out.println("\nImplementation #1");
        long start = System.nanoTime();
        System.out.println(maxConsecutiveString("abcabxyzabcdfg"));
        long timeTaken = System.nanoTime() - start;
        System.out.println("Calculation time:" + timeTaken + " nanoseconds");

        System.out.println("\nImplementation #2");
        start = System.nanoTime();
        System.out.println(maxConsecutiveString2("abcabxyzabcdfg"));
        timeTaken = System.nanoTime() - start;
        System.out.println("Calculation time:" + timeTaken + " nanoseconds");

        // I ran the code above multiple times and logged in manually
        // elsewhere. On average, the second implementation was significantly
        // faster!
    }
}
