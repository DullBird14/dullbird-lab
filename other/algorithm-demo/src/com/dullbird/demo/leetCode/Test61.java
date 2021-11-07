package com.dullbird.demo.leetCode;

import com.dullbird.demo.linkedlist.ListNode;

/**
 * @author : cys
 * date: 2021-09-15 00:07
 */
public class Test61 {
    public static void main(String[] args) {

    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = slow;
        int length = 1;
        while (fast.next!=null) {
            fast = fast.next;
            length++;
        }
        //形成一个圈
        fast.next = head;
        int count = length - k % length;
        for (int i = 0; i < count; i++) {
            fast = fast.next;
        }
        ListNode newHead = fast.next;
        fast.next = null;
        return newHead;
    }
}
