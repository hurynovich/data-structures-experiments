package io.github.hurynovich.dsa.hashtable;

/**
 * Interface which specifies hashtable bucket which handles hashcode collisions.
 * <br />
 * It is possible situation when two different keys must be stored in
 * the same hashtable cell. This situation is known as 'hashcode collision'.
 * Bucket is a sub structure representing hashtable cell which can store
 * and find keys with hashcode collisions.
 *
 * @param <K> key type
 * @param <V> value type
 */
interface Bucket <K, V>{
    /**
     * Finds value associated with given key in this bucket.
     *
     * @param key - key to find associated value.
     * @return value associated given key.
     */
    V get(Object key);

    //TODO javadoc
    public V put(K key, V val, Runnable sizeCallback);

    /**
     * Removes kay/value entry by given key out of this bucket and returns removed value.
     * If there is no entry with given key in this bucket it does nothing and
     * returns <code>null</code>.
     * <br />
     * Note it is possible that <code>null</code> value is bound with given key.
     * So returned value must not be used to find out weather entry was removed
     * or not, use <code>sizeCallback</code> for this purpose.
     * <br />
     * When and only when entry was removed executed <code>sizeCallback</code>.
     * Main purpose of this callback is to detect that bucket size was decreased
     * by one and size of entire hashtable is decreased by one as well.
     *
     * @param key - key find entry for removal.
     * @param sizeCallback - callback function which executed if entry with given
     *                     key was found and removed.
     * @return value which was associated with given key or <code>null</code> if there was
     * no value associated with given key.
     */
    public V remove(Object key, Runnable sizeCallback);

    /**
     * Checks if there is entry with given value in this bucket.
     *
     * @param value - value to check
     * @return <code>true</code> if entry with given value is found
     * and <code>false</code> if it is not found.
     */
    boolean containsValue(Object value);
}
