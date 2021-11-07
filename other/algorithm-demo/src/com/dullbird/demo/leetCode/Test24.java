package com.dullbird.demo.leetCode;

import com.dullbird.demo.offer.ListNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-09-06 23:50
 */
public class Test24 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode();
        ListNode newHead = pre;
        pre.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            ListNode next = fast.next;
            fast.next = slow;
            pre.next = fast;
            slow.next = next;
            pre = slow;
            slow = next;
            if (next == null
                    || next.next == null) {
                break;
            }
            fast = next.next;
        }

        return newHead.next;
    }
}
