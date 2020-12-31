package com.gs.linkedlist.random;

public class RandomNode {
	int val;
	RandomNode next;
	RandomNode random;
	boolean isDeepCopy;
	
	public RandomNode(int val){
		this.val = val;
	}
	
	public RandomNode(int val, boolean isDeepCopy){
		this.val = val;
		this.isDeepCopy = isDeepCopy;
	}
	
	public String toString(){
		RandomNode current = this;
		StringBuilder sb = new StringBuilder();
		while(current != null){
			sb.append(current.val)
			  .append(current.isDeepCopy? "(T)" : "(F)")
			  .append("->");
			/*sb.append("->");
			  if(current.next != null) sb.append("N(" + current.next.val + ")");
			  if(current.random != null) sb.append("R(" + current.random.val + ")");*/
			current = current.next;
		}
		sb.append("NULL");
		String result = "NEXT - " + sb.toString();
		
		current = this;
		sb = new StringBuilder();
		while(current != null){
			if(current.random != null){
				sb.append(current.random.val)
				  .append(current.random.isDeepCopy? "(T)" : "(F)")
				  .append("->");
			}
			current = current.next;
		}
	    result = result + "\t RANDOM - " + sb.toString();
		return result ;
	}
}
