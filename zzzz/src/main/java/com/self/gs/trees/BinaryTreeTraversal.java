package com.self.gs.trees;

import java.util.*;

/*
			5
		   / \
		  3    4
		/ \  / \
	   1   2 6  7

*/

public class BinaryTreeTraversal {
	// N L R
		public static void PreOrderTraversal(TreeNode node,ArrayList<Integer> list) {
			if(node==null) {
				return;
			}
			list.add(node.val);
			PreOrderTraversal(node.left,list);
			PreOrderTraversal(node.right,list);
		}
		// L N R 
		public static void InOrderTraversal(TreeNode node,List<Integer> list) {
			if(node==null) {
				return;
			}
			InOrderTraversal(node.left,list);
			list.add(node.val);
			InOrderTraversal(node.right,list);
		}
		
		
		// L R N
		public static void PostOrderTraversal(TreeNode node, ArrayList<Integer> list) {
			if(node == null)
				return;
			
			PostOrderTraversal(node.left,list);
			PostOrderTraversal(node.right,list);
			System.out.println("post order " + node.val);
			list.add(node.val);
		}
		
	
		public static List<List<Integer>> LevelOrderTraversal(TreeNode node) {
			
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if(node == null)
				return result;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			
			//Stack<TreeNode> stack = new Stack<TreeNode>();
			queue.add(node);
			
			while(!queue.isEmpty()) {
				List<Integer> levelElements = new ArrayList<Integer>();
				int n=queue.size();
				for(int i=0;i<n;i++) {
					TreeNode current = queue.poll();
					levelElements.add(current.val);
					if(current.left!=null)
						queue.add(current.left);
					if(current.right!=null)
						queue.add(current.right);
				}
				result.add(levelElements);
			}
			
			return result;
		}
		
      public static List<List<Integer>> LevelOrderZigZagTraversal(TreeNode node) {
			
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if(node == null)
				return result;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			
			//Stack<TreeNode> stack = new Stack<TreeNode>();
			queue.add(node);
			boolean flag = true;
			while(!queue.isEmpty()) {
				List<Integer> levelElements = new ArrayList<Integer>();
				int n=queue.size();
				for(int i=0;i<n;i++) {
					TreeNode current = queue.poll();
					levelElements.add(current.val);
					if(current.left!=null)
						queue.add(current.left);
					if(current.right!=null)
						queue.add(current.right);
				}
				if(flag) {
				 reverse(levelElements);
				//Collections.reverse(levelElements);
				}
				result.add(levelElements);
				flag = !flag;
			}
			
			return result;
		}
		
        private static void reverse(List<Integer> list) {
        	int left = 0;
        	int right = list.size()-1;
        	while(left<right) {
        		int temp = list.get(right);
        		list.remove(right);
        		list.add(right,list.get(left));
        		list.remove(left);
        		list.add(left, temp);
        		left++;
        		right--;
        	}
        }
		
		public static void main(String}] arg) {
			TreeNode node = new TreeNode(5);
			node.left = new TreeNode(3);
			node.right = new TreeNode(4);
			
			node.left.left = new TreeNode(1);
			node.left.right = new TreeNode(2);
			
			node.right.left = new TreeNode(6);
			node.right.right = new TreeNode(7);
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			PreOrderTraversal(node,list);
			System.out.println("PreOrder Traversal - " + list.toString());
			
			list = new ArrayList<Integer>();
			InOrderTraversal(node,list);
			System.out.println("In order traversal - " + list.toString());
			
			list = new ArrayList<Integer>();
			PostOrderTraversal(node,list);
			System.out.println("Post order traversal - " + list.toString());
			
			System.out.println("Level order traversal - " + LevelOrderTraversal(node));
			
			System.out.println("Level order zig zag traversal - " + LevelOrderZigZagTraversal(node));
			
		}
		
}
