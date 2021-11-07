package com.dullbird.demo.offer.Test36;


import com.dullbird.demo.offer.TreeNode;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-31 22:08
 */
public class Test36 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node2.left = node1;
        node2.right = node3;
        node4.left = node2;
        node4.right = node5;


        Test36 test36 = new Test36();
        Node node6 = test36.treeToDoublyList(node4);
        Node node = test36.treeToDoublyList(new Node(1));
        System.out.println(node);
    }

    private Node head = null;
    private Node pre = null;

    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (Objects.isNull(root)) {
            return;
        }
        dfs(root.left);
        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
    }

//    private Node innerLoop(Node root, Node pre) {
//        if (Objects.isNull(root)) {
//            return root;
//        }
//        Node leftNode = innerLoop(root.left, root);
////        System.out.println(root.val);
//        Node rightNode = innerLoop(root.right, root);
//        if (pre == null) {
//
//        } else if (leftNode == null && rightNode == null && root.val < pre.val) {
//            //最左节点
//            root.right = pre;
//            first = root;
//            return root;
//        } else if (root.val > pre.val) {
//            root.left = pre;
//            return root;
//        } else if (leftNode != null && rightNode != null) {
//            root.left = leftNode;
//            root.right = rightNode;
//            rightNode.left = root;
//            rightNode.right = pre;
//            return rightNode;
//        } else if (leftNode != null) {
//            root.left = leftNode;
//            return root;
//        } else {
//            root.right = rightNode;
//            rightNode.right = pre;
//            return rightNode;
//        }
//    }
}
