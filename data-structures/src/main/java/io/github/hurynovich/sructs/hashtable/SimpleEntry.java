package io.github.hurynovich.sructs.hashtable;

import java.util.Map;
import java.util.Objects;

/**
 * Simple implementation of {@link Map.Entry} interface.
 *
 * @implNote
 * This implementation allows only not null key and value.
 *
 * @param <K> - key type.
 * @param <V> - value type.
 */
final class SimpleEntry<K, V> implements Map.Entry<K, V> {
    private final int keyHash;
    private final K key;
    private V val;

    /**
     * Creates new entry instance with given key and value.
     *
     * @param key - key for this entry. Must not be {@code null}.
     * @param val - initial value for this entry. Can be {@code null}.
     */
    SimpleEntry(K key, V val) {
        Objects.requireNonNull(key, "Key must not be null.");
        this.key = key;
        this.keyHash = key.hashCode();
        setValue(val);
    }

    /** {@inheritDoc} */
    @Override
    public K getKey() {
        return key;
    }

    /** {@inheritDoc} */
    @Override
    public V getValue() {
        return val;
    }

    /** {@inheritDoc} */
    @Override
    public V setValue(V value) {
        V prevVal = this.val;
        this.val = value;
        return prevVal;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Map.Entry)) return false;

        Map.Entry<?,?> e = (Map.Entry<?,?>)o;
        K k1 = getKey();
        Object k2 = e.getKey();

        assert k1 != null;
        if (!k1.equals(k2)) return false;

        V v1 = getValue();
        Object v2 = e.getValue();

        assert v1 != null;
        return v1.equals(v2);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return keyHash ^ getValue().hashCode();
    }
}