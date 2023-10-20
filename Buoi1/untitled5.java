import java.util.Iterator;

public interface ListInterface<T> extends Iterable<T>{
    public void add(T data);
    public T get(int i);
    public void set(int I, T data);
    public void remove(T data);
    public boolean isContain(T data);
    public int size();
    public boolean isEmpty();
}

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
        if(n == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            for(int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[n] = data;
        n++;
    }
    
    public T get(int i) {
        if(i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + n);
        }
        return array[i];
    }
    
    public void set(int i, T data) {
        if(i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + n);
        }
        array[i] = data;
    }
    
    public void remove(T data) {
        for(int i = 0; i < n; i++) {
            if(array[i].equals(data)) {
                for(int j = i; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                n--;
                break;
            }
        }
    }
    
    public boolean isContain(T data) {
        for(int i = 0; i < n; i++) {
            if(array[i].equals(data)) {
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
        return new ArrayListIterator();
    }
    
    private class ArrayListIterator implements Iterator<T> {
        private int i = 0;
        
        public boolean hasNext() {
            return i < n;
        }
        
        public T next() {
            if(!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T item = array[i];
            i++;
            return item;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
