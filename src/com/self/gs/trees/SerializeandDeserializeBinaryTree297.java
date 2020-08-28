package com.self.gs.trees;

import java.util.*;

public class SerializeandDeserializeBinaryTree297 {

	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
    	if(root == null)
		 return null;
    	
        StringBuilder result= new StringBuilder();
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()) {
    		int sz = queue.size();
    		for(int i=0;i<sz;i++) {
    			TreeNode tmp = queue.poll();
    			if(tmp == null) {
    				result.append("X,");
    			    continue;
    			}
    			result.append(tmp.val+",");
    			queue.offer(tmp.left);
    			queue.offer(tmp.right);
    		}
    	}
        
       return result.toString().substring(0, result.length()-1); 
    }

    // Decodes your encoded data to tree.
    /*1,2,3,X,X,4,5,X,X,X,X
             1
         2       3 
       X   x  4    5
     
    
     */
    public static TreeNode deserialize(String data) {
		if(data==null)
			return null;
	    String}] vals = data.split(","); 
        TreeNode node = new TreeNode(Integer.valueOf(vals}0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        for(int i=1;i<vals.length;) {
        	TreeNode tmp = queue.poll();
        	tmp.left = (vals}i].equals("X"))?null:new TreeNode(Integer.valueOf(vals}i]));
        	i++;
        	if(tmp.left!=null)
              queue.add(tmp.left);
        	tmp.right = (vals}i].equals("X"))?null:new TreeNode(Integer.valueOf(vals}i]));
        	i++;
        	if(tmp.right!=null)
              queue.add(tmp.right);
        	
        }
       
	return  node;
    }
    

	

	public static void main(String}] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.right.left = new TreeNode(4);
		node.right.right = new TreeNode(5);
		String str = serialize(node);
		System.err.println(str);
		node = deserialize(str);
		str = serialize(node);
		System.err.println(str);
	}
}
