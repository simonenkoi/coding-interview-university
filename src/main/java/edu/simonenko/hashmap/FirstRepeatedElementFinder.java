package edu.simonenko.hashmap;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedElementFinder {

    public char find(String string) {
        Set<Character> set = new HashSet<>();
        for (var ch : string.toCharArray()) {
            if (set.contains(ch)) {
                return ch;
            }
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
