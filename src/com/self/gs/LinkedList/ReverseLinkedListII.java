package com.self.gs.LinkedList;
import java.util.*;
/*
 * 
 a->b->c->d->e->f->g->h->i->j
       3     5
    a b stack[c,d,e] f g h i
      perv.next = o/p from stck , stack.next = node.next
    
 */
public class ReverseLinkedListII {
	public static SinglyLinkedList<String> Llist = new SinglyLinkedList<String>();

	
	private Node<String> reverse(Node<String> head, int m, int n) {

        if(head==null){
            return head;
        }
        Node<String> node = head,prev = null;
        int count = 0;
        boolean flag = true;
        Stack<Node<String>> stack = new Stack<Node<String>>();
        while(node!=null && flag){
        	Node<String> tmp = node.next;

            count++;
            if(count>=m && count<=n){
            	System.out.println("node data" + node.data);
            	Node<String> nd = node;
            	nd.next = null;
            	stack.add(nd);
            }else{
              prev = node;   // until finding 
            }  
            
            if(count==n)
            	flag = false;
            
            node = tmp;
        }
        
        while(!stack.empty()) {
        	Node<String> tmp = stack.pop();
        	
        	prev.next = tmp;
        	prev = prev.next;
        }
        
        prev.next = node;
        
        return head;
	}

	public static void main(String[] args) {
		Llist.append("a");
		Llist.append("b");
		Llist.append("c");
		Llist.append("d");
		Llist.append("e");
		Llist.append("f");
		Llist.append("g");
		Llist.append("h");
		Llist.append("i");
		Llist.append("j");
		Llist.print();
	
		Node<String> reversed = new ReverseLinkedListII().reverse(Llist.head,3,5);
		Llist.head = reversed;
		Llist.print();
	}
	
}
