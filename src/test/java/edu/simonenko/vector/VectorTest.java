package edu.simonenko.vector;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VectorTest {

    @Test
    @DisplayName("Vector should be empty by default when created")
    void createdVectorShouldBeEmpty() {
        Vector<Integer> vector = new Vector<>();

        assertTrue(vector.isEmpty());
    }

    @Test
    @DisplayName("Vector should have zero size by default when created")
    void createdVectorShouldHaveZeroSize() {
        Vector<Integer> vector = new Vector<>();

        assertEquals(0, vector.size());
    }

    @Test
    @DisplayName("Negative capacity should lead to exception")
    void negativeCapacityShouldLeadToException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Vector<>(-1));
    }

    @Test
    @DisplayName("Negative index should lead to exception")
    void negativeIndexShouldLeadToException() {
        Vector<Integer> vector = new Vector<>();

        assertThrows(IllegalArgumentException.class, () ->
                vector.at(-1));
    }

    @Test
    @DisplayName("Index greater then size should lead to exception")
    void indexGreaterThenSizeShouldLeadToException() {
        Vector<Integer> vector = new Vector<>();

        assertThrows(IllegalArgumentException.class, () ->
                vector.at(1));
    }

    @Test
    @DisplayName("Vector should not be empty when one value was added")
    void vectorWithOneValueShouldNotBeEmpty() {
        Vector<Integer> vector = new Vector<>();

        vector.push(1);

        assertFalse(vector.isEmpty());
    }

    @Test
    @DisplayName("Vector should have 1 size when one value was added")
    void vectorWithOneValueShouldHave1Size() {
        Vector<Integer> vector = new Vector<>();

        vector.push(1);

        assertEquals(1, vector.size());
    }

    @Test
    @DisplayName("Vector should be resized when its size half of capacity")
    void vectorShouldBeResizedOnCapacityStarvation() {
        Vector<Integer> vector = new Vector<>(2);
        int initialCapacity = vector.getCapacity();

        vector.push(1);
        vector.push(2);
        vector.push(3);
        vector.push(4);

        int expectedCapacity = initialCapacity * 2;
        assertEquals(expectedCapacity, vector.getCapacity());
    }

    @Test
    @DisplayName("Negative insertion index should lead to exception")
    void negativeInsertionIndexShouldLeadToException() {
        Vector<Integer> vector = new Vector<>();

        assertThrows(IllegalArgumentException.class, () ->
                vector.insert(-1, 1));
    }

    @Test
    @DisplayName("Value should be inserted to given index")
    void valueShouldBeInsertedToGivenIndex() {
        Vector<Integer> vector = new Vector<>();

        vector.insert(3, 1);

        assertEquals(1, vector.at(3));
    }

    @Test
    @DisplayName("Vector should be resized after insertion to given index")
    void vectorShouldBeResizedAfterInsertionToGivenIndex() {
        Vector<Integer> vector = new Vector<>(2);

        vector.insert(15, 1);

        assertEquals(16, vector.getCapacity());
    }

    @Test
    @DisplayName("Value should be inserted to start of vector")
    void valueShouldBeInsertedToStartOfVector() {
        Vector<Integer> vector = new Vector<>();

        vector.prepend( 1);

        assertEquals(1, vector.at(0));
    }

    @Test
    @DisplayName("Values should be shifted after prepending an element")
    void valuesShouldBeShifterAfterPrependingAnElement() {
        Vector<Integer> vector = new Vector<>();

        vector.push(2);
        vector.push(3);
        vector.prepend( 1);

        assertEquals(2, vector.at(1));
        assertEquals(3, vector.at(2));
    }

    @Test
    @DisplayName("Vector should be resized after prepending an element")
    void vectorShouldBeResizedAfterPrependingAnElement() {
        Vector<Integer> vector = new Vector<>(2);
        int initialCapacity = vector.getCapacity();

        vector.push(2);
        vector.push(3);
        vector.prepend( 1);

        int expectedCapacity = initialCapacity * 2;
        assertEquals(expectedCapacity, vector.getCapacity());
    }

    @Test
    @DisplayName("Exception should be thrown if there is no element to pop")
    void exceptionShouldBeThrownIfThereIsNoElementToPop() {
        Vector<Integer> vector = new Vector<>();

        assertThrows(IllegalArgumentException.class, vector::pop);
    }

    @Test
    @DisplayName("Vector should be resized after poping of element")
    void vectorShouldBeResizedAfterPopingOfElement() {
        Vector<Integer> vector = new Vector<>();
        int initialCapacity = vector.getCapacity();

        vector.push(1);
        vector.pop();

        int expectedCapacity = initialCapacity / 2;
        assertEquals(expectedCapacity, vector.getCapacity());
    }

    @Test
    @DisplayName("Vector should be empty after poping of single element")
    void vectorShouldBeEmptyAfterPopingOfSingleElement() {
        Vector<Integer> vector = new Vector<>();

        vector.push(1);
        vector.pop();

        assertTrue(vector.isEmpty());
    }

    @Test
    @DisplayName("Vector should have zero size after poping of single element")
    void vectorShouldHaveZeroSizeAfterPopingOfSingleElement() {
        Vector<Integer> vector = new Vector<>();

        vector.push(1);
        vector.pop();

        assertEquals(0, vector.size());
    }

    @Test
    @DisplayName("Exception should be thrown if there is no element to delete by given index")
    void exceptionShouldBeThrownIfThereIsNoElementToDeleteByGivenIndex() {
        Vector<Integer> vector = new Vector<>();

        assertThrows(IllegalArgumentException.class, () -> vector.delete(0));
    }

    @Test
    @DisplayName("Exception should be thrown if deletion index is negative")
    void exceptionShouldBeThrownIfDeletionIndexIsNegative() {
        Vector<Integer> vector = new Vector<>();

        assertThrows(IllegalArgumentException.class, () -> vector.delete(-1));
    }

    @Test
    @DisplayName("Vector should be resized after deleting of element")
    void vectorShouldBeResizedAfterDeletingOfElement() {
        Vector<Integer> vector = new Vector<>();
        int initialCapacity = vector.getCapacity();

        vector.push(1);
        vector.delete(0);

        int expectedCapacity = initialCapacity / 2;
        assertEquals(expectedCapacity, vector.getCapacity());
    }

    @Test
    @DisplayName("Vector should be empty after deletion of single element")
    void vectorShouldBeEmptyAfterDeletionOfSingleElement() {
        Vector<Integer> vector = new Vector<>();

        vector.push(1);
        vector.delete(0);

        assertTrue(vector.isEmpty());
    }

    @Test
    @DisplayName("Vector should have zero size after deletion of single element")
    void vectorShouldHaveZeroSizeAfterDeletionOfSingleElement() {
        Vector<Integer> vector = new Vector<>();

        vector.push(1);
        vector.delete(0);

        assertEquals(0, vector.size());
    }

    @Test
    @DisplayName("Values should be shifted after removing of middle element")
    void valuesShouldBeShiftedAfterRemovingOfMiddleElement() {
        Vector<Integer> vector = new Vector<>();

        vector.push(1);
        vector.push(2);
        vector.push(3);
        vector.delete(1);

        assertEquals(1, vector.at(0));
        assertEquals(3, vector.at(1));
    }

    @Test
    @DisplayName("Exception should be thrown if finding element is null")
    void exceptionShouldBeThrownIfFindingElementIsNull() {
        Vector<Integer> vector = new Vector<>();

        assertThrows(IllegalArgumentException.class, () ->
                vector.find(null));
    }

    @Test
    @DisplayName("Found index should be correct")
    void foundIndexShouldBeCorrect() {
        Vector<Integer> vector = new Vector<>();

        vector.push(1);
        vector.push(2);
        int foundIndex = vector.find(2);

        assertEquals(1, foundIndex);
    }

    @Test
    @DisplayName("Index for non existing element should be -1")
    void indexForNonExistingElementShouldBeCorrect() {
        Vector<Integer> vector = new Vector<>();

        vector.push(1);
        vector.push(2);
        int foundIndex = vector.find(3);

        assertEquals(-1, foundIndex);
    }

    @Test
    @DisplayName("Exception should be thrown if removed element is null")
    void exceptionShouldBeThrownIfRemovedElementIsNull() {
        Vector<Integer> vector = new Vector<>();

        assertThrows(IllegalArgumentException.class, () ->
                vector.remove(null));
    }

    @Test
    @DisplayName("Value should be removed after removing call")
    void valueShouldBeRemovedAfterRemoving() {
        Vector<Integer> vector = new Vector<>();

        vector.push(1);
        vector.push(2);
        vector.remove(1);

        assertEquals(-1, vector.find(1));
    }

    @Test
    @DisplayName("Nothing should have happened if removing element was not found")
    void nothingShouldHaveHappenedIfRemovingElementWasNotFound() {
        Vector<Integer> vector = new Vector<>();

        vector.push(1);
        vector.push(2);
        vector.remove(3);

        assertEquals(2, vector.size());
    }
}