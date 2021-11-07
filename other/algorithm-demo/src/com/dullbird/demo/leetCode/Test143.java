package com.dullbird.demo.leetCode;

import com.dullbird.demo.offer.ListNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-14 22:17
 */
public class Test143 {
    public static void main(String[] args) {
        ListNode a_1 = new ListNode(1);
        ListNode a_2 = new ListNode(2);
        ListNode a_3 = new ListNode(3);
        ListNode a_4 = new ListNode(4);
        a_1.next = a_2;
        a_2.next = a_3;
        a_3.next = a_4;
        Test143 test143 = new Test143();
        test143.reorderList(a_1);
        System.out.println(a_1);
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode needReserved = slow.next;
        if (Objects.isNull(slow.next)) {
            return;
        }
        ListNode needReservedNext = slow.next.next;
        ListNode tailNode = slow.next;
        ListNode temp;
        slow.next = null;
        while (needReserved != null) {
            if (needReservedNext == null) {
                break;
            }
            temp = needReservedNext.next;
            needReservedNext.next = needReserved;
            needReserved = needReservedNext;
            needReservedNext = temp;
        }
        tailNode.next = null;
        while (head != null
                && needReserved != null) {
            ListNode temp1 = head.next;
            head.next = needReserved;
            needReserved = needReserved.next;
            head.next.next = temp1;
            head = temp1;
        }
    }
}
