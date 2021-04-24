package com.dullbird.demo.geek.linked.One;

import com.dullbird.demo.linkedlist.ListNode;

import java.util.Objects;

/**
 * 1,2,3,4删除2
 * 1，2，3，4，5删除3
 */
public class Five {
    public static void main(String[] args) {
        ListNode node = ListNode.createNode(new int[]{4,5,1,9});
        System.out.println(node);
        Five five = new Five();
        five.deleteNode(node);
        System.out.println(node);
    }

    public void deleteNode(ListNode node) {
        if (Objects.isNull(node)
                || Objects.isNull(node.next)
                || Objects.isNull(node.next.next)) {
            return;
        }
        ListNode slow = node,fast = node.next.next;
        while (Objects.nonNull(fast.next)
                && Objects.nonNull(fast.next.next)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
    }
}
