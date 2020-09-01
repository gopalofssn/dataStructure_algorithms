package com.gs.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

	private static TreeNode invertBinaryTreeRecurssive(TreeNode node) {
		if (node == null) return null;
		TreeNode left = invertBinaryTreeRecurssive(node.left);
	    TreeNode right = invertBinaryTreeRecurssive(node.right);
	    node.left = right;
	    node.right = left;
	    
	    return node;
	}

	private static TreeNode invertBinaryTreeIterative(TreeNode node) {

		if (node == null) return null;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		
		while(!queue.isEmpty()) {
			int sz = queue.size();
			for(int i = 0; i < sz; i++) {
				TreeNode current = queue.poll();
				TreeNode tmp = current.left;
				current.left = current.right;
				current.right = tmp;
				
				if(current.left != null) queue.offer(current.left);
				if(current.right != null) queue.offer(current.right);
				
			}
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(22);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(33);
		System.out.println("Root " + root);
		
		TreeNode node = CloneBinaryTree.clone(root);
		System.out.println("Recurssive " + invertBinaryTreeRecurssive(node));
        
		 node = CloneBinaryTree.clone(root);
        System.out.println("Iterative " + invertBinaryTreeIterative(root));
	}
	
}
