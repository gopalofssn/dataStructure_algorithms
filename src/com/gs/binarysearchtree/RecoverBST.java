package com.gs.binarysearchtree;

import com.gs.binarytree.TreeNode;

/*
     https://www.youtube.com/watch?v=LR3K5XAWV5k
      N
    L   R
    L < N < R - in order traversal
          10       
		  / \   
		 /   \  
	   (15)  (5)   
		/ \ / \ 
		4 7 14 17 
	[4	15	7	10	14	5	17   10  ]
	    -  -        -   -
    if( prev > current ) 
       assign first as prev ( if not null) // 15 , no update on second time 
       assign current as second (default) , it will change if we find another one with diff. //  7 , override with 5 later
 */
public class RecoverBST {
	static TreeNode first;
	static TreeNode second;
	private static void repair(TreeNode node) {
		helper(node, null);
		int tmp = first.val; // CAREFUL , WE NEED VALUE
		first.val = second.val;
		second.val = tmp;
	}

	private static void helper(TreeNode current, TreeNode prev) {
		if(current == null) return;
		helper(current.left, current);
		if(prev != null && prev.val > current.val ){
			if(first == null) first = prev; // 15 // ONLY ONE TIME
			second = current; // 7 , 5
		}
		helper(current.right, current);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(15);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(14);
		root.right.right = new TreeNode(17);
		System.out.println("ROOT " + root);
		repair(root);
		System.out.println("After repair " + root);
	}
}
