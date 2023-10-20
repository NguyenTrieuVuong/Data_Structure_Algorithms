package Buoi6.Bai2;

public class LinkedBinaryTree<E,T> implements BinaryTreeInterface<T> {
    public static class Node<E> {
        E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        Node<E> left; // a reference to the left child
        Node<E> right; // a reference to the right child
        
        // Constructs a node with the given element and neighbors.
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
    }
    
    private Node<E> root;
    private int size = 0;
    
    // Constructor creates an empty binary tree
    public LinkedBinaryTree() {
        root = null;
    }
    
    // Accessor methods
    public T root() {
        return (T) root;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int numChildren(T p) {
        Node<E> node = (Node<E>) p;
        int count = 0;
        if (node.left != null) count++;
        if (node.right != null) count++;
        return count;
    }
    
    public T parent(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.parent;
    }
    
    public T left(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.left;
    }
    
    public T right(T p) {
        Node<E> node = (Node<E>) p;
        return (T) node.right;
    }
    
    public T sibling(T p) {
        Node<E> node = (Node<E>) p;
        Node<E> parent = node.parent;
        if (parent == null) return null;
        if (parent.left == node) return (T) parent.right;
        else return (T) parent.left;
    }
    
    // Update methods
    public Node<E> addRoot(E element) {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty, cannot add a root");
        root = new Node<>(element, null, null, null);
        size = 1;
        return root;
    }
    
    public Node<E> addLeft(Node p, E element) {
        Node<E> parent = (Node<E>) p;
        if (parent.left != null) throw new IllegalStateException("Node already has a left child");
        Node<E> child = new Node<>(element, parent, null, null);
        parent.left = child;
        size++;
        return child;
    }
    
    public Node<E> addRight(Node p, E element) {
        Node<E> parent = (Node<E>) p;
        if (parent.right != null) throw new IllegalStateException("Node already has a right child");
        Node<E> child = new Node<>(element, parent, null, null);
        parent.right = child;
        size++;
        return child;
    }
    
    public void set(Node p, E element) {
        Node<E> node = (Node<E>) p;
        node.element = element;
    }
}
