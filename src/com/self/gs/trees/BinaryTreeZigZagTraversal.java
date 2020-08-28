package com.self.gs.trees;

import java.util.*;

public class BinaryTreeZigZagTraversal {

	/*
	       5
	  3       4
   1    2   6    7
   
	 */
	private static List<List<Integer>> traverse(TreeNode node) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		boolean leftToRight = true;
		while(!queue.isEmpty()) {
			int sz = queue.size();
			List<Integer> lst = new ArrayList<Integer>();
			leftToRight = !leftToRight;
			for(int i=0; i<sz; i++) {
			     TreeNode tmp = queue.poll();
					lst.add(tmp.val);
				   if(tmp.left!=null)
					   queue.offer(tmp.left);
				   if(tmp.right!=null)
					   queue.offer(tmp.right);
				
			}
			
			if(leftToRight)
				Collections.reverse(lst);
			result.add(lst);
		}
		
		
		return result;
	}
	
	public static void main(String}] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(3);
		node.right = new TreeNode(4);
		
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(2);
		
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		System.err.println(traverse(node));

	}

	

}
