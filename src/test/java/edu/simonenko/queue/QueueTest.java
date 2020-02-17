package edu.simonenko.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    public static final int FIRST_ELEMENT = 10;
    public static final int SECOND_ELEMENT = 20;

    @Test
    void structureShouldBeFifo() {
        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(FIRST_ELEMENT);
        queue.enqueue(SECOND_ELEMENT);

        assertEquals(FIRST_ELEMENT, queue.dequeue());
        assertEquals(SECOND_ELEMENT, queue.dequeue());
    }

    @Test
    void exceptionShouldBeThrownWhenAddingToFullQueue() {
        Queue<Integer> queue = new Queue<>(0);

        assertThrows(IllegalStateException.class, () -> queue.enqueue(FIRST_ELEMENT));
    }

    @Test
    void exceptionShouldBeThrownWhenRemovingFromEmptyQueue() {
        Queue<Integer> queue = new Queue<>(0);

        assertThrows(IllegalStateException.class, queue::dequeue);
    }

    @Test
    void queueShouldNotOverflowAfterDequeueingOnTheMaximalCapacity() {
        Queue<Integer> queue = new Queue<>(2);
        queue.enqueue(FIRST_ELEMENT);
        queue.enqueue(SECOND_ELEMENT);

        queue.dequeue();
        queue.enqueue(FIRST_ELEMENT);

        assertEquals(SECOND_ELEMENT, queue.dequeue());
        assertEquals(FIRST_ELEMENT, queue.dequeue());
    }
}