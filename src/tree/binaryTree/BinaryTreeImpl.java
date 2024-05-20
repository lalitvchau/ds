package tree.binaryTree;

public class BinaryTreeImpl<T> implements BinaryTree{
    private Node root;
    BinaryTreeImpl(T key){
        root = new Node(key);
    }

    BinaryTreeImpl(){
        root=null;
    }

    public Node getRoot() {
        return root;
    }
}
