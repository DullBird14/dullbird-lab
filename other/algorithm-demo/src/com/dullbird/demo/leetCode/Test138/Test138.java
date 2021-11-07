package com.dullbird.demo.leetCode.Test138;


import java.util.Objects;

/**
 * @author : cys
 * date: 2021-10-01 14:35
 */
public class Test138 {

    public static void main(String[] args) {
//        [[1,1],[2,1]]
        Node nodeOne = TestOne();
        Node nodeTwo = TestTwo();
        Test138 test138 = new Test138();

//        System.out.println(test138.copyRandomList(nodeOne));
        System.out.println(test138.copyRandomList(nodeTwo));
    }

    private static Node TestTwo() {
        Node nodeOne = new Node(1);
        Node nodeTwo = new Node(2);
        Node nodeThree = new Node(3);
        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = null;
        nodeOne.random = null;
        nodeTwo.random = nodeOne;
        nodeThree.random = null;
        return nodeOne;
    }

    private static Node TestOne() {
        Node nodeOne = new Node(1);
        Node nodeTwo = new Node(2);
        nodeOne.next = nodeTwo;
        nodeOne.random = nodeTwo;
        nodeTwo.random = nodeTwo;
        nodeTwo.next = null;
        return nodeOne;
    }

    public Node copyRandomList(Node head) {
        if (Objects.isNull(head)) {
            return head;
        }
        Node temp = head;
        // 复制节点，但是不处理random节点
        while (head != null) {
            Node tempNode = head;
            Node copyOne = new Node(tempNode.val);
            copyOne.next = tempNode.next;
            head = head.next;
            tempNode.next = copyOne;
        }
        // 处理random 但是不能分成两个链表
        // 1。比如A -> A1 -> B ->B1->null,
        // 当 处理到 A -> B ->B1->null的时候，
        // B.random指向A就会导致有问题
        Node resultNode = temp;
        while (temp != null) {
            Node copyNode = temp.next;
            Node currentNodeRandom = temp.random;
            if (Objects.nonNull(currentNodeRandom)) {
                copyNode.random = currentNodeRandom.next;
            }
            temp = copyNode.next;
        }
        //3 拆分成两个链表
        Node newHead = resultNode.next;
        Node original = resultNode;
        while (resultNode != null) {
            Node current = resultNode;
            Node next = resultNode.next;
            current.next = next.next;
            if (Objects.nonNull(next.next)) {
                next.next = current.next.next;
            }
            resultNode = current.next;
        }
//        System.out.println(original);
//        System.out.println(newHead);
        return newHead;
    }
}
