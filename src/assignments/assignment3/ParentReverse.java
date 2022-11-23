package assignments.assignment3;

public class ParentReverse {

    // #region Class members

    private String str;

    // #endregion

    // #region Constructor

    public ParentReverse(String str) {
        /* <--super keyword from child lands here for Question 1--> */
        this.str = str;
    }

    // #endregion

    // #region Methods

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
