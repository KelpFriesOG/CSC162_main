package assignments.assignment1;

import java.util.ArrayList;

public class Parent {
    ArrayList<Integer> list;

    public Parent(ArrayList<Integer> list) {
        this.list = list;
    }

    public void removeDuplicates() {
        ArrayList<Integer> uniques = new ArrayList<Integer>();

        for (int j = 0; j < list.size(); j++) {
            if (!uniques.contains(list.get(j))) {
                uniques.add(list.get(j));
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
        try {
            for (int i = 0; i < uniques.size(); i++) {
                System.out.print(uniques.get(i) + " ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
