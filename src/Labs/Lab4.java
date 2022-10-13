package labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/* Lab 4 (I added some extra functionality)
 * Extras:
 * - You don't simply specify size, you can specify number of rows,
 * and columns (grid can be rectangular)!
 * - Functions to populate the array (randGrid) and to
 * print the array (arrayToString) are sectioned out of the main method
 * for clarity.
 * - Definetly not the easiest way to do this lab, but the jyst
 * and general pseudocode (see comment in main method) would be
 * identical. Instead of rows and columns in the conditions
 * both would be replaced by a size parameter.
 * - Attempted usage of try catch!
 * 
 */

public class Lab4 {

    static int[][] randGrid(int rows, int cols) {

        int[][] result = new int[rows][cols];
        // Creating an array with appropriate number of rows and columns

        Random rand = new Random();
        // Initializing random object

        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = rand.nextInt(2);
                    // Populating every spot in grid with 0 or 1
                    // (2 is not included in range)
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }

        return result;
        // Returning filled array
    }

    static String arrayToString(int[][] arr) {

        String result = "";
        // Iniatilizing return string

        try {
            for (int[] row : arr) {
                for (int elem : row) {
                    result += elem;
                    // Using nested enhanced for loops to quickly
                    // grab data from array without
                    // having to go through the hassle of "i < ..." "j < ..."
                    // Appending every element in row for first loop
                }
                result += "\n";
                // Creating a newline for next row of entries.
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }

        return result;
        // Returning built up result string
    }

    static int[] maxIndex(ArrayList<Integer> arr) {

        int max = arr.get(0);
        // Initializing max value

        ArrayList<Integer> results = new ArrayList<>();
        // Initializing array where INDEXES of the max value(s)
        // will be stored

        results.add(0);
        // Since the initial max value was at index 0
        // our initial index array will contain a value of 0
        // corresponding with the index.

        try {

            for (int i = 1; i < arr.size(); i++) {
                // Starting from index 1 since 0 was taken care of
                // as initial placeholder.
                if (arr.get(i) > max) {
                    max = arr.get(i);
                    results.clear();
                    results.add(i);
                    // If we find a new max, which is greater than the
                    // old maximum we clear our results
                    // and add the index of the new maximum
                } else if (arr.get(i) == max) {
                    results.add(i);
                    // If we find a duplicate maximum
                    // we add its index to the results as well
                    // since the lab wants us to return
                    // multiple row/column indexes if multiple
                    // rows/columns have the max row/column sum.
                }
            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        int[] result = new int[results.size()];
        // Initializing a normal int array based on the size
        // of the filled up arraylist

        for (int i = 0; i < results.size(); i++) {
            result[i] = results.get(i);
            // Adding arraylist elements into array
            // because im dumb and my next method
            // requires the output from this method to
            // be of type int[]
            // For your implementation you should
            // try to avoid arrays and always work with
            // arraylists.
            // Converting between the two is a pain!
        }

        return result;
        // Returning int[] filed up with elements from ArrayList results

    }

    static int[][] maxRowAndColSums(int[][] arr, int rowLength, int colLength) {

        ArrayList<Integer> rowSums = new ArrayList<>();
        ArrayList<Integer> colSums = new ArrayList<>(Collections.nCopies(rowLength, 0));

        try {
            for (int row = 0; row < colLength; row++) {
                // Outer loop iterates from one row to next
                int rowSum = 0;
                // Each row has its own sum
                for (int col = 0; col < rowLength; col++) {
                    rowSum += arr[row][col];
                    // Every element in row is added to rowSum
                    colSums.set(col, colSums.get(col) + arr[row][col]);
                    // The columns's values are increased
                    // at the specific indexes specified by col.
                    // We have to identify col #0 as the 0th element
                    // in the colSums array and e.t.c.
                }
                rowSums.add(rowSum);
                // We add the rowSum for each row as distinct elements
                // in rowSums (index 0 in rowSums corresponds with the sum
                // of elements in row 0)
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }

        // System.out.println(rowSums);
        // System.out.println(colSums);

        int[][] result = { maxIndex(rowSums), maxIndex(colSums) };
        // Now that we have the row and column sums, we find the
        // indexes of their maximum values.

        return result;
        // We return a 2d array which has two arrays within it
        // 1st array is the indexes at which rowSum was its max value,
        // 2nd array is the indexes at which colSum was its max value.

    }

    public static void main(String[] args) {

        // int size = 4;
        Scanner input = new Scanner(System.in);
        // Initializing the scanner object

        System.out.println("Lets make a random array!");

        System.out.println("Enter the number of rows in the array:");
        int nRows = input.nextInt();

        System.out.println("Enter the number of columns in the array:");
        int nCols = input.nextInt();
        // Prompting users for number of rows and number of columns

        System.out.println("The random array is: ");

        int[][] grid = randGrid(nRows, nCols);
        System.out.println(arrayToString(grid));
        // Making the random 2d array and printing it out!

        int[][] result = maxRowAndColSums(grid, nCols, nRows);
        // Calling our most important function

        System.out.println("The largest row index(es):");
        System.out.println(Arrays.toString(result[0]));
        // Interpreting that the 1st array in the 2d result
        // gives us the indexes of the largest row sums

        System.out.println("The largest column index(es):");
        System.out.println(Arrays.toString(result[1]));
        // Interpreting that the 2nd array in the 2d result
        // gives us the indexes of the largest column sums.

        input.close();

        // Pseudocode below!
        /*
         * Pseudocode:
         * 
         * [i][size-1], [i][size-2], [i][size-3], ... [i][0] + together for rowSum of i
         * [size-1][j], [size-2][j], [size-3][j], ... [0][j] + together for colSum of j
         * O(n^2) complexity worst case perhaps
         * 
         * main function
         * 
         * for i =0, i < size, i++
         * --rowSum = 0
         * --for j = 0, j < size, j++
         * ----rowSum+=arr[i][j]
         * ----colSums.set(i) = colSums.get(i) + arr[i][j]
         * --rowSums.add(rowSum)
         * 
         * in implementation I did not say size but instead specified
         * rowLength and columnLength.
         * 
         * Keep in mind that
         * number of rows = colLength
         * and
         * number of columns = rowLength
         * 
         * If you have 5 columns, each row has 5 elements.
         * If you have 3 rows, each column has 3 elements.
         * 
         * Therefore rowLength is interchangeable with numberOfCols
         * and colLength is interchangeable with numberOfRows.
         * 
         * helper to get indexes of max sum from sums
         * 
         * int max = arr.get(0);
         * ArrayList results
         * results.add(0)
         * for i = 1, i < arr.size(), i++
         * --if(arr.get(i) > max):
         * ----max = arr.get(i);
         * ----results.clear()
         * ----results.set(0, i)
         * --else if (arr.get(i) equals max):
         * ----results.add(i)
         * --then convert arraylist to array
         * 
         * will need a function to return populated grid of x rows and
         * y columns and a function to print a grid of x rows and y columns.
         * 
         * 
         * 
         * 
         */
    }
}
