package com.self.gs.LinkedList;
import java.util.*;
/*
 * 
 a->b->c->d->e->f->g->h->i->j
       3     5
    a b stack}c,d,e] f g h i
      perv.next = o/p from stck , stack.next = node.next
    
 */
public class ReverseLinkedListII {
	 
	private static class ListNode {
		      int val;
		      ListNode next;
			  ListNode(int val) { 
		    	  this.val = val; 
		      }
			  
			@Override
			public String toString() {
				if(this == null) return "NULL";
				return this.val + "->" + next ;
			}
     
	}
	
	/*
	    
	 
	 */
	private static ListNode reverse(ListNode head, int m, int n) { 
			if(head == null || m > n) return head;
        
        ListNode prev = null;
        ListNode node = head;
        while(node != null && m > 1){
            prev = node;
            node = node.next;
            m--;
        }
        
        int totalNodeToReverse = (n - m);
        ListNode reversedAndRemainingsNodes = reverseBetweenHelper(node , totalNodeToReverse);
        
        if(prev == null){
            return reversedAndRemainingsNodes;
        }else{
            prev.next = reversedAndRemainingsNodes;
            return head;
        }
    }
    
    private static ListNode reverseBetweenHelper(ListNode node , int totalNodeToReverse){
        ListNode originalNode = node; // 2->...
        ListNode reversedNode = null;
        while(node !=null && totalNodeToReverse > 0){
            ListNode nextNode = node.next;
            node.next = reversedNode;
            reversedNode = node;
            node = nextNode;
            totalNodeToReverse--;
        }
       
        // concat reversed node and remaining nodes 4->3->2-null , 5->null
        originalNode.next = node;
        System.err.println(reversedNode);
        return reversedNode; // 4->3->2->5->NULL
    }



	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		//root.next.next = new ListNode(3);
		//root.next.next.next = new ListNode(4);
		//root.next.next.next.next = new ListNode(5);
	
		System.out.println(root.toString());
		
		root = reverse(root, 1, 2);
		
		System.out.println(root.toString());
		
	}
	
}
