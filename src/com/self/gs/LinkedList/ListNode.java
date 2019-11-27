package com.self.gs.LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	ListNode node = this;
    	while(node!=null) {
    		sb.append(node.val+"->");
    		node = node.next;
    	}
    	sb.append("NULL");
    	return sb.toString();
    }
}
