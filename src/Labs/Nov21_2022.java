package labs;

import java.util.ArrayList;

public class Nov21_2022 {
    // 22.2 and 22.3

    // Maximum increasingly ordered subsequence, Complexity = O(n^2)
    static String maxSubsequence(String str) {

        ArrayList<Character> maxArr = new ArrayList<Character>();
        // This array will retain the longest nonconsecutive ordered string
        ArrayList<Character> arr = new ArrayList<Character>();
        // This array will be repopulated multiple times with non-consecutive
        // ordered strings

        for (int i = 0; i < str.length(); i++) {

            arr.add(str.charAt(i));
            // Add initial character (at position i) to arr,
            // this will be the start of a potential subsequence.

            for (int j = i + 1; j < str.length(); j++) {
                // For all characters after the character we are at
                if (arr.get(arr.size() - 1) < str.charAt(j)) {
                    arr.add(str.charAt(j));
                    // if any the charater at index j is greater than the last
                    // character added to the arr, we can add the character at j to
                    // to the end of the array.
                }
            }

            // After exiting the for loop of j's, we have found
            // and recorded one possible non-consecutive ordered subsequence.
            // in our arr variable.

            if (maxArr.size() < arr.size()) {
                // If our current non-consecutive ordered subsequence
                // is greater in size than the previous maximum lengthed
                // non-consective increasingly ordered subsequence, then...
                maxArr.clear();
                maxArr.addAll(arr);
                // We clear the values in the max array,
                // and repopulate the max array with the new longest
                // subsequence of non-consecutive increasingly ordered characters.
            }

            arr.clear();
            // I forgot this line before, but it is essential to clear the
            // array after each run to ensure that we are repopulating
            // the array with new subsequences relative to each character
            // we iterate through.
        }

        String result = "";

        for (Character c : maxArr) {
            // After the nested for loops we now know that maxArr contains
            // the max lengthed non-consecutive increasingly
            // subsequence in the String str.
            // So with this loop we are simply turning the arraylist
            // into a string representation to return.
            result += c;
        }

        return result;
        // Returning the string representation of the
        // max length non-consecutive increasingly ordered subsequence.

        // If you count the loops
        // The apparent time complexity = n^2 + n
        // Actual big O complexity = n^2
    }

    // Pattern matching
    // str1 is the string which may contain str2!
    static int isSubstring(String str1, String str2) {
        int startingIndex = -1;
        int i = 0, j = 0;
        // We want the loop to have linear complexity, so think pointers!
        // i is going to be a pointer going through each character of str1.
        // j is going to be a pointer going through each character of str2.

        for (; i < str1.length() && j < str2.length();) {
            // If we reach the end of the first string or the end of
            // the second string (the substr we hope to find in str1)
            // we break out of the loop.

            if (str1.charAt(i) == str2.charAt(j)) {
                // If the values at out pointers match...

                if (j == 0) {
                    startingIndex = i;
                }
                // If j == 0, this means that that the character
                // at position i in str1 must be the first character
                // of the substr. Therefore the substr must start
                // at the position i in the original string.

                i++;
                j++;
                // Iterate both i and j, so we compare the next
                // two characters to see if the substring continues
                // or if this is a dud.

            } else {
                // If the characters at i and j do not match then...
                j = 0;
                i++;
                // We make sure j = 0, because the substring match in the future
                // needs to happen between some char at i, and the FIRST character
                // of the substring we are looking for.

                // We iterate i to progress through the string we are SEARCHING IN.
            }

        }

        if (j == str2.length()) {
            return startingIndex;
            // If the loop exited when j == str2.length()
            // that means all elements of j must have been matched
            // and therefore a matched substring was found, starting from
            // the startingIndex position in i.
            // For the purposes of this problem, we return the value of
            // the startingIndex.
        } else {
            return -1;
            // The only other way we could have exited the loop is if we reached
            // the condition that i = str1.length().

            // We could reach this condition if the last character in our
            // substring (str2) was the last character of str1, but that
            // case will already be covered by the prior if condition.

            // In other words, the only way we land in this else statement
            // is if i == str1.length() and j != str2.length();
            // If this is the case, then the whole substring (str2) was
            // never found in the larger string (str1).
            // If it was never found, i.e. we did not find the substring
            // we return -1!

        }

        // If you count the loops, the apparent complexity and the big O
        // complexity are O(n)! Ask me why if you need a breakdown!

        // Below are some sample runs, i.e. what I wrote down before I coded,
        // to understand what I wanted my program to do!

        // str1 = Welcome
        // str2 = lco
        /*
         * i = 0, j = 0 -> W does not equal l, iterate i
         * i = 1, j = 0 -> e does not equal l, iterate i
         * i = 2, j = 0 -> l equals l, iterate i and j
         * i = 3, j = 1 -> c equals c, iterate i and j
         * i = 4, j = 2 -> o equals o, iterate i and j
         * i = 5, j = 3 -> loop is exited
         * Since j = str2.length() exit the loop
         * Since j = str2.length(), we know we found our substring
         * return startingIndex which is 2
         */

        // str1 = Zebra
        // str2 = eba
        /*
         * i = 0, j = 0 -> Z does not equal e, iterate i
         * i = 1, j = 0 -> e equals e, iterate i and j
         * i = 2, j = 1 -> b equals b, iterate i and j
         * i = 3, j = 2 -> r does not equal a, reset j, iterate i
         * i = 4, j = 0 -> a does not equal e, iterate i
         * i = 5, j = 0 -> loop is exited
         * Since i = str1.length(), exit the loop
         * Since j != str2.length(), we know we did not find our substring.
         * return -1
         */

    }

    public static void main(String[] args) {
        System.out.println(maxSubsequence("cbacdbefg"));
        System.out.println(isSubstring("Welhelcome", "com"));
        System.out.println(isSubstring("Zebra", "bro"));
        System.out.println(isSubstring("Crimson Dynamo", "Crim"));
    }
}
