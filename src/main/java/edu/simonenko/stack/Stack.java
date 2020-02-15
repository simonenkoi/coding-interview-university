package edu.simonenko.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private final List<T> list = new ArrayList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int lastIndex = list.size() - 1;
        return list.remove(lastIndex);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}
