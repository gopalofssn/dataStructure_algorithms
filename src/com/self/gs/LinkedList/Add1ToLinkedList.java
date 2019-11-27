package com.self.gs.LinkedList;

/*
 * 199 + 1 = 200 => [2 0 0]
 * 187 + 1 = 188 
 * 999 + 1 = 1000 => [10 0 0] or [1 0 0 0] =?
 * 
 * -1+1 =0 ? 
 * -199 + 1 = -198?
 *  -100 + 1 = - 99 ? 
s
 * 
 *  9 9 1
 *  
 *  -101 +1 = -100 ? 
 * 
 */
public class Add1ToLinkedList {

	private static Node<Integer> add(Node<Integer> head) {
		if(head == null)
			return null;
		Node<Integer> node = reverse(head), prev = null;
		head = node;
		int carry = 1;
	
		while(node!=null) {
			Node<Integer> temp = node.next;
			int val = node.data + carry; 
			node.data = val%10;
			carry = val/10;
			prev = node;
			node = temp;
		}
		if(carry==1 && prev!=null) {
			prev.next = new Node<Integer>(1);
		}
		return reverse(head);
	}
	
	private static Node<Integer> reverse(Node<Integer> node) {
		Node<Integer> result = null;
		while(node!=null) {
			Node<Integer> temp = node.next;
			node.next = result;
			result = node;
			node = temp;
		}	
		return result;
	}

	public static void main(String[] args) {
	
		
		SinglyLinkedList<Integer>  Llist = new SinglyLinkedList<Integer>();
		Llist.append(-1);
		Llist.append(9);
		Llist.append(9);
		Llist.print();
		Llist.head = add(Llist.head);
		Llist.print();
	}

	
}
