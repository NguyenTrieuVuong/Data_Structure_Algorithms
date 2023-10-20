public class ArrayStack<E> implements StackInterface<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;
    public ArrayStack(){
        this(CAPACITY);
    }
    public ArrayStack(int capacity){
        data = (E[]) new Object[capacity];
    }
    public int size(){
        return (t+1);
    }
    public boolean isEmpty(){
        return (t == -1);
    }
    public void push(E e) throws IllegalStateException{
        if (size()==data.length){
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = e;
    }
    public E top(){
        if (isEmpty()) return null;
        return data[t];
    }
    public E pop(){
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }
    public static boolean isValid(String expression) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    public static int calculate(String expression) {
        if (!isValid(expression)) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }
        ArrayStack<Integer> stack = new ArrayStack<>();
        int num = 0;
        int sign = 1;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                stack.push(sign * num);
                sign = 1;
                num = 0;
            } else if (ch == '-') {
                stack.push(sign * num);
                sign = -1;
                num = 0;
            } else if (ch == '(') {
                stack.push(sign);
                sign = 1;
            } else if (ch == ')') {
                int val = stack.pop();
                sign = stack.pop();
                num = sign * (num + val);
                sign = 1;
            }
        }
        stack.push(sign * num);
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
    
    public static void main(String[] args) {
        String expression1 = "((2+3)*5)";
        System.out.println("Expression: " + expression1);
        System.out.println("Valid brackets: " + isValid(expression1));
        // System.out.println("Expression value: " + calculate(expression1));
        
        String expression2 = "1 + [(2 + 3) * (4 * 5)]";
        System.out.println("Expression: " + expression2);
        System.out.println("Valid brackets: " + isValid(expression2));
        // System.out.println("Expression value: " + calculate(expression2));
    }
}
