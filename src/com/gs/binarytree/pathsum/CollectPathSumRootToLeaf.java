package com.gs.binarytree.pathsum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.gs.binarytree.TreeNode;

public class CollectPathSumRootToLeaf {

	private static List<List<Integer>> collectRootToLeaf(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) return result;
		
		helper(root, new LinkedList<Integer>(), result, sum);
		return result;
	}

	
	private static void helper(TreeNode node, LinkedList<Integer> currentList, List<List<Integer>> result, int sum) {

		 if(node == null) return;
		
		 if(isLeaf(node) && node.val == sum){
			 currentList.addLast(node.val);
			 result.add(new ArrayList<>(currentList));
			 return;
		 } 
		 
		 currentList.add(node.val);
		 int nextSum = sum - node.val;
		 
		if(node.left != null){
			 helper(node.left, currentList,result, nextSum);
			 currentList.removeLast();
		 }
		 
		 if(node.right != null){
			 helper(node.right, currentList,result, nextSum);
			 currentList.removeLast();
		 }
		 
	}


	private static boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);

		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.left.left = new TreeNode(-4);
		root.right.left.right = new TreeNode(1);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(1);
		root.right.right.right = new TreeNode(5);
		
		System.out.println("Root " + root);
		
		List<List<Integer>> allRootToLeafNodes = collectRootToLeaf(root, 22);
		for(List<Integer> list : allRootToLeafNodes){
			System.out.println(" list " + list);
		}
		
		allRootToLeafNodes = collectRootToLeafIterative(root, 22);
			for(List<Integer> list : allRootToLeafNodes){
				System.out.println(" list " + list);
			}
			
	}


	private static List<List<Integer>> collectRootToLeafIterative(TreeNode node, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(node == null ) return result;
		
		
		
		return null;
	}


}
