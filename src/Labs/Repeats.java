package labs;

import java.util.ArrayList;

public class Repeats {
    static void repeats(ArrayList<Integer> arr) {
        // 1, 1, 2, 3, 4, 4, 4, 5
        int maxCount = 0;
        int maxIndex = 0;
        int current = arr.get(0);
        int count = 0;

        for (int i = 1; i < arr.size() - 1; i++) {

            if (arr.get(i) == current) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    maxIndex = i - count;
                    count = 0;
                }
            }
        }

        System.out.println(maxCount);
        System.out.println(maxIndex);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(4);
        arr.add(4);
        arr.add(8);
        arr.add(8);
        arr.add(8);
        arr.add(8);

        repeats(arr);
    }
}
