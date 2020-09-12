package com.gs.nary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SalesPathMinShippingCostPath {
	
	int minCost = Integer.MAX_VALUE;
	
	private List<List<Integer>>  findMinShippingCostPath(Tree root) {
		if(root == null) return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(root, new LinkedList<Integer>(), result, 0);
		return result;
	}
	
	private void helper(Tree node, LinkedList<Integer> current, List<List<Integer>> result, int sum) {
		if(node == null ) return;
		current.add(node.val);
		sum += node.val;
		if(sum > minCost) return;
		if(node.isLeaf()){
			resultDecider(current, result, sum);
			return;
		}
		for(Tree child : node.getChildren()){
			helper(child, current, result, sum);
			current.removeLast();
		}
	}

	private void resultDecider(LinkedList<Integer> current, List<List<Integer>> result, int sum) {
		 if(sum < minCost){
			 result.clear();
			 minCost= sum;
		 }
		 result.add(new ArrayList<>(current));
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
		List<List<Integer>> minCostRootToLeaf = new SalesPathMinShippingCostPath().findMinShippingCostPath(root);
		for(List<Integer> path : minCostRootToLeaf){
			System.out.println(path);
		}
	}


}
