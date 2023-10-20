package Buoi7;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    private class Node {
        K key;
        E value;
        Node next;

        Node(K key, E value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SortedLinkedPriorityQueue() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        Node newNode = new Node(entry.getKey(), entry.getValue());
        Node current = head;
        Node previous = null;
        while (current != null && newNode.key.compareTo(current.key) > 0) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            head = newNode;
        } else {
            previous.next = newNode;
        }
        newNode.next = current;
        size++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new Entry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Entry<K, E> minEntry = head.entry;
        head = head.next;
        size--;
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.entry;
    }
}
