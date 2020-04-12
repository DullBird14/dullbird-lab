package com.dullbird.demo.chapter.four.two;

/**
 * @author cys
 * @date 2018-09-29 下午2:18
 */

import com.dullbird.demo.chapter.four.one.TreeNode;

import java.util.Objects;
import java.util.Scanner;

// 5
// 88 70 61 96 120
//7
//88 70 61 96 120 90 65



public class MainTwo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String originalTree = sc.nextLine();
        TreeNode root = null;
        //创建第一棵树
        for (String value : originalTree.split(" ")) {
            root = insertTreeNode(root, Integer.valueOf(value));
        }
        System.out.println(root.getValue());
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
