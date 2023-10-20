import java.util.Scanner;

public class BracketMatching {
    int numbers[] = new int[50], num = 0, tn = -1, to = -1, r;
    char op[] = new char[50], c;

    // function to push digits
    void push_num(int n) {
        numbers[++tn] = n;
    }

    // function to push operators
    void push_op(char ch) {
        op[++to] = ch;
    }

    // function to pop digits
    int pop_num() {
        return numbers[tn--];
    }

    // function to pop operators
    char pop_op() {
        return op[to--];
    }

    // function to evaluate an infix expression
    int eval(String exp) {
        for (int i = 0; i < exp.length(); i++) {
            // taking each character from the expression
            c = exp.charAt(i);
            // checking if it is number
            if (Character.isDigit(c)) {
                num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i < exp.length())
                        c = exp.charAt(i);
                    else
                        break;
                }
                i--;
                // pushing the number into stack of numbers
                push_num(num);
            } else if (c == '(') {
                // pushing the operators into the stack
                push_op(c);
            }
            // If we get close bracket, evaluate the entire bracket
            else if (c == ')') {
                while (op[to] != '(') {
                    r = infix_eval(numbers, op);
                    // pushing the result back to stack
                    push_num(r);
                }
                pop_op();
            }
            // if the current character is operator
            else if (isOperator(c)) {
                // evaluating the expression
                while (to != -1 && precedence(c) <= precedence(op[to])) {
                    int output = infix_eval(numbers, op);
                    // pushing the result back to stack
                    push_num(output);
                }
                // pushing the current operator to stack
                push_op(c);
            }
        }
        // if there is any remaining expression, evaluate them
        while (to != -1) {
            int output = infix_eval(numbers, op);
            // pushing it back to stack
            push_num(output);
        }
        return pop_num();
    }

    // the precedence of the operators
    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // evaluating the expression
    public int infix_eval(int numbers[], char op[]) {
        int x, y;
        char ope;
        x = pop_num();
        y = pop_num();
        ope = pop_op();
        switch (ope) {
            case '+':
                return x + y;
            case '-':
                return y - x;
            case '*':
                return x * y;
            case '/':
                if (x == 0) {
                    System.out.println("Cannot divide by zero");
                    System.exit(0);
                } else
                    return y / x;
        }
        return 0;
    }

    // function to check whether it is a operator is not
    public boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '/' || c == '*' || c == '^');
    }

    // Main Function
    public static void main(String[] args) {
        // taking the expression to evaluate
        String inex = new String();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression to evaluate: ");
        inex = sc.nextLine();
        BracketMatching i = new BracketMatching();
        System.out.println(i.eval(inex));
    }
}
