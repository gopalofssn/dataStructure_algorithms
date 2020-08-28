package com.self.gs.LinkedList;
import java.util.*;
/*
  1 2 3  + 1 == 1 2 4
  9 9 9 + 1 == 1 0 0 0
 * 
 */


public class Add1ToLinkedList {

	/*
	 
	 Ex 1 0 0
	 Stack:
	   0
	   0 0
	   1 0 0
	   
	   res : 1 0 1 , without 
	  
	 Ex 9 9 9
	 Stack       == 
	   9                0
	   9 9              0 0
	   9 9 9            0 0 0
	                  1 0 0 0
	                  
	   Ex 1 0 9
	   Stack       == 
	       9              0
	       0 9            1 0
	       1 0 9          
	          return 1 1 0   
	   
	 */
	private static ListNode addOne(ListNode head) {

		Stack<ListNode> stack = new Stack<ListNode>();
		
		ListNode node = head;
		while(node !=null) {
			 stack.push(node);
			node = node.next;
		}
		
		
		int carry = 2;
		while(!stack.isEmpty()) {
			if(stack.peek().val + carry <= 9) {
				stack.peek().val = stack.peek().val  + carry;
				return head;
			}
			
			int tmp = stack.peek().val  + carry;
			stack.pop().val = tmp  % 10;
			carry = tmp / 10;
			
		}
		
		if(carry != 0) {
			ListNode newHead = new ListNode(carry);
			newHead.next = head;
			head = newHead;
		}
		
       return head;
	}

	public static void main(String}] args) {
		
		ListNode root = new ListNode(9);
		root.append(9);
		root.append(8);
		System.err.println(root.toString());
		
		System.err.println(addOne(root).toString());	
		 
	}

	
}
