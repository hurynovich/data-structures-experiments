package io.github.hurynovich.dsa.hashtable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * My complete implementation of JCF {@link Map} just to revise data structures topic.
 *
 * @implNote
 * This implementation has static capacity of hashtable and doesn't grow
 * automatically. To change capacity new instance must be created.
 *
 * @param <K> - key type
 * @param <V> - value type
 */
public final class SimpleHashMap<K, V> implements Map<K,V> {

    /** Array which holds values by hash code. */
    private Bucket<K, V>[] hashTable;

    private final int capacity;

    private final int maxIndex;

    private int size;

    private Supplier<Bucket<K,V>> bucketFactory = LinkedBucket::new;

    public SimpleHashMap(){
        this(1 << 8);
    }

    public SimpleHashMap(int capacity){
        if(capacity < 1) throw new IllegalArgumentException("Hash table capacity must not be less than 1.");
        this.capacity = capacity;
        this.maxIndex = capacity - 1;

        clear();
    }

    @Override
    public int size() { return size; }
    public void increaseSize() { size++; }
    public void decreaseSize() { size--; }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for(var bucket : hashTable) {
            if(bucket.containsValue(value)) return true;
        }

        return false;
    }

    @Override
    public V get(Object key) {
        final int i = toIndex(key);
        return hashTable[i].get(key);
    }

    @Override
    public V put(K key, V value) {
        final int i = toIndex(key);

        Bucket<K,V> bucket;
        if((bucket = hashTable[i]) == null){
            hashTable[i] = (bucket = bucketFactory.get());
        }

        return bucket.put(key, value, this::increaseSize);
    }

    @Override
    public V remove(Object key) {
        final int i = toIndex(key);
        return hashTable[i].remove(key, this::decreaseSize);
    }

    @Override
    public void clear() {
        size = 0;
        hashTable = new Bucket[capacity];
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        //TODO implement
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Set<K> keySet() {
        //TODO implement
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Collection<V> values() {
        //TODO implement
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        //TODO implement
        throw new UnsupportedOperationException("Method is not implemented");
    }

    //TODO find out hot index created in java.util.HashMap
    private int toIndex(Object key) {
        return Math.abs(key.hashCode() % maxIndex);
    }
}
