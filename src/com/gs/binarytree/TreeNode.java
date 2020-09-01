package com.gs.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode() {}
	public TreeNode(int val) {
		this.val = val;
	}
	
	public TreeNode(String str) {
		if(str == null || str.length() == 0)  return;
		
		
		String[] nodeArray = str.split(",");
		int val = Integer.parseInt(nodeArray[0]);
		this.val = val;
	    helper(nodeArray);
	}

	private void helper(String[] nodeArray) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(this);
			for(int i = 1; i < nodeArray.length;) {
				 int queueSize = queue.size();
				 for(int k = 0; k < queueSize; k++) {
					 TreeNode current = queue.poll();
					 current.left = nodeBuilder(nodeArray[i++]);
					 queue.offer(current.left);
					 current.right = nodeBuilder(nodeArray[i++]);
					 queue.offer(current.right);
				 }
			}
	}

	private static TreeNode nodeBuilder(String s) {
		if("X".equalsIgnoreCase(s.toLowerCase())) return null;
		else return new TreeNode(Integer.parseInt(s));
	}
	
	public String toString() {
		BinaryTreePrinter.printTreeNode(this);
		return BinaryTreeSerializer.serialize(this);
	}
	
}
