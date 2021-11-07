package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;

/**
 * @author : cys
 * date: 2021-08-14 21:48
 */
public class Test105 {
    public static void main(String[] args) {
        Test105 test105 = new Test105();
        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{2, 1};
        TreeNode treeNode = test105.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return inner(preorder, 0, preorder.length - 1,
                inorder, 0, preorder.length - 1);
    }

    private TreeNode inner(int[] preorder, int i, int i1, int[] inorder, int i2, int i3) {
        if (i > i1 || i2 > i3) {
            return null;
        }
        int current = preorder[i];
        if (i == i1) {
            return new TreeNode(current);
        }
        //处理左子树
        int index = i2;
        for (int i4 = i2; i4 <= i3; i4++) {
            if (inorder[i4] == current) {
                index = i4;
                break;
            }
        }
        int leftTreeNumber = index - i2;
        System.out.printf("lefttree:%s, %s;%s, %s\n",
                i + 1, i + leftTreeNumber, i2, i2 + leftTreeNumber - 1);
        TreeNode leftNode = inner(preorder,
                i + 1, i + leftTreeNumber, inorder, i2, i2 + leftTreeNumber - 1);

        System.out.printf("rightTree:%s, %s;%s, %s\n",
                i + leftTreeNumber + 1, i1, i2 + leftTreeNumber + 1, i3);
        TreeNode rightNode = inner(preorder,
                i + leftTreeNumber + 1, i1, inorder, i2 + leftTreeNumber + 1, i3);
        return new TreeNode(current, leftNode, rightNode);
    }
}
