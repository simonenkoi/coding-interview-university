package edu.simonenko.tree;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public void insert(T value) {
        var node = new Node<>(value);
        if (root == null) {
            root = node;
            return;
        }
        var current = root;
        while (true) {
            if (value.compareTo(current.value) < 0) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
    }

    public boolean find(T value) {
        var current = root;
        while (current != null) {
            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }
        if (node.left == null && node.right == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private static class Node<T> {

        private final T value;
        private Node<T> left;
        private Node<T> right;

        private Node(T value) {
            this.value = value;
        }
    }

}