package data_structures.binarytree;

public class BTTestings {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10);
        tree.insert(5);
        tree.insert(10);
        tree.insert(3);
        tree.insert(7);
        BinaryTree.inorder(tree.root);
        tree.delete(3);
        BinaryTree.inorder(tree.root);
    }

}
