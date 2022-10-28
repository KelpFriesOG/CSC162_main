package labs;

public class Chapter18Labs {

    static int fibIter(int index) {
        int f0 = 0;
        int f1 = 1;
        int currentFib = 0;

        for (int i = 1; i < index; i++) {
            currentFib = f0 + f1;
            f0 = f1;
            f1 = currentFib;
        }

        return currentFib;

    }

    static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        } else {
            return gcd(n, m % n);
        }
    }

    static double sumSeries(int i) {
        if (i < 1) {
            return -1;
        } else if (i == 1) {
            return 1.0;
        } else {
            return (1.00 / i) + sumSeries(i - 1);
        }
    }

    static double sumSeries2(int i) {
        if (i < 1) {
            return -1;
        } else if (i == 1) {
            return (1.00 / 3.00);
        } else {
            return ((double) i / (2 * i + 1)) + sumSeries2(i - 1);
        }
    }

    static double sumSeries3(int i) {
        if (i < 1) {
            return -1;
        } else if (i == 1) {
            return 1.0 / 2.0;
        } else {
            return (double) i / (i + 1) + sumSeries3(i - 1);
        }

    }

    static void reverseDisplay(int value) {
        if (value > 0) {
            System.out.print(value % 10);
            reverseDisplay(value / 10);
        }
    }

    static void reverseDisplay(String value) {
        if (!value.isEmpty()) {
            System.out.print(value.charAt(value.length() - 1));
            reverseDisplay(value.substring(0, value.length() - 1));
        }
    }

    static int count(String value, char instance) {
        if (!value.isEmpty()) {
            return value.charAt(0) == instance ? 1 + count(value.substring(1), instance)
                    : count(value.substring(1), instance);
        } else {
            return 0;
        }
    }

    static int sumDigits(long n) {
        if (n > 0) {
            return (int) n % 10 + sumDigits((long) (n / 10));
        } else {
            return 0;
        }
    }

    static void reverseString(String value) {
        reverseString(value, value.length() - 1);
    }

    static void reverseString(String value, int high) {
        if (high >= 0) {
            System.out.print(value.charAt(high));
            reverseString(value, high - 1);
        }
    }

    static int max(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        } else {
            int[] newarr = new int[arr.length - 1];
            System.arraycopy(arr, 1, newarr, 0, arr.length - 1);
            return arr[0] > max(newarr) ? arr[0] : max(newarr);
        }
    }

    public static void main(String[] args) {

        // Testing iterative fibonacci series (18.2)
        System.out.println("The hundredth element in the fibonacci sequence is: "
                + fibIter(48));

        // Testing recursive gcd calculations (18.3)
        System.out.println("The greatest common divisor of 60 and 124 is: " +
                gcd(56, 8));

        // Testing first sum series (18.4)
        for (int i = 1; i <= 10; i++) {
            System.out.println("The resulting sum series (1) for i =" + i
                    + ", is = " + sumSeries(i));
        }

        // Testing second sum series (18.5)
        for (int i = 1; i <= 10; i++) {
            System.out.println("The resulting sum series (2) for i =" + i
                    + ", is = " + sumSeries2(i));
        }

        // Testing third sum series (18.6)
        for (int i = 1; i <= 10; i++) {
            System.out.println("The resulting sum series (3) for i =" + i
                    + ", is = " + sumSeries3(i));
        }

        // Testing the integer parametered reverseDisplay method (18.8)
        reverseDisplay(2345236);
        System.out.println();

        // Testing string overloaded version of reverseDisplay method (18.9)
        reverseDisplay("esednogus");
        System.out.println();

        // Testing the count method (18.10)
        System.out.println(count("alpha", 'a'));

        // Testing the sumDigits method (18.11)
        System.out.println("Sum of digits for 12345: " + sumDigits(12345));

        // Testing the reverseString method (which is just another name for an
        // altered reverseDisplay method that has a helper method) (18.12)
        System.out.println("The reverse of 'OMEGA' is: ");
        reverseString("OMEGA");
        System.out.println();

        // Testing a method that finds the largest integer in an array,
        // recursively (18.13)
        int[] values = new int[] { 14, 123, 67, 45, 84, 99, 235, 175, 200, 132, 123, 144 };
        System.out.println(max(values));

    }
}
