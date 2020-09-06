package com.gs.linkedlist.random;

public class RandomNode {
	int val;
	RandomNode next;
	RandomNode random;
	
	public RandomNode(int val){
		this.val = val;
	}
	
	public String toString(){
		RandomNode current = this;
		StringBuilder sb = new StringBuilder();
		sb.append(current.val);
		while(current != null){
			sb.append("->");
			if(current.next != null) sb.append("N(" + current.next.val + ")");
			if(current.random != null) sb.append("R(" + current.random.val + ")");
			current = current.next;
		}
		sb.append("NULL");
		return sb.toString();
	}
}
