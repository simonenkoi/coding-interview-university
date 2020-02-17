package edu.simonenko.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstRepeatedElementFinderTest {

    @Test
    void firstRepeatedElementShouldBeFoundCorrectly() {
        var string ="a green apple";

        char actual = new FirstRepeatedElementFinder().find(string);

        assertEquals('e', actual);
    }

}