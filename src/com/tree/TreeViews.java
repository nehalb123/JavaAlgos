package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeViews {



    //BFS
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i< size;i++){
                TreeNode node = q.poll();
                if(i==0) rightSide.add(node.data);

                if(node.right != null){
                    q.offer(node.right);
                }
                if(node.left != null){
                    q.offer(node.left);
                }
            }

        }
        return rightSide;
    }

    public static void main(String[] args) {
        /*
            10
          /    \
         4      11
       /  \       \
      1    7       25
          /       /  \
         5       20   33

     */

        TreeNode root = new TreeNode(10);
        root.insert(4);
        root.insert(7);
        root.insert(11);
        root.insert(25);
        root.insert(33);
        root.insert(1);
        root.insert(5);
        root.insert(20);

        System.out.println(rightSideView(root));
    }
}
