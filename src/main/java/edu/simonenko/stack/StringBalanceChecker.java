package edu.simonenko.stack;

import java.util.List;
import java.util.Stack;

public class StringBalanceChecker {

    private static final List<Character> OPEN_BRACKETS = List.of('(', '<', '{', '[');
    private static final List<Character> CLOSE_BRACKETS = List.of(')', '>', '}', ']');

    public boolean check(String input) {
        var stack = new Stack<Character>();
        for (char ch : input.toCharArray()) {
            if (isOpenBracket(ch)) {
                stack.push(ch);
            }

            if (isCloseBracket(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (!bracketsMatch(top, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char ch) {
        return OPEN_BRACKETS.contains(ch);
    }

    private static boolean isCloseBracket(char ch) {
        return CLOSE_BRACKETS.contains(ch);
    }

    private boolean bracketsMatch(char open, char close) {
        return OPEN_BRACKETS.indexOf(open) == CLOSE_BRACKETS.indexOf(close);
    }
}

