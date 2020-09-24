package com.gs.binarytree;

import java.util.*;

/*
    1       
  / \   
 /   \  
 3   2   
/ \   \ 
5 3   9 
                
op : [5, 3, 9]
 */
public class LargestValueInEachRow2 {
// but side
	
	private static class RowIdAndNode{
		private int rowId;
		private TreeNode node;
		public RowIdAndNode(int rowId, TreeNode node) {
			this.rowId = rowId;
			this.node = node;
		}
	}
	private static List<Integer> findLargest(TreeNode root) {
		Map<Integer, Integer> rowAndMaxMap = new LinkedHashMap<Integer, Integer>();
		Queue<RowIdAndNode> queue =  new LinkedList<RowIdAndNode>();
		queue.offer(new RowIdAndNode(0, root));
		while(!queue.isEmpty()) {
			int sz = queue.size();
			for(int i = 0; i < sz; i++) {
				RowIdAndNode current = queue.poll();
				TreeNode node = current.node;
				int rowId = current.rowId;
				int val = node.val;
				rowAndMaxMap.merge(rowId, val, (a, b) -> Math.max(a, b));
 				if(node.left != null) queue.offer(new RowIdAndNode(rowId, node.left));
				if(node.right != null) queue.offer(new RowIdAndNode(rowId + 1, node.right));
			}
		}
		
		List<Integer> result = new ArrayList<Integer>(rowAndMaxMap.values());
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
