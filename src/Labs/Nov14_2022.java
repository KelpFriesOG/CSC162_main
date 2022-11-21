package labs;

import java.util.Arrays;
import java.util.Random;

public class Nov14_2022 {

    // #region Question 1

    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {

        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(key) == 0) {
                return i;
            }
        }

        // System.out.println("Could not find match!");
        return -1;
    }

    // #endregion

    // #region Question 2

    // V1: (How I thought about doing it in class, it works but its not intuitive)
    public static <E extends Comparable<E>> int binarySearchWIP(E[] list, E key) {

        int low = 0;
        int high = list.length - 1;
        int mid = (low + high) / 2;

        while (list[mid].compareTo(key) != 0) {

            if (mid == high && mid == low) {
                return -1;
            } else if (list[mid].compareTo(key) == 1) {
                high = mid - 1;
                mid = (low + high) / 2;
            } else {
                low = mid + 1;
                mid = (low + high) / 2;
            }
        }

        return mid;

    }

    // V2: (The more straightforward code, I wrote up by the end of class).
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {

        int low = 0;
        int high = list.length - 1;
        // THESE ARE POSITIONS NOT VALUES

        while (low <= high) {
            // If high < low, then we break from this loop
            // In other words if the low and high pointers cross past each other,
            // then we break out of the loop.

            int mid = (low + high) / 2;

            if (list[mid].compareTo(key) == -1) {
                // If this is true then our KEY IS GREATER THAN CURRENT MID
                low = mid + 1;
                // In that case we shift up our low pointer to now
                // only look at the right half of the array (after the midpoint).
                // Our high pointer is unchanged.
            }

            else if (list[mid].compareTo(key) == 1) {
                // If this is true then our KEY IS LESS THAN CURRENT MID
                high = mid - 1;
                // In that case we shift down or high pointer to now
                // only look at the left half of the array (before the midpoint).
                // Our low pointer is unchanged.
            }

            else {
                // This condition is hit when list[mid].compareTo(key) == 0
                // (ONLY OTHER POSSIBILITY)
                // This means that THE VALUE AT THE CURRENT MID IS OUR KEY
                return mid;
                // Then we simply exit the entire method by returning the
                // position that we found our key at, i.e. the mid position.
            }

        }

        return -1;
        // If we go through the while loop
        // and break out without finding our key,
        // then the key must not exist in the array.
        // To indicate this we return -1.

    }

    /*
     * Complexity Analysis: The length of the array that we are analyzing is
     * halved everytime we shift the pointers. We look to either half of the pivot
     * (of the array) and make one comparison (compare the mid to the key) for
     * each iteration of the loop.
     * 
     * At iteration 1: The portion of the array we analyze is n elements long
     * At iteration 2: The portion of the array we analyze is n/2 elements long
     * At iteration 3: The portion of the array we analyze is n/4 elements long
     * At iteration log[base 2](n): The portion of the array we analyze is 1
     * element.
     * 
     * At each iteration we do 1 comparison (key to midpoint),
     * so at most (in the worst case) we end up doing log[base 2](n) comparisons.
     * 
     * Length of array we look at: n / 2^i
     * Where i is the iteration we are on!
     * Lets say after k iterations, n / 2^i becomes 1
     * 
     * 1 = n / 2^k
     * n = 2^k
     * log[base 2](n) = k
     * k = log[base 2](n)
     * 
     * This final equation explains the complexity of the algorithm.
     * 
     */

    // #endregion

    public static void main(String[] args) {

        // #region Testing Question 1

        Integer[] values = new Integer[10];
        // Initializing array of Integers
        // Since the method wants Objects of type E that
        // extend comparable, using an array of primitive data typed
        // values will not be accepted by the method.

        Random rand = new Random();
        // Initializing Random object

        for (int i = 0; i < values.length; i++) {
            // Filling up the array with random values from 0-9
            values[i] = rand.nextInt(10);
            // No cast is neccesary to put int values in Integer array
        }

        System.out.println("----- Linear Search -----");

        System.out.println("Generated array: " + Arrays.toString(values));
        // Printing out the array.

        System.out.println("Index of first found instance of the key" +
                " (if index = -1, then key not found): " + linearSearch(values, 9));
        // No cast is neccessary to read the key as an Integer object.

        // #endregion

        // #region Testing Question 2

        System.out.println("----- Binary Search -----");

        System.out.println("Generated array: " + Arrays.toString(values));
        // Printing out the array.

        System.out.println("Index of first found instance of the key" +
                " (if index = -1, then key not found): " + binarySearch(values, 9));
        // No cast is neccessary to read the key as an Integer object.

        // #endregion
    }
}
