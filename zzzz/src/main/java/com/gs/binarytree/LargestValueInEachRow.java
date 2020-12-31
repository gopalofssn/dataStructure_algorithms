package com.gs.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInEachRow {

	private static List<Integer> findLargest(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Queue<TreeNode> queue =  new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int sz = queue.size();
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < sz; i++) {
				TreeNode current = queue.poll();
				max = Math.max(max, current.val);
				if(current.left != null) queue.offer(current.left);
				if(current.right != null) queue.offer(current.right);
			}
			result.add(max);
		}
		return result;
	}

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(9);
		System.err.println("ROOT  - " + root);
		System.out.println(findLargest(root));
	}
}
