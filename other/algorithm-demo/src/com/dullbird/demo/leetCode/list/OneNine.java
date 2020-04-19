package com.dullbird.demo.leetCode.list;

import com.dullbird.demo.linkedlist.ListNode;

/**
 * 删除链表的倒数第N个节点
 * 1.使用了递归解决
 * 2. 也可以使用双指针
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月17日 23:10:00
 */
public class OneNine {
    public static void main(String[] args) {
        // n = 2
        testA(2);
        // n=0
        testA(0);
        // 长度为1
        testB(1);
        testB(0);
    }

    /**
     * 1.给定一个链表: 1->2->3->4->5,
     */
    private static void testA(int n) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = null;
        OneNine oneNine = new OneNine();
        ListNode listNode = oneNine.removeNthFromEnd(a1, n);
        System.out.println(listNode);
    }

    /**
     * 给定一个链表只有一个元素
     * @param n
     */
    private static void testB(int n) {
        ListNode a1 = new ListNode(1);
        a1.next = null;
        OneNine oneNine = new OneNine();
        ListNode listNode = oneNine.removeNthFromEnd(a1, n);
        System.out.println(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinelNode = new ListNode();
        sentinelNode.next = head;
        removeNthFromEndWithSentinel(sentinelNode, n);
        return sentinelNode.next;
    }

    private int removeNthFromEndWithSentinel(ListNode currentNode, int n) {
        if (currentNode.next == null) {
            return 1;
        }
        int preNumber = removeNthFromEndWithSentinel(currentNode.next, n);
        if (preNumber == n ) {
            if (currentNode.next != null) {
                currentNode.next = currentNode.next.next;
            }
        }
        return preNumber + 1;
    }
}
