public interface QueueInterface<E> {
    public void enqueue(E element);

    public E dequeue();

    public boolean isEmpty();
}
