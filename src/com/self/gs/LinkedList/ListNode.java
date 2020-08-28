package com.self.gs.LinkedList;


public class ListNode {
    public int val;
    public ListNode next ;
    public ListNode(int _val) {
        val = _val;
        next = null;
    }
    
    public void append(int _val) {
    	ListNode node = this;
    	while(node.next != null) {
    		node = node.next;
    	}
    	node.next = new ListNode(_val);
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
