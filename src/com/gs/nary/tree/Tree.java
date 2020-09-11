package com.gs.nary.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	private final int val;
	private final List<Tree> children;
	
	public Tree(int val) {
		this(val, new ArrayList<Tree>());
	}
	public Tree(int val, List<Tree> children) {
		this.val = val;
		this.children = children;
	}
	
	public List<Tree> getChildren() {
		return new ArrayList<Tree>();
	}
}
