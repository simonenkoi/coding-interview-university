package edu.simonenko.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HashtableTest {

    private static final int FIRST_KEY = 6;
    private static final String FIRST_VALUE = "A";
    private static final int SECOND_KEY = 14;
    private static final String SECOND_VALUE = "B";

    @Test
    void hashtableShouldContainElementWhenInserted() {
        Hashtable<Integer, String> table = new Hashtable<>();

        table.put(FIRST_KEY, FIRST_VALUE);

        assertEquals(FIRST_VALUE, table.get(FIRST_KEY));
        assertNull(table.get(SECOND_KEY));
    }

    @Test
    void hashtableShouldContainSecondElementWhenKeyTheSame() {
        Hashtable<Integer, String> table = new Hashtable<>();

        table.put(FIRST_KEY, FIRST_VALUE);
        table.put(FIRST_KEY, SECOND_VALUE);

        assertEquals(SECOND_VALUE, table.get(FIRST_KEY));
    }

    @Test
    void hashtableShouldContainBothElementsWhenCollisionOccurred() {
        Hashtable<Integer, String> table = new Hashtable<>();

        table.put(FIRST_KEY, FIRST_VALUE);
        int collisionKey = FIRST_KEY + Hashtable.DEFAULT_BUCKETS_COUNT;
        table.put(collisionKey, SECOND_VALUE);

        assertEquals(FIRST_VALUE, table.get(FIRST_KEY));
        assertEquals(SECOND_VALUE, table.get(collisionKey));
    }

    @Test
    void valueShouldNotBePresentInFromHashtableWhenRemoved() {
        Hashtable<Integer, String> table = new Hashtable<>();

        table.put(FIRST_KEY, FIRST_VALUE);
        table.remove(FIRST_KEY);

        assertNull(table.get(FIRST_KEY));
    }

    @Test
    void illegalStateExceptionShouldBeThrownWhenRemovingNonexistentKey() {
        Hashtable<Integer, String> table = new Hashtable<>();

        assertThrows(IllegalStateException.class, () -> table.remove(FIRST_KEY));
    }

    @Test
    void illegalStateExceptionShouldBeThrownWhenRemovingNonexistentKeyInExistentBucket() {
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(FIRST_KEY, FIRST_VALUE);

        int collisionKey = FIRST_KEY + Hashtable.DEFAULT_BUCKETS_COUNT;
        assertThrows(IllegalStateException.class, () -> table.remove(collisionKey));
    }
}