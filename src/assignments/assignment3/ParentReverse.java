package assignments.assignment3;

public class ParentReverse {

    // #region Constructor

    public ParentReverse() {
        /* <--super keyword from child lands here for Question 1--> */
    }

    // #endregion

    // #region Methods

    // The method the user calls
    public void reverseDisplay(String str) {
        reverseDisplay(str.length() - 1, str);
    }

    public void reverseDisplay2(String str) {

        if (str.length() == 1) {
            // BASE CASE
            System.out.print(str);
        } else {
            System.out.print(str.charAt(str.length() - 1));
            reverseDisplay2(str.substring(0, str.length() - 1));
        }

        // abcdefs
        // abcde
        // abcd

    }

    // The method that actually activates internally
    // The reason I used a helper method is to
    // design what I think is a tail-recursive implementation
    // of the method which is substanially faster
    // than the normal recursive method.
    private void reverseDisplay(int index, String str) {
        try { // RECURSIVE CASE

            System.out.print(str.charAt(index));
            // We print the character at the given index of the string.
            // Initially this is always the last character due to the
            // first call from the helper method.
            reverseDisplay(index - 1, str);
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
