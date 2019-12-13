package com.self.gs.trees;

public class TreeNode {
	int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}
	
	public String toString() {
		return Integer.toString(val);
	}
}
