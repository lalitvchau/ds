package ds.tree;

import ds.queue.Queue;

public class BinaryTree<E> {
    Node<E> root;

    BinaryTree(E data) {
        root = new Node<>(data, null, null);
    }

    Node<E> getRoot() {
        return root;
    }

    static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    void levelOrder() {
        Queue<Node<E>> queue = new Queue<>();
        Node<E> current = root;
        queue.enqueue(current);
        while (queue.isNotEmpty()) {
            Node<E> node = queue.dequeue();
            System.out.println(node.data);
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }

    static Integer findMaxElementLevelOrder(Node<Integer> root) {
        Queue<Node<Integer>> queue = new Queue<>();
        Integer max = Integer.MIN_VALUE;
        queue.enqueue(root);
        while (queue.isNotEmpty()) {
            Node<Integer> node = queue.dequeue();
            if (node.data > max) {
                max = node.data;
            }
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
        return max;
    }

    static Integer findMaximumElement(Node<Integer> root) {
        int max = Integer.MIN_VALUE;
        if (root != null) {
            Integer rootValue = root.data;
            Integer left = findMaximumElement(root.left);
            Integer right = findMaximumElement(root.right);
            max = left > right ? left : right;
            if (rootValue > max) {
                max = rootValue;
            }
        }
        return max;
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
        preOrder(tree.getRoot());

        System.out.println("Post order");
        postOrder(tree.getRoot());

        System.out.println("In order");
        inOrder(tree.getRoot());

        System.out.println("Level order");
        tree.levelOrder();

        System.out.println("Maximum element =" + findMaximumElement(tree.getRoot()));
        System.out.println("Maximum element =" + findMaxElementLevelOrder(tree.getRoot()));
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
