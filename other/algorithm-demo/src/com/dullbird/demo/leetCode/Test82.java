package com.dullbird.demo.leetCode;

import com.dullbird.demo.linkedlist.ListNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-09-02 23:55
 */
public class Test82 {
    public static void main(String[] args) {
        Test82 test82 = new Test82();
//        System.out.println(test82.deleteDuplicates(ListNode.createNode(new int[]{1, 2, 3, 3, 4, 4, 5})));
//        System.out.println(test82.deleteDuplicates(ListNode.createNode(new int[]{1, 3, 3, 4, 4, 5})));
//        System.out.println(test82.deleteDuplicates(ListNode.createNode(new int[]{1, 1, 2})));
//        System.out.println(test82.deleteDuplicates(ListNode.createNode(new int[]{1})));
        System.out.println(test82.deleteDuplicates(ListNode.createNode(new int[]{1,1})));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = newHead.next;
        ListNode tempHead = newHead;

        while (fast!=null) {
            if (slow.val == fast.val) {
                while (fast!=null
                        && slow.val == fast.val) {
                    slow = slow.next;
                    fast = fast.next;
                }

                slow.next = null;
                tempHead.next =fast;
                slow = tempHead;
            } else {
                tempHead = slow;
                slow = fast;
                fast = fast.next;
            }
        }
        return newHead.next;
    }
}
