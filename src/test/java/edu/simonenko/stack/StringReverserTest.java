package edu.simonenko.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringReverserTest {

    private static Stream<Arguments> stringsProvider() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("ab", "ba"),
                Arguments.of("abc", "cba"),
                Arguments.of("aba", "aba")
        );
    }

    @ParameterizedTest
    @MethodSource("stringsProvider")
    void inputShouldBeEqualToExpectedWhenReversed(String input, String expected) {
        var stringReverser = new StringReverser();

        var actual = stringReverser.reverse(input);

        assertEquals(expected, actual);
    }
}