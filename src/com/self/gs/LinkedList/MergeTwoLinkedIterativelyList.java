package com.self.gs.LinkedList;

public class MergeTwoLinkedIterativelyList {
	static SinglyLinkedList<Integer>  Llist = new SinglyLinkedList<Integer>();
	public static Node<Integer> merge(Node<Integer> l1, Node<Integer> l2) {
		 if(l1==null || l2==null) return l1==null? l2 : l1;
		 
		 Node<Integer> fakeHead = new Node<Integer>(0);
		 Node<Integer> current = fakeHead;
		 
		    while (l1 != null && l2 != null) {
		        if (l1.data <= l2.data) {
		            current.next = l1;
		            l1 = l1.next;
		        } else {
		            current.next = l2;
		            l2 = l2.next;
		        }
		        current = current.next;
		    }
		    
		    if (l1 == null) 
		    	current.next = l2;
		    if (l2 == null)
		    	current.next = l1;
		    
		    return fakeHead.next;
      }

	
  public static void main(String}] args) {
	  SinglyLinkedList<Integer>  Llist1 = new SinglyLinkedList<Integer>();
		Llist1.append(1);
		Llist1.append(2);
		Llist1.append(5);
		Llist1.append(7);
		
		SinglyLinkedList<Integer>  Llist2 = new SinglyLinkedList<Integer>();
		Llist2.append(3);
		Llist2.append(4);
		Llist2.append(8);
		Llist2.append(9);
		Llist2.append(11);
		Llist2.append(12);
	
		SinglyLinkedList<Integer>  Llist3 = new SinglyLinkedList<Integer>();
		Llist3.head= merge(Llist1.head,Llist2.head);
		Llist3.print();
		
}

		
}
