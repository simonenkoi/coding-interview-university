package edu.simonenko.hashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FirstNonRepeatedElementFinder {

    public char find(String string) {
        /*Map<Character, Integer> map = new HashMap<>();
        char[] chars = string.toCharArray();
        for (var ch : chars) {
            var count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }

        for (var ch: chars) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return Character.MIN_VALUE;*/

        return string.chars()
                     .mapToObj(i -> (char) i)
                     .collect(orderedCountingCollector())
                     .entrySet()
                     .stream()
                     .filter(entry -> entry.getValue() == 1)
                     .findFirst()
                     .map(Map.Entry::getKey)
                     .orElse(Character.MIN_VALUE);
    }

    private static <T> Collector<T, ?, Map<T, Long>> orderedCountingCollector() {
        return Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting());
    }
}
