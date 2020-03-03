package edu.simonenko.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    void treeShouldHaveMinus1HeightWhenEmpty() {
        var tree = new BinaryTree<Integer>();

        assertEquals(-1, tree.height());
    }

    @Test
    void treeShouldHave0HeightWithOneElement() {
        var tree = new BinaryTree<Integer>();

        tree.insert(FIRST_VALUE);

        assertEquals(0, tree.height());
    }

    @Test
    void treeShouldHave2HeightWithThreeHigherElements() {
        var tree = new BinaryTree<Integer>();

        tree.insert(FIRST_VALUE);
        tree.insert(FOURTH_VALUE);
        tree.insert(FIFTH_VALUE);

        assertEquals(2, tree.height());
    }

    @Test
    void minOfTreeShouldBeWhenEmpty() {
        var tree = new BinaryTree<Integer>();

        assertThrows(IllegalStateException.class, tree::min);
    }

    @Test
    void minOfTreeShouldBeSmallestElement() {
        var tree = new BinaryTree<Integer>();

        tree.insert(FIRST_VALUE);
        tree.insert(FOURTH_VALUE);
        tree.insert(FIFTH_VALUE);

        assertEquals(FIRST_VALUE, tree.min());
    }

    @Test
    void twoTreesShouldBeEqualWhenContentIsEqual() {
        var firstTree = new BinaryTree<Integer>();
        firstTree.insert(FIRST_VALUE);
        firstTree.insert(SECOND_VALUE);
        firstTree.insert(THIRD_VALUE);

        var secondTree = new BinaryTree<Integer>();
        secondTree.insert(FIRST_VALUE);
        secondTree.insert(SECOND_VALUE);
        secondTree.insert(THIRD_VALUE);

        assertEquals(firstTree, secondTree);
    }

    @Test
    void twoTreesShouldNotBeEqualWhenContentIsNotEqual() {
        var firstTree = new BinaryTree<Integer>();
        firstTree.insert(FIRST_VALUE);
        firstTree.insert(SECOND_VALUE);
        firstTree.insert(THIRD_VALUE);

        var secondTree = new BinaryTree<Integer>();
        secondTree.insert(FIRST_VALUE);
        secondTree.insert(SECOND_VALUE);

        assertNotEquals(firstTree, secondTree);
    }

    @Test
    void treeShouldBeSearchWhenValuesInserted() {
        var tree = new BinaryTree<Integer>();
        tree.insert(FIRST_VALUE);
        tree.insert(SECOND_VALUE);
        tree.insert(THIRD_VALUE);

        assertTrue(tree.isSearch());
    }

    @Test
    void treeShouldBeSearchWhenEmpty() {
        var tree = new BinaryTree<Integer>();

        assertTrue(tree.isSearch());
    }
}