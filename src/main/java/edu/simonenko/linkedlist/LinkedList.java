package edu.simonenko.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    private int size;

    public boolean isEmpty() {
        return first == null;
    }

    public void addFirst(T element) {
        var node = new Node<>(element);
        if (isEmpty()) {
            last = node;
        } else {
            node.next = first;
        }
        first = node;
        ++size;
    }

    public void addLast(T element) {
        var node = new Node<>(element);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        ++size;
    }

    public int indexOf(T element) {
        int index = 0;
        for (var current = first; current != null; current = current.next) {
            if (current.value.equals(element)) {
                return index;
            }
            ++index;
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = null;
            last = null;
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        --size;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = null;
            last = null;
        } else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        --size;
    }

    private Node<T> getPrevious(Node<T> node) {
        for (var current = first; current != null; current = current.next) {
            if (current.next == node) {
                return current;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        var index = 0;
        for (var current = first; current != null; current = current.next) {
            array[index++] = current.value;
        }
        return array;
    }

    public void reverse() {
        Node<T> previous = null;
        var current = first;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        first = previous;
    }

    private static class Node<T> {

        private final T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }
    }
}
