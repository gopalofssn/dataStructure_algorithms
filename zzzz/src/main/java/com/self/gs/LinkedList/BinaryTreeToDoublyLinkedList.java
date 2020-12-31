package com.self.gs.LinkedList;

import com.self.gs.trees.TreeNode;

public class BinaryTreeToDoublyLinkedList {

	public static void main(String[] args) {
		// Let us create the tree as shown in above diagram
		TreeNode tree = new TreeNode(10);
		tree.left = new TreeNode(12);
		tree.right = new TreeNode(15);
		tree.left.left = new TreeNode(25);
		tree.left.right = new TreeNode(30);
		tree.right.left = new TreeNode(36);

		System.err.println(tree.toString());
		ListNode ll = BinaryTree2DoubleLinkedList(tree);

		System.err.println(ll.toString());

	}

	private static ListNode BinaryTree2DoubleLinkedList(TreeNode tree) {
		
		if(tree == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(-1);
		ListNode result = dummy;
			
		InOrderTraversal(tree ,result);

		return dummy.next;
		
	}

	private static void InOrderTraversal(TreeNode tree, ListNode result) {

		if (tree.left != null) {
			InOrderTraversal(tree.left, result);
		}
		System.err.println(result.toString());
		ListNode tmp = new ListNode(tree.val);
		result.next = tmp;
		result = result.next;

		if (tree.right != null) {
			InOrderTraversal(tree.right, result);
		}

	}
}
