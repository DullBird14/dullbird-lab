package com.dullbird.demo.chapter.three;

/**
 * @author cys
 * @date 2018-09-10 下午1:07
 */

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * 输入给出2棵二叉树树的信息。对于每棵树，首先在一行中给出一个非负整数N (≤10)，即该树的结点数（此时假设结点从0到N−1编号）
 * ；随后N行，第i行对应编号第i个结点，给出该结点中存储的1个英文大写字母、其左孩子结点的编号、右孩子结点的编号。如果孩子结点为空，
 * 则在相应位置上给出“-”。给出的数据间用一个空格分隔。注意：题目保证每个结点中存储的字母是不同的。
 */
//8
//A 1 2
//B 3 4
//C 5 -
//D - -
//E 6 -
//G 7 -
//F - -
//H - -
//8
//G - 4
//B 7 6
//F - -
//A 5 1
//H - -
//C 0 -
//D - -
//E 2 -

//8
//B 5 7
//F - -
//A 0 3
//C 6 -
//H - -
//D - -
//G 4 -
//E 1 -
//8
//D 6 -
//B 5 -
//E - -
//H - -
//C 0 2
//G - 3
//F - -
//A 1 4
public class Main {
    private static Tree firstTree;
    private static Tree secondTree;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        firstTree = createTree(sc);
        secondTree = createTree(sc);

//        System.out.println(firstTree);
//        System.out.println(secondTree);
        if (Objects.equals(isomorphic(firstTree.rootIndex, secondTree.rootIndex), true)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isomorphic(Integer firstTreeIndex, Integer secondTreeIndex) {
        // 如果两个都为null，相等
        if (Objects.isNull(firstTreeIndex)
                && Objects.isNull(secondTreeIndex)) {
            return true;
        }
        // 如果一个是null，一个不是null，不想等
        if ((Objects.isNull(firstTreeIndex) && !Objects.isNull(secondTreeIndex))
                || (Objects.isNull(secondTreeIndex) && !Objects.isNull(firstTreeIndex))) {
            return false;
        }
        TreeNode firstTreeNode = firstTree.treeNode[firstTreeIndex];
        TreeNode secondTreeNode = secondTree.treeNode[secondTreeIndex];
        // 如果两个都不是null，如果根节点不一样。那么肯定不是同构的。
        if (!Objects.equals(firstTreeNode.value, secondTreeNode.value)) {
            return false;
        }
        // 如果左子树都是null。那么只需要比较右子树
        if (Objects.isNull(firstTreeNode.leftNode) && Objects.isNull(secondTreeNode.leftNode)) {
            return isomorphic(firstTreeNode.rightNode, secondTreeNode.rightNode);
        }

        // 如果右子树都是null。那么只需要比较右子树
        if (Objects.isNull(firstTreeNode.rightNode) && Objects.isNull(secondTreeNode.rightNode)) {
            return isomorphic(firstTreeNode.leftNode, secondTreeNode.leftNode);
        }

        //左右子树都不是null，那么要看左子树是不是等于左子树
//        System.out.println(firstTreeNode.leftNode + "      :   " + secondTreeNode.leftNode);
        //ps:有可能其中一个左子树为null，另一个不为null。
        if (!Objects.isNull(firstTreeNode.leftNode) && !Objects.isNull(secondTreeNode.leftNode)
                && Objects.equals(firstTree.treeNode[firstTreeNode.leftNode].value
                , secondTree.treeNode[secondTreeNode.leftNode].value)) {
            // 左子树同构且右子树同构
            return isomorphic(firstTreeNode.leftNode, secondTreeNode.leftNode)
                    && isomorphic(firstTreeNode.rightNode, secondTreeNode.rightNode);
        } else {
            return isomorphic(firstTreeNode.leftNode, secondTreeNode.rightNode)
                    && isomorphic(firstTreeNode.rightNode, secondTreeNode.leftNode);
        }

    }

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
            Integer leftSon = split[1].equals("-")? null : Integer.parseInt(split[1]);
            Integer rightSon = split[2].equals("-")? null : Integer.parseInt(split[2]);
            //把引用到的节点设置为1
            if (!Objects.isNull(leftSon)) {
                checkRootArray[leftSon] = 1;
            }

            if (!Objects.isNull(rightSon)) {
                checkRootArray[rightSon] = 1;
            }
            treeArrays[i] = new TreeNode(leftSon, rightSon, split[0]);
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
