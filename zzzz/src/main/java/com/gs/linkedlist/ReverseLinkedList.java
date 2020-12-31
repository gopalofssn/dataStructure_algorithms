package com.gs.linkedlist;

public class ReverseLinkedList {

	private static Node reverse(Node head) {
		if(head == null) return head;
		Node current = head;
		Node prev = null;
		while(current != null){
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Node head = LinkedListBuilder.build(nums);
		System.out.println("HEAD : " + head);
		System.out.println("Rev : " + reverse(head));
	}
}
