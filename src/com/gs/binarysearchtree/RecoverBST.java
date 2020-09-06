package com.gs.binarysearchtree;

import java.util.Stack;

import com.gs.binarytree.TreeNode;

public class RecoverBST {

	private static void repair(TreeNode node) {
		if(node == null) return;
		class NodeParent{
			TreeNode node;
			TreeNode parent;
			public NodeParent(TreeNode node, TreeNode parent) {
				this.node = node;
				this.parent = parent;
			}
		}
		Stack<NodeParent> stack = new Stack<NodeParent>();
		stack.push(new NodeParent(node, null));
		while(!stack.isEmpty()){
		
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		System.out.println("ROOT " + root);
		repair(root);
		System.out.println("After repair " + root);
	}
}
