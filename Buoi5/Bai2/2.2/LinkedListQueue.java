import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E>{
    private Node<E> first;  // beginning of queue
    private Node<E> last;   // end of queue
    private int size;       // size of the queue

    // helper linked list class
    private static class Node<E> {
        private E element;
        private Node<E> next;
    }

    public LinkedListQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(E element) {
        Node<E> oldlast = last;
        last = new Node<E>();
        last.element = element;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        E element = first.element;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return element;
    }
    public static void main(String[] args) {
        LinkedListQueue<Integer> L = new LinkedListQueue<>();
        L.enqueue(1);
        L.enqueue(2);
        L.dequeue();
        L.dequeue();
        L.enqueue(3);
        L.enqueue(4);
        L.enqueue(5);
        L.dequeue();
        System.out.println(L.isEmpty());
        System.out.println(L.first.element);
        System.out.println(L.last.element);
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}