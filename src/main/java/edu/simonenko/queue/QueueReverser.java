package edu.simonenko.queue;

import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    public <T> void reverse(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

}
