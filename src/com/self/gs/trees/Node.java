package com.self.gs.trees;

import java.util.ArrayList;
import java.util.List;

public class Node{
   public int val;
   public List<Node> children = new ArrayList<Node>();
   public Node(int val) {
	   this.val = val;
   }
   public Node(int val , List<Node> children) {
	   this.val = val;
	   this.children = children;
   }
	public void addChildren(Node node) {
		if(node!=null)
			this.children.add(node);	
	}
}
