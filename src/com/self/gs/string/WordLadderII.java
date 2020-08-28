package com.self.gs.string;

import java.util.*;


class Tree{
	String node;
	Set<Tree> childs;
	public Tree(String _node) {
		node = _node;
		childs = null;
	}
}
public class WordLadderII {
	
	     /*
	             hit
	          hot     hig
	      dot   lot     cig
	    dog        log   cog
	  cog            cog 
	  
	      
	      
	      */

	private static List<List<String>> find(String beginWord, String endWord, Set<String> wordList) {
		
		List<List<String>> ladders = new ArrayList<List<String>>();
		if(!wordList.contains(endWord))
			return ladders;
		boolean flag = true;
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		Tree node = new Tree(beginWord);
		while(!queue.isEmpty()) {
			int sz = queue.size();
			for(int i=0; i<sz; i++) {
				String word = queue.poll();
				
			}
		}
		 
		return  new ArrayList<List<String>>();
	}
	
	public static void main(String}] args) {
		System.err.println( find("hit", "cog", new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log","cig","cog","hig"))));

		System.err.println( find("hit", "cog", new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"))));
		

	}

	

}
