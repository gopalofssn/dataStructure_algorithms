package com.self.gs.trees;

import java.util.*;

/*
          1
     2       3
  4    5   6    7

Expected : 4 5 2 6 7 3 1
*/
// L R N 
public class BinaryTreePostOrderTraversal {

	/*
	|
	|       7           |
	|    3  6 6   5     |
	| 1  2  2 2 2 4 4 _ |
	
result   1
            3 1             Add 0th meas , shift if elemnt present
              7 3 1
                6 7 3 1
                  2 6 7 3 1
                    5 2 6 7 3 1
                      4 5 2 6 7 3 1	
	*/
	private static List<Integer> iterative(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			result.
			add(0,tmp.val);
			if(tmp.left!=null)
				stack.add(tmp.left);
			if(tmp.left!=null)
				stack.add(tmp.right);
		}
		
		return result;
	}

	private static List<Integer> recurssive(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root==null)
			return result;
		recurssive(root,result);
		return result;
	}

	
	private static void recurssive(TreeNode node, List<Integer> result) {
		 if(node==null)
			 return;
		 recurssive(node.left,result);
		 recurssive(node.right,result);
		 result.add(node.val);
	}

	public static void main(String}] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		
		
		System.err.println("Recurssive - " +  recurssive(root));
		
		System.err.println("Recurssive - " +  iterative(root));

	}


}
