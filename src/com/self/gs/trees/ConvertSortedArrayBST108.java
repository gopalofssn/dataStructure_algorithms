package com.self.gs.trees;

/*
 * 
 IP
   [-10,-3,0,5,9]
 O/p
       0
   -3     9
 -10     5
 
 idea - mid point goes as root , left element goes left node, right elemnt goes right side.
  like spit and go , split and go.
 
 */
public class ConvertSortedArrayBST108 {

	public static void main(String[] args) {
		int[] input = new int[] {-10,-3,0,5,9};
		TreeNode node = createBST(input,0,input.length-1);
		System.out.println(BinaryTreeTraversal.LevelOrderTraversal(node));
	}

	private static TreeNode createBST(int[] input,int start, int end) {
		 if(start>end)
			 return null;
		int mid = (start+end)/2;
		TreeNode node = new TreeNode(input[mid]);
		node.left = createBST(input,start,mid-1);
		node.right = createBST(input,mid+1,end);
		return node;
		
	}
}
