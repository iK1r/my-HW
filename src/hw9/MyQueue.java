package hw9;

public class MyQueue {
    private Node first;
    private Node last;
    private int size = 0;

    public void add(Object value) {
        Node node = new Node(value);

        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (first == null) {
            return null;
        }

        return first.value;
    }

    public Object poll() {
        if (first == null) {
            return null;
        }

        Object value = first.value;

        first = first.next;
        size--;

        if (first == null) {
            last = null;
        }

        return value;
    }

    private static class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
}
