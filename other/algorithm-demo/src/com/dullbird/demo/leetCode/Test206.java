package com.dullbird.demo.leetCode;

import com.dullbird.demo.offer.ListNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-08 00:09
 */
public class Test206 {
    public static void main(String[] args) {
        ListNode a_1 = new ListNode(1);
        ListNode a_2 = new ListNode(2);
        ListNode a_3 = new ListNode(3);
        ListNode a_4 = new ListNode(4);
        ListNode a_5 = new ListNode(5);
        a_1.next = a_2;
        a_2.next = a_3;
        a_3.next = a_4;
        a_4.next =a_5;
        Test206 test206 = new Test206();
        ListNode listNode = test206.reverseList(a_1);
        System.out.println(listNode);
    }
    private ListNode head;
    public ListNode reverseList(ListNode head) {
        inner(head);
        return this.head;
    }

    private ListNode inner(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode listNode = inner(head.next);
        if (listNode == null) {
            this.head = head;
            return head;
        } else {
            listNode.next = head;
            head.next = null;
            return head;
        }
    }


}
