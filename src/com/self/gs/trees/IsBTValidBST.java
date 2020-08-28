package com.self.gs.trees;

import java.util.*;

class NodeAndBound{
	int lower;
	int upper;
	TreeNode node;
	public NodeAndBound(int _lower, int _upper, TreeNode _node) {
		lower = _lower;
		upper = _upper;
		node = _node;
	}
	public TreeNode getTreeNode() {
		return node;
	}
	public int getLower() {
		return lower;
	}
	public int getUpper() {
		return upper;
	}
}

public class IsBTValidBST {

	/*
	                           10
	              8(-& 10)              12 ( 10 +& )
	  
	       7(-& 8)    9 ( 8 10)   11(10 12)      13 (12 +&)
	 
	 
	 */
	private static boolean validBst(TreeNode root) {
		 
		Queue<NodeAndBound> queue = new LinkedList<NodeAndBound>();
		
		if(root.left!=null)
		 queue.add(new NodeAndBound(Integer.MIN_VALUE, root.val,root.left) );

		if(root.right!=null)
		 queue.add(new NodeAndBound(root.val,Integer.MAX_VALUE,root.right) );
		
		
		while(!queue.isEmpty()) {
			int sz = queue.size();
			for(int i=0; i<sz; i++) {
				NodeAndBound tmp = queue.poll();
				TreeNode n = tmp.node;

				if(tmp.lower>n.val || tmp.upper<n.val) 
					return false;
				
				if(n.left!=null)
					 queue.add(new NodeAndBound(tmp.lower, n.val,n.left) );

				if(n.right!=null)
					queue.add(new NodeAndBound(n.val,tmp.upper,n.right) );
					
			}
		}
		return true;
	}
	
	public static void main(String}] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(9);
		
		root.right = new TreeNode(12);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(13);
		
		System.err.println(validBst(root));
	}

	

}
