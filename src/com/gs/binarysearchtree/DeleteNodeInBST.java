package com.gs.binarysearchtree;

import com.gs.binarytree.TreeNode;

public class DeleteNodeInBST {
	 public TreeNode deleteNode(TreeNode root, int key) {
	        if(root == null)  return root;
	        helper(root,null ,key, null);
	        return root;
	    }
	    
	    private void helper(TreeNode node,TreeNode parent, int key, Boolean isLeft){
	        if(node == null) return;
	        if(key == node.val){
	        	moveValue(node, parent,isLeft);
	        }else if(key > node.val){
	            helper(node.right, node, key, false);
	        }else{
	            helper(node.left, node, key, true);
	        }
	    }
	    
	    private void moveValue(TreeNode node, TreeNode parent, Boolean isLeft){
	    	if(node == null) return;
	    	if(node.right != null){
	    		node.val = node.right.val;
	    		moveValue(node.right, node, false);
	    	}else if(node.left !=null){
	    		node.val = node.left.val;
	    		moveValue(node.right, node, true);
	    	}else{
	    		if(isLeft == null) parent = null;
	    		else if(isLeft) parent.left = null;
	    		else parent.right = null;
	    	}
	    }
	    
	    public static void main(String[] args) {
	    	TreeNode root = new TreeNode(5);
			root.left = new TreeNode(3);
			root.left.left = new TreeNode(2);
			root.left.right = new TreeNode(4);
			
			root.right = new TreeNode(6);
			root.right.right = new TreeNode(7);

			System.out.println("ROOT  - " + root);
			
			root = new DeleteNodeInBST().deleteNode(root, 2);
			System.out.println("After Delete  - " + root);
			
			System.out.println("After Delete  - " + new DeleteNodeInBST().deleteNode(new TreeNode(1), 1));
		}
}
