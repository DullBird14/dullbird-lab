package com.dullbird.demo.leetCode;

import com.dullbird.demo.linkedlist.ListNode;

import java.util.LinkedList;

/**
 * @author : cys
 * date: 2021-08-01 11:27
 */
public class Test25 {

    public static void main(String[] args) {
        ListNode node = ListNode.createNode(new int[]{1, 2, 3, 4, 5});
        Test25 test25 = new Test25();
        ListNode listNode = test25.reverseKGroup(node, 4);
        System.out.println(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        //哨兵节点
        ListNode pre = new ListNode();
        ListNode newHead = pre;

        LinkedList<ListNode> tempQueue = new LinkedList<>();
        int i = 1;
        while (true) {
            //找到key个就处理
            tempQueue.add(head);
            head = head.next;
            if (i++ % k == 0) {
                //进行反转
                pre = reverse(pre, tempQueue, head);
            }
            if (head == null) {
                break;
            }
        }
        return newHead.next;
    }

    private ListNode reverse(ListNode pre, LinkedList<ListNode> tempQueue, ListNode next) {
        while (!tempQueue.isEmpty()) {
            ListNode listNode = tempQueue.pollLast();
            pre.next = listNode;
            pre = listNode;
        }
        pre.next = next;
        return pre;
    }


//    /**
//     * 枚举所有场景的办法
//     */
//    ListNode startNode = null;
//
//    public ListNode reverseKGroup(ListNode head, int k) {
//        return innerReverseKGroup(head, 1, k);
//    }
//
//    private ListNode innerReverseKGroup(ListNode head, int i, int k) {
//        if (head == null) {
//            return null;
//        }
//        ListNode preNode = innerReverseKGroup(head.next, i + 1, k);
//        if (k == 1) {
//            return head;
//        } else if (i % k == 0
//                && startNode == null) {
//            startNode = head;
//            //说明是尾巴节点,设置开始反转的标记
//            head.next = preNode;
//            return head;
//        } else if ((i - 1) % k == 0
//                && startNode != null) {
//            //说明是结尾节点
//            head.next = preNode.next;
//            preNode.next = head;
//            ListNode temp = startNode;
//            startNode = null;
//            return temp;
//        } else if (startNode != null) {
//            head.next = preNode.next;
//            preNode.next = head;
//        }
//        return head;
//    }
}
