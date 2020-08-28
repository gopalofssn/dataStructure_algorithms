package com.self.gs.trees;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}
	
	public String toString() {
		if(isLeaf()) {
			return Integer.toString(val) + ",";
		}else {
			StringBuilder sb = new StringBuilder();
			
			if(left != null) {
				sb.append(left.toString());
			}
			
			sb.append(this.val + ",");
			
			if(right != null) {
				sb.append(right.toString());
			}
			return sb.toString();
		}
		
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}
}
