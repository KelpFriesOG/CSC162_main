package labs;

public class Lab8 {

    static void reverseDisplay(String value) {
        int index = value.length() - 1;
        char c = value.charAt(index);

        if (value.length() == 1) {
            System.out.print(value);
        } else {
            System.out.print(c);
            reverseDisplay(value.substring(0, index));
        }
    }

    static int count(String value, char a) {

        String uniform = value.toLowerCase();

        if (uniform.length() == 0) {
            return -1;
        }

        int index = uniform.length() - 1;
        char c = uniform.charAt(index);

        if (uniform.length() == 1) {
            if (c == a) {
                return 1;
            } else {
                return 0;
            }
        }

        else {

            if (c == a) {
                return count(value.substring(0, index), a) + 1;

            } else {
                return count(value.substring(0, index), a) + 0;
            }
        }
    }

    static int countWithCounter(String value, char a) {

        int count = 0;

        // BASE CASE 1
        if (value.length() == 0) {
            // If the input string (value) is initially empty
            return -1; // -1 was like the error code
        }

        // BASE CASE 2
        if (value.length() == 1) {
            // If the length of the string is 1 (could be triggered initially or via a
            // recursive call)
            if (value.toLowerCase().charAt(0) == Character.toLowerCase(a)) {
                return 1;
            } else {
                return 0;
            }
        }

        // RECURSIVE CASE
        else {
            // Recursive case
            if (value.toLowerCase().charAt(value.length() - 1) == Character.toLowerCase(a)) {
                // Made the character checking case-insensitive
                count += 1; // Antarctica
            }

            // We use the recursive call to increment the counter
            return count += countWithCounter(value.substring(0, value.length() - 1), a);

            // Note that since the counter can only be 0 or 1 during any given call
            // We are not really "incrementing" the counter. If we tried this code
            // with a loop and a counter that WOULD NOT BE A RECURSIVE SOLUTION
            // In other words,
            // return count += countWithCounter(...)
            // IS DOING THE SAME THING AS
            // return count(value.substring(0, index), a) + 1
            // OR
            // return count(value.substring(0, index), a)
            // That plus one at the end is the "counter"
            // The value of count changes
        }
    }

    public static int countHelper(String value, char check) {
        return countWithCounter(value, check, 0);
    }

    private static int countWithCounter(String value, char check, int counter) {
        // BASE CASE 1
        if (value.length() == 0) {
            // If the input string (value) is initially empty
            return -1; // -1 was like the error code
        }

        // BASE CASE 2
        if (value.length() == 1) {
            // If the length of the string is 1 (could be triggered initially or via a
            // recursive call)
            if (value.toLowerCase().charAt(0) == Character.toLowerCase(check)) {
                return counter + 1;
            } else {
                return counter;
            }
        }

        else {
            if (value.toLowerCase().charAt(0) == Character.toLowerCase(check)) {
                return countWithCounter(value.substring(0, value.length() - 1), check, counter + 1);
            } else {
                return countWithCounter(value.substring(0, value.length() - 1), check, counter);
            }
        }

        // George Looking for g
        // memory location
        // countWithCounter("George", 'g', 0, 5)
        // George --> e
        // countWithCounter("George", 'g', 0, 4)
        // Georg --> g
        // countWithCounter("George", 'g', 1, 3)
        // Geor --> r
        // countWithCounter("George", 'g', 1)
        // ...
        // countWithCounter("George", 'g', 1)
        // G --> G == g
        // 1+1 = 2
        // Interned Strings

    }

    public static void main(String[] args) {
        // reverseDisplay("Kalpesh");

        // System.out.println(countWithCounter("alphA", 'a'));

        String value = new String("Kalpesh"); // RAM
        String str =  "Kalpesh"; // STORED STRING POOL

        System.out.println(value.hashCode());
        System.out.println(str.hashCode());

    }

}
