package com.dullbird.demo.chapter.four.one;

/**
 * @author cys
 * @date 2018-09-29 下午2:18
 */

import java.util.Objects;
import java.util.Scanner;

/**
 * 04-树4 是否同一棵二叉搜索树 （25 分）
 * 给定一个插入序列就可以唯一确定一棵二叉搜索树。
 * 然而，一棵给定的二叉搜索树却可以由多种不同的插入序列得到。
 * 例如分别按照序列{2, 1, 3}和{2, 3, 1}插入初始为空的二叉搜索树，都得到一样的结果。
 * 于是对于输入的各种插入序列，你需要判断它们是否能生成一样的二叉搜索树。
 *
 * 输入格式:
 * 输入包含若干组测试数据。每组数据的第1行给出两个正整数N (≤10)和L，分别是每个序列插入元素的个数和需要检查的序列个数。
 * 第2行给出N个以空格分隔的正整数，作为初始插入序列。最后L行，每行给出N个插入的元素，属于L个需要检查的序列。
 *
 * 简单起见，我们保证每个插入序列都是1到N的一个排列。当读到N为0时，标志输入结束，这组数据不要处理。
 *
 * 输出格式:
 * 对每一组需要检查的序列，如果其生成的二叉搜索树跟对应的初始序列生成的一样，输出“Yes”，否则输出“No”。
 *
 * 输入样例:
 * 4 2
 * 3 1 4 2
 * 3 4 1 2
 * 3 2 4 1
 * 2 1
 * 2 1
 * 1 2
 * 0
 * 输出样例:
 * Yes
 * No
 * No
 */
//4 2
//3 1 4 2
//3 4 1 2
//3 2 4 1
//2 1
//2 1
//1 2
//0

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String lineValue = sc.nextLine();
        while (!"0".equals(lineValue)) {
            String[] nAndLValue = lineValue.split(" ");
            int v = Integer.valueOf(nAndLValue[0]);
            int l = Integer.valueOf(nAndLValue[1]);
            String[][] treeArray = new String[l + 1][];
            String originalTree = sc.nextLine();
            TreeNode root = null;
            //创建第一棵树
            for (String value : originalTree.split(" ")) {
                root = insertTreeNode(root, Integer.valueOf(value));
            }
            //读取l组数据。进行判断是否是同一棵树
            for (int i = 0; i < l; i++) {
                String compareTreeString = sc.nextLine();
                //默认认为是同一棵树
                boolean ifIsSameTree = true;
                for (String value : compareTreeString.split(" ")) {
                    //如果前面没有判断失败。就继续判断。否则退出循环
                    ifIsSameTree = checkIfIsSameTree(root, Integer.valueOf(value));
                    if (!ifIsSameTree) {
                        break;
                    }
                }

                if (ifIsSameTree) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

                //清除标记
                clearTarget(root);
            }
            lineValue = sc.nextLine();
        }
