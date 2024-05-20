package tree.binaryTree;

public interface BinaryTree<T> {
    public Node<T> getRoot();

    public static int getMaxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getMaxDepth(node.getLeft());
        int rightDepth = getMaxDepth(node.getRight());
        return (leftDepth < rightDepth ? leftDepth : rightDepth) + 1;
    }

    public static void inorderPrint(Node startNode) {
        if (startNode != null) {
            inorderPrint(startNode.left);
            System.out.print(" " + startNode.getKey());
            inorderPrint(startNode.right);
        }
    }

    public static void preorderPrint(Node startNode) {
        if (startNode != null) {
            System.out.print(" " + startNode.getKey());
            preorderPrint(startNode.left);
            preorderPrint(startNode.right);
        }
    }

    public static void postorderPrint(Node startNode) {
        if (startNode != null) {
            postorderPrint(startNode.left);
            postorderPrint(startNode.right);
            System.out.print(" " + startNode.getKey());
        }
    }

    public static Node findRightMostDeepestParentNode(Node node) {
        if (node == null) {
            return null;
        }
        return node.getRight() != null && node.getRight().getRight() != null ? findRightMostDeepestParentNode(node.getRight()) : node;
    }

    public default boolean deleteNode(T key) {
        Node root = this.getRoot();
        if (key != null && root != null) {
            Node rightMostDeepestNode = findRightMostDeepestParentNode(root);
            Node targetNode = inorderSearch(root, key);
            if (targetNode != null) {
                if (rightMostDeepestNode.getRight() != null) {
                    targetNode.setKey(rightMostDeepestNode.getRight().getKey());
                }
                rightMostDeepestNode.setRight(null);
            }
        }
        return false;
    }

    public default void levelOrderTravesal() {
        Node root = this.getRoot();
        if (root != null) {
            int height = getMaxDepth(root);
            for (int i = 1; i <= height; i++) {
                printCurrentLevel(root, i);
            }
        }
    }

    default void printCurrentLevel(Node root, int level) {
        if (root != null) {
            if (level == 1) {
                System.out.print(" " + root.getKey());
            } else if (level > 1) {
                printCurrentLevel(root.getLeft(), level - 1);
                printCurrentLevel(root.getRight(), level - 1);
            }
        }
    }

    public default Node inorderSearch(Node node, T key) {
        Node keyNode = null;
        if (node != null) {
            keyNode = inorderSearch(node.left, key);
            if (keyNode == null) {
                if (node.getKey() == key) {
                    return node;
                }
                keyNode = inorderSearch(node.right, key);
            }
        }
        return keyNode;
    }

    public class Node<T> {
        private T key;
        private Node left;
        private Node right;

        public Node(T key) {
            this.key = key;
        }

        public void setLeft(T key) {
            left = new Node(key);
        }

        public void setRight(T key) {
            right = new Node(key);
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }
    }
}
