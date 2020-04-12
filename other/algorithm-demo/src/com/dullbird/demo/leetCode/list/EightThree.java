package com.dullbird.demo.leetCode.list;

import java.util.Objects;

/**
 * @author cys
 * @date 2019-11-07 12:15 PM
 */

public class EightThree {
	public static void main(String[] args) {

	}

	public ListNode deleteDuplicates(ListNode head) {
		if (Objects.isNull(head)
				|| Objects.isNull(head.next)) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		do {
			if (slow.val == fast.val) {
				slow.next = fast.next;
			} else {
				slow = slow.next;
			}
			fast = fast.next;
		} while (Objects.nonNull(fast));
		return head;
	}


	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
