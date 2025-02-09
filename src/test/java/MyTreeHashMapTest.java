import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyTreeHashMapTest {
    private MyTreeHashMap<Integer, String> map;

    @BeforeEach
    void setUp() {
        map = new MyTreeHashMap<>();
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
    void removeElement() {
        map.put(1, "one");
        assertEquals("one", map.remove(1));
        assertNull(map.get(1));
    }

    @Test
    void removeNonExistentElement() {
        assertNull(map.remove(1));
    }

    @Test
    void containsKey() {
        map.put(1, "one");
        assertTrue(map.containsKey(1));
        assertFalse(map.containsKey(2));
    }

    @Test
    void containsValue() {
        map.put(1, "one");
        assertTrue(map.containsValue("one"));
        assertFalse(map.containsValue("two"));
    }

    @Test
    void sizeAfterOperations() {
        assertEquals(0, map.size());
        map.put(1, "one");
        assertEquals(1, map.size());
        map.put(2, "two");
        assertEquals(2, map.size());
        map.remove(1);
        assertEquals(1, map.size());
    }

    @Test
    void clearMap() {
        map.put(1, "one");
        map.put(2, "two");
        map.clear();
        assertEquals(0, map.size());
        assertNull(map.get(1));
        assertNull(map.get(2));
    }

    @Test
    void removeRootNodeWithTwoChildren() {
        map.put(2, "two");
        map.put(1, "one");
        map.put(3, "three");
        assertEquals("two", map.remove(2));
        assertNull(map.get(2));
        assertEquals(2, map.size());
    }

    @Test
    void removeNodeWithOneChild() {
        map.put(2, "two");
        map.put(1, "one");
        assertEquals("two", map.remove(2));
        assertNull(map.get(2));
        assertEquals(1, map.size());
    }

    @Test
    void removeNodeWithNoChildren() {
        map.put(1, "one");
        assertEquals("one", map.remove(1));
        assertNull(map.get(1));
        assertEquals(0, map.size());
    }

    @Test
    void containsValueInDeepTree() {
        map.put(5, "five");
        map.put(3, "three");
        map.put(7, "seven");
        map.put(2, "two");
        map.put(4, "four");
        map.put(6, "six");
        map.put(8, "eight");
        assertTrue(map.containsValue("six"));
        assertFalse(map.containsValue("nine"));
    }
}