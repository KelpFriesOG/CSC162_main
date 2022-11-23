package assignments.assignment3;

public class ChildCount extends ParentCount{
    
    public ChildCount(String str, char letter) { // Constructor used for Q1
        super(str, letter);
        // The super keyword here calls the parent counstructor
        // that matches with the give parameters (a single String object).
    }
}
