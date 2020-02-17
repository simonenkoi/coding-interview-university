package edu.simonenko.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstNonRepeatedElementFinderTest {

    @Test
    void firstNonRepeatedElementShouldBeFoundCorrectly() {
        var string ="a green apple";

        char actual = new FirstNonRepeatedElementFinder().find(string);

        assertEquals('g', actual);
    }

}