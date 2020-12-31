package com.gs.linkedlist;
/*
Input: 1->2->3->4->5->NULL k =2
Output: 2->1->4->3->5

Input: 1->2->3->4->5->6->7->8->9->10->NULL k =4
Output: 4->3->2->1->8->7->6->5->10->9->NULL

initialize dummy node with neg val;
dummy's next will be assigned only one , first time
we will maintain prev node , that will help assign reverse val after K size reverse

 */
public class ReverseLinkedLisingroupsofgivensize {
	
	private static Node reverseGroup(Node root, int k) {
		Node current = root;
		Node prev = null;
		Node dummy = new Node(-1);
		while(current != null){
		   Node rev = reverseGroupHelper(current, k);
		   if(prev == null)  dummy.next = rev;
		   else prev.next = rev; 
		   Node next = current.next;
		   prev = current;
		   current = next;
		}
		return dummy.next;
	}

	private static Node reverseGroupHelper(Node node, int k) {
		Node current = node;
		Node prev = null;
		while(current != null && k > 0){
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			k--;
		}
		node.next = current;
		return prev;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Node head = LinkedListBuilder.build(nums);
		System.out.println("HEAD : " + head);
		System.out.println("HEAD : " + reverseGroup(head, 3));
	}

}
