package com.dullbird.demo.link;

import javax.sound.midi.Soundbank;
import java.util.Objects;

/**
 * @author cys
 * @date 2019-07-12 12:54 PM
 */

public class PalindromeLinkNode {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(isPalindrome(listNode1));
    }

    public static boolean isPalindrome(ListNode head) {
        if (Objects.isNull(head)) {
            return true;
        }

        if (Objects.isNull(head.next)) {
            return true;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        // 是否奇数
        boolean ifIsOdd =false;
        // 快慢指针找中点
        while (fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
//            // 判断奇偶数
//            if (Objects.isNull(fastNode.next)) {
//                ifIsOdd = true;
//            } else {
//                fastNode = fastNode.next;
//            }
            //不用判断奇偶
            if (Objects.nonNull(fastNode.next)) {
                fastNode = fastNode.next;
            }
        }

        reverseLink(slowNode.next);
        //检查是否反转
//        while (fastNode != null) {
//            System.out.println(fastNode.val);
//            fastNode = fastNode.next;
//        }
        ListNode temp = head;
        while (fastNode != null) {
            if (!Objects.equals(fastNode.val, temp.val)) {
                return false;
            }
            fastNode = fastNode.next;
            temp = temp.next;
        }

        return true;
    }

    private static ListNode reverseLink(ListNode half) {
        if (Objects.isNull(half.next)) {
            return half;
        }

        ListNode lastNode = reverseLink(half.next);
        lastNode.next = half;
        half.next = null;
        return half;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x){
        val = x;
    }
 }