package com.dullbird.demo.offer;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-04 16:17
 */
public class Test18 {
    public static void main(String[] args) {

    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode sentinelHead = new ListNode(-1);
        sentinelHead.next=head;
        innerDeleted(sentinelHead, val);
        return sentinelHead.next;
    }

    private ListNode innerDeleted(ListNode sentinelHead, int val) {
        if (Objects.isNull(sentinelHead.next)) {
            return sentinelHead;
        }
        if (sentinelHead.next.val == val) {
            sentinelHead.next = sentinelHead.next.next;
            return sentinelHead;
        }
        return innerDeleted(sentinelHead.next, val);
    }
}
