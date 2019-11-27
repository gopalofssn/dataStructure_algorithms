package com.self.gs.LinkedList;

/*
i/p : 1->2->4->4->4->4->5
o/p : 1->2->4->5
 */
public class RemoveDuplicateSortedList {
	

	private static void removeDuplicate(Node<Integer> head) {
		Node<Integer> node = head;
		 while(node!=null ) {//&& node.next!=null) {  // 1 2
			 System.out.println(node.data);
			 while(node.next!=null && node.data == node.next.data) { // 5 
				 node.next = node.next.next; // 
			 }
				 node = node.next;
			 
			 
		 }
		
	}

  public static void main(String[] args) {
	  SinglyLinkedList<Integer>  Llist = new SinglyLinkedList<Integer>();
		Llist.append(1);
		Llist.append(2);
		Llist.append(4);
		Llist.append(4);
		Llist.append(4);
		Llist.append(4);
		Llist.append(5);
		Llist.append(5);
		Llist.print();
		removeDuplicate(Llist.head);
		Llist.print();
}

}
