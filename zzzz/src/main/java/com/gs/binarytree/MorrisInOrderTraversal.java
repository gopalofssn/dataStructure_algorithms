package com.gs.binarytree;

public class MorrisInOrderTraversal {
   // L P R
	private static String traversal(TreeNode root) {
		if(root == null) return "";
		StringBuilder sb = new StringBuilder();
		//TreeNode prev;
		TreeNode current = root;
		while(current != null) {
			if(current.left == null) {
				sb.append(current.val)
				  .append(",");
				current = current.right;
			}else {
				TreeNode predecessor = current.left;
				/* Find the previous (prev) of curr */
				while(predecessor.right != null && predecessor.right != current) {
					predecessor = predecessor.right;
				}
				/* Make curr as right child of its prev */
				if(predecessor.right == null) {
					predecessor.right = current;
					current = current.left;
				}else { /* fix the right child of prev*/
					predecessor.right = null;
					sb.append(current.val)
					  .append(",");
					current = current.right;
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.err.println("ROOT  - " + root);
		
		String s = traversal(root);
		System.out.println("morris preorder " + s);

	}

}
