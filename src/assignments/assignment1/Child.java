package assignments.assignment1;

import java.util.ArrayList;

public class Child extends Parent {

    public Child() {
        this(new ArrayList<>());
    }

    public Child(ArrayList<Integer> list) {
        super(list);
    }
}
