package com.dullbird.demo.linkedlist;

import java.util.List;

/**
 * 统一的连表节点
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月12日 22:32:00
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode createNode(int[] nodes) {

        ListNode head = new ListNode(nodes[0]);
        ListNode current = head;
        for (int i = 1; i < nodes.length; i++) {
            current.next = new ListNode(nodes[i]);
            current = current.next;
        }
        return head;
    }
}
