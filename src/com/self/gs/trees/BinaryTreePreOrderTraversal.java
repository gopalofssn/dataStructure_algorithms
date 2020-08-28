package com.self.gs.trees;

import java.util.*;

public class BinaryTreePreOrderTraversal {

	private static List<Integer> iterative(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
         iterative(root,result);
        return result;
	}
	/*
			    1
			2       3
		 4    5   6    7


  |
  |
  |        4            |
  |     2  5  5   6     |
  |  1  3  3  3 3 7 7 _ | 
  
ans :   1  2  4 5 3 6 7

*/
	
	private static void iterative(TreeNode node, List<Integer> result) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while(!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			result.add(tmp.val);
			if(tmp.right!=null)
				stack.push(tmp.right);
			if(tmp.left!=null)
				stack.push(tmp.left);
		}
	}

	private static List<Integer>  recurssive(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        recurssive(root, result);
       // iterative(root,result);
        return result;
	}
	 private static void recurssive(TreeNode node, List<Integer> result){
	        if(node==null)
	            return;
	        result.add(node.val);
	        recurssive(node.left,result);
	        recurssive(node.right,result);
	    }
	public static void main(String}] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		System.err.println("Recurssive - " +  recurssive(root));
		
		System.err.println("Recurssive - " +  iterative(root));

	
	}

	

}
