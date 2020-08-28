package com.self.gs.trees;

import java.util.*;

public class NaryTreePreorderTraversal589 {

	public static List<Integer> preorderRecurssive(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        recurssive(root,result);
        return result;
    }
    
    private static void recurssive(Node node , List<Integer> result){
        if(node == null)
            return;
        result.add(node.val);
        if(node.children!=null && node.children.size()>0){
            for(Node tmp:node.children){
                recurssive(tmp,result);
            }
        }
    }
    
    // root left right
	private static List<Integer> preorderIterative(Node root) {
		 List<Integer> result = new ArrayList<Integer>();
	        if(root == null)
	            return result;
	        Stack<Node> stack = new Stack<Node>();
	        stack.push(root);
	        while(!stack.isEmpty()) {
	        	Node node = stack.pop();
	        	result.add(node.val);
	        	if(node.children!=null && node.children.size()>0){
	                for(int i = node.children.size()-1; i>=0;i-- ){
	                    stack.add(node.children.get(i)) ;
	                }
	            }
	        }
	        return result;
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
		System.err.println(preorderRecurssive(node));
		System.err.println(preorderIterative(node));
	}


}
