package com.gs.binarysearchtree;

import com.gs.binarytree.TreeNode;

public class DeleteNodeInBST {
	 public TreeNode deleteNode(TreeNode root, int key) {
	        if(root == null)  return root;
	        helper(root, key);
	        return root;
	    }
	    
	    private void helper(TreeNode node, int key){
	        if(node == null) return;
	        if(key == node.val){
	        	System.out.println("found");
	            moveRightNodeAsParentNode(node);
	        }else if(key > node.val){
	            helper(node.right, key);
	        }else{
	            helper(node.left, key);
	        }
	        System.out.println(node); 
	    }
	    
	    private void moveRightNodeAsParentNode(TreeNode node){
	        if(node == null || node.right == null) return;
	        TreeNode newParentNode = new TreeNode(node.right.val);
	        newParentNode.left = node.left;
	        newParentNode.right = node.right;
	        System.out.println("moved " + node.right.val + ", in the place of " + node.val);
	        node = newParentNode;
	        moveRightNodeAsParentNode(node.right);
	    }
	    
	    public static void main(String[] args) {
	    	TreeNode root = new TreeNode(5);
			root.left = new TreeNode(3);
			root.left.left = new TreeNode(2);
			root.left.right = new TreeNode(4);
			
			root.right = new TreeNode(6);
			root.right.right = new TreeNode(7);

			System.out.println("ROOT  - " + root);
			
			root = new DeleteNodeInBST().deleteNode(root, 5);
			System.out.println("After Delete  - " + root);
			
		}
}
