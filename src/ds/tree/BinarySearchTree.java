package ds.tree;

public class BinarySearchTree {

    Node root;

    public boolean search(Integer targetElement) {
        if (targetElement != null) {
            Node foundNode = search(root, targetElement);
            return foundNode != null;
        } else {
            return false;
        }
    }

    private Node search(Node root, Integer targetElement) {
        if (root == null) {
            return null;
        } else if (root.data == targetElement) {
            return root;
        } else if (targetElement < root.data) {
            return search(root.left, targetElement);
        } else {
            return search(root.right, targetElement);
        }
    }

    public void insert(Integer element) {
        if (root == null) {
            root = new Node(element);
        } else {
            insert(root, element);
        }
    }

    private void insert(Node root, Integer element) {
        if (root != null) {
            if (element < root.data) {
                if (root.left == null) {
                    root.left = new Node(element);
                } else {
                    insert(root.left, element);
                }
            } else {
                if (root.right == null) {
                    root.right = new Node(element);
                } else {
                    insert(root.right, element);
                }
            }
        }
    }

    public void deleteNode(int key) {
        deleteNode(root, key);
    }

    private Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        } else if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.data = minValue(root.right);
                root.right = deleteNode(root.right, root.data);
            }
        }
        return root;
    }

    private int minValue(Node root) {
        if (root.left == null) {
            return root.data;
        } else {
            return minValue(root.left);
        }
    }

    public void inorder() {
        System.out.println("BST : ");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.printf(" %s", root.data);
            inorder(root.right);
        }
    }

    private static class Node {
        Integer data;
        Node left;
        Node right;

        Node(Integer data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.inorder();
        tree.insert(70);
        tree.insert(40);
        tree.insert(80);
        tree.insert(30);
        tree.insert(45);
        tree.insert(80);
        tree.insert(75);
        tree.insert(85);
        tree.insert(83);
        tree.insert(81);
        tree.insert(84);
        tree.insert(90);
        tree.inorder();

        tree.deleteNode(30);
        tree.inorder();
        tree.deleteNode(40);
        tree.inorder();
        tree.deleteNode(81);
        tree.inorder();
    }
}
