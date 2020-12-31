package com.self.gs.LinkedList;

public class Node<T> {
	T data;
	Node<T> next;
	public Node(T val) {
		this.data = val ;
		this.next = null;
	}
	
	public String toString() {
		String str="";
		if(this==null)
			return str;
		Node<T> temp = this;
		while(temp.next!=null) {
			str = str + temp.data + "->";
			temp = temp.next;
		}
		return str + temp.data;
	}
}
