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
		System.err.println(nodeArray.length);
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
				 if(current.left != null) queue.offer(current.left);
				 System.err.println(i + "," +current.val);
				 current.right = nodeBuilder(nodeArray[i++]);
				 if(current.right != null) queue.offer(current.right);
			 }
		}
		System.err.println(root);
		return root;
	}

	private static TreeNode nodeBuilder(String s) {
		if("X".equalsIgnoreCase(s.trim().toLowerCase())) return null;
		else return new TreeNode(Integer.parseInt(s));
	}

	public static void main(String[] args) {
		String nodes = "2,0,33,X,1,25,40,X,X,11,31,34,45,10,18,29,32,X,36,43,46,4,X,12,24,26,30,X,X,35,39,42,44,X,48,3,9,X,14,22,X,X,27,X,X,X,X,38,X,41,X,X,X,47,49,X,X,5,X,13,15,21,23,X,28,37,X,X,X,X,X,X,X,X,8,X,X,X,17,19,X,X,X,X,X,X,X,7,X,16,X,X,20,6,X,X,X,X,X";
		TreeNode root = BinaryTreeDeserializer.deserializer(nodes);
		System.out.println("ROOT  - " + root);
	}

}
