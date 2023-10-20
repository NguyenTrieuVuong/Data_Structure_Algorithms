import java.util.Iterator;

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
        if (n == array.length) {
            resize(2 * array.length);
        }
        array[n] = data;
        n++;
    }
    
    public T get(int i) {
        if (i < 0 || i >= n) {
            // throw new IndexOutOfBoundsException();
        }
        return array[i];
    }
    
    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        array[i] = data;
    }
    
    public void remove(T data) {
        int i = 0;
        while (i < n && !array[i].equals(data)) {
            i++;
        }
        if (i < n) {
            for (int j = i; j < n - 1; j++) {
                array[j] = array[j + 1];
            }
            n--;
            if (n > 0 && n == array.length / 4) {
                resize(array.length / 2);
            }
        }
    }
    
    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }
    
    public int size() {
        return n;
    }
    
    public boolean isEmpty() {
        return n == 0;
    }
    
    public Iterator<T> iterator() {
        return new SimpleArrayListIterator();
    }
    
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
    
    public class SimpleArrayListIterator implements Iterator<T> {
        public int i = 0;
        
        public boolean hasNext() {
            return i < n;
        }
        
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T data = array[i];
            i++;
            return data;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
