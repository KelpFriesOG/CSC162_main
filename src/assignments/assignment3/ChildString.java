package assignments.assignment3;

public class ChildString extends ParentString {

    // #region Constructors

    public ChildString(String str, char letter) { // Constructor used for Q1
        super(str, letter);
        // The super keyword here calls the parent counstructor
        // that matches with the give parameters (a single String object).
    }

    public ChildString(String str) { // Constructor used for Q2
        super(str);
        // The super keyword here calls the parent counstructor
        // that matches with the give parameters (a single String object).
    }

    // #endregion
}
