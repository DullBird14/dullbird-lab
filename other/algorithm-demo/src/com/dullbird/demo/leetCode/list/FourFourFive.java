package com.dullbird.demo.leetCode.list;

import com.dullbird.demo.linkedlist.ListNode;

import java.util.LinkedList;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月18日 17:06:00
 */
public class FourFourFive {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        while (l1 != null
                || l2 != null) {
            if (l1 != null) {
                stack1.addLast(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.addLast(l2.val);
                l2 = l2.next;
            }
        }
        int increase = 0;
        ListNode head = new ListNode();
        while (stack1.size() != 0
                || stack2.size() != 0
                /**
                 * 很重要，如果最高位相加需要进位
                 */
                || increase > 0) {

            Integer value1 = stack1.pollLast();
            Integer value2 = stack2.pollLast();
            value1 = value1 == null ? 0 : value1;
            value2 = value2 == null ? 0 : value2;
            int i = value1 + value2 + increase;
            increase = i / 10;
            i = i % 10;
            ListNode listNode = new ListNode(i);
            listNode.next = head.next;
            head.next = listNode;
        }
        return head.next;
    }
}
