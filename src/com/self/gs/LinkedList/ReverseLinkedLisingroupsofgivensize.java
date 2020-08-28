package com.self.gs.LinkedList;

/*
Input: 1->2->3->4->5->NULL k =2
Output: 2->1->4->3->5

Input: 1->2->3->4->5->6->7->8->9->10->NULL k =4
Output: 4->3->2->1->8->7->6->5->10->9->NULL

 */


public class ReverseLinkedLisingroupsofgivensize {
  
    static Node<String> groupReverse(Node<String> head, int k) {
    	Node<String> node = head,result = new Node<String>("DUMMY"), chunkHead = null , chunkTail = null;
    	int count=0;
    	while(node!=null) {
    		Node<String> tmp = node.next;
    		count++;
    		if(count==k) {
    			
    		}else {
    	  	 node.next = result;
    		 result = node;
    		}
    		node = tmp;
    	}
    	
    	return result.next;
	}
	
	public static void main(String}] args) {
		SinglyLinkedList<String>  Llist = new SinglyLinkedList<String>();
		Llist.append("a");
		Llist.append("b");
		Llist.append("c");
		Llist.append("d");
		Llist.append("e");
		Llist.append("f");
		Llist.print();
		Llist.head = groupReverse(Llist.head,2);
		Llist.print();
	}

	
}
