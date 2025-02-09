public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private final Entry<K, V>[] table;
    private int size = 0;

    public MyHashMap() {
        table = new Entry[INITIAL_CAPACITY];
    }

    // Basic Entry class to hold key-value pairs
    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // Hash function
    private int hash(Object key) {
        return key == null ? 0 : Math.abs(key.hashCode()) % INITIAL_CAPACITY;
    }

    // Put method
    public void put(K key, V value) {

        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value cannot be null");
        }

        int hash = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                previous = current;
                current = current.next;
            }

            if (previous != null) {
                previous.next = newEntry;
            }
        }
        size++;
    }

    // Get method
    public V get(Object key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key != null && temp.key.equals(key)) {
                    return temp.value;
                }
                temp = temp.next;
            }
            return null;
        }
    }

    // Size method
    public int size() {
        return size;
    }
}
