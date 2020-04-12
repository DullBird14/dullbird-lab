package com.dullbird.demo.leetCode.list;

import java.util.Objects;

/**
 *
 * 回文链表
 * @author cys
 * @date 2019-11-07 8:06 PM
 */

public class TwoZoreThree {
	public ListNode removeElements(ListNode head, int val) {
		if (Objects.isNull(head)) {
			return null;
		}
		ListNode first = new ListNode(0);
		ListNode preNode = first;
		while (head != null) {
			if (head.val == val) {
				preNode.next = head.next;
			} else {
				preNode.next = head;
				preNode = preNode.next;
			}
			head = head.next;
		}
		return first.next;
	}

	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
