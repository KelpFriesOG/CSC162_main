package data_structures.binarytree;

public class BinaryTree {

    Node root;

    public BinaryTree(double value) {
        root = new Node(value);
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    // #region Adding and Deleting Methods

    public void add(double value) {
        addRecursive(root, value);
    }

    private Node addRecursive(Node current, double value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public boolean delete(int data) {
        return delete(root, data) != null ? true : false;
    }

    private Node delete(Node root, double value) {
        // this is the termination condition for our recursion call
        if (root == null) {
            return root;
        }
        // we will keep traversing the left subtree until the element is less than node
        // data.
        else if (root.value > value) {
            root.left = delete(root.left, value);
        }
        // we will keep traversing the right subtree until the element is greater than
        // node data.
        else if (root.value < value) {
            root.right = delete(root.right, value);
        } else {
            /*
             * we have found a potential match, mow we need to check
             * the 3 different cases to see which one should be executed.
             */

            // we are dealing with situation, where we have either one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            /*
             * this is the complex use case where element contains both left and right
             * sub-tree
             * We will go with our algorithm to find the minimum element in the right
             * sub-tree and
             * replace it followed by deletion
             */
            root.value = findMin(root.right);

            root.right = delete(root.right, root.value);
        }
        return root;
    }

    private double findMin(Node node) {
        // we are assuming that it's the minimum value
        double min = node.value;

        // remember left sub-tree will have the minimum value.You can also use the same
        // logic to implement BST without recursion.
        while (node.left != null) {
            min = node.left.value;
            node = node.left;
        }
        return min;
    }

    // #endregion

    // #region Searching methods

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    // #endregion

    // #region Traversal methods

    public void printInorder(Node node) {

        // We will continue until null or empty node is found
        if (node != null) {

            // visit the left subtree until the leaf node
            printInorder(node.left);

            // Print the node
            System.out.print(node.value + " ");

            // process the same step for the right node
            printInorder(node.right);
        }
    }

    public void printInorder() {
        printInorder(root);
    }

    public void printPreorder(Node node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.value + " ");

        /* then recur on left subtree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    public void printPreorder() {
        printPreorder(root);
    }

    public void printPostorder(Node node) {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.value + " ");
    }

    public void printPostorder() {
        printPostorder(root);
    }

    // #endregion

}
