package com.dullbird.demo.leetCode;

import com.dullbird.demo.linkedlist.ListNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-09-02 13:07
 */
public class Test83 {
    public static void main(String[] args) {
        ListNode node = ListNode.createNode(new int[]{1,1,2,2});
        Test83 test83 = new Test83();
        ListNode listNode = test83.deleteDuplicates(node);
        System.out.println(listNode);
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp!=null) {
            if (Objects.isNull(temp.next)) {
                break;
            }
            if (temp.val == temp.next.val) {
                ListNode next = temp.next.next;
                temp.next.next = null;
                temp.next = next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
