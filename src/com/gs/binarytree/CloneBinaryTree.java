package com.gs.binarytree;

public class CloneBinaryTree {
	
	public static TreeNode clone(TreeNode node) {
		if(node == null) return null;
		TreeNode clonedNode = new TreeNode(node.val);
		if(node.left != null)
		  clonedNode.left = new TreeNode(clone(node.left).val);
		if(node.right != null)
		  clonedNode.right = new TreeNode(clone(node.right).val);
		savsdfv
        return clonedNode;
	}
}
