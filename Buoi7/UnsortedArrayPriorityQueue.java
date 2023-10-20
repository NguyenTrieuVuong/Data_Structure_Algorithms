package Buoi7;
public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            key = k;
            element = e;
        }

        public K getKey() {
            return key;
        }

        public E getValue() {
            return element;
        }
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultsize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultsize];
    }

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
        ArrEntry<K, E> e = (ArrEntry<K, E>) entry;
        array[n] = e;
        n++;
    }

    @Override
    public void insert(K k, E e) {
        ArrEntry<K, E> e1 = new ArrEntry<>(k, e);
        array[n] = e1;
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }

        Entry<K, E> min = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(min.getKey()) < 0) {
                min = array[i];
            }
        }

        ArrEntry<K, E> temp = array[0];
        array[0] = array[n - 1];
        array[n - 1] = temp;
        n--;

        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }

        return array[0];
    }
}