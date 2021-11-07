package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

import java.util.LinkedList;

/**
 * @author : cys
 * date: 2021-09-08 12:56
 */
public class Test662 {
    public static void main(String[] args) {
        TreeNode a_1 = new TreeNode(1);
        TreeNode a_2 = new TreeNode(3);
        TreeNode a_3 = new TreeNode(2);
        TreeNode a_4 = new TreeNode(5);
        TreeNode a_5 = new TreeNode(3);
        TreeNode a_6 = new TreeNode(9);
        a_1.left = a_2;
        a_1.right = a_3;
        a_2.left = a_4;
        a_2.right = a_5;
        a_3.right = a_6;
        Test662 test662 = new Test662();
        System.out.println(test662.widthOfBinaryTree(a_1));
    }

    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<Entry> queueOne = new LinkedList<>();
        LinkedList<Entry> queueTwo = new LinkedList<>();
        queueOne.addLast(new Entry(root, 1));
        int max = 0;
        while (!queueOne.isEmpty()
                || !queueTwo.isEmpty()) {
            LinkedList<Entry> queryQueue = queueOne.isEmpty() ? queueTwo : queueOne;
            LinkedList<Entry> putQueue = queueOne.isEmpty() ? queueOne : queueTwo;
            Entry first = queryQueue.getFirst();
            Entry last = queryQueue.getLast();
            max = Math.max(last.value - first.value +1, max);
            while (!queryQueue.isEmpty()) {
                Entry entry = queryQueue.removeFirst();
                if (entry.node.left != null) {
                    putQueue.addLast(new Entry(entry.node.left,
                            entry.value * 2 - 1));
                }
                if (entry.node.right != null) {
                    putQueue.addLast(new Entry(entry.node.right,
                            entry.value * 2));                }
            }
        }
        return max;
    }

    class Entry {
        TreeNode node;
        int value;


        public Entry(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}
