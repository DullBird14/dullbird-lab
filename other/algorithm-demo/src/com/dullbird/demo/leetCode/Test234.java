package com.dullbird.demo.leetCode;

import com.dullbird.demo.linkedlist.ListNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-28 12:15
 */
public class Test234 {
    public static void main(String[] args) {
        Test234 test234 = new Test234();
        ListNode node = ListNode.createNode(new int[]{1,2,2,1});
        System.out.println(test234.isPalindrome(node));
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null
                || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //找到中间
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        //反转后半段
        ListNode reverseHead = new ListNode();
        reverseNode(slow.next, reverseHead);
        reverseHead = reverseHead.next;
        while (reverseHead!=null) {
            if (!(reverseHead.val == head.val)) {
                return false;
            }
            reverseHead = reverseHead.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseNode(ListNode current, ListNode head) {
        if (Objects.isNull(current)) {
            return null;
        }
        ListNode nextNode = reverseNode(current.next, head);
        if (nextNode == null) {
            head.next = current;
            return current;
        }
        nextNode.next = current;
        current.next =null;
        return current;
    }
}
