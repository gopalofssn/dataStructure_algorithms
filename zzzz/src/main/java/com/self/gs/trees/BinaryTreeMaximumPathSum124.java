package com.self.gs.trees;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
//https://www.youtube.com/watch?v=p8P4Iv1rrtg
	
public class BinaryTreeMaximumPathSum124 {
	
	/*
	      -10(0)
	    9(9)     20(20)      // 9+0 = 9, 20+0 =20, 0 from parent node 
	  x  x     15  7
	  
	  max sum 20 + 15 + 7 = 42
	  
	  
	  
	 */

	 static Integer max = Integer.MIN_VALUE;
	 public static int maxPathSum(TreeNode root) {
	      if(root==null)
	    	  return max;
	      max = 0;
	       findMax(root);
	       return max;
	    }

	 private static int findMax(TreeNode node) {
		if(node==null) 
			return 0;
		int left = findMax(node.left);
		int right = findMax(node.right);
        int currentMax = max(node.val,left+node.val,right+node.val); // root alone , root + left or root+right
        int nlrMax = node.val + left + right;  /// all 3 contribution
        max = max(max,currentMax,nlrMax);  // max of either
        return currentMax;  // return  current max to caller , so 
	 }
	 
	 private static int max(int a, int b, int c) {
		 int tmp = Math.max(a, b);
		 return Math.max(tmp, c);
	 }
	public static void main(String}] args) {
		String str = "-10,9,20,X,X,15,7";
		TreeNode node = SerializeandDeserializeBinaryTree297.deserialize(str);
		
		System.err.println(maxPathSum(node));
		
		
		str = "10,2,15,-4,-6,X,-25,28,-22,X,X,3,4";
	   node = SerializeandDeserializeBinaryTree297.deserialize(str);
	   System.err.println(maxPathSum(node));
		
	}

}
