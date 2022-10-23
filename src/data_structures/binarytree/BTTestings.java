package data_structures.binarytree;

public class BTTestings {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(24);
        tree.add(14);
        tree.add(17);
        tree.add(25);
        tree.add(31);
        tree.add(43);
        tree.add(26);

        tree.printInorder();
        tree.delete(10);
        System.out.println();
        tree.printInorder();
        tree.delete(25);
        System.out.println();
        tree.printInorder();
        tree.add(25);
        System.out.println();
        tree.printInorder();

    }

}
