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

2. **Retrieval (Get Operation)**:
    - Compute the hash code for the key using the hash function.
    - Determine the bucket index using the hash code.
    - If the bucket is empty, return `null`.
    - If the bucket is not empty, iterate through the linked list (or tree) to find the entry with the matching key.
    - Return the value associated with the key.

3. **Size**:
    - The size of the `HashMap` is the total number of entries (key-value pairs) it contains.

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
