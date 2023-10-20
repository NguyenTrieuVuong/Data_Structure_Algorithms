public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        Node node = new Node();
        node.data = data;
        node.next = top;
        top = node;
        if (bot == null) {
            bot = node;
        }
        n++;
    }

    public void addBot(T data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (bot == null) {
            top = node;
            bot = node;
        } else {
            bot.next = node;
            bot = node;
        }
        n++;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        Node node = top;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        return node.data;
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        Node node = top;
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        node.data = data;
    }

    public boolean isContain(T data) {
        Node node = top;
        while (node != null) {
            if (node.data.equals(data)) {
                return true;
            }
            node = node.next;
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
        if (top == null) {
            bot = null;
        }
        n--;
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
            Node node = top;
            while (node.next != bot) {
                node = node.next;
            }
            node.next = null;
            bot = node;
        }
        n--;
        return data;
    }

    public void remove(T data) {
        Node node = top;
        Node prev = null;
        while (node != null) {
            if (node.data.equals(data)) {
                if (prev == null) {
                    top = node.next;
                } else {
                    prev.next = node.next;
                }
                if (node.next == null) {
                    bot = prev;
                }
                n--;
            } else {
                prev = node;
            }
            node = node.next;
        }
    }
}
