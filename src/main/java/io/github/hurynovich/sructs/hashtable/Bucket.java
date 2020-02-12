package io.github.hurynovich.sructs.hashtable;

import java.util.Map;

interface Bucket <K, V>{
    V get(Object key);

    public V put(K key, V val, Runnable sizeCallback);

    public V remove(Object key, Runnable sizeCallback);

    boolean containsValue(Object value);
}
