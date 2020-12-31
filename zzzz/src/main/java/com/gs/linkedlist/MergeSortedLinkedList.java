package com.gs.linkedlist;

public class MergeSortedLinkedList {
    /*
       initialize dummy node , we are going to send dummy.next as result
       assign dummy node to result node.
       while(both n1 and n2 is not null){
          compare n1 and n2 value
          if n1 < n2
              result next = n1 and advance n1 to next
          if n2 < n1
              result next = n2 and advance n2 to next
          FINALLY increase advance result to next
       }
       we may have either left over from n1 or n2, assign remaining as result's next
       return dummy.next
     */
	private static Node merge(Node node1, Node node2) { // n1 : 1, 2, 5, 7, 9 &  n2 : 1, 3, 6, 8
		if(node1 == null) return node2;
		if(node2 == null) return node1;
		Node dummy = new Node(-1);
		Node result = dummy; // null 
		while(node1 != null && node2 != null){
			if(node1.val < node2.val){ 
				result.next = node1; // -1 -> 1 -> 2 -> 3 -> 
				node1 = node1.next; // @2, 5..  @5,9 , @9
			}else{
				result.next = node2; // -1 -> 1 -> 1 -> 2 -> 3
				node2 = node2.next; // @3, 6...  , @ 6,8,...
			}
			result = result.next; // very important // 1 1 2
		}
		if(node1 != null) result.next = node1;
		if(node2 != null) result.next = node2;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 5, 7, 9};
	    Node head = LinkedListBuilder.build(nums);
	    int[] nums2 = {1, 3, 6, 8};
	    Node head2 = LinkedListBuilder.build(nums2);
	    Node merge = merge(head, head2);
	    System.out.println("MERGE " + merge);
	}
}
