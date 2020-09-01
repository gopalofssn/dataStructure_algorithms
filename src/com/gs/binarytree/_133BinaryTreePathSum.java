package com.gs.binarytree;
import java.util.*;
public class _133BinaryTreePathSum {
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(root, new LinkedList<Integer>(),sum, result);
        return result;
    }
    
    private  static void helper(TreeNode node, LinkedList<Integer> currentResult , int sum, List<List<Integer>> result){
      if(node == null) {
    	  return;
      }
      
      currentResult.add(node.val);
      System.err.println(sum);
      if(node.left == null && node.right == null && node.val == sum) {
    	   result.add(new LinkedList<Integer>(currentResult));
      }
     else if(sum<0) {  /// if we know no negative numbers below 
    	  System.err.println("got negative value , useless to go further below to reach leaf ... ");
      }else {
       helper(node.left,currentResult, sum-node.val, result);
       helper(node.right,currentResult, sum-node.val, result); 
      }

      currentResult.removeLast();
    }
    
  public static void main(String[] args) {
	  String str = "5,4,8,11,X,13,4,7,2,X,X,5,1,1,2";
	 TreeNode node = BinaryTreeDeserializer.deserializer(str);
	System.err.println(pathSum(node,22));
}
}
