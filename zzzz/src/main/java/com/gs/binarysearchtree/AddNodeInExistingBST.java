package com.gs.binarysearchtree;

import com.gs.binarytree.TreeNode;

public class AddNodeInExistingBST {
/*ADDING 5
           3       
		  / \   
		 /   \  
		 1   (6)   
		/ \ / \ 
		0 2 4 7 

		
		       3       
			  / \   
			 /   \  
			 1   5  
			/ \ / \ 
			0 2 4  6
			        \
			        7 

 */
	private static void addNode(TreeNode node, int num) {
		if(node == null) return;
		TreeNode locateNode = locate(node, num);
		System.out.println("located " + locateNode.val);
		move(locateNode, num);
	}
	
	private static void move(TreeNode node, int num) {
		int newNum = node.val;
		node.val = num;
		if(newNum < num && node.left == null){
			node.left = new TreeNode(newNum);
		}else if(newNum > num && node.right == null){
			node.right = new TreeNode(newNum);
		}else if(newNum < num){
			move(node.left, newNum);
		}else{
			move(node.right, newNum);
		}
	}

	private static TreeNode locate(TreeNode node, int num) {
		if(node == null) return null;
		if(isReplacable(node, num)){
			return node;
		}else if(num < node.val){
			return locate(node.left, num);
		}else{
			return locate(node.right, num);
		}
	}

	private static boolean isReplacable(TreeNode node, int num) {
		if(node.left != null && node.left.val > num){
			return false;
		}
		if(node.right !=null && node.right.val < num){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(8);

		System.out.println("ROOT  - " + root);
		addNode(root, 7);
		System.out.println("after adding node  - " + root);

	}



}
