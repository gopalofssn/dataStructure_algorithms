package com.gs.linkedlist;

public class RemoveLinkedListElements203 {

/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
usecase : 
  1. val can  come as 1st element
        keep moving head position 
  2. val can come as last element
  3. val can come multiple times in sequence
  4. val can come at any middle positions
      
      6->2->6->6->4->5->6->NULL   , val = 6
         head
         2  6  6  4  5  6
         node = head
            2 --> 4  5  6
               |_ another while until we get non 6 val
                  4  5  6
                     5  6
                     5--> null 
	 */
	private static Node remove(Node head, int k) {
		if(head == null) return head;
		while(head != null && head.val == k){
			head = head.next;
		}
		Node current = head;
		Node prev = null;
		loop:
		while(current != null){
			while(current != null && current.val == k) {
				prev.next = current.next;
				current = current.next;
				if(current == null) break loop;
			}
			prev = current;
			current = current.next;
		}
		return head;
	}

	public static void main(String[] args) {
		int[] nums = {6, 2, 3, 4, 5, 6, 6, 7, 8, 9, 6};
		Node head = LinkedListBuilder.build(nums);
		System.out.println("HEAD : " + head);
		System.out.println("Rev : " + remove(head, 6));
	}



}
