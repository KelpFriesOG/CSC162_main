package assignments.assignment3;

public class ParentCount {

    private String str;
    private char letter;

    public ParentCount(String str, char letter) {
        /* <--super keyword from child lands here for Question 2--> */
        this.str = str;
        this.letter = letter;
    }

    // The method the user calls
    public int count() {
        return count(0);
    }

    // The method that actually activates internally
    private int count(int index) { // Case insensitive implementation

        char input = Character.toLowerCase(letter);
        // We convert the desired letter to lowercase (if it was given as uppercase)

        try { // RECURSIVE CASES
            if (str.toLowerCase().charAt(index) == input) { // RECURSIVE CASE 1

                // We compare the lowercase character to the lowercased String
                return 1 + count(index + 1);
                // If the character is found at the index point, we call the
                // method again but with the next index and also add 1
                // to the running count.

            } else { // RECURSIVE CASE 2

                return count(index + 1);
                // Even if the input character does not match, we make a recursive
                // call (without actually incrementing our count) to process
                // the next index in the string.

            }
        } catch (IndexOutOfBoundsException e) { // BASE CASE

            return 0;
            // This exception is triggered when the index we hit is actually
            // unreachable, this is our base case and stops the recursive calls.
            // For an initially null or empty string,
            // this base case is hit immeadiately.

        }

    }

}
