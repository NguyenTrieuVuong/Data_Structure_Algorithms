// package Buoi6.Bai1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BinaryTree {

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else {
            add(root, node);
        }
    }

    private void add(Node current, Node node) {
        if (node.data < current.data) {
            if (current.left == null) {
                current.left = node;
            } else {
                add(current.left, node);
            }
        } else {
            if (current.right == null) {
                current.right = node;
            } else {
                add(current.right, node);
            }
        }
    }

    public void print() {
        print(root, 0);
    }

    private void print(Node node, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node.data);
        if (node.left != null) {
            print(node.left, level + 1);
        }
        if (node.right != null) {
            print(node.right, level + 1);
        }
    }

    public void printToFile(String filename) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File(filename));
        printToFile(root, writer, 0);
        writer.close();
    }

    private void printToFile(Node node, PrintWriter writer, int level) {
        for (int i = 0; i < level; i++) {
            writer.print("  ");
        }
        writer.println(node.data);
        if (node.left != null) {
            printToFile(node.left, writer, level + 1);
        }
        if (node.right != null) {
            printToFile(node.right, writer, level + 1);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        BinaryTree tree = new BinaryTree();
        tree.add(7);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(6);
        tree.add(5);
        tree.add(8);

        System.out.println("Printing tree to console:");
        tree.print();

        System.out.println("Printing tree to file:");
        tree.printToFile("output.txt");
    }
}