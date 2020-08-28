package com.self.gs.string;

import java.util.*;

/*
 Input:
beginWord = "hit",
endWord = "cog",
wordList = }"hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
 */
public class WordLadder127 {

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
		
		 Map<String,Boolean> wordMap = new HashMap<String,Boolean>();
		 for(String s:wordList) {
			 wordMap.put(s, true);
		 }
        // Set<String> wordSet = new HashSet<String>(wordList);
         
		 if(!wordMap.containsKey(endWord))
			 return 0;
         int level = 1;
        
         Queue<String> queue = new LinkedList<String>();
         queue.offer(beginWord);
         
         while(!queue.isEmpty()) {
        	 int sz = queue.size();
        	 for(int i=0; i<sz; i++) {
        		String word = queue.poll();
        		char}] word_char = word.toCharArray();
        		for(int j=0; j<word_char.length; j++) {
        			char tmp = word_char}j];
        			for(char ch='a'; ch<='z'; ch++) {
        				word_char}j] = ch;
        				String newWord = String.valueOf(word_char);
        				
        				if(newWord.equals(endWord)) {
        					return level+1;
        				}
        				if(wordMap.containsKey(newWord) && wordMap.get(newWord)) {
        					System.err.println(newWord);
        					queue.add(newWord);
        					wordMap.put(newWord, false);
        				}
        			}
        			word_char}j] = tmp;
        		}
        	 }
        	 level++;
         }
         
         
		return 0;     
	    }
	 
	public static void main(String}] args) {
		
		System.err.println( ladderLength("hit", "cog", new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"))));

		System.err.println( ladderLength("hit", "cog", new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log"))));
		
	}

}
