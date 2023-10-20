package Buoi6.Bai2;

import Buoi6.Bai2.LinkedBinaryTree.Node;

public class printOrder {
    public static void main(String[] args) {
        ExpressionTree<Character> expressionTree = buildExpressionTree();

        // Print prefix expression
        System.out.print("Prefix expression: ");
        expressionTree.preorderPrint(expressionTree.root);
        System.out.println();

        // Print postfix expression
        System.out.print("Postfix expression: ");
        expressionTree.postorderPrint(expressionTree.root);
        System.out.println();

        // Print infix expression
        System.out.print("Infix expression: ");
        expressionTree.inorderPrint(expressionTree.root);
        System.out.println();
    }

    public static ExpressionTree<Character> buildExpressionTree() {
        ExpressionTree<Character> tree = new ExpressionTree<>();
        ExpressionTree.Node<Character> multiply = tree.createNode('*');
        ExpressionTree.Node<Character> plus = tree.createNode('+');
        ExpressionTree.Node<Character> divide = tree.createNode('/');
        ExpressionTree.Node<Character> subtract = tree.createNode('-');

        tree.root = multiply;

        multiply.left = plus;
        multiply.right = subtract;

        plus.left = divide;
        tree.createNode('6', null, null, divide);
        tree.createNode('2', null, null, divide);
        divide.right = tree.createNode('3', null, null, plus);

        tree.createNode('7', null, null, subtract);
        tree.createNode('4', null, null, subtract);

        return tree;
    }
}
