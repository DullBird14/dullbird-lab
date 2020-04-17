package com.dullbird.demo.leetCode.list;

import com.dullbird.demo.linkedlist.ListNode;

import java.util.Objects;

/**
 * 单链表指定部分反转
 * 传入m~n，指定m～n反转
 * 1.非n和m 节点，直接反转
 * 2. m-1的节点需要指向n节点
 * 3. m节点需要指向n+1节点
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月13日 21:55:00
 */
public class NineTwo {
//    private int currentNum = 1;
    private ListNode tailN = null;
    private ListNode headM = null;
    private ListNode resultHead = null;
    public static void main(String[] args) {
//        ListNode a1 = new ListNode(1);
//        ListNode a2 = new ListNode(2);
//        ListNode a3 = new ListNode(3);
//        ListNode a4 = new ListNode(4);
//        ListNode a5 = new ListNode(5);
//        a1.next = a2;
//        a2.next = a3;
//        a3.next = a4;
//        a4.next = a5;
//        a5.next = null;
//        NineTwo nineTwo = new NineTwo();
//        ListNode listNode = nineTwo.reverseBetween(a1, 2, 4);
//        System.out.println(listNode);

        ListNode a3 = new ListNode(3);
        ListNode a5 = new ListNode(5);
        a3.next = a5;
        a5.next = null;
        NineTwo nineTwo = new NineTwo();
        ListNode listNode = nineTwo.reverseBetween(a3, 1, 2);
        System.out.println(listNode);
    }
    //优雅的解法

    /**
     * 反转一段链表的m到n节点
     */
    public ListNode reverseBetweenGood(ListNode head, int m, int n) {
        //如果m==1那么就是翻转前n个元素
        if (m==1){
            return reverseN(head, n);
        }
        /**
         * 如果m!=1那么递归往下，比如 A -> B -> C -> D -> E -> F -> G ->NUll, m=3,n=5
         * 递归为 A -> 反转方法(B->C->D->E->F->G->null, 2,4)  m-1=2, n-1=4,
         * .
         * .
         * 直到出现，m=1，就是反转前n个。
         */
        head.next = reverseBetween(head.next, m-1, n-1);
        return head;
    }

    /**
     * 反转前n个对象，并且链表的对象头
     */
    public ListNode reverseN(ListNode head, int n) {
        return null;
    }


    /**
     * 失败的数据
     * 1.m==n
     * 2. 3->5   m=1, n=2
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (Objects.equals(m,n)) {
            return head;
        }
        reverse(null, head, m, n, 1);
        if (Objects.nonNull(resultHead)) {
            return resultHead;
        }
        return head;
    }


    private void reverse(ListNode pre, ListNode current, int m, int n, int currentNum) {
        if (currentNum == m-1) {
            headM = current;
        } else if (currentNum == n + 1) {
            tailN = current;
            return;
        }

        reverse(current, current.next, m, n, currentNum +1);
        if (currentNum < m || currentNum>n) {
            return;
        }
        current.next = pre;
        if (currentNum == n) {
            if (headM!=null) {
                headM.next = current;
            }
            if (m ==1) {
                resultHead = current;
            }
        } else if (currentNum == m) {
            current.next = tailN;
        }

    }




}
