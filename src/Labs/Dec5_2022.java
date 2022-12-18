package labs;

import java.util.ArrayList;

public class Dec5_2022 {

    // Programming Exercises
    // 23.1, 23.2, 23.3, 23.7

    // 23.1
    /*
     * bubbleSort does not need any pointers
     * and works with two nested loops that compare
     * consecutive elements. The complexity is O(n^2)
     * But this algorithm is by far one of the easiest
     * to understand.
     */
    static <E extends Comparable<E>> ArrayList<E> bubbleSort(ArrayList<E> arr) {

        int n = arr.size();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j).compareTo(arr.get(j + 1)) > 0) {
                    // swap arr[j+1] and arr[j]
                    E temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }

        }

        return arr;
    }

    // 23.2
    /*
     * Merges two subarrays of arr[].
     * First subarray is arr[l..m]
     * Second subarray is arr[m+1..r]
     */
    static <E extends Comparable<E>> ArrayList<E> mergeSort(ArrayList<E> arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            int n1 = mid - low + 1;
            int n2 = high - mid;

            ArrayList<E> arrL = new ArrayList<>();
            ArrayList<E> arrR = new ArrayList<>();

            for (int i = 0; i < n1; ++i) {
                arrL.add(arr.get(low + i));
            }

            for (int i = 0; i < n2; ++i) {
                arrR.add(arr.get(mid + i + 1));
            }

            int i = 0, j = 0, k = low;

            while (i < n1 && j < n2) {
                if (arrL.get(i).compareTo(arrR.get(j)) <= 0) {
                    arr.set(k, arrL.get(i));
                    i++;
                } else {
                    arr.set(k, arrR.get(j));
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr.set(k, arrL.get(i));
                i++;
                k++;
            }

            while (j < n2) {
                arr.set(k, arrR.get(j));
                j++;
                k++;
            }

        }

        return arr;

    }

    // 23.3 (Note that this method is void, and performs and in-place sort)
    /*
     * The main function that implements QuickSort
     * arr[] --> Array to be sorted,
     * low --> Starting index,
     * high --> Ending index
     */
    static <E extends Comparable<E>> void quickSort(ArrayList<E> arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Helper method for 23.3
    /*
     * This function takes last element as pivot, places
     * the pivot element at its correct position in sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right
     * of pivot
     */
    static <E extends Comparable<E>> int partition(ArrayList<E> arr, int low, int high) {

        // pivot
        E pivot = arr.get(high);

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr.get(j).compareTo(pivot) < 0) {

                // Increment index of
                // smaller element
                i++;
                E temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        E temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return (i + 1);
    }

    public static <E extends Comparable<E>> void insertionSort(E[] list) {
        for (int i = 0; i < list.length; i++) {
            E current = list[i];
            int j = i - 1;
            while (j >= 0 && current.compareTo(list[j]) > 0) {
                list[j + 1] = list[j];
                j--;
            }

            // placement
            list[j + 1] = current;

        }
    }

    public static void main(String[] args) {

        ArrayList<Long> myList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            // Fill the list with 15 random Long values
            myList.add(Math.round(Math.random() * 100));
        }

        System.out.println("Original List: ");
        System.out.println(myList + "\n");

        System.out.println("Printing the result of bubbleSort on the list: ");
        System.out.println(bubbleSort(myList) + "\n");

        System.out.println("Printing the result of mergeSort on the list: ");
        System.out.println(mergeSort(myList, 0, myList.size() - 1) + "\n");

        // The quicksort sorts the myList in place (it does not return anything)
        quickSort(myList, 0, myList.size() - 1);
        // When we print the myList object afterwords, it has been sorted.
        System.out.println("Printing the list after an in-place quickSort: ");
        System.out.println(myList + "\n");

    }
}
