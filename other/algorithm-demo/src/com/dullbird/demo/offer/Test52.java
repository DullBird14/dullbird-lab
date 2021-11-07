package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-22 13:23
 */
public class Test52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode preA = headA;
        ListNode preB = headB;
        while (preA != preB) {
            preA = preA != null ? preA.next : headB;
            preB = preB != null ? preB.next : headA;
        }
        return preA;
    }
}
