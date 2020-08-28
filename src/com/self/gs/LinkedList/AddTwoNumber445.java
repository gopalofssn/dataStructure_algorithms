package com.self.gs.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;
/*
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

7243
 564(+)
----
7807
  
  stack1    stack2    ==  build ListNode but with reverse option
  -----     ---- 
  3          4              7 
  4          6              0
  2          5              8
  7                         7
  */


public class AddTwoNumber445 {
	
	static ListNode addLinkedList(ListNode m,ListNode n) {
		//Deque<Integer> mDeque = new ArrayDeque<Integer>(); // deque work as stack 
		Stack<Integer> mStack = new Stack<Integer>();
		//Deque<Integer> nDeque = new ArrayDeque<Integer>();
		Stack<Integer> nStack = new Stack<Integer>();
		while(m!=null) {
			//mDeque.push(m.val);
			mStack.add(m.val);
			m = m.next;
		}
		
		while(n!=null) {
			//nDeque.push(n.val); // push method to make stack
			nStack.add(n.val);
			n = n.next;
		}
		System.err.println(mStack + " & " + nStack);
		
		ListNode result = null, temp=null;
		int carry =0;
		//while(!mDeque.isEmpty() || !nDeque.isEmpty() || carry!=0) {
		while(!mStack.isEmpty() || !nStack.isEmpty() || carry!=0) {
			int val = carry;
			if(!mStack.isEmpty())
			  val += mStack.pop(); // pop method take from top
			if(!nStack.isEmpty())
			  val += nStack.pop();
			
			carry = val/10;
			val = val%10;
			ListNode node = new ListNode(val); // 7 -> null , 0->null
			temp = result;    // null  ,  7-> null
			result = node; // 7 , 0 - null
			result.next = temp; // 7 -> null , 0 -> 7 -> null
 
		}
		
		return result;
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
	  ListNode root1 = new ListNode(7);
	  root1.next = new ListNode(2);
	  root1.next.next = new ListNode(4);
	  root1.next.next.next = new ListNode(3);
	  
	  ListNode root2 = new ListNode(5);
	  root2.next = new ListNode(6);
	  root2.next.next = new ListNode(4);
	  
	  System.out.print(add(root1,root2).toString());

}
}
