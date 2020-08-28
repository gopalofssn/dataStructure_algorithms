package com.self.gs.LinkedList;
/*
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation:  807
 
  1
  342
  465 
  ---
  807
  ---
  
  carry = sum/10 - divided by 7/10 = 0 , 10/10 = 1
  val = sum%10 - mod  , 7mod10 = 7 , 11mod10 = 1, 
  
  
 Time/Space Complexity
 ---------------------
Time Complexity: O(m + n)
Space Complexity: O(m + n)

  */


public class AddTwoNumber {
	
	static ListNode addLinkedList(ListNode m,ListNode n) {
		ListNode dummyNode = new ListNode(-1);
		ListNode tail = dummyNode;
		int carry = 0;
		while(m!=null || n!=null || carry !=0) { // carry is still 1 after everything , set new node at end
			int val = carry;
			if(m!=null) {
				val += m.val;
				m = m.next;
			}
			if(n!=null) {
				val += n.val;
				n = n.next;
			}
			
			carry = val/10;
			val = val%10;
			tail.next = new ListNode(val);
			tail = tail.next;
		}
		
	 return dummyNode.next;	
	}
	
    static ListNode add(ListNode m, ListNode n) {
		if(m==null && n==null)
			throw new IllegalArgumentException("Both Linked List are null !!! ");
		else if(m==null && n!=null)
			return n;
		else if(m!=null && n==null)
			return m;
		
		return addLinkedList(m,n);
	}
 public static void main(String}] args) {
	  ListNode root1 = new ListNode(2);
	  root1.next = new ListNode(4);
	  root1.next.next = new ListNode(9);
	  ListNode root2 = new ListNode(5);
	  root2.next = new ListNode(6);
	  root2.next.next = new ListNode(4);
	  
	  System.out.print(add(root1,root2).toString());

}
}
