// package Bai4;
import java.util.*;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
        top = 0;
    }

    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
        top = 0;
    }

    @Override
    public void enqueue(E element) {
        // TODO Auto-generated method stub
        if(count < n){
            queue[(top+count)%n] = element;
            count++;
        }else{
            throw new IllegalStateException("Queue is full");
        }
    }

    @Override
    public E dequeue() {
        // TODO Auto-generated method stub
        if(count > 0){
            E element = queue[top];
            top = (top + 1)%n;
            count--;
            return element;
        }else{
            throw new IllegalStateException("Queue is empty");
        }
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if(count == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new ArrayQueueIterator();

    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;

        private int num = 0;

        @Override
        public boolean hasNext() {

            // TODO Auto-generated method stub
            return num < count;

        }

        @Override
        public E next() {

            // TODO Auto-generated method stub
            E data = queue[(current + num) % n];

            num++;
            return data;
        }
    }
    public static void main(String[] args) {
        ArrayQueue<Integer> A = new ArrayQueue<>(3);
        A.enqueue(6);
        A.dequeue();
        System.out.println(A.isEmpty());
    }
}