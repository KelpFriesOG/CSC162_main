package practice.objects;

public class Queue {
    // FIFO Data structure
    // First in, first out data structure.
    private int[] elements;
    private int size = 0;
    private int capacity;

    public Queue() {
        capacity = 8;
        elements = new int[8];
    }

    public Queue(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
    }

    public void enqueue(int v) {

        if (size == capacity) {
            int[] temp = new int[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                temp[i] = elements[i];
            }

            elements = temp;
            capacity = capacity * 2;

        }

        elements[size] = v;
        size++;

    }

    public int dequeue() {
        int fifo = elements[0];

        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;
        return fifo;

    }

    public boolean empty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(" " + elements[i] + ",");
        }
        sb.append(" " + elements[size - 1] + " ]");

        return sb.toString();
    }

}
