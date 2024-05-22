package ds.tree;

public class BinaryTree<E> {
    Node<E> root;

    BinaryTree(E data) {
        root = new Node<>(data, null, null);
    }

    Node<E> getRoot() {
        return root;
    }

    void preOrder(Node<E> root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void inOrder(Node<E> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    void postOrder(Node<E> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.getRoot().addLeft(2);
        tree.getRoot().addRight(3);

        Node<Integer> left = tree.getRoot().getLeft();
        left.addLeft(4);
        left.addRight(5);

        Node<Integer> right = tree.getRoot().getRight();
        right.addLeft(6);
        right.addRight(7);

        System.out.println("Pre order");
        tree.preOrder(tree.getRoot());

        System.out.println("Post order");
        tree.postOrder(tree.getRoot());

        System.out.println("In order");
        tree.inOrder(tree.getRoot());

    }

    static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }


        Node<E> getLeft() {
            return left;
        }

        Node<E> getRight() {
            return right;
        }

        void addLeft(E data) {
            left = new Node<>(data, null, null);
        }

        void addRight(E data) {
            right = new Node<>(data, null, null);
        }
    }
}
