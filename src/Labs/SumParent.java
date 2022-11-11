package labs;

import java.util.ArrayList;

public class SumParent {
    ArrayList<Double> arr;

    // #region Constructors

    public SumParent() { // No arg-constructor
        this(new ArrayList<Double>());
    }

    public SumParent(ArrayList<Double> arr) {
        // <-- This constructor is called from the child class -->
        this.arr = arr;
    }

    // #endregion

    // #region Methods

    public double sum() {

        double sum = 0;
        // Initializing the value of sum

        for (double value : arr) {
            sum += value;
            // Incrementing the sum for each value we hit
        }

        return sum;
        // Returning the sum
    }

    // #endregion
}
