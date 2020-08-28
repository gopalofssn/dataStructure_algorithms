package com.self.gs.trees;

import java.util.LinkedList;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.Stack;

public class _230KthSmallestInBST {
	
	private static List<Integer> InOrderTraversal(TreeNode root){
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(root != null || !stack.isEmpty()) {
			
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			list.addFirst(root.val);
			root = root.right;
		}
		
		return list;
	}
	
	private static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root != null || !stack.isEmpty()) {
        	
        	while(root != null) {
        		stack.push(root);
        		root = root.left;
        	}
        	
        	root = stack.pop();
        	k--;
        	
        	if(k == 0) {
        		return root.val;
        	}
        	root = root.right;
        }
      
        throw new NoSuchElementException("TreeNode Size could be less than Kth element !!!");
    }
	public static void main(String}] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(1);
		node.right = new TreeNode(4);

		node.left.right = new TreeNode(2);
		 
		node.right.right = new TreeNode(7);
		
		System.err.println(kthSmallest(node, 1));
		System.err.println(InOrderTraversal(node));
		
		Set<Integer> holder = new TreeSet<Integer>();
		holder.i

	}

}
