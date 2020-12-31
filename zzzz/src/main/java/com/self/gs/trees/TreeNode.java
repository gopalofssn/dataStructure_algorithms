package com.self.gs.trees;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}
}
