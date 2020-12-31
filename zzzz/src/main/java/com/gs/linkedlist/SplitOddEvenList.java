package com.gs.linkedlist;

public class SplitOddEvenList {

	/*
	  1->2->3->4->5->6->7->8->NULL
	  odd @ 1st node    1
	  even @ 2nd node   2
	  odd.next = even.next  1->3 -> 5
	  advance odd as to next 3 5
	  even.next = odd.next 2->4 -> 6
	  advance even to next 4 6
	 */
	private static Node[] split(Node head) {
		if(head == null) return null;
		Node odd = head;
		Node even = (head.next != null) ? head.next : null;
		Node[] nodes = new Node[2];
		nodes[0] = odd;
		nodes[1] = even;
		while(odd != null && even != null){
			odd.next = (even != null) ? even.next : null;
			odd = odd.next;
			even.next = (odd != null) ? odd.next : null;
			even = even.next;
		}
		return nodes;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		Node node = LinkedListBuilder.build(nums);
		System.out.println("HEAD : " + node);
		Node[] nodes = split(node);
		System.out.println("ODD : " + nodes[0]);
		System.out.println("EVEN : " + nodes[1]);
	}

}
