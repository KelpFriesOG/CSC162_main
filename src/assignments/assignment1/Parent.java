package assignments.assignment1;

import java.util.ArrayList;
import java.util.Collections;

/* Author: Kalpesh Chavan
 * Date: 10/03/2022
 * Prof Suero
 * CSC162 Assignment 1
 * Parent class
*/

public class Parent {
    private ArrayList<Integer> list;

    // #region Constructors

    public Parent(ArrayList<Integer> list) {
        this.list = list;
    }

    // #endregion

    // #region Methods

    public void removeDuplicates() {

        ArrayList<Integer> uniques = new ArrayList<Integer>();
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

        System.out.println("The distinct integers are: ");
        // The prompt showed the removeDuplicates method as being
        // void so it did not return any arrayList.
        // I have made a version of this method that returns the arraylist
        // but I use this method for ease of printing into the console
        // with a cleaner test class.

        try {
            for (int i = 0; i < uniques.size(); i++) {
                System.out.print(uniques.get(i) + " ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public double sum() {
        int sum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    // Testing code (unused)
    public ArrayList<Integer> removeDuplicates2() {

        ArrayList<Integer> uniques = new ArrayList<Integer>();
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

    public void fastRemoveDups() {
        // What a quicker implementation of removeDuplicates may look like
        Collections.sort(list);
        // Collections .sort uses a modified version of timsort,
        // which makes it an optimized version of mergesort
        // This means it has a time complexity of O(n*log(n)).

        // This loop would have a complexity of O(n)
        // with operations happening in constant time?
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size()) {
                while (list.get(i) == list.get(i + 1)) {
                    list.remove(i + 1);
                }
            }
        }

        // Overall complexity O(n)
    }

    // #endregion

    // #region Getter (if needed)

    public ArrayList<Integer> getList() {
        return list;
    }

    // #endregion

}
