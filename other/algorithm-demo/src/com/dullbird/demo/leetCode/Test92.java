package com.dullbird.demo.leetCode;

import com.dullbird.demo.offer.ListNode;

/**
 * @author : cys
 * date: 2021-08-14 17:43
 */
public class Test92 {
    public static void main(String[] args) {
        Test92 test92 = new Test92();
        ListNode a_1 = new ListNode(1);
        ListNode a_2 = new ListNode(2);
//        ListNode a_3 = new ListNode(3);
//        ListNode a_4 = new ListNode(4);
//        ListNode a_5 = new ListNode(5);
        a_1.next = a_2;
//        a_2.next = a_3;
//        a_3.next = a_4;
//        a_4.next =a_5;

        ListNode listNode = test92.reverseBetween(a_1, 1, 2);
        System.out.println(listNode);
    }

    private ListNode preNode;
    private ListNode lastNode;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        preNode = new ListNode();
        preNode.next = head;
        ListNode listNode = reverseBetween(head, left, right, 1);
        if (left == 1) {
            return preNode.next;
        } else {
            return listNode;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right, int i) {
        if (i + 1 == left) {
            preNode = head;
        }
        if (i == right) {
            lastNode = head.next;
            preNode.next = head;
            return head;
        }
        ListNode listNode = reverseBetween(head.next, left, right, i + 1);
        if (left == i) {
            listNode.next = head;
            head.next = lastNode;
        } else if (left < i
                && i < right) {
            listNode.next = head;
        }
        return head;
    }

}
