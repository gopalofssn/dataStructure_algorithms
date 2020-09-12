package com.gs.linkedlist;

public class Node {
	int val;
	Node next;

	public Node(int val){
		this.val = val;
	}

	public String toString(){
		Node current = this;
		StringBuilder sb = new StringBuilder();
		while(current != null){
			sb.append(current.val);
			sb.append("->");
			current = current.next;
		}
		sb.append("NULL");
		return sb.toString();
	}
}
