package Bai1;

import java.util.NoSuchElementException;

public class BinarySearchTree {
    private Node root;

    private class Node {
        private int key;
        private Node left, right;

        public Node(int key) {
            this.key = key;
        }
    }

    public int FindMin() {
        if (root == null) throw new NoSuchElementException("Tree is empty");
        return FindMin(root).key;
    }

    private Node FindMin(Node node) {
        if (node.left == null) return node;
        else return FindMin(node.left);
    }

    public boolean Search(int x) {
        return Search(root, x);
    }

    private boolean Search(Node node, int x) {
        if (node == null) return false;
        if (x < node.key) return Search(node.left, x);
        else if (x > node.key) return Search(node.right, x);
        else return true;
    }

    public void Insert(int x) {
        root = Insert(root, x);
    }

    private Node Insert(Node node, int x) {
        if (node == null) return new Node(x);
        if (x < node.key) node.left = Insert(node.left, x);
        else if (x > node.key) node.right = Insert(node.right, x);
        return node;
    }

    public void Delete(int x) {
        root = Delete(root, x);
    }

    private Node Delete(Node node, int x) {
        if (node == null) return null;
        if (x < node.key) node.left = Delete(node.left, x);
        else if (x > node.key) node.right = Delete(node.right, x);
        else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node t = node;
            node = FindMin(t.right);
            node.right = DeleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }

    private Node DeleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = DeleteMin(node.left);
        return node;
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.Insert(15625);
        bst.Insert(65536);
        bst.Insert(111111);
        bst.Insert(11111);
        System.out.println("Min value: " + bst.FindMin()); // 1
        System.out.println("Search for 15625: " + bst.Search(65536)); // true
        System.out.println("Search for 15625: " + bst.Search(15625)); // false
        bst.Delete(111111);
        System.out.println("Search for 111111 after deletion: " + bst.Search(111111)); // false
    }
}
