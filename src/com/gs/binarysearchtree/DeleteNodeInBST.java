package com.gs.binarysearchtree;

import com.gs.binarytree.TreeNode;

public class DeleteNodeInBST {
	 public TreeNode deleteNode(TreeNode root, int key) {
	        if(root == null)  return root;
	        if(root.val == key && root.right == null && root.left == null) return null;
	        helper(root,null, key, null);
	        return root;
	    }
	    
	    private void helper(TreeNode node,TreeNode parent, int key, Boolean isLeft){
	        if(node == null) return;
	        if(key == node.val){
	            move(node, parent, isLeft);
	        }else if(key > node.val){
	            helper(node.right, node, key,false);
	        }else{
	            helper(node.left, node, key, true);
	        }
	    }
	    
	    private void move(TreeNode node, TreeNode parent, Boolean isLeft){
	         if(node == null) return;
	         if(node.right != null){
	             node.val = node.right.val;
	             move(node.right, node, false);
	         }else if(node.left != null ){
	             node.val = node.left.val;
	             move(node.left, node, true);
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
			//[2,0,33,null,1,25,40,null,null,11,31,34,45,10,18,29,32,null,36,43,46,4,null,12,24,26,30,null,null,35,39,42,44,null,48,3,9,null,14,22,null,null,27,null,null,null,null,38,null,41,null,null,null,47,49,null,null,5,null,13,15,21,23,null,28,37,null,null,null,null,null,null,null,null,8,null,null,null,17,19,null,null,null,null,null,null,null,7,null,16,null,null,20,6]
			//33
		}
}
