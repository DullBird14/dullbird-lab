package com.dullbird.demo.leetCode.list;

/**
 * @author cys
 * @date 2019-11-10 9:51 PM
 */

public class OneSixZero {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode tempHeadA = headA;
		ListNode tempHeadB = headB;
		while (tempHeadA != tempHeadB){
			tempHeadA = tempHeadA == null? headB : tempHeadA.next;
			tempHeadB = tempHeadB == null? headA : tempHeadB.next;
		}
		return tempHeadA;
	}

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
