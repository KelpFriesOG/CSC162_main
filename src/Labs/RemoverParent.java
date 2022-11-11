package labs;

import java.util.ArrayList;

public class RemoverParent<E extends Number> {
    ArrayList<E> arr;

    // #region Constructors

    public RemoverParent() {
        this(new ArrayList<E>());
    }

    public RemoverParent(ArrayList<E> arr) { // <--- This constructor is called
        // from child class
        this.arr = arr; 
    }

    // #endregion

    // #region Methods

    public double sum() {
        double sum = 0;

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i).doubleValue();
        }

        return sum;
    }

    // #endregion
}
