import java.util.*;

public class AllOne {

    // Double linked list node representing a count and keys with that count
    private class Node {
        int count;
        Set<String> keys;
        Node prev;
        Node next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Node head; // Dummy head (lowest count)
    private Node tail; // Dummy tail (highest count)
    private Map<String, Integer> keyCountMap; // Map key to count
    private Map<Integer, Node> countNodeMap;  // Map count to Node in linked list

    /** Initialize your data structure here. */
    public AllOne() {
        keyCountMap = new HashMap<>();
        countNodeMap = new HashMap<>();

        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    /** Inserts a new node with given count after prevNode */
    private Node addNodeAfter(Node prevNode, int count) {
        Node newNode = new Node(count);
        newNode.prev = prevNode;
        newNode.next = prevNode.next;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        countNodeMap.put(count, newNode);
        return newNode;
    }

    /** Removes the node from the linked list and map */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        countNodeMap.remove(node.count);
    }

    /** Increment the count of the key by 1 */
    public void inc(String key) {
        int count = keyCountMap.getOrDefault(key, 0);
        int newCount = count + 1;
        keyCountMap.put(key, newCount);

        Node currentNode = countNodeMap.get(count);
        Node newNode;

        if (countNodeMap.containsKey(newCount)) {
            newNode = countNodeMap.get(newCount);
        } else {
            newNode = addNodeAfter(currentNode == null ? head : currentNode, newCount);
        }

        newNode.keys.add(key);

        if (currentNode != null) {
            currentNode.keys.remove(key);
            if (currentNode.keys.isEmpty()) {
                removeNode(currentNode);
            }
        }
    }

    /** Decrement the count of the key by 1 */
    public void dec(String key) {
        if (!keyCountMap.containsKey(key)) {
            return; // key does not exist
        }
        int count = keyCountMap.get(key);
        Node currentNode = countNodeMap.get(count);

        if (count == 1) {
            // Remove key entirely
            keyCountMap.remove(key);
        } else {
            int newCount = count - 1;
            keyCountMap.put(key, newCount);

            Node newNode;
            if (countNodeMap.containsKey(newCount)) {
                newNode = countNodeMap.get(newCount);
            } else {
                newNode = addNodeAfter(currentNode.prev, newCount);
            }
            newNode.keys.add(key);
        }

        // Remove key from current count node
        currentNode.keys.remove(key);
        if (currentNode.keys.isEmpty()) {
            removeNode(currentNode);
        }
    }

    /** Returns one of the keys with maximal count */
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    /** Returns one of the keys with minimal count */
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }

    // For testing
    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey()); // "hello"
        System.out.println(allOne.getMinKey()); // "hello"
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey()); // "hello"
        allOne.dec("hello");
        allOne.dec("hello");
        System.out.println(allOne.getMinKey()); // "leet"
    }
}
