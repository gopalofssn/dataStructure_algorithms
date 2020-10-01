package com.gs.linkedlist;

public class ReverseLinkedListMToN {

	private static Node reverse(Node head, int m, int n) {
		if(head == null) return head;
		if(n <= m) return head;
		Node current = head;
		Node prev = null;
		while(m > 1){
			Node next = current.next;
			prev = current;
			current = next;
			m--;
		}
		int k = (n - m);
		Node reversed = helper(current, k);
		if(prev == null) return reversed;
		prev.next = reversed;
		return head;
	}

	private static Node helper(Node node, int k) {
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
		System.out.println("Rev : " + reverse(head, 2, 5));
	}
}
