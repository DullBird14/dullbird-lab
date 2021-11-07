package com.dullbird.demo.leetCode;

import com.dullbird.demo.offer.ListNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-07 23:20
 */
public class Test160 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (true) {
            if (tempB == tempA) {
                return tempA;
            }
            if (tempA.next==null
                    && tempB.next==null) {
                return null;
            }
            if (Objects.isNull(tempA.next)) {
                tempA = headB;
            } else {
                tempA = tempA.next;

            }
            if (Objects.isNull(tempB.next)) {
                tempB = headA;
            } else {
                tempB = tempB.next;
            }
        }
    }
}
