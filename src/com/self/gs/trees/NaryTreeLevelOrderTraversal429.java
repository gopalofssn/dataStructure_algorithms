package com.self.gs.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal429 {

	public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
           int qSize = queue.size();
           List<Integer> elements = new ArrayList<Integer>();
           for(int i=0 ; i<qSize; i++){
               Node node = queue.poll();
               elements.add(node.val) ;
               if(node.children!=null && node.children.size()>0){
                   queue.addAll(node.children);
               }
           }
          result.add(elements);
        } 
        return result;
    }
	public static void main(String[] args) {
		Node node = new Node(1);
		List<Node> list = new ArrayList<Node>() {{ 
			add(new Node(5));
			add(new Node(6)); 
		 }};
		node.addChildren(new Node(3,list));
		node.addChildren(new Node(2));
		node.addChildren(new Node(4));
		System.err.println(levelOrder(node));
		
	}

}
