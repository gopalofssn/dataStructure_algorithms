package com.gs.linkedlist;

public class LinkedListBuilder {
	
	  public static Node build(int[] nums) {
	    Node head = new Node(-1);
	    Node node = head;
	    for(int num : nums) {
	      Node tmp = new Node(num);
	      node.next = tmp;
	      node = node.next;
	    }
	    return head.next;
	  }
	  
	  public static void main(String[] args) {
		  int[] nums = {1, 2, 8, 9, 12, 16};
		  Node node = build(nums);
		  System.out.println(node);
	}
}
