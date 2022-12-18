package practice;

import java.util.ArrayList;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");

        powerSet(strings);

    }

    public static <E> void powerSet(ArrayList<E> list) {
        powerSet(list, -1, new ArrayList<E>());
    }

    private static <E> void powerSet(ArrayList<E> list, int pointer, ArrayList<E> current) {

        if (pointer == list.size()) {
            return;
        }

        System.out.println(current);

        for (int i = pointer + 1; i < list.size(); i++) {
            current.add(list.get(i));
            powerSet(list, i, current);

            current.remove(current.size() - 1);
        }
    }

    static double multiply(double x, double y) {
        if (x == 0 || y == 0) {
            return 0;
        } else if (y < 0) {
            return -x + multiply(x, y + 1);
        } else {
            return x + multiply(x, y - 1);
        }
    }

    
}
