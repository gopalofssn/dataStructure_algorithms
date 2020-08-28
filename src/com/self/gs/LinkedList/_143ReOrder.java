package com.self.gs.LinkedList;

public class _143ReOrder {
	// 1 2 3 4 5 6
    // get second half 4 5 6
    // reverse 6 5 4
    // merge 1 6 2 5 3 4 - untill second half null
    public static  void reorderList(ListNode head) {
        
        if(head == null || head.next == null){
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }

        ListNode reverse = reverse(slow.next);
        slow.next = null;

        head = mergeList(head ,reverse);
        
        
    }
    
    private static ListNode mergeList(ListNode l1, ListNode l2) {
    	
    	System.err.println("l1 - " + l1.toString());
    	System.err.println("l2 - " + l2.toString());
    	
		ListNode node = new ListNode(-1);
		ListNode tmp = node;
		while(l1 != null && l2 != null) {
			 tmp.next = l1;
			 l1 = l1.next;
			 tmp = tmp.next;
			 
			 tmp.next = l2;
			 l2 = l2.next;
			 tmp = tmp.next;
			 
		}
		
		if(l1 != null) {
			tmp.next = l1;
		}else {
			tmp.next = l2;
		}
		//System.err.println("merge - " +  node.toString());
		return node.next;
		
	}
/*
   1 2 3 4 5
   s
   f
     s f
       s   f           
 */
	private static ListNode getHalf(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //System.err.println("half - " + slow.next.toString());
        return slow.next;
    }
    
    private static ListNode reverse(ListNode half){
        if(half == null){
            return half;
        }
        
        ListNode reverse = null;
        while(half != null){
            ListNode tmp = half.next;
            half.next = reverse;
            reverse = half;
            half = tmp;
        }
        System.err.println("reverse - " + reverse.toString());
        return reverse;
    }
    
    public static void main(String}] args) {
    	ListNode head = new ListNode(1);
    	head.append(2);
    	head.append(3);
    	head.append(4);
    	head.append(5);
    	//head.append(6);
    	
    	System.err.println(head.toString());
    	reorderList(head);
    	System.err.println(head.toString());
    	
    	
	}
}
