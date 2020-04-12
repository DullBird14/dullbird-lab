package com.dullbird.demo.leetCode.list;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author cys
 * @date 2019-11-07 12:34 PM
 */

public class OneFourOne {
	public static void main(String[] args) {
		OneFourOne oneFourOne = new OneFourOne();
		ListNode listNode = new ListNode(3);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(0);
		listNode.next.next.next = new ListNode(-4);
		listNode.next.next.next.next = listNode.next;
		System.out.println(oneFourOne.hasCycle(listNode));
	}

	public boolean hasCycle(ListNode head) {
		if (Objects.isNull(head)
				||Objects.isNull(head.next)) {
			return false;
		}
		ListNode fast = head.next.next;
		while (Objects.nonNull(fast)
				 && Objects.nonNull(fast.next)) {
			if (fast == head) {
				return true;
			}
			head = head.next;
			fast = fast.next.next;
		}
		return false;
	}
//	//错误代码
//	public boolean hasCycle(ListNode head) {
//		boolean mark = false;
//		while (Objects.nonNull(head)) {
//			ListNode fast = head.next;
//			while (Objects.nonNull(fast)){
//				if (fast.next == head) {
//					return true;
//				}
//				fast = fast.next;
//			}
//			head = head.next;
//		}
//		return mark;
//	}

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
