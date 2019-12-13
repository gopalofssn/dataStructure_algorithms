package com.self.gs.LinkedList;

import java.util.*;
/*
 Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedList {
	 
	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists==null || lists.length==0)
			return null;
		ListNode result = null;
		for(int i=0;i<lists.length;i++) {
			result = mergeListsRecurssive(result,lists[i]);
			//result = mergeListsIterative(result,lists[i]);
		}
		return result;
	}

	private static ListNode mergeListsIterative(ListNode result, ListNode listNode) {
		// TODO Auto-generated method stub
		return null;
	}

	private static ListNode mergeListsRecurssive(ListNode l1, ListNode l2) {
		 if(l1==null)
			 return l2;
		 if(l2==null)
			 return l1;
		 if(l1.val<l2.val) {
			 l1.next = mergeListsRecurssive(l1.next,l2);
			 return l1; 
		 }else {
			 l2.next = mergeListsRecurssive(l1,l2.next);
			 return l2;
		 }
			 
	}

	public static void main(String[] args) {
		ListNode[] lists = new ListNode[4];
		ListNode a = new ListNode(1);
		a.next = new ListNode(4);
		a.next.next = new ListNode(5);
		lists[0] = a;
		ListNode b = new ListNode(1);
		b.next = new ListNode(3);
		b.next.next = new ListNode(4);
		lists[1] = b;
		ListNode c = new ListNode(2);
		c.next = new ListNode(6);
		lists[2] = c;
		lists[3]= null;
		System.err.println(mergeKLists(lists).toString());
	}
}
