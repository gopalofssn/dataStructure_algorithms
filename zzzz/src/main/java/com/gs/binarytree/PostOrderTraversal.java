package com.gs.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
    P
  L   R
  
post order : L R P
 */
public class PostOrderTraversal {

	private static List<Integer> recursive(TreeNode node) {
		List<Integer> result = new ArrayList<Integer>();
		if(node == null) return result;
		helper(node, result);
		return result;
	}
	
	private static void helper(TreeNode node, List<Integer> result) {
		if(node == null) return;
		helper(node.left, result);
		helper(node.right, result);
		result.add(node.val);
	}

	/*
	  LinkedList and Stack
	    1
	   2 3
	   LL add as first element for each pop, so it keep going to last
	  
	      push [1] // root push
	    loop   
	        pop 1 and add LL first element 1
	      push pop.left first [2]
	      push pop.right second [3 2]
	    loop
	 */
	private static List<Integer> iterative(TreeNode node) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		if(node == null) return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while(!stack.isEmpty()){
			node = stack.pop();
			result.addFirst(node.val);
			if(node.left != null) stack.push(node.left);
			if(node.right != null) stack.push(node.right);
		}
		
		return result;
	}

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.err.println("ROOT  - " + root);
		
		System.err.println("Recurssive - ");
		List<Integer> result =  recursive(root);
		for(int val : result){
			System.err.println(val);
		}
		System.err.println("Iterative - " +  iterative(root));
		
	    result =  iterative(root);
		for(int val : result){
			System.err.println(val);
		}
	}

}
