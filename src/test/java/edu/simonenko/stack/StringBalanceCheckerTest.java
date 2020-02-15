package edu.simonenko.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringBalanceCheckerTest {

    private static Stream<Arguments> expressionsProvider() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("(1 + 2)", true),
                Arguments.of("1 + 2)", false),
                Arguments.of("(1 + 2", false),
                Arguments.of(")1 + 2", false),
                Arguments.of(")1 + 2(", false),
                Arguments.of("[1 + 2]", true),
                Arguments.of("1 + 2]", false),
                Arguments.of("[1 + 2", false),
                Arguments.of("]1 + 2", false),
                Arguments.of("]1 + 2[", false),
                Arguments.of("{1 + 2}", true),
                Arguments.of("1 + 2}", false),
                Arguments.of("{1 + 2", false),
                Arguments.of("}1 + 2", false),
                Arguments.of("}1 + 2{", false),
                Arguments.of("<1 + 2>", true),
                Arguments.of("1 + 2>", false),
                Arguments.of("<1 + 2", false),
                Arguments.of(">1 + 2", false),
                Arguments.of(">1 + 2<", false),
                Arguments.of("(<1 + 2>)", true),
                Arguments.of("(<1 + 2)>", false),
                Arguments.of("(<1 + 2>", false),
                Arguments.of("(<1 + 2)", false)
        );
    }

    @ParameterizedTest
    @MethodSource("expressionsProvider")
    void inputShouldBeEqualToExpectedWhen(String expression, boolean expected) {
        var stringBalanceChecker = new StringBalanceChecker();

        var actual = stringBalanceChecker.check(expression);

        assertEquals(expected, actual);
    }
}