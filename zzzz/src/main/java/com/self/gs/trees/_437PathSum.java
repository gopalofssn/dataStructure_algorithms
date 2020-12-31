package com.self.gs.trees;

public class _437PathSum {
	static int result = 0;
    public static int pathSum(TreeNode root, int sum) {
       helper(root,sum);
       return result;
    }
    
    /*
     
        5
        
     5     6
     
     10
     
    
     */
    
    private static void helper(TreeNode node,int sum){
        if(node == null)
            return;
        if(sum == node.val) {
        	System.err.println(node.val);
            result++;
        }
        
        helper(node.left, sum);
       // helper(node.right, sum);
        
        helper(node.left, (sum-node.val));
        helper(node.right, (sum-node.val));
        
        
    }
    
 public static void main(String[] args) {
	String str = "10,5,-3,3,2,X,11,3,-2,X,1";
	TreeNode node = SerializeandDeserializeBinaryTree297.deserialize(str);
	System.err.println(pathSum(node,8));
}
}
