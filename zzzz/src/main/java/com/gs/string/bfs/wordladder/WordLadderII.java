package com.gs.string.bfs.wordladder;

import java.util.*;
// find all possible ladder options.
public class WordLadderII {
	
	     /*
	             hit
	          hot     hig
	      dot   lot     cig
	    dog        log   cog
	  cog            cog 
	  
	   fina   
	      
	      */

	private static List<List<String>> find(String beginWord, String endWord, Set<String> wordList) {
		
		List<List<String>> ladders = new ArrayList<List<String>>();
		if(!wordList.contains(endWord))
			return ladders;
		WordTree root = buildLadderTree(wordList, beginWord);
		System.out.println(root);
		LinkedList<String> ladder = new LinkedList<String>();
		ladder.addLast(root.word);
		dfs(root, ladder, ladders, endWord);
		return ladders;
	}
	
	private static void dfs(WordTree tree, LinkedList<String> ladder, List<List<String>> ladders, String endWord) {
		if(tree.childs.size() == 0 && ladder.size() > 1 && isSame(ladder.peekLast(), endWord)){
			ladders.add(new ArrayList<String>(ladder));
			return;
		}
		
		for(WordTree child : tree.childs){
			ladder.addLast(child.word);
			dfs(child, ladder, ladders, endWord);
			ladder.removeLast();
		}
	}

	private static boolean isSame(String word1, String word2) {
		return (word1 != null && word2 !=null && word1.equalsIgnoreCase(word2));
	}

	private static WordTree buildLadderTree(Set<String> wordList, String word) {
		
		Set<String> visited = new HashSet<String>();
		Queue<WordTree> queue = new LinkedList<WordTree>();
		WordTree root = new WordTree(word);
		queue.offer(root);
		while(!queue.isEmpty()){
			int sz = queue.size();
			for(int i = 0; i <sz; i++){
				WordTree current = queue.poll();
				addToQueueAndAddAsChilds(queue, current, wordList, visited);
			}
		}
		return root;
	}

	private static void addToQueueAndAddAsChilds(Queue<WordTree> queue, WordTree node, Set<String> wordList,
			Set<String> visited) {
		String exploringWord = node.word;
		visited.add(exploringWord);
		char[] v = exploringWord.toCharArray();
		for(int i = 0; i < v.length; i++){
			for(char c = 'a'; c <= 'z'; c++){
				char tmp = v[i];
				v[i] = c;
				String newWord = String.valueOf(v);
				if(!visited.contains(newWord) && wordList.contains(newWord)){
					WordTree child = new WordTree(newWord);
					node.addChild(child);
					queue.offer(child);
				}
				v[i] = tmp;
			}
		}	
	}

	public static void main(String[] args) {
		System.err.println( find("hit", "cog", new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
		System.err.println( find("hit", "cog", new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"))));
	}

}
