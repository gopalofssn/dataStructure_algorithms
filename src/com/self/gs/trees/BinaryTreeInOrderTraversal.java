package com.self.gs.trees;

import java.util.*;

public class BinaryTreeInOrderTraversal {

	private static List<Integer> recurssiveInorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null)
			return result;
		recurssive(root,result);
		return result;
	}
	
	private static void recurssive(TreeNode node, List<Integer> result) {
		if(node==null)
			return;
		recurssive(node.left,result);
		result.add(node.val);
		recurssive(node.right,result);
		
	}

	/*
	       1
	    2     3
	  4   5  6  7
	  
	  Stack
	  |                          |
	  |4                         |
	  |2   2  5      6           |
	  |1   1  1  1   3  3  7  _  |
	  
	  store : 4 2 5  1 6 3 7
	  
	 Time O(n) , space O(1)
	 */
	private static List<Integer> IterativeInorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null)
			return result;
		Stack<TreeNode> stack= new Stack<TreeNode>();
		while(true) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			}else {
				if(stack.isEmpty()) {
					break;
				}
				TreeNode tmp = stack.pop();
				result.add(tmp.val);
				root = tmp.right;
			}
		}
		
		return result;
	}
	
	public static void main(String}] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		System.err.println("Recurssive - " +  recurssiveInorderTraversal(root));
		
		System.err.println("Recurssive - " +  IterativeInorderTraversal(root));

	}



	

}
