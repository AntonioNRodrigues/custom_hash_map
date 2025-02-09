# Understanding HashMap Internals

This project demonstrates how a `HashMap` works internally using `LinkedList` and `TreeMap` implementations.

## HashMap Overview

A `HashMap` is a data structure that allows you to store key-value pairs, where each key is unique. It uses a combination of an array and linked lists (or trees) to efficiently store and retrieve data based on the key's hash code.

### Components of HashMap:

1. **Hash Function**: The hash function computes an index (or bucket) based on the hash code of the key. This index determines where the entry (key-value pair) will be stored in the array.

2. **Buckets**: Each bucket in the array can store multiple entries. In our implementation, a bucket is a `LinkedList` or a `TreeMap`.

3. **LinkedList Implementation**: When collisions occur (i.e., multiple keys have the same hash code and thus map to the same bucket), the entries are stored in a linked list. This is the default approach for handling collisions.

4. **TreeMap Implementation**: When the number of entries in a bucket exceeds a certain threshold, the `LinkedList` is converted into a balanced tree (e.g., `TreeMap`). This improves the performance of operations like `get` and `put`.

### How HashMap Works:

1. **Insertion (Put Operation)**:
   - Compute the hash code for the key using the hash function.
   - Determine the bucket index using the hash code.
   - If the bucket is empty, create a new entry and place it in the bucket.
   - If the bucket is not empty, iterate through the linked list (or tree) to check if the key already exists.
   - If the key exists, update the value. If not, add the new entry to the end of the linked list (or insert it into the tree).
   - **Time Complexity**: Average case \(O(1)\), worst case \(O(n)\) for `LinkedList` and \(O(\log n)\) for `TreeMap`.

2. **Retrieval (Get Operation)**:
   - Compute the hash code for the key using the hash function.
   - Determine the bucket index using the hash code.
   - If the bucket is empty, return `null`.
   - If the bucket is not empty, iterate through the linked list (or tree) to find the entry with the matching key.
   - Return the value associated with the key.
   - **Time Complexity**: Average case \(O(1)\), worst case \(O(n)\) for `LinkedList` and \(O(\log n)\) for `TreeMap`.

3. **Size**:
   - The size of the `HashMap` is the total number of entries (key-value pairs) it contains.
   - **Time Complexity**: \(O(1)\).



## Map Implementations in Java

Java provides several implementations of the `Map` interface, each with its own characteristics and internal workings. Here are the main implementations:

### 1. `HashMap`
- **Internal Structure**: Uses an array of buckets, where each bucket is a linked list or a balanced tree (when the number of entries in a bucket exceeds a certain threshold).
- **Characteristics**: Allows null keys and values, not thread-safe.

| Operation | Average Time Complexity | Worst Time Complexity |
|-----------|-------------------------|-----------------------|
| Put       | \(O(1)\)                | \(O(n)\)              |
| Get       | \(O(1)\)                | \(O(n)\)              |
| Remove    | \(O(1)\)                | \(O(n)\)              |
| Size      | \(O(1)\)                | \(O(1)\)              |

### 2. `LinkedHashMap`
- **Internal Structure**: Extends `HashMap` with a doubly-linked list running through all its entries, maintaining insertion order.
- **Characteristics**: Predictable iteration order, slightly slower than `HashMap` due to the additional overhead of maintaining the linked list.

| Operation | Average Time Complexity | Worst Time Complexity |
|-----------|-------------------------|-----------------------|
| Put       | \(O(1)\)                | \(O(n)\)              |
| Get       | \(O(1)\)                | \(O(n)\)              |
| Remove    | \(O(1)\)                | \(O(n)\)              |
| Size      | \(O(1)\)                | \(O(1)\)              |

### 3. `TreeMap`
- **Internal Structure**: Uses a Red-Black tree, a self-balancing binary search tree.
- **Characteristics**: Sorted order of keys, does not allow null keys, thread-safe if accessed through `Collections.synchronizedSortedMap`.

| Operation | Average Time Complexity | Worst Time Complexity |
|-----------|-------------------------|-----------------------|
| Put       | \(O(\log n)\)           | \(O(\log n)\)         |
| Get       | \(O(\log n)\)           | \(O(\log n)\)         |
| Remove    | \(O(\log n)\)           | \(O(\log n)\)         |
| Size      | \(O(1)\)                | \(O(1)\)              |

### 4. `Hashtable`
- **Internal Structure**: Similar to `HashMap`, but synchronized.
- **Characteristics**: Thread-safe, does not allow null keys or values, generally slower than `HashMap` due to synchronization overhead.

| Operation | Average Time Complexity | Worst Time Complexity |
|-----------|-------------------------|-----------------------|
| Put       | \(O(1)\)                | \(O(n)\)              |
| Get       | \(O(1)\)                | \(O(n)\)              |
| Remove    | \(O(1)\)                | \(O(n)\)              |
| Size      | \(O(1)\)                | \(O(1)\)              |

### 5. `ConcurrentHashMap`
- **Internal Structure**: Uses a segmented locking mechanism to allow concurrent access.
- **Characteristics**: Thread-safe, high concurrency, does not allow null keys or values.

| Operation | Average Time Complexity | Worst Time Complexity |
|-----------|-------------------------|-----------------------|
| Put       | \(O(1)\)                | \(O(n)\)              |
| Get       | \(O(1)\)                | \(O(n)\)              |
| Remove    | \(O(1)\)                | \(O(n)\)              |
| Size      | \(O(1)\)                | \(O(1)\)              |

### Example Usage:

```java
public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> hashMap = new MyHashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);
        System.out.println("MyHashMap Size: " + hashMap.size());
        System.out.println("Value for 'Two': " + hashMap.get("Two"));

        MyTreeHashMap<String, Integer> treeHashMap = new MyTreeHashMap<>();
        treeHashMap.put("One", 1);
        treeHashMap.put("Two", 2);
        treeHashMap.put("Three", 3);
        System.out.println("MyTreeHashMap Size: " + treeHashMap.size());
        System.out.println("Value for 'Two': " + treeHashMap.get("Two"));
    }
}