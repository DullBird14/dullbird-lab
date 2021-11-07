package com.dullbird.demo.leetCode;

import com.dullbird.demo.linkedlist.ListNode;

/**
 * @author : cys
 * date: 2021-08-28 18:17
 */
public class Test142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null
                    || fast.next ==null) {
                return null;
            }
            fast = fast.next;
            if (slow == fast) {
                break;
            }
        }

        while (head != null) {
            if (head == slow) {
                return head;
            }
            head = head.next;
            slow = slow.next;
        }
        return null;
    }

}
