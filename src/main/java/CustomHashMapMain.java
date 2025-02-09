public class CustomHashMapMain {
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

        // Additional methods to test
        System.out.println("Remove 'Two': " + treeHashMap.remove("Two"));
        System.out.println("Contains key 'One': " + treeHashMap.containsKey("One"));
        System.out.println("Contains value 3: " + treeHashMap.containsValue(3));

        treeHashMap.clear();
        System.out.println("Size after clear: " + treeHashMap.size());
    }
}
