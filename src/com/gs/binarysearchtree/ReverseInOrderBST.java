package com.gs.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.gs.binarytree.TreeNode;

/*
     N
   L   R
     o/p  R N L
      - used to get descending order of BST
      
 */
public class ReverseInOrderBST {
	
	private static List<Integer> recursive(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		helper(root, result);
		return result;
	}
/*
       3       
	  / \   
	 /   \  
	 1   6   
	/ \ / \ 
	0 2 4  7 
	      2
	    1  3
*/	
	private static void helper(TreeNode node, List<Integer> result) {
		if(node == null) return;
		helper(node.right, result);
		result.add(node.val); 
		helper(node.left, result);
	}

	private static List<Integer> iterative(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		doRightStack(stack, root);
		while(!stack.isEmpty()) {
			TreeNode pop = stack.pop();
			result.add(pop.val);
			doRightStack(stack, pop.left);
		}
		return result;
	}
	
	private static void doRightStack(Stack<TreeNode> stack, TreeNode node) {
		 if(node == null) return;
		 stack.push(node);
		 doRightStack(stack, node.right);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(7);

		System.out.println("ROOT  - " + root);
		System.out.println(recursive(root));
		System.out.println(iterative(root));
		//System.out.println(morris(root));
	}
}
