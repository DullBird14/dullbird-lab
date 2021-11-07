package com.dullbird.demo.offer;

import com.dullbird.demo.chapter.five.Test;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-04 17:13
 */
public class Test25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);
        ListNode head = result;
        while (Objects.nonNull(l1)
                && Objects.nonNull(l2)) {
            if (l1.val <= l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        if (Objects.nonNull(l1)) {
            result.next = l1;
        }
        if (Objects.nonNull(l2)) {
            result.next = l2;
        }
        return head.next;
    }
}
