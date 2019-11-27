package com.self.gs.LinkedList;

import com.self.gs.trees.BinaryTreeTraversal;
import com.self.gs.trees.TreeNode;

/*
 Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

       0
     /  \
   -3    9
   / \   / \
 -10 -1  5  11
 */
public class ConvertSortedListToBST09 {

	public static TreeNode sortedListToBST(ListNode head) {
		if(head==null)
			return null;
		if(head.next == null)
			return new TreeNode(head.val);
		ListNode slow = head, fast = head;
		if(fast!=null && fast.next!=null)
			fast = fast.next.next;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.err.println(slow.next.val);
		TreeNode node = new TreeNode(slow.next.val);
		node.right = sortedListToBST(slow.next.next);
		slow.next = null; // nullify since it is assigned as node;
		node.left = sortedListToBST(head);
		return node;
	}
	public static void main(String[] args) {
		 ListNode root = new ListNode(-10);
		  root.next = new ListNode(-3);
		  root.next.next = new ListNode(-1);
		  root.next.next.next = new ListNode(0);
		  root.next.next.next.next = new ListNode(5);
		  root.next.next.next.next.next = new ListNode(9);
		  root.next.next.next.next.next.next = new ListNode(11);
		  System.out.println(root.toString());
		  
		  System.out.println(BinaryTreeTraversal.LevelOrderTraversal(sortedListToBST(root)));
	}
}
