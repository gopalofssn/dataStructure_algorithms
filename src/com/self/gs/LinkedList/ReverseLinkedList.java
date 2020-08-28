package com.self.gs.LinkedList;

/*
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
 */


public class ReverseLinkedList {
	
	//input  : 0->1->2->3->4->5->null
	//output : 5->4->3->2->1->0->null
	public Node<Integer> reverse(Node<Integer> head) {
		if(head==null)
			return head;
		Node<Integer> result = null;
		while(head!=null) {
			Node<Integer> next = head.next ;  // 1->2->3->4->null, 2->3->4->null
			head.next = result; // 0->NULL, 1->0->NULL
			result = head; // 0->NULL, 
			head = next;
		}
		return result;
	}
	
	public static void main(String}] args) {
		SinglyLinkedList<Integer>  Llist = new SinglyLinkedList<Integer>();
		Llist.append(1);
		Llist.append(2);
		Llist.append(4);
		Llist.append(5);
		Llist.prepend(0);
		Llist.insertAt(3, 3);
		Llist.append(6);
		Llist.append(7);
		Llist.append(8);
		Llist.append(9);
		Llist.print();
		System.out.println("LL size - " + Llist.size);
		System.out.println("Reversing all...");
		Node<Integer> reversed = new ReverseLinkedList().reverse(Llist.head);
		Llist.head = reversed;
		Llist.print();
	}

}
