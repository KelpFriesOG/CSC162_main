package labs;

import java.util.ArrayList;

public class Lab8_2 {

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        E max = list.get(1);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            } else {
            }
        }

        return max;
    }

    public static int count(String str, char a) {
        return count(str, a, 0);
    }

    private static int count(String str, char a, int index) {

        if (index > str.length() - 1) {
            return 0;
        }
        if (str.toLowerCase().charAt(index) == Character.toLowerCase(a)) {
            return 1 + count(str, a, index + 1);
        } else {
            return count(str, a, index + 1);
        }
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> uniques = new ArrayList<>();
        // Initializing arraylist to keep track of unique values

        for (int j = 0; j < list.size(); j++) {

            if (!uniques.contains(list.get(j))) {
                uniques.add(list.get(j));
                // We add the element at list[j] if
                // and only if it is not in the uniques list.
            }

            // Worst case runtime: if your arraylist is given in descending
            // order.

            // If checking and insertion happen in constant time
            // 0 + 1 + 2 + 3...n = n(n+1)/2 which
            // means worst case complexity = O(n^2) time?

            // Better solution may be to sort then delete consecutive elements
            // which would take O(n) + O(n log n) = O(n) time.
        }

        // System.out.println("The distinct integers are: ");
        // The prompt showed the removeDuplicates method as being
        // void so it did not return any arrayList.
        // I have made a version of this method that returns the arraylist
        // but I use this method for ease of printing into the console
        // with a cleaner test class.

        return uniques;

    }

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Kalpesh");
        names.add("Bryan");
        names.add("Dev");
        names.add("Dev");

        // Scanner input = new Scanner(System.in);
        // ArrayList<Integer> myInts = new ArrayList<>();

        // try {
        // for (int i = 0; i < 10; i++) {
        // System.out.println("Please enter a number");
        // int value = input.nextInt();
        // myInts.add(value);
        // }
        // } catch (InputMismatchException e) {
        // System.out.println("Please only enter ints.");
        // }

        // System.out.println(max(myInts));
        System.out.println(count("KAAlpesh is a dumbass", 'A'));

    }
}
