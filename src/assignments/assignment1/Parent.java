package assignments.assignment1;

import java.util.ArrayList;
import java.util.Collections;

public class Parent {

    public Parent() {

    }

    public static void removeDuplicates(ArrayList<Integer> list) {
        Collections.sort(list);

        for (int j = 0; j < list.size() - 1; j++) {
            // size is updated automatically as elements are deleted!
            int A = list.get(j);
            int B = list.get(j + 1);

            if (A == B) {
                list.remove(B);
            }

        }

    }
}
