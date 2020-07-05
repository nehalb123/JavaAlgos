package tree;

public class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }

    /*Insertion for BST*/
    public void insert(int value){
        if(value <= this.data){
            if(left == null){
                left = new TreeNode(value);
            }else{
                left.insert(value);
            }
        }else{
            if(right == null){
                right = new TreeNode(value);
            }else{
                right.insert(value);
            }
        }
    }
}
