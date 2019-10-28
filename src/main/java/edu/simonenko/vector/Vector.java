package edu.simonenko.vector;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Vector<T> {

    private static final int DEFAULT_VECTOR_CAPACITY = 16;

    private T[] array;
    private int size;

    public Vector() {
        this(DEFAULT_VECTOR_CAPACITY);
    }

    public Vector(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmtpy() {
        return size() == 0;
    }

    public int getCapacity() {
        return array.length;
    }

    public T at(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must not be negative");
        }
        if (index >= size) {
            throw new IllegalArgumentException("Index must not be greater than vector's size");
        }

        return array[index];
    }

    public void push(T element) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[size] = element;
        ++size;
    }

    public void insert(int index, T element) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must not be negative");
        }
        if (index > array.length) {
            resize((int) Math.pow(2, Math.ceil(Math.log(index) / Math.log(2))));
        }
        array[index] = element;
        if (index > size) {
            size = index + 1;
        }
    }

    public void prepend(T element) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        T[] copy = array;
        System.arraycopy(copy, 0, array, 1, array.length - 1);
        array[0] = element;
        ++size;
    }

    public void pop() {
        if (isEmtpy()) {
            throw new IllegalArgumentException("Cannot pop element of empty vector");
        }
        if (size <= array.length / 4) {
            resize(array.length / 2);
        }
        array[size - 1] = null;
        --size;
    }

    public void delete(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must not be negative");
        }
        if (index >= size) {
            throw new IllegalArgumentException("There is no element to delete by given index");
        }
        if (size <= array.length / 4) {
            resize(array.length / 2);
        }
        array[index] = null;
        --size;
        System.arraycopy(array, index + 1, array, index, size - index);
    }

    public void remove(T item) {
        int elementIndex = find(item);
        if (elementIndex != -1) {
            delete(elementIndex);
        }
    }

    public int find(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot find index of null item in the vector");
        }
        return IntStream.range(0, size)
                        .filter(i -> item.equals(array[i]))
                        .findFirst()
                        .orElse(-1);
    }

    private void resize(int newCapacity) {
        array = Arrays.copyOf(array, newCapacity);
    }
}
