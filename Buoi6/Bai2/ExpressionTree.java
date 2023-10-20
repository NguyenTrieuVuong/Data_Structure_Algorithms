package Buoi6.Bai2;

import Buoi6.Bai2.LinkedBinaryTree.Node;

public class ExpressionTree<E> {

    public void preorderPrint(Node<E> p) {
        // Pre-order traversal of tree with root p
        if (p != null) {
            System.out.print(p.element);
            preorderPrint(p.left);
            preorderPrint(p.right);
        }
    }

    public void postorderPrint(Node<E> p) {
        // Post-order traversal of tree with root p
        if (p != null) {
            postorderPrint(p.left);
            postorderPrint(p.right);
            System.out.print(p.element);
        }
    }

    public void inorderPrint(Node<E> p) {
        // In-order traversal of tree with root p
        if (p != null) {
            inorderPrint(p.left);
            System.out.print(p.element);
            inorderPrint(p.right);
        }
    }
}