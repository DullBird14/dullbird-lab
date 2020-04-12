package com.dullbird.demo.leetCode.list;

import java.util.Objects;

/**
 * 反转链表
 * @author cys
 * @date 2019-11-08 12:49 PM
 */

public class TwoZeroSix {
	public static void main(String[] args) {
		TwoZeroSix twoZeroSix = new TwoZeroSix();
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		listNode.next.next.next.next = null;

//		listNode.next.next.next.next = listNode.next;
		listNode = twoZeroSix.reverseList(listNode);
		while (listNode!=null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
	public ListNode reverseList(ListNode head) {
		if (Objects.isNull(head)) {
			return null;
		}
		ListNode first = new ListNode(0);

		reverse(head, first);
		return first.next;
	}
	private ListNode reverse(ListNode node, ListNode first) {
		if (Objects.isNull(node.next)) {
			first.next = node;
			return node;
		}
		ListNode reverseNode = reverse(node.next, first);
		node.next = null;
		reverseNode.next = node;
		return node;
	}
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