//        firstTree = createTree(sc);
    }

    private static void clearTarget(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }

        root.setIfIsPass(false);
        clearTarget(root.getLeftNode());
        clearTarget(root.getRightNode());
    }

    /**
     *
     * @param root
     * @param value
     * @return
     */
    private static boolean checkIfIsSameTree(TreeNode root, Integer value) {
        //如果空树。肯定不匹配
        if (Objects.isNull(root)) {
            return false;
        }
        //如果就是当前节点。那么就找到了
        if (value == root.getValue()) {
            //设置该状态已经被路过
            root.setIfIsPass(true);
            return true;
        } else if (root.getValue() > value) {
            //查看路径上的节点是和否已经被标记。
            if (root.isIfIsPass()) {
                return checkIfIsSameTree(root.getLeftNode(), value);
            }

            return false;
        } else if (root.getValue() < value) {
            //查看路径上的节点是和否已经被标记。
            if (root.isIfIsPass()) {
                return checkIfIsSameTree(root.getRightNode(), value);
            }

            return false;
        }
        //其他情况
        return false;
    }

    /**
     * 往树里面插入一个节点
     * @param tree
     * @param value
     * @return
     */
    public static TreeNode insertTreeNode(TreeNode tree, int value) {
        //如果树是空的。那么就创建一个节点
        if (Objects.isNull(tree)) {
            tree = new TreeNode(value, 0);
        } else if (tree.getValue() > value) {
            //如果值小于根节点的值，那么往左子树插入,左子树同样的递归逻辑
            tree.setLeftNode(insertTreeNode(tree.getLeftNode(), value));
            //计算左右节点树高。是否需要旋转
            if (getTreeHight(tree.getLeftNode()) - getTreeHight(tree.getRightNode()) == 2 ) {
                //判断是LL旋转还是左右旋转
                if (tree.getLeftNode().getValue() > value ) {
                    tree = singleLeftRotation(tree);
                } else {
                    tree = doubleLeftRightRotation(tree);
                }
            }
        } else if (tree.getValue() < value) {
            //如果值小于根节点的值，那么往右子树插入,右子树同样的递归逻辑
            tree.setRightNode(insertTreeNode(tree.getRightNode(), value));
            //计算左右节点树高。是否需要旋转
            if (getTreeHight(tree.getRightNode()) - getTreeHight(tree.getLeftNode()) == 2 ) {
                //判断是LL旋转还是左右旋转
                if (tree.getRightNode().getValue() > value ) {
                    tree = doubleRightLeftRotation(tree);
                } else {
                    tree = singleRightRotation(tree);
                }
            }
        }
        //如果值相等不需要插入
        //插入新节点了。重新计算树的高度
        int hight = getMax(getTreeHight(tree.getLeftNode()), getTreeHight(tree.getRightNode())) +1;
        tree.setHight(hight);
        return tree;
    }

    /**
     * 左旋
     * @param target
     * @return
     */
    private static TreeNode singleLeftRotation(TreeNode target) {
        TreeNode leftNode = target.getLeftNode();
        TreeNode rightNode = leftNode.getRightNode();
        leftNode.setRightNode(target);
        target.setLeftNode(rightNode);
        leftNode.setHight(getMax(getTreeHight(leftNode.getLeftNode()), getTreeHight(leftNode.getRightNode())) + 1);
        target.setHight(getMax(getTreeHight(target.getLeftNode()), getTreeHight(target.getRightNode())) + 1);
        return leftNode;
    }

    /**
     * 右旋
     * @param target
     * @return
     */
    private static TreeNode singleRightRotation(TreeNode target) {
        TreeNode rightNode = target.getRightNode();
        TreeNode leftNode = rightNode.getLeftNode();
        rightNode.setLeftNode(target);
        target.setRightNode(leftNode);
        rightNode.setHight(getMax(getTreeHight(rightNode.getLeftNode()), getTreeHight(rightNode.getRightNode())) + 1);
        target.setHight(getMax(getTreeHight(target.getLeftNode()), getTreeHight(target.getRightNode())) + 1);
        return rightNode;
    }

    /**
     * LR旋转，左右旋转
     * @param target
     * @return
     */
    private static TreeNode doubleLeftRightRotation(TreeNode target) {
        target.setLeftNode(singleRightRotation(target.getLeftNode()));
        return singleLeftRotation(target);
    }

    /**
     * RL旋转，右左旋转
     * @param target
     * @return
     */
    private static TreeNode doubleRightLeftRotation(TreeNode target) {
        target.setRightNode(singleLeftRotation(target.getRightNode()));
        return singleRightRotation(target);
    }

//    public static TreeNode
    /**
     * 获取树的高度
     * @param tree
     * @return
     */
    public static int getTreeHight(TreeNode tree) {
        if (Objects.isNull(tree)) {
            return -1;
        }

        return tree.getHight();
//        return getMax(getTreeHight(tree.leftNode), getTreeHight(tree.rightNode));
    }

    /**
     * 返回两个数中比较大的一个
     * @param a
     * @param b
     * @return
     */
    public static int getMax(int a, int b) {
        return a > b ? a : b;
    }


}
