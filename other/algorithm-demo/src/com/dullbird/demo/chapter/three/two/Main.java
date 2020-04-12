package com.dullbird.demo.chapter.three.two;

/**
 * @author cys
 * @date 2018-09-10 下午1:07
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *Given a tree, you are supposed to list all the leaves in the order of top down, and left to right.
 *
 * Input Specification:
 * Each input file contains one test case. For each case, the first line gives a positive integer N (≤10) which is
 * the total number of nodes in the tree -- and hence the nodes are numbered from 0 to N−1. Then N lines follow,
 * each corresponds to a node, and gives the indices of the left and right children of the node. If the child does
 * not exist, a "-" will be put at the position. Any pair of children are separated by a space.
 *
 * Output Specification:
 * For each test case, print in one line all the leaves' indices in the order of top down, and left to right.
 * There must be exactly one space between any adjacent numbers, and no extra space at the end of the line.
  */
//
//8
//1 -
//- -
//0 -
//2 7
//- -
//- -
//5 -
//4 6
public class Main {
    private static Tree firstTree;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static Queue<Integer> queue = new LinkedList<Integer>();
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        firstTree = createTree(sc);

//        System.out.println(firstTree);
        iterateTreeByStack(firstTree.rootIndex);
        System.out.println(stringBuilder.toString().trim());
    }
    private static void iterateTreeByStack(Integer index){
        if (Objects.isNull(index)) {
            return;
        }

        queue.add(index);

        while (!queue.isEmpty()) {
            Integer popIndex = queue.poll();

            TreeNode treeNode = firstTree.treeNode[popIndex];

            if (Objects.isNull(treeNode.value)) {
                stringBuilder.append(popIndex + " ");
                continue;
            }else {
                if (!Objects.isNull(treeNode.leftNode)) {
                    queue.add(treeNode.leftNode);
                }

                if (!Objects.isNull(treeNode.rightNode)) {
                    queue.add(treeNode.rightNode);
                }
            }

        }


    }
    /**
     * 遍历数
     * @param index
     */
    private static void iterateTree(Integer index){
        if (Objects.isNull(index)) {
            return;
        }

        if (Objects.isNull(firstTree.treeNode[index].value)) {
            System.out.print(index + " ");
            return;
        }

        iterateTree(firstTree.treeNode[index].leftNode);
        iterateTree(firstTree.treeNode[index].rightNode);

    }
//    private static boolean isomorphic(Integer firstTreeIndex, Integer secondTreeIndex) {
//        // 如果两个都为null，相等
//        if (Objects.isNull(firstTreeIndex)
//                && Objects.isNull(secondTreeIndex)) {
//            return true;
//        }
//        // 如果一个是null，一个不是null，不想等
//        if ((Objects.isNull(firstTreeIndex) && !Objects.isNull(secondTreeIndex))
//                || (Objects.isNull(secondTreeIndex) && !Objects.isNull(firstTreeIndex))) {
//            return false;
//        }
//        TreeNode firstTreeNode = firstTree.treeNode[firstTreeIndex];
//        TreeNode secondTreeNode = secondTree.treeNode[secondTreeIndex];
//        // 如果两个都不是null，如果根节点不一样。那么肯定不是同构的。
//        if (!Objects.equals(firstTreeNode.value, secondTreeNode.value)) {
//            return false;
//        }
//        // 如果左子树都是null。那么只需要比较右子树
//        if (Objects.isNull(firstTreeNode.leftNode) && Objects.isNull(secondTreeNode.leftNode)) {
//            return isomorphic(firstTreeNode.rightNode, secondTreeNode.rightNode);
//        }
//
//        // 如果右子树都是null。那么只需要比较右子树
//        if (Objects.isNull(firstTreeNode.rightNode) && Objects.isNull(secondTreeNode.rightNode)) {
//            return isomorphic(firstTreeNode.leftNode, secondTreeNode.leftNode);
//        }
//
//        //左右子树都不是null，那么要看左子树是不是等于左子树
////        System.out.println(firstTreeNode.leftNode + "      :   " + secondTreeNode.leftNode);
//        //ps:有可能其中一个左子树为null，另一个不为null。
//        if (!Objects.isNull(firstTreeNode.leftNode) && !Objects.isNull(secondTreeNode.leftNode)
//                && Objects.equals(firstTree.treeNode[firstTreeNode.leftNode].value
//                , secondTree.treeNode[secondTreeNode.leftNode].value)) {
//            // 左子树同构且右子树同构
//            return isomorphic(firstTreeNode.leftNode, secondTreeNode.leftNode)
//                    && isomorphic(firstTreeNode.rightNode, secondTreeNode.rightNode);
//        } else {
//            return isomorphic(firstTreeNode.leftNode, secondTreeNode.rightNode)
//                    && isomorphic(firstTreeNode.rightNode, secondTreeNode.leftNode);
//        }
//
//    }

    /**
     * 读取两个一元多次多项式
     * @param sc
     * @return
     */
    private static Tree createTree(Scanner sc) {
        int number = Integer.parseInt(sc.nextLine().trim());
        int i=0;
        TreeNode[] treeArrays = new TreeNode[number];
        int[] checkRootArray = new int[number];

        Tree tree =new Tree();
        while( i < number ) {
            String line = sc.nextLine();
            String[] split = line.trim().split(" ");
            Integer leftSon = "-".equals(split[0]) ? null : Integer.parseInt(split[0]);
            Integer rightSon = "-".equals(split[1]) ? null : Integer.parseInt(split[1]);
            //把引用到的节点设置为1
            if (!Objects.isNull(leftSon)) {
                checkRootArray[leftSon] = 1;
            }

            if (!Objects.isNull(rightSon)) {
                checkRootArray[rightSon] = 1;
            }
            String value = null;

            // 如果没有子节点的。那么节点的值为null
            if (!Objects.isNull(leftSon)
                    || !Objects.isNull(rightSon)) {
                value = "1";
            }

            treeArrays[i] = new TreeNode(leftSon, rightSon, value);
            i++;
        }
        //遍历。找到没有引用节点就是根节点
        for (int j = 0; j < checkRootArray.length; j++) {
            if (Objects.equals(checkRootArray[j], 0)) {
                tree.setRootIndex(j);
                break;
            }
        }

        tree.setTreeNode(treeArrays);
        return tree;
    }

    static class Tree {
        private Integer rootIndex;
        private TreeNode[] treeNode;

        public Integer getRootIndex() {
            return rootIndex;
        }

        public void setRootIndex(Integer rootIndex) {
            this.rootIndex = rootIndex;
        }

        public TreeNode[] getTreeNode() {
            return treeNode;
        }

        public void setTreeNode(TreeNode[] treeNode) {
            this.treeNode = treeNode;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "rootIndex=" + rootIndex +
                    ", treeNode=" + Arrays.toString(treeNode) +
                    '}';
        }
    }
    static class TreeNode {
        private Integer leftNode;
        private Integer rightNode;
        private String value;

        public TreeNode() {
        }

        public TreeNode(Integer leftNode, Integer rightNode, String value) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.value = value;
        }

        public Integer getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Integer leftNode) {
            this.leftNode = leftNode;
        }

        public Integer getRightNode() {
            return rightNode;
        }

        public void setRightNode(Integer rightNode) {
            this.rightNode = rightNode;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    ", value='" + value + '\'' +
                    '}';
        }
    }


}
