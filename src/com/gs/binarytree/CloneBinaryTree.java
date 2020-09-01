package com.gs.binarytree;

public class CloneBinaryTree {
	
	public static TreeNode clone(TreeNode node) {
		if(node == null) return null;
		TreeNode clonedNode = new TreeNode(node.val);
		if(node.left != null)   clonedNode.left = clone(node.left); 
		if(node.right != null) clonedNode.right = clone(node.right);
        return clonedNode;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(21);
		root.left.right = new TreeNode(23);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(31);
		root.right.right = new TreeNode(33);
		System.out.println("Root " + root);
		TreeNode clone = CloneBinaryTree.clone(root);
		System.out.println("Clone " + clone);
	}
}
