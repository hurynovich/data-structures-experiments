package io.github.hurynovich.sructs.hashtable;

import java.util.Map;

interface Bucket <K, V>{
    Map.Entry<K, V> get(Object key);

    public Map.Entry<K, V> put(K key, V val);

    public V remove(Object key);

    boolean containsValue(Object value);
}
