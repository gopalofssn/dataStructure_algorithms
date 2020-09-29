package com.gs.binarytree;

import java.util.Stack;

public class _230KthSmallestInBST {
	
	private static int kthLargest(TreeNode root, int k) {
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.isEmpty() || node != null){
			while(node != null){
				stack.push(node);
				node = node.right;
			}
			node = stack.pop();
			k--;
			if(k == 0) return node.val;
			node = node.left;
		}
		return -1;
	}
	
	private static int kthSmallest(TreeNode root, int k) {
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.isEmpty() || node != null){
			while(node != null){
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			k--;
			if(k == 0)return node.val;
			node = node.right;
		}
		return -1;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(1);
		node.right = new TreeNode(4);
		node.left.right = new TreeNode(2);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		System.out.println(node);
		System.err.println(kthSmallest(node, 4));
		System.err.println(kthLargest(node, 2));
	}

}
