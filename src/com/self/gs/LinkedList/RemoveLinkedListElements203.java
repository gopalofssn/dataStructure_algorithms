package com.self.gs.LinkedList;

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
   public static ListNode removeElements(ListNode head, int val) {
       if(head == null)
    	   return head;
       while(head!=null && head.val==val) { // uc 1
    	   head = head.next;
       }
       ListNode node = head;
       while(node!=null) {
    	   while(node.next!=null && node.next.val==val) {  // when we at node 2, we know next node has val 6 , so skip also check uc 3
    		  node.next = node.next.next;   // 
       	   System.err.println(head.toString());
    	   }
           node = node.next;   
       }
	   return head;
    }

	public static void main(String[] args) {
		  ListNode root = new ListNode(1);
		  root.next = new ListNode(2);
		  root.next.next = new ListNode(6);
		  root.next.next.next = new ListNode(6);
		  root.next.next.next.next = new ListNode(4);
		  root.next.next.next.next.next = new ListNode(5);
		  root.next.next.next.next.next.next = new ListNode(6);
		  System.err.println("IP :" + root.toString());
		  root = removeElements(root,6);
		  if(root!=null)
		   System.err.println("OP :" + root.toString());
	}

}
