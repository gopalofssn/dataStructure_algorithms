package com.self.gs.LinkedList;
/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
                
Output: 1->2->2->3->4->5
 */
public class PartitionList86 {

	public static Node<Integer> partition(Node<Integer> head, int x) {
        if(head==null)
            return null;
        Node<Integer> node=head, leftHead=null,leftTail=null,rightHead=null,rightTail=null;
        while(node!=null){
        	Node<Integer> tmp = node.next; // save for next iteration
           node.next = null; // beacuse we should place only head a.k.a current node;
           if(node.data<x){
               if(leftHead==null){
                   leftHead = node;
                   leftTail = node;
               }else{
                  leftTail.next = node;
                  leftTail = leftTail.next;
               }
           }else{
               if(rightHead==null){
                   rightHead = node;
                   rightTail = node;
               }else{
                   rightTail.next = node;
                   rightTail = rightTail.next;
               }
           }
           node = tmp; // assign back to next iteration
        }
      
     if(leftHead==null){
         return rightHead;
     }
     leftTail.next = rightHead;
     return leftHead;   
    }
	
 public static Node<Integer> partition1(Node<Integer> head1, int x) {
      if(head1==null)  
    	  return null;
      Node<Integer> node = head1;
      Node<Integer> leftHead=null,leftTail=null,rightHead=null,rightTail=null,middleHead=null,middleTail=null;
      while(node!=null) {
    	 // preserve to travel next node ,
    	  Node<Integer> tmp = node.next; 
    	  node.next = null;
    	  
    	  // below condition put node in right place.
    	  if(node.data<x) {
    		  if(leftHead==null) {
    			  leftHead = node;
    			  leftTail = node;
    		  }else {
    			  leftTail.next = node;
    			  leftTail = leftTail.next;
    		  }
    	  }else if(node.data==x) {
    	        if(middleHead==null) {
    	        	middleHead = node;
    	        	middleTail = node;
    	        }else {
    	        	middleTail.next = node;
    	        	middleTail = middleTail.next;
    	        }  
    	  }else {
    		  if(rightHead==null) {
    			  rightHead = node;
    			  rightTail = node;
    		  }else {
    			  rightTail.next = node;
    			  rightTail = rightTail.next;
    		  }
    	  }
    	//move on to next
    	  node = tmp;
      }
      
      
      if(leftHead==null && middleHead==null) {
    	  return rightHead;
      }else if(leftHead==null && middleHead!=null) {
    	  middleTail.next = rightHead;
    	  return middleHead;
      }else {
          if(rightHead!=null && middleHead!=null) {
        	  middleTail.next = rightHead; 
        	  leftTail.next = middleHead;
          }else if(middleHead==null) {
        	  leftTail.next = rightHead;
          }
	      return leftHead;
      }
    }
 
  public static void main(String[] args) {
	  SinglyLinkedList<Integer>  Llist = new SinglyLinkedList<Integer>();
		Llist.append(1);
		Llist.append(4);
		Llist.append(3);
		Llist.append(2);
		Llist.append(5);
		Llist.append(3);
		Llist.append(2);
		Llist.print();
		Llist.head = partition(Llist.head,3);
		Llist.print();
}
}
