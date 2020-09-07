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
		/ \ /  \ 
		4 7 14 17 
	[4	15	7	10	14	5	17  ]
	    -  -        -   -
    if( prev > current ) 
       assign first as prev ( if not null) // 15 , no update on second time 
       assign current as second (default) , it will change if we find another one with diff. //  7 , override with 5 later
 */
public class RecoverBST {
	private TreeNode first;
	private TreeNode second;
	private TreeNode prev;
	private  void repair(TreeNode node) {
		helper(node);
		int tmp = first.val; // CAREFUL , WE NEED VALUE
		first.val = second.val;
		second.val = tmp;
	}

	/*
	       3
	     11
	     
	    Step 1 
	 */
	private void helper(TreeNode current) {
		if(current == null) return; // s1  null(11's left)  , null 11's right (still prev = 11) , s2 : 3's right null
		helper(current.left);  //  s1 : 11 null
		if(prev != null && prev.val > current.val ){ // (prev) 11 is not  null  && 11 > 3(current)
			System.out.println("prev " + prev.val); // 11
			System.out.println("current " + current.val); // 3
			if(first == null) first = prev; //   11
			second = current; //  3
		}
		prev = current; // s1 11 as prev.  // 3 as prev now 
		helper(current.right); // 11's right ( null) ,  // 3's right ( null)
	}
	
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(10);
		root.left = new TreeNode(15);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(14);
		root.right.right = new TreeNode(17);
		System.out.println("ROOT " + root);
		new RecoverBST().repair(root);
		System.out.println("After repair " + root);
		*/
		/*TreeNode node = new TreeNode(3);
		node.left = new TreeNode(1);
		node.right = new  TreeNode(4);
		node.right.left = new TreeNode(2);
		System.out.println("node " + node);
		new RecoverBST().repair(node);
		System.out.println("After node  " + node);*/
		
		TreeNode node = new TreeNode(2);
		node.right = new TreeNode(1);
		System.out.println("ROOT " + node);
		new RecoverBST().repair(node);
		System.out.println("After node  " + node);
	}
}
