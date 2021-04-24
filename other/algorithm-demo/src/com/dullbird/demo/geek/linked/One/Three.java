package com.dullbird.demo.geek.linked.One;

import com.dullbird.demo.linkedlist.ListNode;

import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Three {
    public static void main(String[] args) {
        ListNode node = ListNode.createNode(new int[]{1});
        Three three = new Three();
        ListNode listNode = three.removeNthFromEnd(node, 1);
        System.out.println(listNode);

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //增加一个哨兵。因为链表里面每一个节点都有可能被删除。包括head
        ListNode temp = new ListNode(-1, head), slow = temp, fast = temp;
        int k = 0;
        //快节点先走n步
        while (k++ < n) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        //这里一定是哨兵的下一个。否则有一种情况是头节点被删除了
        return temp.next;
    }

}
