package hw9;

public class MyStack {
    private Object[] array = new Object[10];
    private int size = 0;

    public void push(Object value) {
        if (size == array.length) {
            Object[] newArray = new Object[array.length + 10];

            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }

            array = newArray;
        }

        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;
    }

    public void clear() {
        array = new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) {
            return null;
        }

        return array[size - 1];
    }

    public Object pop() {
        if (size == 0) {
            return null;
        }

        Object value = array[size - 1];

        array[size - 1] = null;
        size--;

        return value;
    }
}
