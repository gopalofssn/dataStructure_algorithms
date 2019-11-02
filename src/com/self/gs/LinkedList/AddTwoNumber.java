package com.self.gs.LinkedList;

//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807

class Node{
	int data;
	Node next;
	public Node(int val) {
		this.data = val ;
		this.next = null;
	}
}

class SinglyLinkedList{
	Node head;
	
	public void append(int val) {
		Node node = new Node(val);
		if(head==null) {
			head=node;
		}else {
			Node temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	public void prepend(int val) {
		Node node = new Node(val);
		if(head==null) {
			head=node;
		}else {
			Node temp = head;
			head = node;
			head.next = temp;
		}
	}
	
	public void insert(int val, int position) {
		Node node = new Node(val);
		if(position==0) {
			head = node;
		}else if(position>size()){
			System.out.println("\n Position "+position + " is greate than LinkedList size " + size());
			return;
		}else {
			Node temp = head;
			 for(int i=1;i<position;i++) {
				 temp = temp.next;
			 }
			 node.next = temp.next;
			 temp.next = node;
		}
	}
	
	public int size() {
		if(head == null) {
			return 0;
		}else {
			int count = 0;
			Node temp = head;
			while(temp.next!=null) {
				++count;
				temp =temp.next;
			}
			
			return count;
		}
	}

	public void print() {
		if(head==null)
			return;
		System.out.print(head.data);
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
			System.out.print("-->"+temp.data);
		}
	}
	
	public int reverseVal() {
		if(head==null)
			return 0;
		int result = head.data;
		Node temp = head;
		int multiple = 1;
		while(temp.next!=null) {
			temp = temp.next;
			multiple = multiple *10;
			result = result + (temp.data * multiple);
		}
		
		return result;
	}
	
	public void reverse(int val) {
		if(val==0) {
			return;
		}else {
			while(val>0) {
				int data = val%10;
				append(data);
				val = val /10;
			}
		}
	}
}

public class AddTwoNumber {
 public static void main(String[] args) {
	 SinglyLinkedList list = new SinglyLinkedList();
	list.append(2);
	list.append(3);
	list.append(5);
	list.prepend(1);
	list.print();
	int list1Reverse = list.reverseVal();
	System.out.println("\n Reversed Val - "+list1Reverse);
	SinglyLinkedList list2 = new SinglyLinkedList();
	list2.append(4);
	list2.append(1);
	list2.append(2);
	list2.print();
	int list2Reverse = list2.reverseVal();
	System.out.println("\n Reversed val - "+list2Reverse);
	
	int total = list1Reverse + list2Reverse;
	System.out.println("Total - " + total);
	
	SinglyLinkedList list3 = new SinglyLinkedList();
	
	list3.reverse(total);
	list3.print();

}
}
