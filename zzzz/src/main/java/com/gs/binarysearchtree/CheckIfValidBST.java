package com.gs.binarysearchtree;

import java.util.Stack;

import com.gs.binarytree.TreeNode;

public class CheckIfValidBST {

	private static boolean isValid(TreeNode root) {
		if(root == null) return true;
		if(root.left != null && root.val < root.left.val)
			return false;
		if(root.right != null && root.val > root.right.val)
			return false;
		return isValid(root.left) && isValid(root.right);
	}
	
	private static boolean isValidIterative(TreeNode node) {
		if(node == null) return true;
		Stack<TreeNode> stack =  new Stack<TreeNode>();
		stack.push(node);
		while(!stack.isEmpty()){
			TreeNode current = stack.pop();
			if(current.left != null && current.left.val > current.val){
				return false;
			}else if(current.left != null){
				stack.push(current.left);
			}
			if(current.right != null && current.right.val < current.val){
				return false;
			}else if(current.right != null){
				stack.push(current.right);
			}
		}
		return true;
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
		System.out.println("Recursive isvalid?" + isValid(root));
		
		System.out.println("Iterative isValid?" + isValidIterative(root));
	}	
}
