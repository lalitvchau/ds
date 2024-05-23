package ds.tree;

import ds.queue.Queue;

public class BinaryTree<E> {
    Node<E> root;

    public BinaryTree(E data) {
        root = new Node<>(data, null, null);
    }

    public BinaryTree() {
    }

    public Node<E> getRoot() {
        return root;
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    public static boolean preOrderSearch(Node root, Object target) {
        if (root != null) {
            if (root.data == target) {
                return true;
            }
            if (preOrderSearch(root.left, target) || preOrderSearch(root.right, target)) {
                return true;
            }
        }
        return false;
    }

    public void levelOrder() {
        Queue<Node<E>> queue = new Queue<>();
        Node<E> current = root;
        if (root != null) {
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
    }

    public static Integer findMaxElementLevelOrder(Node<Integer> root) {
        Queue<Node<Integer>> queue = new Queue<>();
        Integer max = Integer.MIN_VALUE;
        if (root != null) {
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
        }
        return max;
    }

    public static Integer findMaximumElement(Node<Integer> root) {
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

    public int size() {
        return size(root);
    }

    private int size(Node<E> root) {
        if (root == null) {
            return 0;
        } else {
            return size(root.left) + 1 + size(root.right);
        }
    }

    public BinaryTree<E> insert(E data) {
        Node<E> newNode = new Node<>(data, null, null);
        if (root == null) {
            root = newNode;
        } else {
            Queue<Node<E>> queue = new Queue<>();
            queue.enqueue(root);
            while (queue.isNotEmpty()) {
                Node<E> current = queue.dequeue();
                if (current.left == null) {
                    current.left = newNode;
                    break;
                } else {
                    queue.enqueue(current.left);
                }
                if (current.right == null) {
                    current.right = newNode;
                    break;
                } else {
                    queue.enqueue(current.right);
                }
            }
        }
        return this;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
        }
    }

    public void mirror() {
        mirror(root);
    }

    private void mirror(Node<E> root) {
        if (root != null) {
            Node<E> tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
            mirror(root.left);
            mirror(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

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
        System.out.println("Find element =" + preOrderSearch(tree.getRoot(), 7));
        System.out.println("Find element =" + preOrderSearch(tree.getRoot(), 77));
        System.out.println("Size =" + tree.size());
        System.out.println("Height =" + tree.height());
        System.out.println("Height =" + (new BinaryTree().insert(12)).height());

        System.out.println("Tree before mirror");
        tree.levelOrder();
        tree.mirror();
        System.out.println("Tree after mirror");
        tree.levelOrder();
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
