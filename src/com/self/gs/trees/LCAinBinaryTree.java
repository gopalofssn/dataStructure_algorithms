package com.self.gs.trees;

public class LCAinBinaryTree {
	
	//https://www.youtube.com/watch?v=13m9ZCB8gjw
	private static TreeNode find(TreeNode node, TreeNode t1, TreeNode t2) {
		if(node==null)
			return null;
		if(node.val == t1.val || node.val == t2.val)
			return node;
		TreeNode left = find(node.left,t1,t2);
		TreeNode right = find(node.right,t1,t2);
		if(left!=null && right!=null)
			return node;
		if(left==null && right ==null)
			return null;
		
		return (left!=null)?left:right;
	}
	
	
	public static void main(String}] args) {
		String str = "3,6,8,2,11,X,13,X,X,9,5,7,X";
		TreeNode node = SerializeandDeserializeBinaryTree297.deserialize(str);
		System.err.println(find(node,new TreeNode(2),new TreeNode(5)).val);
		System.err.println(find(node,new TreeNode(7),new TreeNode(8)).val);
	}

	
}
