package StackandQueue.MonotonicStackAndQueue;

import java.util.*;
//we are basically design lru using doubly ll and HashMap with O(1) time

//time complexity - O(1)
//space complexity - O(capacity) to store capacity node in doubly ll and map

class LRUCache{

    //create a doub;y linked list
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            

        }
    }

    //create a dummy node of head and tail
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    int cap;// capacity of a lru cache
    HashMap<Integer, Node> m = new HashMap<>();

    //constructor of lru cache
    public LRUCache(int capacity){
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // adding node in a linked list

    void addNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev= newNode;
    
    }

    // deleteing the node
    void deleteNode(Node delNode){
        Node delPrev = delNode.prev;
        Node delNext = delNode.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }

    // get()- it will get the value of particular key ki or uss (key,value) ko mru(most recently used) banayega head ke next daal ke

    public int get(int key){
        // agar key exist krti hia map mai toh
        if(m.containsKey(key)){
            Node ansNode = m.get(key); // (key,value)
            int val = ansNode.val;// store kr diya sirf value of particular key ki
            deleteNode(ansNode); // delete kro 
            addNode(ansNode);

            return val;
        }

        //agar key hai he nhi map mai to return kro -1
        return -1;

    }

    // put function kya karega woh ll mai (key ,val) put kr dega

    void put(int key, int val){
        // agar key exist krti hai toh
        if(m.containsKey(key)){
            Node ansNode = m.get(key); // particular key nikal li(key,val)
        
            deleteNode(ansNode);
            m.remove(key);

        }

        // agare capacity full hai 
        if(m.size() == cap){
            // lru remove krna hai
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        Node newNode = new Node(key, val);
        addNode(newNode);
        m.put(key, newNode);

    }
}

public class Main{
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1,1);
        cache.put(2,2);

        // Get value for key 1
        System.out.println(cache.get(1));

        // Insert another key (evicts key 2)
        cache.put(3, 3);

        // Key 2 should be evicted
        System.out.println(cache.get(2));

        // Insert another key (evicts key 1)
        cache.put(4, 4);

        // Key 1 should be evicted
        System.out.println(cache.get(1));

        // Key 3 should be present
        System.out.println(cache.get(3));

        // Key 4 should be present
        System.out.println(cache.get(4));

    }

}

