package edu.simonenko.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeTest {

    private static final int FIRST_VALUE = 10;
    private static final int SECOND_VALUE = 5;
    private static final int THIRD_VALUE = 3;
    private static final int FOURTH_VALUE = 15;
    private static final int FIFTH_VALUE = 18;

    @Test
    void rootShouldBeInitializedWhenFirstValueIsInserted() {
        var tree = new BinaryTree<Integer>();

        tree.insert(FIRST_VALUE);

        assertTrue(tree.find(FIRST_VALUE));
    }

    @Test
    void elementsShouldBeInsertedToTreeWhenSmallerThanRoot() {
        var tree = new BinaryTree<Integer>();

        tree.insert(FIRST_VALUE);
        tree.insert(SECOND_VALUE);
        tree.insert(THIRD_VALUE);

        assertTrue(tree.find(FIRST_VALUE));
        assertTrue(tree.find(SECOND_VALUE));
        assertTrue(tree.find(THIRD_VALUE));
    }

    @Test
    void elementsShouldBeInsertedToTreeWhenGreaterThanRoot() {
        var tree = new BinaryTree<Integer>();

        tree.insert(FIRST_VALUE);
        tree.insert(FOURTH_VALUE);
        tree.insert(FIFTH_VALUE);

        assertTrue(tree.find(FIRST_VALUE));
        assertTrue(tree.find(FOURTH_VALUE));
        assertTrue(tree.find(FIFTH_VALUE));
    }

    @Test
    void elementShouldNotBeFoundInEmptyTree() {
        var tree = new BinaryTree<Integer>();

        assertFalse(tree.find(FIRST_VALUE));
    }

}