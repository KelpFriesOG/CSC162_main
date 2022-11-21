package notes;

public class Chapter12Testing {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        // #region Testing the CircleWithException class

        try {
            CircleWithException c1 = new CircleWithException(5);
            CircleWithException c2 = new CircleWithException(-5);
            // The line above will throw the exception (debug to check)
            CircleWithException c3 = new CircleWithException(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // Should print "Radius cannot be negative"
        }

        Integer i = new Integer(15);

        System.out.println("Hello");

        // #endregion

    }
}
