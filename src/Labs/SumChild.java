package labs;

import java.util.ArrayList;

public class SumChild extends SumParent {

    // #region Constructor

    public SumChild(ArrayList<Double> values) {
        super(values);
        // the line above is equivalent to SumParent(values)
        // super takes the arguments and passes them to the
        // matching constructor of the parent class!
    }

    // #endregion
}
