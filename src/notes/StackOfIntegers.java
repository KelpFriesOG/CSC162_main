package notes;

public class StackOfIntegers {

    // #region Class Members
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    // #endregion

    // #region Constructors

    public StackOfIntegers() {
        this(DEFAULT_CAPACITY);
    }

    public StackOfIntegers(int capacity) {
        this.elements = new int[capacity];
    }

    // #endregion

    // #region Getters and Setters

    public int[] getElements() {
        return elements;
    }

    public int getSize() {
        return size;
    }

    // #endregion

    // #region Methods

    public boolean empty() {
        return size == 0 ? true : false;
    }

    public int peek() {
        return elements[size - 1];
    }

    public void push(int value) {
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }

        elements[size++] = value;
    }

    public int pop() {
        return elements[--size];
    }

    // #endregion

}
