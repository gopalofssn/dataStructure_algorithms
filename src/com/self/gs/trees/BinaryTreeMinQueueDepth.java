package com.self.gs.trees;
import java.util.*;
public class BinaryTreeMinQueueDepth {

	/*
	      5
	     / \
	    3   4
	   /   / \
	  1   6   7
	           \
	             9
	    
	 */
	private static int minQDepthRecurssive(TreeNode node) {
		if(node==null)
			return 0;
		
		int left = minQDepthRecurssive(node.left);
		int right = minQDepthRecurssive(node.right);
		System.out.println("**********************");
		System.out.println("Node data is - " + node.data);
		System.out.println("left len " + left);
		System.out.println("right len " + right);
		if(left==0)
			return right+1;
		else if(right==0)
			return left+1;
		else
			return Math.min(left,right) + 1;
	}
	
	private static int minQDepthBFS(TreeNode node) {
		if(node==null)
			return 0;
		int depth = 0 ;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			depth++;
			
			int n = queue.size();
			for(int i=0;i<n;i++) {
				TreeNode current = queue.poll();
				System.out.println("Node data is - " + current.data);
				if(current.left == null && current.right == null)
					return depth;
				
				if(current.left != null)
					queue.add(current.left);
				if(current.right != null)
					queue.add(current.right);
				
			}
		}
		
		return depth;
		
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(3);
		node.right = new TreeNode(4);
		
		node.left.left = new TreeNode(1);
		
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		
		node.right.right.right = new TreeNode(9);
		
		System.out.println(minQDepthRecurssive(node));
		
		System.out.println(minQDepthBFS(node));
	}



	
}
