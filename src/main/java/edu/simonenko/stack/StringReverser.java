package edu.simonenko.stack;

import java.util.Stack;

public class StringReverser {

    public String reverse(String input) {
        var stack = new Stack<Character>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
