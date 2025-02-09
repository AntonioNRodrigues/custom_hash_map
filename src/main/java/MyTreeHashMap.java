public class MyTreeHashMap<K extends Comparable<K>, V> {
    private TreeNode<K, V> root;
    private int size = 0;

    // TreeNode class to represent each node in the tree
    static class TreeNode<K, V> {
        K key;
        V value;
        TreeNode<K, V> left;
        TreeNode<K, V> right;

        TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Put method
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private TreeNode<K, V> put(TreeNode<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new TreeNode<>(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    // Get method
    public V get(Object key) {
        TreeNode<K, V> node = get(root, (K) key);
        return node == null ? null : node.value;
    }

    private TreeNode<K, V> get(TreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    // Remove method
    public V remove(Object key) {
        TreeNode<K, V> removedNode = get(root, (K) key);
        if (removedNode == null) {
            return null;
        }
        root = remove(root, (K) key);
        size--;
        return removedNode.value;
    }

    private TreeNode<K, V> remove(TreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            TreeNode<K, V> temp = node;
            node = min(temp.right);
            node.right = removeMin(temp.right);
            node.left = temp.left;
        }
        return node;
    }

    private TreeNode<K, V> removeMin(TreeNode<K, V> node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = removeMin(node.left);
        return node.left;
    }

    private TreeNode<K, V> min(TreeNode<K, V> node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    // Contains Key method
    public boolean containsKey(Object key) {
        return get(root, (K) key) != null;
    }

    // Contains Value method
    public boolean containsValue(Object value) {
        return containsValue(root, value);
    }

    private boolean containsValue(TreeNode<K, V> node, Object value) {
        if (node == null) {
            return false;
        }
        if (node.value.equals(value)) {
            return true;
        }
        return containsValue(node.left, value) || containsValue(node.right, value);
    }

    // Size method
    public int size() {
        return size;
    }

    // Clear method
    public void clear() {
        root = null;
        size = 0;
    }
}
