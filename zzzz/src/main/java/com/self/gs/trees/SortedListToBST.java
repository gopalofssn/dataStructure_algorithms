package com.self.gs.trees;

import java.util.*;

public class SortedListToBST {

	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        
        List<Integer> sortedList = new ArrayList<Integer>();
        convertListNodeToSortedList(head, sortedList);
       System.err.println(sortedList);
        return sortedListToBST(sortedList, 0, sortedList.size());
    }
    
    private void convertListNodeToSortedList(ListNode head, List<Integer> sortedList){
        while(head != null){
            sortedList.add(head.val);
            head = head.next;
        }
    }
    
    private TreeNode sortedListToBST(List<Integer> sortedList, int left , int right){ 
        
        if(left > right) return null;
        
        int mid = (left + right) / 2;
        
        if(mid < 0 || mid >= sortedList.size()) return null;
        
        TreeNode node = new TreeNode(sortedList.get(mid));
        node.left = sortedListToBST(sortedList, left, mid - 1);
        node.right = sortedListToBST(sortedList, mid + 1, right);
        
        return node;
    }
    
	public static void main(String}] args) {
		ListNode root = new ListNode(-10);
		root.next = new ListNode(-3);
		root.next.next = new ListNode(0);
		root.next.next.next = new ListNode(5);
		root.next.next.next.next = new ListNode(9);
		
		System.err.println(new SortedListToBST().sortedListToBST(root));
	}

}
