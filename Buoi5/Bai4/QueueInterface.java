// package Bai4;

public interface QueueInterface<E> extends Iterable {
    public void enqueue(E element);

    public E dequeue();

    public boolean isEmpty();
}
