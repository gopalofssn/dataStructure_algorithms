package com.gs.string.bfs.wordladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordTree {
	public String word;
	public List<WordTree> childs;
	public WordTree(String word){
		this.word = word;
		this.childs = new ArrayList<WordTree>();
	}
	public void addChild(WordTree child){
		this.childs.add(child);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Queue<WordTree> queue = new LinkedList<WordTree>();
		queue.offer(this);
		Set<String> visited = new HashSet<String>();
		while(!queue.isEmpty()){
			int sz = queue.size();
			for(int i = 0; i < sz; i++){
				WordTree current = queue.poll();
				String word = current.word;
				sb.append(word)
				  .append("\t");
				visited.add(word);
				for(WordTree child : current.childs){
					if(!visited.contains(child.word)){
						queue.offer(child);
					}
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}