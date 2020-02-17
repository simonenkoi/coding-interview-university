package edu.simonenko.queue;

public class Queue<T> {

    private final T[] items;
    private int rear;
    private int front;
    private int size;

    public Queue(int capacity) {
        items = (T[]) new Object[capacity];
    }

    public void enqueue(T element) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        items[rear] = element;
        rear = (rear + 1) % items.length;
        ++size;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        T item = peek();
        items[front] = null;
        front = (front + 1) % items.length;
        --size;
        return item;
    }

    public T peek() {
        return items[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }
}
