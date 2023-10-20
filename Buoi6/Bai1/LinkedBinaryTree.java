package Buoi6.Bai1;

import java.io.FileOutputStream;
import java.io.IOException;

public class LinkedBinaryTree<E,T> implements BinaryTreeInterface<T> {
    protected static class Node<E> {
        private E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child
        private Node<E> right; // a reference to the right child
        
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
    public static void main(String[] args) {
        // Create the nodes of the binary tree
        ArrayBinaryTree<Integer, Integer> abt = new ArrayBinaryTree<>();
        abt.setRoot(1);
        abt.setLeft(1, 3);
        abt.setRight(1, 5);
        abt.setLeft(2, 2);
        abt.setRight(2, 6);
        abt.setRight(3, 7);
        abt.setLeft(6, 8);
    
        Node<Integer> root = new Node<>(1, null, null, null);
        LinkedBinaryTree<Integer, Node<Integer>> lbt = new LinkedBinaryTree<>();
        lbt.addRoot(root);
        Node<Integer> node1 = lbt.addLeft(root, 3);
        Node<Integer> node2 = lbt.addRight(root, 5);
        Node<Integer> node3 = lbt.addLeft(node1, 2);
        Node<Integer> node4 = lbt.addRight(node1, 6);
        Node<Integer> node5 = lbt.addRight(node2, 7);
        Node<Integer> node6 = lbt.addLeft(node4, 8);
    
        // Print the binary tree horizontally
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("output.txt");
            printTreeHorizontally(abt.root(), "", false, fos);
            printTreeHorizontally(lbt.root(), "", false, fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void printTreeHorizontally(Object node, String prefix, boolean isLeft, FileOutputStream fos) throws IOException {
        if (node != null) {
            String direction = isLeft ? "  L" : "  R";
            System.out.println(prefix + direction + node);
            fos.write((prefix + direction + node + "\n").getBytes());
            printTreeHorizontally(getRight(node), prefix + (isLeft ? "│   " : "    "), false, fos);
            printTreeHorizontally(getLeft(node), prefix + (isLeft ? "│   " : "    "), true, fos);
        }
    }
    
    private static Object getLeft(Object node) {
        return node instanceof Integer ? null : ((Node<Integer>) node).left;
    }
    
    private static Object getRight(Object node) {
        return node instanceof Integer ? null : ((Node<Integer>) node).right;
    }
    
}
