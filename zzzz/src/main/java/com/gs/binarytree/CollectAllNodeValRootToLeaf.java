package com.gs.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectAllNodeValRootToLeaf {

	private static List<List<Integer>> collectRootToLeaf(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) return result;
		
		helper(root, new LinkedList<Integer>(), result);
		return result;
	}
	
	private static void helper(TreeNode node, LinkedList<Integer> current, List<List<Integer>> result) {
	    
		if(isLeaf(node)){
			current.addLast(node.val);
			result.add(new ArrayList<>(current));
			return;
		}
		
		current.addLast(node.val);
		
		if(node.left != null){
			helper(node.left, current, result);
			current.removeLast();
		}
		
		if(node.right != null){
			helper(node.right, current, result);
			current.removeLast();
		}
		
	}

	private static boolean isLeaf(TreeNode node) {
		return (node.left == null && node.right == null);
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
		
		List<List<Integer>> allRootToLeafNodes = collectRootToLeaf(root);
		for(List<Integer> list : allRootToLeafNodes){
			System.out.println(list);
		}
	}



}
