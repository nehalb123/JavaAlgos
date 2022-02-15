package com.tree;

/**
 * Create a height balanced BST.
 *
 * Approach:
 * 1. This is an easy problem just choose the middle element as root.
 * 2. Recurse on left and right parts
 * 3. If left > right, return null;
 */
public class SortedArrayToBST {
    static int numsArr[];

    TreeNode construct(int left, int right){
        if(left > right) return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(numsArr[mid]);
        root.left = construct(left, mid-1);
        root.right = construct(left+1, right);

        return root;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        numsArr = nums;
        return construct(0, numsArr.length-1);
    }

    public static void main(String[] args) {
        int nums[] = {-10,-3,0,5,9};

    }
}
