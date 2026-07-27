package hw9;

public class MyHashMap {
    private Node[] table = new Node[16];
    private int size = 0;

    public void put(Object key, Object value) {
        int index = getIndex(key);

        Node current = table[index];

        while (current != null) {
            if (isKeysEquals(current.key, key)) {
                current.value = value;
                return;
            }

            current = current.next;
        }

        Node node = new Node(key, value);
        node.next = table[index];
        table[index] = node;
        size++;
    }

    public void remove(Object key) {
        int index = getIndex(key);

        Node current = table[index];
        Node previous = null;

        while (current != null) {
            if (isKeysEquals(current.key, key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }

                size--;
                return;
            }

            previous = current;
            current = current.next;
        }
    }

    public void clear() {
        table = new Node[16];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = getIndex(key);

        Node current = table[index];

        while (current != null) {
            if (isKeysEquals(current.key, key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    private int getIndex(Object key) {
        if (key == null) {
            return 0;
        }

        int hash = key.hashCode();

        if (hash < 0) {
            hash = -hash;
        }

        return hash % table.length;
    }

    private boolean isKeysEquals(Object firstKey, Object secondKey) {
        if (firstKey == secondKey) {
            return true;
        }

        if (firstKey == null || secondKey == null) {
            return false;
        }

        return firstKey.equals(secondKey);
    }

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
}
