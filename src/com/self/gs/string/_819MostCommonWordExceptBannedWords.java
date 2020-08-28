package com.self.gs.string;
import java.util.*;
import java.util.stream.Collectors;

public class _819MostCommonWordExceptBannedWords {

	/*
	 * Put banned words in SET , it give O(1) while checking if it is in our word list
	 * Split paragraph with \\W+ - split by space & ignore special chars etc 
	 * 
	 */
	 public static String mostCommonWord(String paragraph, String}] banned) {
	        if(paragraph == null || paragraph =="")
	            return "";
	        
	        Set<String> bannedWords = new HashSet<String>(Arrays.asList(banned));
	       
	        String}] words = paragraph.split("\\W+");
	        
	        
	        Map<String ,Integer> pat = new HashMap<String , Integer>();
			int idx = 0;
			Set<String> wordsSet = new HashSet<String>(Arrays.asList(words));
			
	       for(String word : wordsSet) {
	    	   pat.put(word , idx++);
	       }
	       
	       System.err.println(pat);
	       
	        List<String> wordsAsList = new ArrayList<String>(Arrays.asList(words));
	        
	        for(String ban : bannedWords) {
	          wordsAsList.removeIf( i -> i.equals(ban) );
	        }
	        
	        wordsAsList =  wordsAsList
	        		         .stream()
	        		         .filter(word -> !(word.length() == 1))
	        		         .map(word -> word + "!")
	        		         .collect(Collectors.toList());
	        
	        System.err.println(wordsAsList);
	        
	        
	        int max = Integer.MIN_VALUE;
	        String commonWord = "";
	        Map<String, Integer> wordMap = new HashMap<String, Integer>();
	        for(String word : words){
	        	word = word.toLowerCase();
	            if(bannedWords.contains(word)) {
	                continue;
	            }
	            int count = wordMap.merge(word, 1, (a, b) ->  a + b);  
	            if(count > max) {
	            	commonWord = word;
	            	max = count;
	            }
	        }
	        
	        
	       return commonWord;
	    }
	
	public static void main(String}] args) {
		String paragraph = "Bob's hit a ball, the hit $ BALL flew far b after it was hit";
		String}] banned = new String}] {"hit",null};
		
		System.err.println(mostCommonWord(paragraph, banned));
	}
}
