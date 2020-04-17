package com.dullbird.demo.leetCode.list;

import com.dullbird.demo.linkedlist.ListNode;

import java.util.Objects;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月14日 23:47:00
 */
public class OneFourTwo {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode meetNode = null;
        while (fast!=null
                && fast.next != null
                && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meetNode = fast;
                break;
            }
        }
        if (Objects.isNull(meetNode)) {
            System.out.println("no cycle");
            return null;
        }
        slow = head;
        int count = 0;
        while (slow!=meetNode) {
            slow = slow.next;
            meetNode = meetNode.next;
            count ++;
        }
        System.out.println("tail connects to node index " + count);
        return slow;
    }
}
