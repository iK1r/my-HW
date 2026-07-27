package hw9;

public class MyLinkedList {
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
            node.previous = last;
            last = node;
        }

        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        Node current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current.previous == null) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current.next == null) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        size--;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    private static class Node {
        private Object value;
        private Node previous;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
}
