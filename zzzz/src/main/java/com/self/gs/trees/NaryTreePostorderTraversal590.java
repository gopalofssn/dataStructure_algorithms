package com.self.gs.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NaryTreePostorderTraversal590 {

	private static void postOrderRecurssive(Node root, List<Integer> result) {
      if(root==null)
    	  return;
      
      if(root.children!=null && root.children.size()>0) {
    	  for(Node node:root.children){
    		  postOrderRecurssive(node,result);
    	  }
      }
      result.add(root.val);
	}
	
  // left right root 
	private static void postOrderIterative(Node node, List<Integer> result) {
		if(node==null)
	    	  return;
		Stack<Node> stack = new Stack<Node>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
 		stack.add(node);
		while(!stack.isEmpty()) { 
			Node tmp = stack.pop();
			int val = tmp.val;
			//result.add(0,val);    // tricks result.add(0, tmp.val);
			ll.addFirst(val);
			queue.add(val);
			if(tmp.children!=null &&  tmp.children.size()>0) {
				stack.addAll(tmp.children);
			}
		}
		//Collections.reverse(result);
	  
	    result.addAll(ll);
		System.err.println(ll);
	}

	
	
	public static void main(String}] args) {
		Node node = new Node(1);
		List<Node> list = new ArrayList<Node>() {{ 
			add(new Node(5));
			add(new Node(6)); 
		 }};
		node.addChildren(new Node(3,list));
		node.addChildren(new Node(2));
		node.addChildren(new Node(4));
		List<Integer> result = new ArrayList<Integer>();
		postOrderRecurssive(node,result);
		System.err.println(" recurssive - " + result);
		result.clear();
		postOrderIterative(node,result);
		System.err.println("Iterative - " + result);
	}

}
