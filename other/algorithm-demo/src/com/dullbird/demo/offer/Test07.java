package com.dullbird.demo.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-07-03 17:25
 */
public class Test07 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        Test07 a = new Test07();
        TreeNode node = a.buildTree(preorder, inorder);
        System.out.println(node);
    }
    private Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(Objects.isNull(preorder) || preorder.length==0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return innerBuildTree(preorder, 0, 0, inorder.length - 1);
    }

    public TreeNode innerBuildTree(int[] preorder,int preStart, int start, int endint) {
        if(preStart >= preorder.length){
            return null;
        }
        if(endint < start){
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        root.left = innerBuildTree(preorder, preStart+1, start, indexMap.get(rootVal)-1);
        int leftLength = indexMap.get(rootVal) - start;
        root.right = innerBuildTree(preorder, preStart + leftLength + 1, indexMap.get(rootVal) +1, endint);
        return root;
    }

}
