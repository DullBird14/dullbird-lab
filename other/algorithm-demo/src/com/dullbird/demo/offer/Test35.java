package com.dullbird.demo.offer;

import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-21 13:17
 */
public class Test35 {
    public static void main(String[] args) {
        Test35 test35 = new Test35();
        Node node_7 = new Node(7);
        Node node_13 = new Node(13);
        Node node_11 = new Node(11);
        Node node_10 = new Node(10);
        Node node_1 = new Node(1);
        node_7.next = node_13;
        node_7.random = null;
        node_13.next = node_11;
        node_13.random = node_7;
        node_11.next = node_10;
        node_11.random = node_1;
        node_10.next = node_1;
        node_10.random = node_11;
        node_1.next = null;
        node_1.random = node_7;
        Node node = test35.copyRandomList(node_7);
        System.out.println(node);
    }

    public Node copyRandomList(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        temp = head;
        while (temp != null) {
            if (Objects.nonNull(temp.random)) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node result = head.next;
        Node tempNext = head.next;
        while (tempNext.next != null) {
            temp.next = temp.next.next;
            tempNext.next = tempNext.next.next;
            temp = temp.next;
            tempNext = tempNext.next;
        }
        temp.next = null;
        return result;
    }
}
