package com.example;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {

    private final Map<Integer, Node> map;
    private int size;
    private final int capacity;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }

    public class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;
        public Node(int key, int value) {this.key = key; this.value=value;}
        public int value() {return value;}
        public int key() {return key;}
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node==null) {
            return -1;
        }
        removeNode(node);
        addToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node==null) {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            size++;
            addToHead(newNode);
            if (size>capacity) {
                Node removeNode = removeTail();
                size--;
                map.remove(removeNode.key());
            }
        } else {
            node.value = value;
            removeNode(node);
            addToHead(node);
        }
    }

    public void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        Node sec = head.next;
        head.next = node;
        node.next = sec;
        node.pre = head;
        sec.pre = node;
    }

    public Node removeTail() {
        Node node = tail.pre;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        return node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // 输出: 1
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2)); // 输出: -1
        System.out.println(lruCache.get(3)); // 输出: 3
    }
}