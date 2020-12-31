package com.gs.nary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NAryTreeRootToLeaf {
	
	public List<List<Integer>> collect(Tree root) {
		if(root == null) return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(root, new LinkedList<Integer>(), result);
		return result;
	}
	
	private void helper(Tree node, LinkedList<Integer> current, List<List<Integer>> result) {
		if(node == null) return;
		current.addLast(node.val);
		if(node.isLeaf()){
			result.add(new ArrayList<Integer>(current)); // copy
		}
		for(Tree child : node.getChildren()){
			helper(child, current, result);
			current.removeLast();
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
		List<List<Integer>> rootToLeaf = new NAryTreeRootToLeaf().collect(root);
		for(List<Integer> path : rootToLeaf){
			System.out.println(path);
		}
	}
}
