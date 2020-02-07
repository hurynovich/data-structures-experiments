package io.github.hurynovich.sructs.hashtable;

public interface Bucket <K, V>{
    V get(Object key);

    public V put(Object key, V val);

    public V remove(Object key);

    boolean containsValue(Object value);
}
