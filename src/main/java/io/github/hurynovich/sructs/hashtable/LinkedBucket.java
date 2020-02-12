package io.github.hurynovich.sructs.hashtable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class implements bucked for hashtable which is used
 * to handle hash code collisions.
 * This implementation stores key/value pairs as linked
 * list and finds keys by simple iteration.
 */
final class LinkedBucket<K, V> implements Bucket<K, V>{
    private final List<Map.Entry<K, V>> content = new LinkedList<>();

    @Override
    public V get(Object key){
        for (var entry : content) {
            if(entry.getKey().equals(key)) {
                assert entry != null;
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V val, Runnable sizeCallback){
        var it = content.iterator();
        while (it.hasNext()){
            var entry = it.next();
            if(entry.getKey().equals(key)){
                return entry.setValue(val);
            }
        }

        var entry = new SimpleEntry<K,V>(key, val);
        content.add(entry);
        sizeCallback.run();
        return null;
    }

    @Override
    public boolean containsValue(Object value) {
        var it = content.iterator();
        while (it.hasNext()){
            var entry = it.next();
            if(entry.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public V remove(Object key, Runnable countCallback) {
        var it = content.iterator();
        while (it.hasNext()){
            var entry = it.next();
            if(entry.getKey().equals(key)){
                it.remove();
                countCallback.run();
                return entry.getValue();
            }
        }
        return null;
    }

}
