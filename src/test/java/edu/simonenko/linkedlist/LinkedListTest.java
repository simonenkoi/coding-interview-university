package edu.simonenko.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Nested
    class EmptyLinkedListTest {

        private LinkedList<Integer> list;

        @BeforeEach
        void init() {
            list = new LinkedList<>();
        }

        @Test
        void linkedListShouldBeEmptyWhenCreated() {
            assertTrue(list.isEmpty());
        }

        @Test
        void linkedListShouldHave0SizeWhenCreated() {
            assertEquals(0, list.size());
        }

        @Test
        void firstElementOfLinkedListShouldBeNullWhenCreated() {
            assertNull(list.first());
        }

        @Test
        void lastElementOfLinkedListShouldBeNullWhenCreated() {
            assertNull(list.last());
        }

        @Test
        void removeFirstShouldThrowNoSuchElementExceptionWhenCreated() {
            assertThrows(NoSuchElementException.class, () -> list.removeFirst());
        }

        @Test
        void removeLastShouldThrowNoSuchElementExceptionWhenCreated() {
            assertThrows(NoSuchElementException.class, () -> list.removeLast());
        }
    }

    @Nested
    class InsertedToStartLinkedListTest {

        private static final int VALUE = 1;
        private LinkedList<Integer> list;

        @BeforeEach
        void init() {
            list = new LinkedList<>();
            list.addFirst(VALUE);
        }

        @Test
        void linkedListShouldNotBeEmptyWhenValueInsertedToStart() {
            assertFalse(list.isEmpty());
        }

        @Test
        void linkedListShouldHave1SizeWhenValueInsertedToStart() {
            assertEquals(1, list.size());
        }

        @Test
        void firstElementOfLinkedListShouldBeEqualToValueWhenValueInsteredToStart() {
            assertEquals(VALUE, list.first());
        }

        @Test
        void lastElementOfLinkedListShouldBeEqualToValueWhenValueInsertedToStart() {
            assertEquals(VALUE, list.last());
        }

        @Test
        void linkedListShouldContainValueWhenValueInsertedToStart() {
            assertTrue(list.contains(VALUE));
        }

        @Test
        void indexOfValueShouldBe0WhenValueInsertedToStart() {
            assertEquals(0, list.indexOf(VALUE));
        }

        @Test
        void removeFirstShouldMakeListEmptyWhenValueInsertedToStart() {
            list.removeFirst();

            assertTrue(list.isEmpty());
        }

        @Test
        void removeLastShouldMakeListEmptyWhenValueInsertedToStart() {
            list.removeLast();

            assertTrue(list.isEmpty());
        }
    }

    @Nested
    class InsertedToEndLinkedListTest {

        private static final int VALUE = 1;
        private LinkedList<Integer> list;

        @BeforeEach
        void init() {
            list = new LinkedList<>();
            list.addLast(VALUE);
        }

        @Test
        void linkedListShouldNotBeEmptyWhenValueInsertedToStart() {
            assertFalse(list.isEmpty());
        }

        @Test
        void linkedListShouldHave1SizeWhenValueInsertedToStart() {
            assertEquals(1, list.size());
        }

        @Test
        void firstElementOfLinkedListShouldBeEqualToValueWhenValueInsertedToEnd() {
            assertEquals(VALUE, list.first());
        }

        @Test
        void lastElementOfLinkedListShouldBeEqualToValueWhenValueInsertedToEnd() {
            assertEquals(VALUE, list.last());
        }

        @Test
        void linkedListShouldContainValueWhenValueInsertedToEnd() {
            assertTrue(list.contains(VALUE));
        }

        @Test
        void indexOfValueShouldBe0WhenValueInsertedToEnd() {
            assertEquals(0, list.indexOf(VALUE));
        }

        @Test
        void removeFirstShouldMakeListEmptyWhenValueInsertedToEnd() {
            list.removeLast();

            assertTrue(list.isEmpty());
        }

        @Test
        void removeLastShouldTMakeListEmptyWhenValueInsertedToEnd() {
            list.removeLast();

            assertTrue(list.isEmpty());
        }
    }

    @Nested
    class LinkedListFirstRemovalTest {

        private static final int FIRST_VALUE = 10;
        private static final int SECOND_VALUE = 20;

        private LinkedList<Integer> list;

        @BeforeEach
        void init() {
            list = new LinkedList<>();
            list.addLast(FIRST_VALUE);
            list.addLast(SECOND_VALUE);
            list.removeFirst();
        }

        @Test
        void linkedListShouldNotBeEmptyWhenFirstValueRemoved() {
            assertFalse(list.isEmpty());
        }

        @Test
        void linkedListShouldHave1SizeWhenFirstValueRemoved() {
            assertEquals(1, list.size());
        }

        @Test
        void firstElementOfLinkedListShouldBeEqualToSecondValueWhenFirstValueRemoved() {
            assertEquals(SECOND_VALUE, list.first());
        }

        @Test
        void lastElementOfLinkedListShouldBeEqualToSecondValueWhenFirstValueRemoved() {
            assertEquals(SECOND_VALUE, list.last());
        }

        @Test
        void linkedListShouldNotContainFirstValueWhenFirstValueRemoved() {
            assertFalse(list.contains(FIRST_VALUE));
        }

        @Test
        void linkedListShouldContainSecondValueWhenFirstValueRemoved() {
            assertTrue(list.contains(SECOND_VALUE));
        }

        @Test
        void indexOfSecondValueShouldBeMinus1WhenFirstValueRemoved() {
            assertEquals(-1, list.indexOf(FIRST_VALUE));
        }

        @Test
        void indexOfSecondValueShouldBe0WhenFirstValueRemoved() {
            assertEquals(0, list.indexOf(SECOND_VALUE));
        }
    }

    @Nested
    class LinkedListLastRemovalTest {

        private static final int FIRST_VALUE = 10;
        private static final int SECOND_VALUE = 20;

        private LinkedList<Integer> list;

        @BeforeEach
        void init() {
            list = new LinkedList<>();
            list.addFirst(SECOND_VALUE);
            list.addFirst(FIRST_VALUE);
            list.removeLast();
        }

        @Test
        void linkedListShouldNotBeEmptyWhenLastValueRemoved() {
            assertFalse(list.isEmpty());
        }

        @Test
        void linkedListShouldHave1SizeWhenLastValueRemoved() {
            assertEquals(1, list.size());
        }

        @Test
        void firstElementOfLinkedListShouldBeEqualToFirstValueWhenLastValueRemoved() {
            assertEquals(FIRST_VALUE, list.first());
        }

        @Test
        void lastElementOfLinkedListShouldBeEqualToFirstValueWhenLastValueRemoved() {
            assertEquals(FIRST_VALUE, list.last());
        }

        @Test
        void linkedListShouldContainFirstValueWhenLastValueRemoved() {
            assertTrue(list.contains(FIRST_VALUE));
        }

        @Test
        void linkedListShouldNotContainSecondValueWhenLastValueRemoved() {
            assertFalse(list.contains(SECOND_VALUE));
        }

        @Test
        void indexOfSecondValueShouldBe0WhenLastValueRemoved() {
            assertEquals(0, list.indexOf(FIRST_VALUE));
        }

        @Test
        void indexOfSecondValueShouldBeMinus1WhenLastValueRemoved() {
            assertEquals(-1, list.indexOf(SECOND_VALUE));
        }
    }

    @Nested
    class LinkedListToArrayTest {

        private final Integer[] array = {10, 20, 30, 40};
        private LinkedList<Integer> list;

        @BeforeEach
        void init() {
            list = new LinkedList<>();
            Arrays.stream(array).forEach(i -> list.addLast(i));
        }

        @Test
        void arrayShouldBeEqualToOriginalWhenCreatedFromLinkedList() {
            assertArrayEquals(array, list.toArray());
        }
    }

    @Nested
    class LinkedListReverseTest {

        private final Integer[] array = {10, 20, 30, 40};
        private LinkedList<Integer> list;

        @BeforeEach
        void init() {
            list = new LinkedList<>();
            Arrays.stream(array).forEach(i -> list.addFirst(i));
            list.reverse();
        }

        @Test
        void arrayShouldBeEqualToOriginalWhenCreatedFromReversedLinkedList() {
            assertArrayEquals(array, list.toArray());
        }

    }

    @Nested
    class LinkedListKthFromEndTest {

        private final Integer[] array = {10, 20, 30, 40, 50, 60};
        private LinkedList<Integer> list;

        @BeforeEach
        void init() {
            list = new LinkedList<>();
            Arrays.stream(array).forEach(i -> list.addLast(i));
        }

        @Test
        void kthValueFromEndShouldBeEqualToCorrespondingValueFromOriginalArray() {
            for (int i = 0; i < array.length; i++) {
                assertEquals(array[i], list.getKthFromEnd(array.length - i));
            }
        }

        @Test
        void kthValueFromEndShouldThrowIllegalArgumentExceptionWhenIndexIsOutOfBounds() {
            assertThrows(IllegalArgumentException.class, () -> list.getKthFromEnd(array.length + 1));
        }

    }
}