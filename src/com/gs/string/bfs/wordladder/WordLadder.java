package com.gs.string.bfs.wordladder;

import java.util.*;

/*
 Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
 */
public class WordLadder {

	/*
	  BFS approach
	                 hit
	            hot
	        dot    lot
	     dog           log
	       cog        cog
	   * dont revisit if element if visited , ok to remove to list?
	   * if not ok to remove , let us mark element as visited.
	   * 
	 */
	 public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		 Set<String> words = new HashSet<String>(wordList);
		 Queue<String> queue = new LinkedList<String>();
		 queue.offer(beginWord);
		 int steps = 0;
		 while(!queue.isEmpty()){
			 int sz = queue.size();
			 for(int i = 0; i < sz; i++){
				 String current = queue.poll();
				 if(current.equalsIgnoreCase(endWord)) return steps;
				 addToQueue(queue, current, words);
			 }
			 steps++;
		 }
		 return -1;
	    }
	 
	private static void addToQueue(Queue<String> queue, String word, Set<String> words) {
		char[] v = word.toCharArray();
		for(int i = 0; i < v.length; i++){
			for(char c = 'a' ; c <= 'z'; c++){
				char old = v[i];
				v[i] = c;
				String newWord = String.valueOf(v);
				if(words.contains(newWord)){
					queue.offer(newWord);
					words.remove(newWord);
				}
				v[i] = old;
			}
		}
	}

	public static void main(String[] args) {
		System.err.println( ladderLength("hit", "cog", new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
		System.err.println( ladderLength("hit", "cog", new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log"))));	
	}

}
