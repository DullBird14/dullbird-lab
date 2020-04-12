package com.dullbird.demo.linkedlist;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;

/**
 * 利用链表实现LRU 缓存淘汰算法
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月12日 22:22:00
 */
public class LruCacheImpl {
//    private ListNode head = new ListNode();
////    private ListNode tail = new ListNode();

    private LinkedList cache = new LinkedList();
    private int currentNum = 0;
    private int capacity = 0;

    public LruCacheImpl(int capacity) {
        this.capacity = capacity;
    }


    public static void main(String[] args) {
        LruCacheImpl lru = new LruCacheImpl(5);
        int count = 100;
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int i1 = random.nextInt(count);
            System.out.printf("current add value = %d\n", i1);
            lru.add(i1);
            lru.printAll();
        }
    }

    public void add(int num) {
        this.remove(num);
        if (currentNum >=capacity) {
            cache.removeLast();
            cache.addFirst(num);
        } else {
            cache.addFirst(num);
            currentNum ++;
        }
    }

    public void remove(Object num) {
        boolean remove = cache.remove(num);
        if (remove) {
            currentNum--;
        }
    }
    public void printAll() {
        if (cache.size() >0 ){
            System.out.println("======start=======");
            cache.forEach(System.out::println);
            System.out.println("=======end======");
        }
    }

//
//    public ListNode search(int num) {
//        ListNode startNode = head;
//        while (startNode.next != null) {
//            if (startNode.next.getVal() == num) {
//                return startNode.next;
//            }
//            startNode = startNode.next;
//        }
//        return null;
//    }



}
