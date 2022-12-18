package assignments.assignment4;

import java.util.ArrayList;

public class ParentRemoveDuplicates<E> {

    ArrayList<E> list;

    public ParentRemoveDuplicates(ArrayList<E> list) {
        this.list = list;
    }

    public ArrayList<E> removeDuplicates() {

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

}
