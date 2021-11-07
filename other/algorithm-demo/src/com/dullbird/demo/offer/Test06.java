package com.dullbird.demo.offer;

import java.util.ArrayList;
import java.util.List;

public class Test06 {
    private List<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        list.add(innterReversePrint(head));
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public int innterReversePrint(ListNode head) {
        if (head.next == null) {
            return head.val;
        }
        int val = innterReversePrint(head);
        list.add(val);
        return head.val;
    }
    
}