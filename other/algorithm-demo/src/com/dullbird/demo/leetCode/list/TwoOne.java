package com.dullbird.demo.leetCode.list;

import java.util.Objects;

/**
 * @author cys
 * @date 2019-11-06 7:52 PM
 */

public class TwoOne {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (Objects.isNull(l1)) {
			return l2;
		}

		if (Objects.isNull(l2)) {
			return l1;
		}
		ListNode head = new ListNode(0);
		ListNode current = head;

		while (l1!= null
				&& l2!=null) {
			if (l1.val >= l2.val ) {
				current.next = l2;
				l2 = l2.next;
			} else {
				current.next = l1;
				l1 = l1.next;
			}
			current =current.next;
		}
		if (Objects.nonNull(l1)) {
			current.next = l1;
		}
		if (Objects.nonNull(l2)) {
			current.next = l2;
		}
		return head.next;
	}

	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}



