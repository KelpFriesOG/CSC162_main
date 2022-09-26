package data_structures;

public class LinkedList<E> {
    Node<E> head, tail;
    int size = 1;

    // #region Constructors

    public LinkedList() {

    }

    public LinkedList(E[] elements) {
        head = new Node<E>(elements[0]);
        for (E value : elements) {
            addLast(value);
        }

    }

    // #endregion

    // #region Getters and Setters

    public E getFirst() {
        return this.head.value;
    }

    public E getLast() {
        return this.tail.value;
    }

    // #endregion

    // #region Methods

    public void addFirst(E e) {
        Node<E> node = new Node<E>(e);
        node.next = head;
        head = node;

        if (tail == null)
            tail = head;

        size++;
    }

    public void addLast(E e) {
        Node<E> node = new Node<E>(e);

        if (tail != null) {
            tail.next = node;
            tail = node;
        } else {
            tail = node;
            head = tail;
        }

        size++;
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;

            if (head == null)
                tail = null;
            return temp.value;
        }

    }

    public E removeLast() {
        if (size == 0 || size == 1) {
            return removeFirst();
        } else {
            Node<E> temp = tail;
            Node<E> traverseNode = head;

            while (traverseNode.next != tail) {
                traverseNode = traverseNode.next;
            }

            tail = traverseNode;
            tail.next = null;
            size--;

            return temp.value;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            return null;
        else if (index == 0)
            return removeFirst();
        else if (index == size - 1)
            return removeLast();

        else {
            Node<E> previousNode = head;

            for (int i = 0; i < index - 1; i++) {
                previousNode = previousNode.next;
            }
            // The loop aboves gets the node directly before
            // the node we want to remove.
            Node<E> currentNode = previousNode.next;
            previousNode.next = currentNode.next;
            // The two lines above link the node before
            // the target node to the node right after the target node,
            // effectively skipping over the target node entirely.
            size--;
            return currentNode.value;
        }
    }

    // #endregion

    public static void main(String []args){
        LinkedList<String> users = new LinkedList<String>();
        users.addFirst("Hello");
    }

}