package com.dullbird.demo.leetCode.sort;

/**
 * @author cys
 * @date 2019-11-17 21:39
 */

public class OneFourSeven {
	public ListNode insertionSortList(ListNode head) {
		ListNode newHead = new ListNode(Integer.MIN_VALUE);
		ListNode current;
		while (head != null) {
			current = newHead;
			while (current.next !=null) {
				if (current.next.val < head.val) {
					current = current.next;
				} else {
					break;
				}
			}
			ListNode temp = head;
			head = head.next;
			temp.next = current.next;
			current.next = temp;
		}
		return newHead.next;
	}
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
