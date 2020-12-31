package com.gs.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.gs.binarytree.TreeNode;

public class GetAllNodeInBST {

	private static List<Integer> recursive(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		helper(root, result);
		return result;
	}
	// in order traversal L P R
	private static void helper(TreeNode node, List<Integer> result) {
		if(node == null) return;
		helper(node.left, result);
		result.add(node.val);
		helper(node.right, result);
	}

	private static List<Integer> iterative(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		doLeftStack(stack, root);
		while(!stack.isEmpty()) {
			TreeNode pop= stack.pop();
			result.add(pop.val);
			doLeftStack(stack, pop.right);
		}
		return result;
	}
	
	private static void doLeftStack(Stack<TreeNode> stack, TreeNode node) {
		if(node == null) return;
		stack.push(node);
		doLeftStack(stack, node.left);
	}
	
	/*
	       3       
		  / \   
		 /   \  
		 1   6   
		/ \ / \ 
		0 2 4 7 
	 */
	private static List<Integer> morris(TreeNode node) {
		List<Integer> result = new ArrayList<Integer>();
		
		return result;
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
		System.out.println(morris(root));
	}
}
