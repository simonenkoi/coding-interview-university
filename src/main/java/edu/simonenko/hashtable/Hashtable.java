package edu.simonenko.hashtable;

import java.util.LinkedList;

public class Hashtable<K, V> {

    public static final int DEFAULT_BUCKETS_COUNT = 8;

    private LinkedList<Entry<K, V>>[] buckets;

    public Hashtable() {
        this(DEFAULT_BUCKETS_COUNT);
    }

    public Hashtable(int bucketsCount) {
        buckets = new LinkedList[bucketsCount];
    }

    public void put(K key, V value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        var bucket = getOrCreateBucket(key);
        bucket.add(new Entry<>(key, value));
    }

    private Entry<K, V> getEntry(K key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry;
                }
            }
        }
        return null;
    }

    private LinkedList<Entry<K, V>> getBucket(K key) {
        return buckets[hash(key)];
    }

    private LinkedList<Entry<K, V>> getOrCreateBucket(K key) {
        var index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        return buckets[index];
    }

    private int hash(K key) {
        return key.hashCode() % buckets.length;
    }

    public V get(K key) {
        var entry = getEntry(key);
        return entry != null ? entry.value : null;
    }

    public void remove(K key) {
        var entry = getEntry(key);
        if (entry == null) {
            throw new IllegalStateException();
        }
        getBucket(key).remove(entry);
    }

    public static class Entry<K, V> {

        public final K key;
        public V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
