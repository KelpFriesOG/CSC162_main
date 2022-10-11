package data_structures.binarytree;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(double rootValue) {
        this.root = new Node(rootValue);
    }

    void insert(double value) {
        insertIter(value);
    }

    // Iterative implementation of insertion
    public Node insert(Node current, double value) {
        if (current == null) {
            // If the node we are on is null, we create a new node
            // at the location of the current pointer.
            return new Node(value);
        }

        if (value < current.value) { // Search left subtree
            current.left = insert(current.left, value);
        } else if (value > current.value) { // Search right subtree
            current.right = insert(current.right, value);
        } else { // Found duplicate
            return current;
        }

        return current;
    }

    // Recursive implementation of recursion
    private void insertIter(double value) {
        Node current = root;
        Node trail = null;

        if (current == null) {
            root = new Node(value);
        }

        while (current != null) {
            trail = current;
            if (value < current.value)
                current = current.left;
            else
                current = current.right;
        }

        if (value > trail.value) {
            // new node value is greater than trail node value
            trail.right = new Node(value);
        }

        else if (value < trail.value) {
            // new node value is less than trail node value
            trail.left = new Node(value);
        }

        else {
            return;
        }
    }

    // TODO: implementation of delete functions

    void delete(double value) {
        root = delete(root, value);
    }

    //
    private Node delete(Node current, double value) {
        if (current == null) {
            // If the node we are on is null, we create a new node
            // at the location of the current pointer.
            return new Node(value);
        }

        if (value < current.value) { // Search left subtree
            current.left = delete(current.left, value);
        } else if (value > current.value) { // Search right subtree
            current.right = delete(current.right, value);
        } else { // Found the value to delete
            current = null;
        }

        return current;
    }

}
