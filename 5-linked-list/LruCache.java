/**
 * 
 * https://neetcode.io/problems/lru-cache/question?list=neetcode150
 * 
 * Implement the Least Recently Used (LRU) cache class LRUCache. The class should support the following operations
 * LRUCache(int capacity) Initialize the LRU cache of size capacity.
 * int get(int key) Return the value corresponding to the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the introduction of the new pair causes the cache to exceed its capacity, remove the least recently used key.
 * 
 * A key is considered used if a get or a put operation is called on it.
 * 
 * Ensure that get and put each run in O(1) O(1) average time complexity.
 * 
 * Constraints:
 * 1 <= capacity <= 3000
 * 0 <= key <= 10^4
 * 0 <= value <= 10^5
 * At most 2 * 10^5 calls will be made to get and put.
 */
public class LruCache {
    Map<Integer, Node> hm;
    Node dummy;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.hm = new HashMap<>();
        this.dummy = new Node(-1, -1);
        this.tail = dummy;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = this.hm.get(key);
        if (node == null) return -1;
        this.moveFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = this.hm.get(key);
        if (node != null) {
            node.value = value;
            this.moveFirst(node);
            return;
        } 
        
        if (this.capacity == this.hm.size()) {
            this.hm.remove(this.tail.key);
            this.tail = this.tail.previous;
            this.tail.next = null;
        }
 
        node = new Node(key, value);
        node.next = this.dummy.next;
        node.previous = this.dummy;
        if (this.dummy.next != null) this.dummy.next.previous = node;
        else this.tail = node;
        this.dummy.next = node;
        this.hm.put(key, node); 
    }

    private void moveFirst(Node node) {
        if (this.dummy.next == node) return;
        node.previous.next = node.next;
        if (node.next != null) node.next.previous = node.previous;
        else this.tail = node.previous;
        node.next = this.dummy.next;
        this.dummy.next.previous = node;
        node.previous = this.dummy;
        this.dummy.next = node;
    }
}

class Node {
    int key;
    int value;
    Node previous;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}