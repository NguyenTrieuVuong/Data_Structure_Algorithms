// package Bai4;
public interface StackInterface<E> {
    public void push(E element);

    public E pop();

    public boolean isEmpty();

    public E top();

    public int size();
}