package labs;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Nov072022_Testing {
    public static void main(String[] args) {

        System.out.println("Question 1---------------------------------\n");

        // #region Testing Q1), Location class

        Location ex = new Location(0, 0, 0);
        // Testing the Location constructor

        double[] values = new double[10];
        // Creating array to be passed for locateLargest method

        for (int i = 0; i < values.length; i++) {
            // Populating array with random values from 0 to 100
            values[i] = Math.round(Math.random() * 100);
        }

        Location result = Location.locateLargest(values);
        // Calling the method and storing result in a variable

        System.out.println("The largest value is: " + result.getMaxValue());
        System.out.println("The largest element is located at index: " + result.getColumn());
        // Printing data from result

        // #endregion

        System.out.println("\nQuestion 2---------------------------------\n");

        // #region Testing regular version of Q2)

        ArrayList<Double> arr = new ArrayList<>();

        // IntStream.range(0, 10).forEach(n -> arr.add(Math.random() * 100));

        for (int i = 0; i < 10; i++) {
            arr.add(Math.random() * 100);
        }
        // Populating array with random values from 0 to 100 (double values!)

        SumChild sumObject = new SumChild(arr);

        System.out.println("The sum of the elements in the arraylist is: " + sumObject.sum());

        // #endregion
    }
}
