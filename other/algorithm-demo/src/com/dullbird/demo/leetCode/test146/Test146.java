package com.dullbird.demo.leetCode.test146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : cys
 * date: 2021-08-06 13:22
 */
public class Test146 {
    public static void main(String[] args) {
        Test146 test146 = new Test146(2);

//        System.out.println(test146.get(2));
//        System.out.println(test146.get(2));
        test146.put(2, 1);
//        System.out.println(test146.get(1));
        test146.put(1, 1);
        test146.put(2, 3);
        test146.put(4, 1);
        System.out.println(test146.get(1));
        System.out.println(test146.get(2));
    }

    private Map<Integer, Node> integerMap;
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public Test146(int capacity) {
        integerMap = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node integerNode = integerMap.get(key);
        if (integerNode == null) {
            return -1;
        }
        //移除当前节点
        integerNode.next.pre = integerNode.pre;
        integerNode.pre.next = integerNode.next;
        // 移动到头节点
        head.next.pre = integerNode;
        integerNode.next = head.next;
        integerNode.pre = head;
        head.next = integerNode;
        return integerNode.getVal();
    }

    public void put(int key, int value) {
        Node nodeExists = integerMap.get(key);
        if (size >= capacity
                && nodeExists ==null) {
            //删除一个节点
            Node target = tail.pre;
            target.pre.next = tail;
            tail.pre = target.pre;
            target.next = null;
            target.pre = null;
            integerMap.remove(target.key);
            size--;
        }
        if (nodeExists == null) {
            //增加一个节点
            Node node = new Node(key, value);
            node.setVal(value);
            integerMap.put(key, node);
            node.next = head.next;
            head.next = node;
            node.pre = head;
            node.next.pre = node;
            size++;
        } else {
            nodeExists.setVal(value);
            //移动一个节点
            nodeExists.next.pre = nodeExists.pre;
            nodeExists.pre.next = nodeExists.next;
            head.next.pre = nodeExists;
            nodeExists.next = head.next;
            head.next = nodeExists;
            nodeExists.pre = head;
        }
    }

    private class Node {
        private Integer key;
        private Integer val;
        private Node next;
        private Node pre;

        public Node() {
        }

        public Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    ", pre=" + pre +
                    '}';
        }
    }
}


