package com.gs.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDeserializer {

	public static TreeNode deserializer(String str) {
		return deserializer(new TreeNode(), str);
	}

	public static TreeNode deserializer(TreeNode root, String str) {
		if(str == null || str.length() == 0) {
			return null;
		}
		
		String[] nodeArray = str.split(",");
		int val = Integer.parseInt(nodeArray[0]);
		root = new TreeNode(val);
		return helper(nodeArray, root);
		
	}
	
	private static TreeNode helper(String[] nodeArray, TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
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
		System.err.println(root);
		return root;
	}
	

	
	private static TreeNode nodeBuilder(String s) {
		if("X".equalsIgnoreCase(s.toLowerCase())) return null;
		else return new TreeNode(Integer.parseInt(s));
	}

	

}
