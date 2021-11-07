package com.dullbird.demo.leetCode;

import com.dullbird.demo.offer.ListNode;

/**
 * @author : cys
 * date: 2021-08-18 23:23
 */
public class Test141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null && slow!=null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
        }

        return false;
    }
}
