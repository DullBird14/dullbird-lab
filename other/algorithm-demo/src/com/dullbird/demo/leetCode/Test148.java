package com.dullbird.demo.leetCode;

import com.dullbird.demo.linkedlist.ListNode;

/**
 * @author : cys
 * date: 2021-08-28 15:54
 */
public class Test148 {
    public static void main(String[] args) {
        Test148 test148 = new Test148();
        ListNode node = ListNode.createNode(new int[]{4, 2, 1, 3});
        System.out.println(test148.sortList(node));
    }

    public ListNode sortList(ListNode head) {
        //如果已经是一个节点了，直接返回
        if (head == null
                || head.next == null) {
            return head;
        }
        //查找中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode listNodeOne = sortList(next);
        ListNode listNodeTwo = sortList(head);
        return combine(listNodeOne, listNodeTwo);
    }

    private ListNode combine(ListNode listNodeOne, ListNode listNodeTwo) {
        ListNode temp = new ListNode();
        ListNode head = temp;
        while (listNodeOne != null
                && listNodeTwo != null) {
            if (listNodeOne.val < listNodeTwo.val) {
                head.next = listNodeOne;
                listNodeOne = listNodeOne.next;
            } else {
                head.next = listNodeTwo;
                listNodeTwo = listNodeTwo.next;
            }
            head = head.next;
        }
        if (listNodeOne != null) {
            head.next = listNodeOne;
        }

        if (listNodeTwo != null) {
            head.next = listNodeTwo;
        }
        return temp.next;
    }
}
