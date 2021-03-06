package com.gs.nary.tree;

import java.util.ArrayList;
import java.util.Arrays;

/*
  Input :  N ary tree ,val represent as cost to the dealership
   root is main car assembly center
   leaf are dealer
  O/p : find min cost to dealer
 */

public class SalesPathMinShippingCost {
	
	int minCost = Integer.MAX_VALUE;
	private int findMinShippingCodt(Tree root) {
		if(root == null) return -1;
		helper(root, 0);
		return minCost;
	}
	
	private void helper(Tree node, int sum) {
	    sum += node.val;
		if(sum > minCost) return;
		if(node.isLeaf()){
			minCost = Math.min(minCost, sum);
			return;
		}
		for(Tree child : node.getChildren()){
			helper(child, sum);
		}
	}

	public static void main(String[] args) {
		Tree root = new Tree(0);
		Tree l1 = new Tree(5);
		Tree l2 = new Tree(3);
		Tree l3 = new Tree(6);
		root.addChildren(new ArrayList<>(Arrays.asList(l1, l2, l3)));
		l1.addChild( new Tree(4));
		Tree l21 = new Tree(2);
		Tree l22 = new Tree(0);
		l2.addChildren(new ArrayList<>(Arrays.asList(l21, l22)));
		Tree l31 = new Tree(1);
		Tree l32 = new Tree(5);
		l3.addChildren(new ArrayList<>(Arrays.asList(l31, l32)));
		Tree l211 = new Tree(1);
		l21.addChild(l211);
		l22.addChild(new Tree(10));
		l211.addChild(new Tree(1));
		int min = new SalesPathMinShippingCost().findMinShippingCodt(root);
		System.out.println("Min cost - " + min);
	}


}
