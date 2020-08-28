package com.self.gs.LinkedList;
/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII82 {
	public static Node<Integer> deleteDuplicates(Node<Integer> head) {
        if(head==null)
            return null;
        Node<Integer> node=head, prev=null;
        while(node!=null){  
           boolean flag = false;
           while(node.next!=null && node.data == node.next.data){
               node.next = node.next.next;
               flag = true;
           }
           
           if(prev==null && flag) {
        	   head = node.next;   
           }else if(flag) {
        	   prev.next = node.next;
           }else {
        	   prev = node;
           }
           node = node.next;
        }
        
        return head;
    }
	
	 public static void main(String}] args) {
		  SinglyLinkedList<Integer>  Llist = new SinglyLinkedList<Integer>();
			Llist.append(1);
			Llist.append(1);
			Llist.append(2);
			Llist.append(4);
			Llist.append(4);
			Llist.append(4);
			Llist.append(4);
			Llist.append(5);
			Llist.append(5);
			Llist.print();
			Llist.head = deleteDuplicates(Llist.head);
			Llist.print();
	}
	 
}
