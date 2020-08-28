package com.self.gs.LinkedList;

public class MergeTwoLinkedRecussivelyList {
	
	public static Node<Integer> mergeListRecursively(Node<Integer> l1, Node<Integer> l2) {
		  if(l1==null||l2==null)
			  return l1==null?l2:l1;
		  
		  if(l1.data<=l2.data) {
			  l1.next = mergeListRecursively(l1.next,l2);
			  return l1;
		  }else {
			  l2.next = mergeListRecursively(l1,l2.next);
			  return l2;
		  }
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
	
		SinglyLinkedList<Integer>  Llist3 = new SinglyLinkedList<Integer>();
		Llist3.head= mergeListRecursively(Llist1.head,Llist2.head);
		Llist3.print();
		
}

		
}
