package com.gs.graph.similar;

import java.util.*;

public class SentenceSimilarity {

	public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		
		Map<String , Set<String>> graph = new HashMap<String , Set<String>>();
		for(String[] pair : pairs) {
			String rep = pair[0];
			graph.putIfAbsent(rep, new HashSet<String>());
			for(int i = 1; i < pair.length; i++) {
				graph.get(rep).add(pair[i]);
			}
		}
		
		final int LEN = words1.length;
		for(int i = 0; i < LEN; i++) {
			String word1 = words1[i];
			String word2 = words2[i];
			if()
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String[][] pairs = { 
								{"great", "fine"}, 
								{"acting","drama"}, 
								{"skills","talent"}
						  };
		String[] words1 = {"great","acting", "skills"};
		String[] words2 = {"fine", "drama", "talent"};
		System.out.println(areSentencesSimilar( words1, words2, pairs));
	}

}
