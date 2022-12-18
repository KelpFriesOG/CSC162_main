package notes;

public class SortingAlgos {
    /*
     * Types of sorts covered:
     * Insertion Sort
     * Bubble Sort
     * Improved Bubble Sort
     * Merge Sort
     * Quick Sort
     * Heap Sort
     * Bucket Sort
     * Radix Sort
     * External Sort
     * 
     * Sorting algorithms illustrate many creative approaches
     * to problem solving and these approaches can be applied
     * to solve other problems.
     * 
     * Sorting algorithms are good for practicing fundamental
     * coding techniques and skills.
     * 
     * Sorting algorithms are excellent examples of processes
     * with varying, derievable time complexities.
     * 
     * Java API already contains overloadable sorting methods in
     * the util library to sort primitive arrays. The collections
     * library which includes Arrays, ArrayLists, LinkedLists, and e.t.c
     * can be sorted upon using built in sorts.
     * 
     * Insertion sort sorts in either ascending or descending numerical order
     * It swaps elements until the whole entire array is sorted. The time
     * complexity of the InsertionSort algorithm is O(n^2)
     * 
     * 
     * 
     */

    static int[] insertionSort(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; ++i) {

            int key = arr[i];
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }

        return arr;
    }

    static int[] bubbleSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }

        return arr;
    }

    static int[] fastBubbleSort(int[] arr) {

        int i, j, temp, n = arr.length;
        boolean swapped;

        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }

        return arr;
    }

    static int[] mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            // Find sizes of two subarrays to be merged
            int n1 = m - l + 1;
            int n2 = r - m;

            /* Create temp arrays */
            int L[] = new int[n1];
            int R[] = new int[n2];

            /* Copy data to temp arrays */
            for (int i = 0; i < n1; ++i)
                L[i] = arr[l + i];
            for (int j = 0; j < n2; ++j)
                R[j] = arr[m + 1 + j];

            /* Merge the temp arrays */

            // Initial indexes of first and second subarrays
            int i = 0, j = 0;

            // Initial index of merged subarray array
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            /* Copy remaining elements of L[] if any */
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            /* Copy remaining elements of R[] if any */
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {

    }
}
