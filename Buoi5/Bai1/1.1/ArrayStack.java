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
    @Override
    public int size(){
        return (t+1);
    }
    @Override
    public boolean isEmpty(){
        return (t == -1);
    }
    @Override
    public void push(E e) throws IllegalStateException{
        if (size()==data.length){
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = e;
    }
    @Override
    public E top(){
        if (isEmpty()) return null;
        return data[t];
    }
    @Override
    public E pop(){
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }
    public static void main(String[] args) {
        StackInterface<Integer> S = new ArrayStack<>(10);
        S.push(5);
        S.push(3);
        System.out.println(S.size());
        System.out.println(S.pop());
        System.out.println(S.isEmpty());
        System.out.println(S.pop());
        System.out.println(S.isEmpty());
        System.out.println(S.pop());
        S.push(7);
        S.push(9);
        System.out.println(S.top());
        S.push(4);
        System.out.println(S.size());
        System.out.println(S.pop());
        S.push(6);
        S.push(8);
        System.out.println(S.pop());
    }
}
