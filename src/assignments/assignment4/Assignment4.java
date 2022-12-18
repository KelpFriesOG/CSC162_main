package assignments.assignment4;

import java.util.ArrayList;

public class Assignment4 {

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> uniques = new ArrayList<E>();
        // Initializing arraylist to keep track of unique values

        for (int j = 0; j < list.size(); j++) {

            if (!uniques.contains(list.get(j))) {
                uniques.add(list.get(j));
                // We add the element at list[j] if
                // and only if it is not in the uniques list.
            }
        }

        return uniques;

    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {

        E maximum = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(maximum) > 0) {
                maximum = list.get(i);
            }
        }

        return maximum;

    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("amino");
        arr.add("alphabet");
        arr.add("cyano");
        arr.add("Kalpesh");
        arr.add("Kelp");
        arr.add("wings");
        arr.add("wings");
        arr.add("cyan");
        arr.add("tertiary");
        arr.add("full-sized");

        System.out.println(arr);
        System.out.println(max(arr));
        System.out.println(removeDuplicates(arr));

    }
}
