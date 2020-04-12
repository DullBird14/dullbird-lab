package com.dullbird.demo.chapter.four.one;

/**
 * @author cys
 * @date 2018-09-30 下午1:35
 */


public class TreeNode {
    private TreeNode leftNode;
    private TreeNode rightNode;
    private int value;
    private int hight;
    private boolean ifIsPass;

    public boolean isIfIsPass() {
        return ifIsPass;
    }

    public void setIfIsPass(boolean ifIsPass) {
        this.ifIsPass = ifIsPass;
    }

    public TreeNode(int value, int hight) {
        this.value = value;
        this.hight = hight;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                ", value=" + value +
                ", hight=" + hight +
                ", ifIsPass=" + ifIsPass +
                '}';
    }
}
