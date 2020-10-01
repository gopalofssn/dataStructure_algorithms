package com.gs.linkedlist;

/*
i/p : 1->2->4->4->4->4->5
o/p : 1->2->4->5
 */
public class RemoveDuplicateSortedList {

   private static Node remove(Node head) {
		Node current = head;
		Node prev = null;
		loop:
		while(current != null){
			while(prev != null && current!= null && prev.val == current.val){
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
	    int[] nums = {1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8, 9, 9};
		Node head = LinkedListBuilder.build(nums);
		System.out.println("HEAD : " + head);
		System.out.println("Rev : " + remove(head));
  	}


}
