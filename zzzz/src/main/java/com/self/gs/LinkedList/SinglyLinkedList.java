package com.self.gs.LinkedList;

public class SinglyLinkedList<T> {

	Node<T> head;
	int size=0;
	
	public void append(T val) {
		Node<T> node = new Node<T>(val);
		if(head==null) {
			head = node;
			increaseSize();
		}else {
			Node<T> temp = head;
			while(temp.next!=null) { // iterate one by one and reach last element 
				temp = temp.next;
			}
			temp.next = node; // then assign node to last element
			increaseSize();
		}
	}

	private void increaseSize() {
		size = size+1;
	}
	
	public void prepend(T val) {
		Node<T> node = new Node<T>(val);
		Node<T> temp = head; // assign head to temp 
		head = node; // assign new node as head 
		head.next = temp;   // point head's next as temp
		increaseSize();
	}
	
	public void insertAt(int position , T val) {
		if(head==null && position<=0) {
			return;
		}else {
			int i = 0;
			Node<T> temp = head;
			while(temp.next!=null) {
				if(i++==position) {
					Node<T> node = new Node<T>(val);
					node.next = temp.next;
					temp.next = node;
					increaseSize();
					break;
				}
				temp = temp.next;
			}
		}
	}
	
	
	
	
	public void print() {
		if(head==null)
			return;
		Node<T> temp = head;
		while(temp.next!=null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print(temp.data+"\n");
	}
	
	public void printNodes(Node<T> node) {
		if(node==null)
			return;
		Node<T> temp = node;
		while(temp.next!=null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print(temp.data+"\n");
	}
}
