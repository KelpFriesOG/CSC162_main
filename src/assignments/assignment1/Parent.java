package assignments.assignment1;

import java.util.ArrayList;

public class Parent {

    public Parent() {

    }

    public static void removeDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> uniques = new ArrayList<Integer>();

        for (int j = 0; j < list.size(); j++) {
            if (!uniques.contains(list.get(j))) {
                uniques.add(list.get(j));
            }
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

    public static void main(String[] args){
        System.out.println("Hello");
    }
}
