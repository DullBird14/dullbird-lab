package com.dullbird.demo.leetCode;

import com.dullbird.demo.linkedlist.ListNode;

/**
 * @author : cys
 * date: 2021-08-28 22:40
 */
public class Test23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) {
            return null;
        }
        return innerMergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode innerMergeKLists(ListNode[] lists, int start, int end) {
        if (end == start) {
            return lists[start];
        }
        int mid = (end - start) / 2 + start;
        ListNode left = innerMergeKLists(lists, start, mid);
        ListNode right = innerMergeKLists(lists, mid + 1, end);
        return mix(left, right);
    }

    private ListNode mix(ListNode left, ListNode right) {
        ListNode temp = new ListNode();
        ListNode head = temp;
        while (left != null
                && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left != null) {
            temp.next = left;
        }
        if (right != null) {
            temp.next = right;
        }
        return head.next;
    }
}
