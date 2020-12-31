package com.self.gs.trees;
import java.util.*;

class IncorrectInputException extends RuntimeException{
	private String msg;
	public IncorrectInputException() {}
	public IncorrectInputException(String _msg) {msg = _msg;}
}

public class LCAinBST {

	 
	 /*
	  All of the nodes' values will be unique.
       p and q are different 
            1. if values exists , return anchestor 
            2. if not exists, throw custom unchecked exception

	  */
	
	

	private static int find(TreeNode node, TreeNode p, TreeNode q) {
		if(node.val>p.val && node.val>q.val) {
			return find(node.left,p,q);
		}else if(node.val<p.val && node.val < q.val) {
			return find(node.right,p,q);
		}else {
		  return checkIfPresent(node,p,q);
		}
	}

	private static int checkIfPresent(TreeNode node, TreeNode p, TreeNode q) {
		int anchestor = node.val;
		Queue<TreeNode> queue  = new LinkedList<TreeNode>();
		boolean isPpresent = false;
		boolean qPresent = false;
		queue.add(node);
		while(!queue.isEmpty()) {
			int sz = queue.size();
			for(int i=0; i<sz; i++) {
				TreeNode t = queue.poll();
				if(t.val == p.val)
					isPpresent = true;
				if(t.val == q.val)
					qPresent = true;
				
				if(isPpresent && qPresent)
					return anchestor;
				
				if(t.left!=null)
					queue.add(t.left);
				if(t.right!=null)
					queue.add(t.right);
				
			}
		}
		
		
	  throw new IncorrectInputException("Either P and/or Q is not in BST");
	}

	public static void main(String}] args) {
		String str = "6,2,8,0,4,7,9,X,X,3,5";
		TreeNode node = SerializeandDeserializeBinaryTree297.deserialize(str);
		System.err.println(find(node,new TreeNode(2),new TreeNode(8)));
		System.err.println(find(node,new TreeNode(-2),new TreeNode(4)));
	}
}
