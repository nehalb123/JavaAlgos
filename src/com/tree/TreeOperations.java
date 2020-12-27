package com.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeOperations {

    /*Hints:
     * 1. Drawing jumping arrows makes recursion simple.
     * 2. A recursion stack is an additional visual aid.
     * */
    static int deepestSum;
    static int maxDepth;
    static int diameter;

    static void inOrder(TreeNode root) {
        /*Depth first traversals : Inorder, pre-order and post-order*/
        if (root.left != null) {
            inOrder(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            inOrder(root.right);
        }
    }
    /* --------------------------------------------------------------- */

    static int heightOfTree(TreeNode node) {
        /*
        Height of com.tree = no. of edges from longest root-to-leaf path.
        In this example for 11 we get left side height 0 and right side height 2. We return the max(left side height, right side height) + 1 to
        the  node above i.e. 10
        */
        if (node == null) {
            return -1;
        }
        int lHeight = heightOfTree(node.left);
        int rHeight = heightOfTree(node.right);

        return 1 + Math.max(lHeight, rHeight);
    }

    /* --------------------------------------------------------------- */
    static void goLeft(TreeNode node) {
        if (node.left != null) {
            goLeft(node.left);
        }
        System.out.print(node.data + " ");
    }

    static void goRight(TreeNode node) {
        System.out.print(node.data + " ");
        if (node.right != null) {
            goRight(node.right);
        }
    }

    static void topView(TreeNode root) {
        if (root.left != null) {
            goLeft(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            goRight(root.right);
        }
    }
    /* --------------------------------------------------------------- */

    static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        System.out.println('\n' + "Level Order Traversal: ");
        queue.add(root);
        /* Note: offer() is much faster than add()*/
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
    /* --------------------------------------------------------------- */

    static TreeNode lowestCommonAncestor(TreeNode root, int val1, int val2) {
        TreeNode node = root;
        if (val1 <= node.data && val2 < node.data) {
           /*
           Initially I made a mistake in this code; I did not put return in front of lowestCommonAncestor().
           This was causing the program to go down the entire recursion stack.
           */
            //both value less go left
            return lowestCommonAncestor(node.left, val1, val2);
        }
        if (val1 > node.data && val2 >= node.data) {
            return lowestCommonAncestor(node.right, val1, val2);
        }
        return node;
    }

    /* --------------------------------------------------------------- */

    static boolean isBST(TreeNode root, int min, int max) {
        /*If both left and right subtree return true then the binary com.tree is BST*/
        if (root == null) {
            return true;
        }
        if (root.data <= min || root.data > max) {
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    static boolean checkBST(TreeNode root) {
        /*Another method: Inorder traversal of the BST com.tree is always in ascending order*/
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return isBST(root, min, max);
    }
    /* --------------------------------------------------------------- */

    static TreeNode deleteFromBST(TreeNode root, int val) {
        if (root == null)
            return root;
        else if (val < root.data) {
            //go left
            root.left = deleteFromBST(root.left, val);
        } else if (val > root.data) {
            root.right = deleteFromBST(root.right, val);
        } else {
            // value found
            /*Case 1: Leaf node*/
            if (root.left == null && root.right == null) {
                return null;
            }
            /*Case 2: One child*/
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            /*Case 3 : 2 children*/
            else {
                /*Finding minimum of the right subtree. Exploiting the property that minimum in the right subtree
                won't have left subtree   */
                TreeNode temp = findMin(root.right);
                root.data = temp.data;
                root.right = deleteFromBST(root.right, temp.data);
            }
        }
        return root;
    }

    static TreeNode findMin(TreeNode node) {
        if (node.left == null)
            return node;
        return findMin(node.left);
    }
    /* --------------------------------------------------------------- */


    static int deepestSumLeaves(TreeNode root) {
        return findDeepestSum(root, 0);
    }

    static int findDeepestSum(TreeNode root, int count) {
        /*deepestSum and maxDepth are two global variables*/
        if (root == null)
            return 0;
        count++;
        if (root.left == null && root.right == null) {
            //Leaf Node
            if (count > maxDepth) {
                maxDepth = count;
                deepestSum = 0;
                deepestSum += root.data;
            } else if (count == maxDepth) {
                deepestSum += root.data;
            }
        }
        findDeepestSum(root.left, count);
        findDeepestSum(root.right, count);

        return deepestSum;
    }
    /* --------------------------------------------------------------- */

    static TreeNode find(TreeNode root, int data) {
        if (root == null || root.data == data) {
            return root;
        }
        if (data < root.data)
            return find(root.left, data);

        return find(root.right, data);
    }

    static TreeNode inorderSuccessor(TreeNode root, int data) {
        TreeNode current = find(root, data);
        TreeNode successor = null;
        /*
        Case 1: Node has right subtree
        Go deep to the leftmost node in right subtree i.e. min in the right subtree.
        */
        if (current.right != null) {
            successor = findMin(current.right);
        } else {
            /*
             * Case 2: No right subtree
             * Go to the nearest node for which given node would be in left subtree.
             * Hint: Walk the com.tree from root to the node. Update successor when we go left.
             **/
            TreeNode ancestor = root;
            while (ancestor != current) {
                if (current.data < ancestor.data) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
        }
        return successor;
    }
    /* --------------------------------------------------------------- */

    static void reverseLevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            stack.push(node);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }
    /* --------------------------------------------------------------- */

    static int diameterOfBinaryTree(TreeNode root) {
        /*https://imgur.com/I2x2ZqN*/
        diameter(root);
        return diameter;
    }

    static int diameter(TreeNode root) {
        if (root != null) {
            int left = diameter(root.left);
            int right = diameter(root.right);
            diameter = Math.max(diameter, left + right);
            return 1 + Math.max(left, right);
        }
        return 0;
    }
    /* --------------------------------------------------------------- */

    /**
     * What happens there when you pass the path (instead of new ArrayList(path) is that
     * you use a single object in all methods call, which means that, when you return to
     * the original caller, the object is not in the same state as it was.
     */
    static void rootToLeafPaths(TreeNode node, ArrayList path) {
        if (node == null)
            return;
        path.add(node.data);
        if (node.left == null && node.right == null) {
            System.out.println(path);
            return;
        }
        rootToLeafPaths(node.left, new ArrayList(path));
        rootToLeafPaths(node.right, new ArrayList(path));

    }

    /**
     * Find width of binary com.tree: Refer leetcode
     */

    /* --------------------------------------------------------------- */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.data);
        node.left = invertTree(root.right);
        node.right = invertTree(root.left);
        return node;
    }

    public static void main(String[] args) {

    /*
            10
          /    \
         3      11
       /  \       \
      1    4       25
                  /  \
                 20   33

     */
        TreeNode root = new TreeNode(10);
        root.insert(3);
        root.insert(4);
        root.insert(11);
        root.insert(25);
        root.insert(33);
        root.insert(1);
        root.insert(20);
        inOrder(root);
        int heightOfTree = heightOfTree(root);
        System.out.println("");
        System.out.println("Height of the tree: " + heightOfTree);
        System.out.println("Top View: ");
        topView(root);
        levelOrderTraversal(root);
        TreeNode lca = lowestCommonAncestor(root, 1, 33);
        System.out.println('\n' + "Lowest Common Ancestor: " + lca.data);
        System.out.println("Is BST?: " + checkBST(root));

        System.out.println("Deepest leaves sum: " + deepestSumLeaves(root));

        int data = 25;
        TreeNode newRoot = deleteFromBST(root, data);
        System.out.print("BST with deleted value " + data + ": ");
        inOrder(newRoot);
        root.insert(25);
        levelOrderTraversal(root);
    /*
            10
          /    \
         3      11
       /  \       \
      1    4       33
                  /
                 20
                   \
                   25

     */
        int findInorderSuccessorOf = 1;
        TreeNode inorderSucc = inorderSuccessor(root, findInorderSuccessorOf);
        System.out.println('\n' + "Inorder successor of " + findInorderSuccessorOf + " is: " + inorderSucc.data);
        System.out.println("Reverse level order traversal: ");
        reverseLevelOrderTraversal(root);
        System.out.println('\n' + "Diameter of tree: " + diameterOfBinaryTree(root));
        ArrayList path = new ArrayList();
        System.out.println("Root to leaf paths: ");
        rootToLeafPaths(root, path);

        invertTree(root);

    }
}
