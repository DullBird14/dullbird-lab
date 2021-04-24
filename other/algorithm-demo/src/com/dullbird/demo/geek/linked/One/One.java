package com.dullbird.demo.geek.linked.One;

import com.dullbird.demo.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 从头开始遍历的时候。从头开始反转。不是最优的操作。
 * 应该从尾巴开始反转
 */
public class One {
    public static void main(String[] args) {
        ListNode node = ListNode.createNode(new int[]{1});
        One one = new One();
        ListNode listNode = one.reverseList(node);
        System.out.println(listNode);
    }

    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head)
                || Objects.isNull(head.next)) {
            return head;
        }
        ListNode newHead = innerReverseList(head, head.next);
        head.next = null;
        return newHead;
    }

    private ListNode innerReverseList(ListNode head, ListNode next) {
        if (Objects.isNull(next)) {
            return head;
        }
        ListNode nextAndNextNode = next.next;
        next.next = head;
        if (Objects.nonNull(nextAndNextNode)) {
            return innerReverseList(next, nextAndNextNode);
        }
        return next;
    }
}
