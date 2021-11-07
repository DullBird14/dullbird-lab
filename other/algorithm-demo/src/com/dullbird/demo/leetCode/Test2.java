package com.dullbird.demo.leetCode;

import com.dullbird.demo.offer.ListNode;

/**
 * @author : cys
 * date: 2021-08-25 23:09
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.addTwoNumbers(null, null);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        int nextAdd = 0;
        while (l1!=null
                || l2!=null) {
            int value1= 0;
            int value2= 0;
            if (l1!=null) {
                value1 = l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                value2= l2.val;
                l2 = l2.next;
            }
            int sum = value1 + value2 + nextAdd;
            nextAdd = sum /10;
            head.next = new ListNode(sum%10);
            head = head.next;
        }
        if (nextAdd==1) {
            head.next = new ListNode(1);
        }
        return temp.next;
    }
}
