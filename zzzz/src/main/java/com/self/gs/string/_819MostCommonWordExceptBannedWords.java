package com.self.gs.string;
import java.util.*;

public class _819MostCommonWordExceptBannedWords {

	/*
	 * Put banned words in SET , it give O(1) while checking if it is in our word list
	 * Split paragraph with \\W+ - split by space & ignore special chars etc 
	 * 
	 */
	 public static String mostCommonWord(String paragraph, String[] banned) {
	         if(paragraph == null || paragraph.trim().isEmpty()) return ""; 
	         Set<String> bannedWords =  consolidateUniqueWord(banned);
	         String[] words = paragraph.split("\\W+");
	         Map<String, Integer> wordByCount = new HashMap<String, Integer>();
	         int max = 0;
	         String mostCommonWord = "";
	         for(String word : words){
	        	 if(bannedWords.contains(word.toLowerCase())) continue;
	        	 int count = wordByCount.merge(word.toLowerCase(), 1, (a, b) -> a + b);
	        	 if(count > max){
	        		 max = count;
	        		 mostCommonWord = word.toLowerCase();
	        	 }
	         }
	         return mostCommonWord;
	    }

	private static Set<String> consolidateUniqueWord(String[] banned) {
		Set<String> bannedWords = new HashSet<>();
		 for(String word : banned){
			 if(word != null) bannedWords.add(word.toLowerCase());
		 }
		 return bannedWords;
	}
	
	public static void main(String[] args) {
		String paragraph = "Bob's hit a ball, the hit $ BALL flew far b after it was hit";
		String[] banned = new String[] {"hit",null};
		
		System.err.println(mostCommonWord(paragraph, banned)); // ball
	}
}
