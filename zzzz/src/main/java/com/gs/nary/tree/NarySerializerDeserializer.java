package com.gs.nary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NarySerializerDeserializer {

	private String serialize(Tree node) {
		if(node == null ) return "";
		StringBuilder sb = new StringBuilder();
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.offer(node);
		while(!queue.isEmpty()){
			int sz = queue.size();
			for(int i = 0; i < sz; i++){
				Tree current = queue.poll();
				List<Tree> children = current.getChildren() != null ? current.getChildren() : Collections.emptyList();
				sb.append(current.val)
				  .append("$")
				  .append(children.size())
				  .append("|");
				queue.addAll(children);
			}
		}
		return sb.toString();
	}
	
	private class TreeAndChildCount{
		private Tree node;
		private int childCount;
		public TreeAndChildCount(Tree node, int childCount){
			this.node = node;
			this.childCount = childCount;
		}
	}
	
	private Tree deserialize(String str) {
		 String[] split = str.split("\\|"); // CAREFUL , NEED \\ To split special chars
		 int index = 0;
		 TreeAndChildCount root = treeAndChildCountBuilder(split[index++]);
		 Queue<TreeAndChildCount> queue = new LinkedList<TreeAndChildCount>();
		 queue.offer(root);
		 while(!queue.isEmpty()){
			 int sz = queue.size();
			 for(int i = 0; i < sz; i++){
				 TreeAndChildCount current = queue.poll();
				 Tree node = current.node;
				 int childCount = current.childCount;
				 while(childCount > 0){
					 TreeAndChildCount child = treeAndChildCountBuilder(split[index++]);
					 node.addChild(child.node);
					 queue.offer(child);
					 childCount--;
				 }
			 }
		 }
		
		 return root.node;
	}
	
	private TreeAndChildCount treeAndChildCountBuilder(String s){
		 String[] nodeAndChildCount = s.split("\\$");
		 int rootVal = Integer.parseInt(nodeAndChildCount[0]);
		 int childCount = Integer.parseInt(nodeAndChildCount[1]);
		 Tree node = new Tree(rootVal);
		 return new TreeAndChildCount(node, childCount);
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
		System.out.println("ORIGINAL.. " );
		List<List<Integer>> rootToLeaf = new NAryTreeRootToLeaf().collect(root);
		for(List<Integer> path : rootToLeaf){
			System.out.println(path);
		}
		String serialString = new NarySerializerDeserializer().serialize(root);
		System.out.println("Serialize String - " + serialString);
		Tree deserialize =  new NarySerializerDeserializer().deserialize(serialString);
		System.out.println("DESERIAL .. " );
		rootToLeaf = new NAryTreeRootToLeaf().collect(deserialize);
		for(List<Integer> path : rootToLeaf){
			System.out.println(path);
		}
		
		System.out.println("*** are the same ? " + root.equals(deserialize));
		System.out.println("*** ROOT hash code ***");
		System.out.println(root.hashCode());
		System.out.println("*** Deserialize hash code *** ");
		System.out.println( deserialize.hashCode());
	}


}
