import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K, V> implements Map<K,V> {

    private SimpleBucket<K, V>[] hashTable;

    private final int capacity;

    private final int maxIndex;

    private int size;

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
    public int size() {
        return size;
    }

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

        SimpleBucket<K,V> bucket;
        if((bucket = hashTable[i]) == null){
            hashTable[i] = bucket = new SimpleBucket<>();
        }

        return bucket.put(key, value);
    }

    @Override
    public V remove(Object key) {
        final int i = toIndex(key);
        return hashTable[i].remove(key);
    }

    @Override
    public void clear() {
        size = 0;
        hashTable = new SimpleBucket[capacity];
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("Method is not implemented");
    }

    private int toIndex(Object key) {
        return key.hashCode() % maxIndex;
    }
}
