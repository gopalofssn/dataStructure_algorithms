package com.self.gs.trees;
import java.util.*;
public class SubtreeofAnotherTree572 {
	
	public static boolean isSubtreeBFS(TreeNode s, TreeNode t) {
		if(s==null)
			return false;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(s);
		
		while(!queue.isEmpty()) {
		 
			
			int n = queue.size();
			for(int i=0;i<n;i++) {
				TreeNode current = queue.poll();
				System.out.println("Node data is - " + current.val);
				TreeNode s1 = current;
				 TreeNode t1 = t;
				if( (s1.val == t1.val) && isSameBFS(s1, t1)) {
					
					System.err.println("return...true");
					 return true;
				}
				if(current.left != null)
					queue.add(current.left);
				if(current.right != null)
					queue.add(current.right);
				
			}
		}	
		return false;
	}

	private static boolean isSameBFS(TreeNode s1, TreeNode t1) {
		System.err.println("calling for " + s1.val + "&" + t1.val);
		 Queue<TreeNode> s1Queue = new LinkedList<TreeNode>();
		 s1Queue.add(s1);
		 Queue<TreeNode> t1Queue = new LinkedList<TreeNode>();
		 t1Queue.add(t1);
		 while(!s1Queue.isEmpty() && !t1Queue.isEmpty()) {
			 TreeNode s2 = s1Queue.poll();
			 TreeNode t2 = t1Queue.poll();
		     if(s2.val!=t2.val) {
		    	 break;
		     }
		     if(s2.left!=null)
		    	 s1Queue.add(s2.left);
		     if(t2.left!=null) 
		    	 t1Queue.add(t2.left);
		     if(s2.right!=null) 
		    	 s1Queue.add(s2.right);
		     if(t2.right!=null) 
		    	 t1Queue.add(t2.right); 
		     if(t1Queue.isEmpty() && s1Queue.isEmpty())
		       return  true;
		 }
		 return false;
	}
	
	 /*
	public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) 
        	return false;
        
        if (isSame(s, t))
        	return true;
        return  isSubtree(s.right, t) || isSubtree(s.left, t) ;
    }
    */
    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
  
    /*
	public static boolean isSubtree(TreeNode s, TreeNode t) {
        String spreorder = generatepreorderString(s); 
        String tpreorder = generatepreorderString(t);
        System.err.println(spreorder);
        System.err.println(tpreorder);
        return spreorder.contains(tpreorder) ;
    }
    public static String generatepreorderString(TreeNode s){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stacktree = new Stack();
        stacktree.push(s);
        while(!stacktree.isEmpty()){
           TreeNode popelem = stacktree.pop();
           if(popelem==null)
              sb.append(",#"); // Appending # inorder to handle same values but not subtree cases
           else      
              sb.append(","+popelem.data);
           if(popelem!=null){
                stacktree.push(popelem.right);    
                stacktree.push(popelem.left);  
           }
        }
        return sb.toString();
    } */
 public static void main(String[] args) {
	 TreeNode node = new TreeNode(5);
		node.left = new TreeNode(2);
		node.right = new TreeNode(-3);
		
		
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(1);
		
		node.left.left.left = new TreeNode(1);
		node.left.left.right = new TreeNode(0);
		
		node.left.left.right.left = new TreeNode(-3);
		node.left.left.right.right = new TreeNode(3);
		
		
		node.right.left = new TreeNode(3);
		node.right.right = new TreeNode(3);
		
		
		node.right.right.left = new TreeNode(7);
		node.right.right.right = new TreeNode(8);
		
		TreeNode tnode =  new TreeNode(-3);
	
		tnode.left = new TreeNode(3);
		tnode.right = new TreeNode(3);
		
		
		tnode.right.left = new TreeNode(7);
		tnode.right.right = new TreeNode(8);
		System.out.println(BinaryTreeTraversal.LevelOrderTraversal(node));
		System.out.println(BinaryTreeTraversal.LevelOrderTraversal(tnode));
		
		
		System.out.println("isSubtree - " + isSubtreeBFS(node,tnode));
		
}
}
