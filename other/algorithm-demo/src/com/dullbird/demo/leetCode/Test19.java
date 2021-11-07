package com.dullbird.demo.leetCode;

import com.dullbird.demo.linkedlist.ListNode;

/**
 * @author : cys
 * date: 2021-09-10 13:15
 */
public class Test19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = new ListNode();
        pre.next = head;
        ListNode newHead = pre;
        ListNode slow = head;
        ListNode fast = slow;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast!=null) {
            slow = slow.next;
            fast = fast.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        slow.next = null;
        return newHead.next;
    }
}
