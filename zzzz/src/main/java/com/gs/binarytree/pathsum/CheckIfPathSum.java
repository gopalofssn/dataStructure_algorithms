package com.gs.binarytree.pathsum;

import java.util.LinkedList;
import java.util.Queue;

import com.gs.binarytree.TreeNode;

public class CheckIfPathSum {


	private static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		return hasPathSumHelper(root, sum);
	}
	
	private static boolean hasPathSumHelper(TreeNode node, int expectedVal) {
		if(node == null || expectedVal < 0) return false; // no use to go further if it is < 0
		else if( isLeaf(node) && node.val == expectedVal) return true;
		else return hasPathSumHelper(node.left, (expectedVal - node.val))
			  ||hasPathSumHelper(node.right, (expectedVal - node.val));
	}

	private static boolean isLeaf(TreeNode node) {
		return (node.left == null ) &&  (node.right == null);
	}

	class TreeNodeAndSum{
		TreeNode node;
		int sum;
		public TreeNodeAndSum(TreeNode node, int sum){
			this.node = node;
			this.sum = sum;
		}
	}
	
	private boolean hasPathSumIterative(TreeNode root, int sum) {
		if(root == null) return false;

		Queue<TreeNodeAndSum> queue = new LinkedList<TreeNodeAndSum>();
		queue.offer(new TreeNodeAndSum(root, sum));
		while(!queue.isEmpty()){

			int sz = queue.size();
			for(int i = 0; i < sz; i++){
				TreeNodeAndSum current = queue.poll();
				TreeNode node = current.node;
				int currentSum = current.sum;
				if(isLeaf(node) && node.val == currentSum){
					return true;
				}
				if(currentSum < 0) return false; // no use go further 
				
				int nextSum = (currentSum - node.val);
				
				addToQueue(queue, node.left, nextSum);
				addToQueue(queue, node.right, nextSum);
			}
		}
		
		return false;
	}
	
	private void addToQueue(Queue<TreeNodeAndSum> queue, TreeNode node, int sum) {
		  if(node == null) return;
		  queue.offer(new TreeNodeAndSum(node, sum));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		
		System.out.println("Root " + root);
		
		System.out.println("hasPathSum? " + hasPathSum(root, 22));
		
		System.out.println("hasPathSumIterative? " + new CheckIfPathSum().hasPathSumIterative(root, 22));
		
		root = new TreeNode(5);
	    System.out.println("hasPathSum? " + hasPathSum(root, 5)); 
		 
		 root = new TreeNode(5);
		 System.out.println("hasPathSum? " + hasPathSum(root, 4)); 
	}




}
