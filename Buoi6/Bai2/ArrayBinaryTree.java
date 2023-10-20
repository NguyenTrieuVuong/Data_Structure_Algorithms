package Buoi6.Bai2;

public class ArrayBinaryTree<E,T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultsize = 100;

    public ArrayBinaryTree(){
        array = (E[]) new Object[defaultsize];
    }

    public void setRoot(E element) {
        // Set element to root of an empty tree (at index 1)
        if (isEmpty()) {
            array[1] = element;
            n++;
        } else {
            array[1] = element;
        }
    }

    public void setLeft(int p, E element) {
        // Set left child of p (at index 2p)
        if (2 * p <= n && array[p] != null) {
            array[2 * p] = element;
            n++;
        } else {
            array[2 * p] = element;
        }
    }

    public void setRight(int p, E element) {
        // Set right child of p (at index 2p+1)
        if (2 * p + 1 <= n && array[p] != null) {
            array[2 * p + 1] = element;
            n++;
        } else {
            array[2 * p + 1] = element;
        }
    }

    public T root() {
        return (T) array[1];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int numChildren(T p) {
        int num = 0;
        int index = getIndex(p);
        if (2 * index <= n && array[2 * index] != null) {
            num++;
        }
        if (2 * index + 1 <= n && array[2 * index + 1] != null) {
            num++;
        }
        return num;
    }

    public T parent(T p) {
        int index = getIndex(p);
        if (index == 1) {
            return null;
        }
        return (T) array[index / 2];
    }

    public T left(T p) {
        int index = getIndex(p);
        if (2 * index > n || array[2 * index] == null) {
            return null;
        }
        return (T) array[2 * index];
    }

    public T right(T p) {
        int index = getIndex(p);
        if (2 * index + 1 > n || array[2 * index + 1] == null) {
            return null;
        }
        return (T) array[2 * index + 1];
    }

    public T sibling(T p) {
        T parent = parent(p);
        if (parent == null) {
            return null;
        }
        if (left(parent) == p) {
            return right(parent);
        } else {
            return left(parent);
        }
    }

    private int getIndex(T p) {
        return (int) p;
    }
}