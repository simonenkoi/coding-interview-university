package edu.simonenko.queue;

import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.*;

class QueueReverserTest {

    public static final int FIRST_ELEMENT = 10;
    public static final int SECOND_ELEMENT = 20;

    @Test
    void queueShouldBeReversedAfterReversing() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(FIRST_ELEMENT);
        queue.add(SECOND_ELEMENT);

        new QueueReverser().reverse(queue);

        assertEquals(SECOND_ELEMENT, queue.poll());
        assertEquals(FIRST_ELEMENT, queue.poll());
    }

}