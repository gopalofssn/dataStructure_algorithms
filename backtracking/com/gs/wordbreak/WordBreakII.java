package com.gs.wordbreak;

import java.util.*;

public class WordBreakII {

	 public List<String> wordBreak(String s, List<String> wordDict) {
	        Set<String> words = new HashSet<String>(wordDict);
	        List<String> result = new ArrayList<String>();
	        helper(s, words, new LinkedList<String>(), result);
	        return result;
	    }
	    
	    private void helper(String s, Set<String> words, LinkedList<String> current , List<String> result){	
	    	
	    	System.err.println(s);
	        if(s.isEmpty()){
	            result.add(convertAsString(current));
	            return;
	        }
	        for(int i = 0; i < s.length(); i++){
	            String word = s.substring(0, i + 1);
	            if(words.contains(word)){
	                current.addLast(word);
	                helper(s.substring(i + 1), words, current, result);
	                current.removeLast();
	            }
	        }   
	    }
	    
	    private String convertAsString(List<String> wordList){
	        StringBuilder sb = new StringBuilder();
	        for(String word : wordList){
	            sb.append(word)
	              .append(" ");
	        }
	        return sb.substring(0, sb.length() -1 );
	    }
	    
	    private final Map<String, List<String>> cache = new HashMap<>();

	    public List<String> wordBreak(String s, Set<String> dict) {
	        if (cache.containsKey(s)) return cache.get(s);
	        List<String> result = new LinkedList<>();
	        if (dict.contains(s)) result.add(s);
	        for (int i = 1; i < s.length(); i++) {
	            String left = s.substring(0,i), right = s.substring(i);
	            if (dict.contains(left) ) {//&& containsSuffix(dict, right)) {
	                for (String ss : wordBreak(right, dict)) {
	                    result.add(left + " " + ss);
	                }
	            }
	        }
	        cache.put(s, result);
	        return result;
	    }
	    
	public static void main(String[] args) {
		String s = "catsanddog";
	    String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
	    System.out.println(new WordBreakII().wordBreak(s, new ArrayList<String>(Arrays.asList(wordDict))));

	    s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	    String[] wordDict2 = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
	    System.out.println(new WordBreakII().wordBreak(s, new HashSet<String>(Arrays.asList(wordDict2))));

	}

}
