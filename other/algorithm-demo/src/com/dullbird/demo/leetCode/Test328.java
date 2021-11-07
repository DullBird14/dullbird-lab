package com.dullbird.demo.leetCode;

import com.dullbird.demo.linkedlist.ListNode;

/**
 * @author : cys
 * date: 2021-11-05 23:51
 */
public class Test328 {
    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = new ListNode();
        ListNode evenTemp = even;
        while (head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;
            evenTemp.next = temp;
            evenTemp = temp;
            temp.next = null;
            if (head.next != null) {
                head = head.next;
            }
        }
        head.next = even.next;
        return odd;
    }
}
