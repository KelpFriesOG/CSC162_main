package assignments.assignment3;

public class ParentString {

    // #region Class members

    private String str;
    private char letter = '\u0000';

    // #endregion

    // #region Constructor

    public ParentString(String str, char letter) {
        /* <--super keyword from child lands here for Question 1--> */
        this.str = str;
        this.letter = letter;
    }

    public ParentString(String str) {
        /* <--super keyword from child lands here for Question 2--> */
        this.str = str;

    }

    // #endregion

    // #region Methods

    // The method the user calls
    public int count() {
        if (letter == '\u0000') {
            System.out.println("This object was not made for the count method!");
            return -2;
        }

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

    // The method the user calls
    public void reverseDisplay() {
        reverseDisplay(str.length() - 1);
    }

    // The method that actually activates internally
    private void reverseDisplay(int index) {

        try { // RECURSIVE CASE

            System.out.print(str.charAt(index));
            // We print the character at the given index of the string.
            // Initially this is always the last character due to the
            // first call from the helper method.
            reverseDisplay(index - 1);
            // Then we call reverseDisplay again, but this time with
            // an index one step lower (one index to the left)

        } catch (IndexOutOfBoundsException e) { // BASE CASE

            // This always triggers because the initial call will
            // either have index set to -1, (if the string was null)
            // Or, as we progress through the recursive calls, index
            // will decrement to -1, which is an invalid index.

            if (str.length() == 0) {
                // If the string was null to begin with, it had a length of 0.
                // In that case maybe we want to notify the user!
                System.out.println("String was null!");
            }

        }
    }

    // #endregion

}
