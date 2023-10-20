package Bai2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void add(T data) {
        if (n == array.length) resize(2 * array.length);
        array[n++] = data;
    }

    public T get(int i) {
        if (i < 0 || i >= n) throw new IndexOutOfBoundsException();
        return array[i];
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n) throw new IndexOutOfBoundsException();
        array[i] = data;
    }

    public void remove(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                for (int j = i; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[n - 1] = null;
                n--;
                if (n > 0 && n == array.length / 4) resize(array.length / 2);
                return;
            }
        }
    }

    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) return true;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < n; i++) temp[i] = array[i];
        array = temp;
    }

    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int i = 0;

        public boolean hasNext() {
            return i < n;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return array[i++];
        }
    }
}
