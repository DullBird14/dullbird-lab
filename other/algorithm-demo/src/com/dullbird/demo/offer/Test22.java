package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-04 17:07
 */
public class Test22 {
    public static void main(String[] args) {
        Test22 test22 = new Test22();
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        for (int i = 1; i < k; i++) {
            fastNode = fastNode.next;
        }
        while (fastNode.next!=null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

}
