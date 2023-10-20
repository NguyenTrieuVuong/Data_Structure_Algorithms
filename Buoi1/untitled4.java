public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
    }
    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = top;
        top = newNode;
        if (bot == null) {
            bot = top;
        }
        n++;
    }

    public void addBot(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        if (bot == null) {
            top = newNode;
            bot = top;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        Node current = top;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        Node current = top;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        current.data = data;
    }

    public boolean isContain(T data) {
        Node current = top;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public T removeTop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = top.data;
        top = top.next;
        n--;
        if (top == null) {
            bot = null;
        }
        return data;
    }

    public T removeBot() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = bot.data;
        if (top == bot) {
            top = null;
            bot = null;
        } else {
            Node current = top;
            while (current.next != bot) {
                current = current.next;
            }
            current.next = null;
            bot = current;
        }
        n--;
        return data;
    }

    public void remove(T data) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        while (top != null && top.data.equals(data)) {
            top = top.next;
            n--;
        }
        if (top == null) {
            bot = null;
            return;
        }
        Node current = top;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                n--;
            } else {
                current = current.next;
            }
        }
        bot = current;
    }
}
