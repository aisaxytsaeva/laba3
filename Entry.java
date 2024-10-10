public class Entry<K, V> {
    public K key;
    public V value;

    Entry<K, V> next;

    
    public Entry(K _key, V _value) {
        this.key = _key;
        this.value = _value;
    }
}
