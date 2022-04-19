package com.example.demo.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 手写一个LRU
 * @author: yyc
 * @time: 2022/3/17 0:29
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1,1);
//        lruCache.put(2,2);
//        System.out.println(lruCache.get(1));
//        lruCache.put(3,3);
//        System.out.println(lruCache.get(1));
//
        // get方法
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);  // 把3移除了
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(2));

        System.out.println(lruCache.get(3));
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        // 初始化哈希表
        map = new HashMap<Integer,Node>();
        // 初始化链表
        initList();
    }

    private void initList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    // 哈希表
    Map<Integer,Node> map;
    // 头节点，尾节点
    private Node head,tail;

    // 容量
    private int capacity;

    // 缓存节点数
    private int size;

    public void put(int key,int val){
        Node node = map.get(key);
        if(node!=null){
            node.val = val;
            // 删除节点
            deleteNode(node);
            // 移动到头部
            moveToHead(node);
            // 更新哈希表
            map.put(key,node);
        }
        // 容量是否满了
        if(size==capacity){
            // 删除末尾节点
            Node pre = tail.pre;
            deleteNode(pre);
            // 更新map删除key
            map.remove(pre.key);
            size--;
        }
        node = new Node(key,val);
        moveToHead(node);
        // 更新哈希表
        map.put(key,node);
        size++;

    }

    public int get(int key){
        Node node = map.get(key);
        if(node==null){
            return -1;
        }
        // 移动节点到头部
        deleteNode(node);
        moveToHead(node);
        return node.val;
    }


    /**
     * 移动节点到头部
     * @param node
     */
    private void moveToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    /**
     * 当前节点前一个指向后一个
     * @param node
     */
    private void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

class Node{
    int key;
    int val;
    Node next;
    Node pre;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public Node() {
    }
}
