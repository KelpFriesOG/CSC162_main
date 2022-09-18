package practice;

public class SortedArrayFindCommons {

    /*
     * Question: Given 2 sorted arrays, find the number of elements
     * in common.
     * 
     * Suppose these two arrays as an example
     * A: 13, 27, 35, 40, 49, 55, 59
     * B: 17, 35, 39, 40, 55, 58, 60
     * 
     * Well we could compare one element in A to all
     * elements in B by conducting a search in B.
     * 
     * The best big O complexiety for such a searching
     * algorithm would be a binary search. Lets walk through it.
     * 
     * A[0] = 13, search for 13 in B: No match, takes O(log n).
     * A[1] = 27, search for 27 in B: No match, takes O(log n).
     * A[2] = 35, search for 35 in B: FOUND at B[1].
     * A[3] = 40, search for 40 in B: FOUND at B[3].
     * A[4] = 49, search for 49 in B: No match, takes O(log n).
     * A[5] = 55, search for 59 in B: FOUND at B[4].
     * A[6] = 59, search for 59 in B: No match, takes O(log n).
     * 
     * Now this is the naive way to solve this problem, because
     * if you notice...
     * 
     * When we encounter 13 in A, and 17 in B, all subsequent values
     * in B must be bigger than 13, which means there is no point
     * in conducting a search for 13 throughout the array.
     * 
     * Similarly, when we approach 27 in A and get to 35 in B, all
     * subsequent values in B must be bigger than 35 and we can stop
     * our search there.
     * 
     * Brute force implementation: 2 for loops, O(n^2)
     * For every nth element we search n elements
     * 
     * We can reduce the value of that second n by applying a
     * binary search algorithm!
     * Semi-optimal algorithm: O(n*log(n))
     * 
     * We could also use more storage and less time by tossing
     * all the elements into a hash table in O(n) and then search from
     * the hash table in O(1) time.
     * Almost-optimal algorithm: O(n) space complexiety, O(1) time
     * complexity.
     * 
     * Optimal algorithm: ???
     * Best case hypothetical: O(n)?
     * 
     * So in most cases the hash map approach would be fine enough,
     * but with vast arrays we may want to have a space complexity
     * of O(1) and a time (search complexity) of O(n).
     * 
     * To do this we can apply a straightforward linear search but
     * stop the search and resume it appropriately rather than doing
     * multiple searches per entry in array A.
     * 
     * 
     */

    static double sortedSearchDuplicates(double[] arr1, double[] arr2) {

        int i1 = 0, i2 = 0;
        int nDuplicates = 0;
        while (i2 < arr2.length && i1 < arr1.length) {
            double val1 = arr1[i1];
            double val2 = arr2[i2];

            if (val2 > val1) {
                i1++;
            } else if (val1 == val2) {
                nDuplicates++;
                i1++;
                i2++;
            } else if (val2 < val1) {
                i2++;
            }
        }

        return nDuplicates;
    }

    public static void main(String[] args) {
        double[] arr1 = { 13, 27, 35, 40, 49, 55, 59 };
        double[] arr2 = { 17, 35, 39, 40, 55, 58, 60 };

        System.out.println("The number of duplicates is " + sortedSearchDuplicates(arr1, arr2));
    }
}
