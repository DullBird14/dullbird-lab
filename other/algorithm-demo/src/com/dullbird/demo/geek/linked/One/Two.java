package com.dullbird.demo.geek.linked.One;

import com.dullbird.demo.linkedlist.ListNode;

import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/      简单
 */
public class Two {

    public boolean hasCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        }
        ListNode slow = head;
        //fast = double slow
        ListNode fast = head;
        while (true) {
            if (Objects.isNull(fast.next)
                    || Objects.isNull(fast.next.next)) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (Objects.equals(slow, fast)) {
                return true;
            }
        }
    }
}
