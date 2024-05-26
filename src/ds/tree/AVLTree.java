package ds.tree;

public class AVLTree {

    Node root;

    private Node rotateLeftLeft(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        return temp;
    }

    private Node rotateRightRight(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        return temp;
    }

    private Node rotateLeftRight(Node root) {
        root.left = rotateRightRight(root.left);
        return rotateLeftLeft(root);
    }

    private Node rotateRightLeft(Node root) {
        root.left = rotateLeftLeft(root.right);
        return rotateRightRight(root);
    }

    public int height(Node root) {
        return root == null ? -1 : root.height;
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.printf("%s ", root.data);
            inorder(root.right);
        }
    }

    public void inorder() {
        System.out.println("Inorder = ");
        inorder(root);
        System.out.println();
    }

    private void preorder(Node root) {
        if (root != null) {
            System.out.printf("%s ", root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void preorder() {
        System.out.println("Preorder = ");
        preorder(root);
        System.out.println();
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data, 0);
        } else if (data < root.data) {
            root.left = insert(root.left, data);
            if (height(root.left) - height(root.right) == 2) {
                if (data < root.left.data) {
                    root = rotateLeftLeft(root);
                } else {
                    root = rotateLeftRight(root);
                }
            }
        } else if (data > root.data) {
            root.right = insert(root.right, data);
            if (height(root.right) - height(root.left) == 2) {
                if (data < root.right.data) {
                    root = rotateRightRight(root);
                } else {
                    root = rotateRightLeft(root);
                }
            }
        } else {
            root.height = max(height(root.left), height(root.right)) + 1;
        }
        return root;
    }

    private int max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }

    static class Node {
        int data;
        Node left;
        Node right;
        int height = 0;

        public Node(int data, int height) {
            this.data = data;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        avl.inorder();
        avl.insert(11);
        avl.inorder();
        avl.preorder();
        avl.insert(12);
        avl.insert(6);
        avl.insert(7);
//        avl.insert(8);
//        avl.insert(4);
//        avl.insert(9);
//        avl.insert(10);
//        avl.insert(17);
        avl.inorder();
        avl.preorder();
    }
}
