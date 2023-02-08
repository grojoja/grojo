package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{

    private Node root;
    private int size;
    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
        /** Leaf node constructor */
        Node (K key, V value) {
            this(key, value, null, null);
        }
    }

    public BSTMap () {
        clear();
    }
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        return getHelper(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node result = getHelper(root, key);
        if (result == null) {
            return null;
        }
        return result.value;
    }

    private Node getHelper(Node n, K key) {
        if (n == null) {
            return null;
        }
        int compare = key.compareTo(n.key);
        if (compare < 0) {
            return getHelper(n.left, key);
        } else if (compare > 0) {
            return getHelper(n.right, key);
        } else {
            return n;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        root = putHelper(root, key, value);
    }

    private Node putHelper(Node n, K key, V value) {
        if (n == null) {
            size++;
            return new Node(key, value);
        }
        int compare = key.compareTo(n.key);
        if (compare < 0) {
            n.left = putHelper(n.left, key, value);
        } else if (compare > 0) {
            n.right = putHelper(n.right, key, value);
        } else {
            n.value = value;
        }
        return n;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public void printInOrder() {
        printHelper(root);
    }
    private void printHelper(Node n) {
        if (n == null) {
            return;
        }
        printHelper(n.left);
        System.out.println(n.key + " : " + n.value);
        printHelper(n.right);
    }
}