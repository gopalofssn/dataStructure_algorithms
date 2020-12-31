package com.gs.binarysearchtree;

import java.util.HashSet;
import java.util.Set;

import com.gs.binarytree.TreeNode;

public class BinaryTreeToDoblyLinkedList {
	
   class DoublyLinkedList{
	    int val;
	    DoublyLinkedList prev = null;
	    DoublyLinkedList next = null;
		public DoublyLinkedList(int val) {
			this.val = val;
		}
		@Override
		public String toString() {
			return buildString(this, new HashSet<Integer>());
		}
		private String buildString(DoublyLinkedList head, Set<Integer> visited) {
			DoublyLinkedList current = head;
			StringBuilder sb = new StringBuilder();
			DoublyLinkedList p = null;
			while(current!= null && (visited.isEmpty() || !visited.contains(current.val)) ) {
				visited.add(current.val);
				sb.append(current.val)
				  .append("->");
				p = current;
			   current = current.next;   
			}
			sb.append(">>");
			return "NEXT : " +sb.toString() + " \n" + "PREV :" + buildPrevString(p, new HashSet<Integer>());
		}
		private String buildPrevString(DoublyLinkedList node, HashSet<Integer> visited) {
			DoublyLinkedList current = node;
			StringBuilder sb = new StringBuilder();
			while(current!= null && (visited.isEmpty() || !visited.contains(current.val)) ) {
				visited.add(current.val);
				sb.append(current.val)
				  .append("<-");
			   current = current.prev;   
			}
			sb.append("<<");
			
			return sb.toString();
		}
	}
	
	 DoublyLinkedList head = new DoublyLinkedList(-1);
	 DoublyLinkedList tail = head;

	private DoublyLinkedList converToList(TreeNode root) {
		 //head.next = tail;
		 //tail.prev = head;
		helper(root);
		head = head.next;
		tail.next = head;
		head.prev = tail;
		return head;
	}
	/* L P R
	   1
	 2  3
	 
	 */
	private void helper(TreeNode node) {
		 if(node == null) return;
		 helper(node.left); // 2
		 addToDoblyLL(node.val);
		 helper(node.right);
	}


	private void addToDoblyLL(int val) {
		DoublyLinkedList listNode = new DoublyLinkedList(val);
		tail.next = listNode;
		listNode.prev = tail;
		tail = listNode;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(7);
		System.out.println("Root : " + root.toString());
		//converToList(root);
		System.out.println("Linked List : " + new BinaryTreeToDoblyLinkedList().converToList(root).toString());
	}

}
