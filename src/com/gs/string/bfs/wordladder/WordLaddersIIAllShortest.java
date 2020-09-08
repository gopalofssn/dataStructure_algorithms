package com.gs.string.bfs.wordladder;

import java.util.*;
//2ND CASE IF NOT WORKING.
public class WordLaddersIIAllShortest {
	 private class WordAndLadders{
	        private String word;
	        private LinkedList<String> ladder;
	        public WordAndLadders(String word){
	            this.word = word;
	            this.ladder = new LinkedList<String>();
	        }
	        public void addLadderWords(List<String> words){
	            this.ladder.addAll(words);
	        }
	        public void addLadderWord(String word){
	            this.ladder.add(word);
	        }
	    }
	    
	    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	        List<List<String>> ladders = new ArrayList<List<String>>();
	        if(wordList.size() == 0 && isSame(beginWord, endWord)) return ladders;
	        Queue<WordAndLadders> queue = new LinkedList<WordAndLadders>();
	        WordAndLadders element = new WordAndLadders(beginWord);
	        element.addLadderWord(beginWord);
	        queue.offer(element);
	        Set<String> visited = new HashSet<String>();
	        Set<String> uniqueWords = new HashSet<String>(wordList);
	        while(!queue.isEmpty()){
	            int sz = queue.size();
	            for(int i = 0; i < sz; i++){
	                WordAndLadders current = queue.poll();
	                if(isSame(current.word, endWord)){
	                    ladders.add(current.ladder);
	                }
	                addToQueue(queue, current, visited, uniqueWords);
	                visited.add(current.word);
	            }
	            if(ladders.size() != 0){
	                return ladders;
	            }
	        }
	        return new ArrayList<List<String>>();
	    }
	    
	    private boolean isSame(String word1, String word2){
	        return (word1 !=null && word2 != null && word1.equalsIgnoreCase(word2));
	    }

	    private void addToQueue(Queue<WordAndLadders> queue, WordAndLadders current, Set<String> visited, Set<String> uniqueWords){
	         
	    	if(visited.contains(current.word)) return;
	         char[] v = current.word.toCharArray();
	         for(int i = 0; i < v.length; i++){
	             for(char c = 'a'; c <= 'z'; c++){
	                 char tmp = v[i];
	                 v[i] = c;
	                 String newWord = String.valueOf(v);
	                 
	                 if(uniqueWords.contains(newWord)){
	                	 if(newWord.equalsIgnoreCase("rex")) System.out.println("rex is added in queue");
	                     WordAndLadders element = new WordAndLadders(newWord);
	                     element.addLadderWords(current.ladder);
	                     element.addLadderWord(newWord) ; 
	                     queue.offer(element);  
	                 }
	                 v[i] = tmp;
	             }
	         }
	    }
	    
	public static void main(String[] args) {
		List<List<String>>  result = new WordLaddersIIAllShortest().findLadders("hit", "cog", new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog")));
		for(List<String> r : result){
			System.out.println(r);
		}
		

		result = new WordLaddersIIAllShortest().findLadders("red", "tax", new ArrayList<String>(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee")));
		for(List<String> r : result){
			System.out.println(r);
		}
	}

}
