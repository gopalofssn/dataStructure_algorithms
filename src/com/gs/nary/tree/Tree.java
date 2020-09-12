package com.gs.nary.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Tree{
    final int val;
	private final List<Tree> children;
	
	public Tree(int val) {
		this(val, new ArrayList<Tree>());
	}
	public Tree(int val, List<Tree> children) {
		this.val = val;
		this.children = children;
	}
	
	public List<Tree> getChildren() {
		return new ArrayList<Tree>(this.children);
	}
	
	public void addChild(Tree child){
		this.children.add(child);
	}
	
	public void addChildren(List<Tree> children){
		this.children.addAll(children);
	}
	
	public boolean isLeaf(){
		return ( this.children == null || this.children.size() == 0 );
	}
	
	 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		int childrenHashCode = 0;
		List<Tree> childs = (children != null)? children : Collections.emptyList();
		for(Tree child : childs){
			System.out.println( children.hashCode());
		}
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + val;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Tree) ) return false;
		Tree that = (Tree) obj;
		if(this.val != that.val) return false;
		if(this.children.size() != that.children.size()) return false;
		if(this.isLeaf() != that.isLeaf()) return false;
		Iterator<Tree> thisChilderenIterator = this.children.iterator();
		Iterator<Tree> thatChilderenIterator = that.children.iterator();
		while(thisChilderenIterator.hasNext() && thatChilderenIterator.hasNext()){
			return thisChilderenIterator.next().equals(thatChilderenIterator.next());
		}
		return ( thisChilderenIterator.hasNext() == thatChilderenIterator.hasNext());
	}
	@Override
	public String toString() {
		return String.valueOf(this.val);
	}
}
