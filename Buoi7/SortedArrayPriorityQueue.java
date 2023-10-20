public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    private K[] keys;
    private E[] values;
    private int size;

    public SortedArrayPriorityQueue() {
        keys = new K[10];
        values = new E[10];
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
        if (size == keys.length) {
            resize(2 * keys.length);
        }
        keys[size] = entry.getKey();
        values[size] = entry.getValue();
        size++;
        shiftUp(size - 1);
    }

    @Override
    public void insert(K k, E e) {
        insert(new Entry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        Entry<K, E> min = new Entry<>(keys[0], values[0]);
        keys[0] = keys[size - 1];
        values[0] = values[size - 1];
        size--;
        shiftDown(0);
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return new Entry<>(keys[0], values[0]);
    }

    private void resize(int capacity) {
        K[] newKeys = new K[capacity];
        E[] newValues = new E[capacity];
        for (int i = 0; i < size; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }

    private void shiftUp(int index) {
        while (index > 0 && keys[index].compareTo(keys[index / 2]) < 0) {
            swap(index, index / 2);
            index /= 2;
        }
    }

    private void shiftDown(int index) {
        while (2 * index + 1 < size) {
            int child = 2 * index + 1;
            if (child + 1 < size && keys[child + 1].compareTo(keys[child]) < 0) {
                child++;
            }
            if (keys[index].compareTo(keys[child]) < 0) {
                swap(index, child);
                index = child;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        K tempKey = keys[i];
        E tempValue = values[i];
        keys[i] = keys[j];
        values[i] = values[j];
        keys[j] = tempKey;
        values[j] = tempValue;
    }
}
