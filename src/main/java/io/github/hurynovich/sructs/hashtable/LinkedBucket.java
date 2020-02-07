package io.github.hurynovich.sructs.hashtable;

/**
 * This class implements bucked for hashtable which is used
 * to handle hash code collisions.
 * This implementation stores key/value pairs as linked
 * list and finds keys by simple iteration.
 */
final class LinkedBucket<K, V> implements Bucket<K, V>{

    public V get(Object key){
        //TODO implement
        throw new UnsupportedOperationException();
    }

    public V put(Object key, V val){
        //TODO implement
        throw new UnsupportedOperationException();
    }

    public boolean containsValue(Object value) {
        //TODO implement
        throw new UnsupportedOperationException();
    }

    public V remove(Object key) {
        //TODO implement
        throw new UnsupportedOperationException();
    }
}
