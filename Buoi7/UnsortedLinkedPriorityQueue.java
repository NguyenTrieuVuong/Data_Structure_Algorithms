package Buoi7;

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            key = k;
            element = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getElement() {
            return element;
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    private int n;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        NodeEntry<K, E> nodeEntry = (NodeEntry<K, E>) entry;
        nodeEntry.next = null;
        if (isEmpty()) {
            head = tail = nodeEntry;
        } else {
            tail.next = nodeEntry;
            tail = nodeEntry;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new NodeEntry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        NodeEntry<K, E> min = head;
        head = head.next;
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head;
    }
}
