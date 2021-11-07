package com.dullbird.demo.leetCode;

import com.dullbird.demo.offer.ListNode;

/**
 * @author : cys
 * date: 2021-08-12 00:26
 */
public class Test21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
//        while (l1!=null) {
//            temp.next = l1;
//            l1 = l1.next;
//            temp =temp.next;
//        }
//        while (l2!=null) {
//            temp.next = l2;
//            l2 = l2.next;
//            temp =temp.next;
//        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        temp.next = l1 == null ? l2 : l1;
        return head.next;
    }
}
