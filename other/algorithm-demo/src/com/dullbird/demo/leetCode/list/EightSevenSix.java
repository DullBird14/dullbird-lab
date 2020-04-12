package com.dullbird.demo.leetCode.list;

import java.util.Objects;
import java.util.jar.JarEntry;

/**
 * 中位数
 * @author cys
 * @date 2019-11-10 9:37 PM
 */

public class EightSevenSix {
	public ListNode middleNode(ListNode head) {
		ListNode fastNode = head;
		while (true){
			if (Objects.isNull(fastNode.next)) {
				return head;
			} else if (Objects.isNull(fastNode.next.next)){
				return head.next;
			}
			head = head.next;
			fastNode = fastNode.next.next;
		}
	}
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
