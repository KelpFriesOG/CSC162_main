package assignments.assignment4;

import java.util.ArrayList;

public class ParentMax<E extends Comparable<E>> {

    ArrayList<E> list;

    public ParentMax(ArrayList<E> list) {
        this.list = list;
    }

    public E max() {

        E maximum = list.get(0);
        int i = 1;

        while (i < list.size()) {
            if (list.get(i).compareTo(maximum) > 0) {
                maximum = list.get(i);
            }
            i++;
        }

        return maximum;

    }
}
