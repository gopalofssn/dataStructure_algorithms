package com.self.gs.trees;

import java.util.*;
public class RootToLeafBinaryTreeSum {
	/*
	 targetSum = 16
	             10(16)
	    16(0)             5(11)
	       -3(-3)     6(5)   11(0)
	 */
	private static List<Integer> find(TreeNode root, int target) {
		
		List<Integer> result = new ArrayList<Integer>();
		if(root == null)
			return result;
		
		util(root,target,result);
		return result;
	}
	
	/*
	  In order traversal , visit node , left , right
	  
	 */
	
	private static boolean util(TreeNode node, int sum, List<Integer> result) {
		if(node==null)
			return false;
		if(node.left==null && node.right==null) {
			if(sum==node.val) {
				result.add(node.val);
				return true;
			}else {
				return false;
			}
		}
		
	   if(util(node.left,sum-node.val,result)) {
		  result.add(node.val) ;
		  return true;
	   }
	   if(util(node.right,sum-node.val,result)) {
		   result.add(node.val);
		   return true;
	   }
		
	   return false;
	}
	
public static void main(String}] args) {
	String str = "10,16,5,X,-3,6,11";
	TreeNode node = SerializeandDeserializeBinaryTree297.deserialize(str);
	System.err.println(find(node,26));
}
}
