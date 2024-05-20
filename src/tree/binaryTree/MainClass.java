package tree.binaryTree;

public class MainClass {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTreeImpl<>(1);
        tree.getRoot().setLeft(2);
        tree.getRoot().setRight(3);

        tree.getRoot().getLeft().setLeft(4);
        tree.getRoot().getLeft().setRight(5);

        tree.getRoot().getRight().setLeft(6);
        tree.getRoot().getRight().setRight(7);

        tree.getRoot().getRight().getRight().setRight(8);

        System.out.println("Depth of a tree = "+BinaryTree.getMaxDepth(tree.getRoot()));

        /**
         *          1
         *       2     3
         *     4   5  6 7
         *                8
         */
        System.out.println("LEVEL order");
        tree.levelOrderTravesal();
        System.out.println("\n=_=_=_=_=_=_=_= Inorder Print");
        BinaryTree.inorderPrint(tree.getRoot());
        System.out.println();
        System.out.println("=_=_=_=_=_=_=_= preorder Print");
        BinaryTree.preorderPrint(tree.getRoot());
        System.out.println();
        System.out.println("=_=_=_=_=_=_=_= postorder Print");
        BinaryTree.postorderPrint(tree.getRoot());
        System.out.println();
        System.out.println("Right most deepest node "+ BinaryTree.findRightMostDeepestParentNode(tree.getRoot()).getKey());
        System.out.println("Delete a node");
        tree.deleteNode(5);
        System.out.println("=_=_=_=_=_=_=_= After delete Inorder Print");
        BinaryTree.inorderPrint(tree.getRoot());
        System.out.println();


    }
}
