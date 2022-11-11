package labs;

public class Location {

    // #region Class Members

    private int row;
    private int column;
    private double maxValue;
    // These are the class members or values that are unique to each
    // instance of the class

    // #endregion

    // #region Constructors

    public Location(int row, int column, double maxValue) {
        this.row = row;
        this.column = column;
        this.maxValue = maxValue;
    }

    // #endregion

    // #region Methods

    public static Location locateLargest(double[] arr) {
        double max = arr[0]; // Initialize max to first element of array
        int maxIndex = 0; // The position of the initial max will always be 0 (the beginning of the array)

        for (int i = 1; i < arr.length; i++) { // Iterating through remaining array
            if (arr[i] > max) { // If we encounter a value greater than our current maximum...

                max = arr[i]; // Current value
                maxIndex = i; // Current index

                // We set the max equal to that value, and update the maxIndex to the position
                // of this new max.
            }
        }

        Location result = new Location(0, maxIndex, max);
        // For a 2D array, the location is defined by a row, column and the value
        // itself.
        // For a 1D array there is only one "row", so I hard-coded row to always be 0.
        // The column is the index within the row (single array) that the max is at.
        // And the value held by the Location is the value of the maximum.

        return result;
    }

    // #endregion

    // #region Getters and Setters

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    // #endregion

}
