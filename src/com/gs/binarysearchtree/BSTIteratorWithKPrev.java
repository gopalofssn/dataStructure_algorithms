package com.gs.binarysearchtree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

import com.gs.binarytree.TreeNode;

public class BSTIteratorWithKPrev {
	
	private Stack<TreeNode> stack;
	private final int k;
	private ArrayDeque<TreeNode> prevStack;
	
    public BSTIteratorWithKPrev(TreeNode root, int k) {
        this.stack = new Stack<TreeNode>();
        this.k = k + 1;
        this.prevStack = new ArrayDeque<TreeNode>();
        doLeftStack(root);
    }
    
    private void doLeftStack(TreeNode node){
        if(node == null) return;
        stack.push(node);  // [ 7], [ 3 7] , [15 ] , [9 15] , [20]  []
        doLeftStack(node.left);
    }
    /** @return the next smallest number */
    public int next() {
        if(!hasNext())  throw new NoSuchElementException();
        TreeNode node = stack.pop(); // 3  , 7  , 9  , 15  20 
        doLeftStack(node.right);
        prevStack.offer(node);
        if(prevStack.size() > k) {
        	prevStack.pollFirst(); // remve olest
        }
       
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty(); // T T T F
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(7);
		List<Integer> lst = null;
		lst.isEmpty();
		System.out.println("ROOT  - " + root);
		
		BSTIteratorWithKPrev iterator = new BSTIteratorWithKPrev(root , 3);
		while(iterator.hasNext()) {
			System.out.println("node - " + iterator.next());
			iterator.printKPrev();
		}
	
	}

	private void printKPrev() {
		ArrayDeque<TreeNode> prevStackCopy = prevStack.clone();
		prevStackCopy.pollLast();
		 System.out.println(" pre k values ***" );
		 while(!prevStackCopy.isEmpty()) {
			 System.out.println(prevStackCopy.poll().val);
		 }
		 
		 System.out.println("****");
	}
}
