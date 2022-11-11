package labs;

import java.util.ArrayList;

public class RemoverChild<E extends Number> extends RemoverParent<E> {

    // #region Constructor

    public RemoverChild(ArrayList<E> arr) {
        super(arr);
        // Calls parent constructor with given arguments
        // --> RemoverParent(arr)
    }

    // #endregion

}
