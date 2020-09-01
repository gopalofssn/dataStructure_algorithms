package com.gs.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerializer {
	
	public static String serialize(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		StringBuilder sb = new StringBuilder();
		queue.offer(node);
		sb.append(node.val);
		while(!queue.isEmpty()) {
			int sz = queue.size();
			for(int i = 0; i < sz; i++) {
				TreeNode current = queue.poll();
				helper(queue, current.left, sb);
				helper(queue, current.right, sb);
			}
		}
		
		return sb.toString();
		
	}

	private static void helper(Queue<TreeNode> queue, TreeNode node, StringBuilder sb) {
		if(node == null) {
			sb.append(",X");
			return;
		}

	    sb.append(",")
		  .append(node.val);
	    queue.offer(node);	
	}
}
