import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyHashMapTest {
    private MyHashMap<Integer, String> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    void putAndGetElement() {
        map.put(1, "one");
        assertEquals("one", map.get(1));
    }

    @Test
    void putAndGetMultipleElements() {
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        assertEquals("one", map.get(1));
        assertEquals("two", map.get(2));
        assertEquals("three", map.get(3));
    }

    @Test
    void getNonExistentElement() {
        assertNull(map.get(1));
    }

        @Test
        void putNullKeyThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> map.put(null, "nullValue"));
        }

        @Test
        void putNullValueThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> map.put(1, null));
        }

    @Test
    void putDuplicateKey() {
        map.put(1, "one");
        map.put(1, "uno");
        assertEquals("uno", map.get(1));
    }

    @Test
    void sizeAfterOperations() {
        assertEquals(0, map.size());
        map.put(1, "one");
        assertEquals(1, map.size());
        map.put(2, "two");
        assertEquals(2, map.size());
        map.put(1, "uno");
        assertEquals(2, map.size());
    }

    @Test
    void putAndGetElementWithCollision() {
        map.put(1, "one");
        map.put(17, "seventeen"); // Assuming hash collision with 1
        assertEquals("one", map.get(1));
        assertEquals("seventeen", map.get(17));
    }

    @Test
    void putAndUpdateElementWithCollision() {
        map.put(1, "one");
        map.put(17, "seventeen"); // Assuming hash collision with 1
        map.put(1, "uno");
        assertEquals("uno", map.get(1));
        assertEquals("seventeen", map.get(17));
    }

}