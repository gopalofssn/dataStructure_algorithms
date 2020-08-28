package com.self.gs.LinkedList;

public class MiddleNode {
	
	private static void middle(Node<Integer> head) {
		
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		
		while( fast !=null && fast.next!=null) {
			slow = slow.next;
			fast =fast.next.next;
		}
		System.out.print("middle node is - " + slow.data);
	}
	
	
public static void main(String}] args) {
	SinglyLinkedList<Integer>  Llist = new SinglyLinkedList<Integer>();
	Llist.append(1);
	Llist.append(2);
	Llist.append(3);
	Llist.append(4);
	Llist.append(5);
	Llist.append(6);
	Llist.append(7);
	Llist.append(8);
	Llist.append(9);
	Llist.append(10);
	Llist.append(11);
	Llist.print();
    middle(Llist.head);
}


}
