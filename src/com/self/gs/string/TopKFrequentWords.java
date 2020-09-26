package com.self.gs.string;

import java.util.*;

/*
 Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: }"i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: }"i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: }"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: }"the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
 */


public class TopKFrequentWords {

	public static List<String> topKFrequent(String[] words, int k) {
		 if(words == null || words.length == 0 || k == 0) return Collections.emptyList();
		 Map<String,Integer> wordCountMap = new HashMap<String,Integer>();
		 buildWordCountMap(words, wordCountMap);
		 Comparator<String> cmp = new Comparator<String>() {
			public int compare(String a, String b) {
				int diff = wordCountMap.get(a) - wordCountMap.get(b);
				if(diff == 0) return a.compareTo(b);
				return diff;
			}
		 };
		 System.out.println(wordCountMap);
		 PriorityQueue<String> minimumCountWordHeap = new PriorityQueue<String>(cmp);
		 for(String word: wordCountMap.keySet()){
			 minimumCountWordHeap.offer(word);
			 if(minimumCountWordHeap.size() > k){
				 minimumCountWordHeap.poll();
			 }
		 }
		 System.out.println(minimumCountWordHeap);
		 LinkedList<String> result = new LinkedList<String>();
		 while(!minimumCountWordHeap.isEmpty()){
			 result.addFirst(minimumCountWordHeap.poll());
		 }
		 return result;
	 }
	 
	private static void buildWordCountMap(String[] words, Map<String, Integer> wordCountMap) {
		for(String word : words){
			wordCountMap.merge(word, 1, (a,b) -> a + b);
		}
	}

	public static void main(String[] args) {
		String[] input1 = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
		String[] input2 = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		System.err.println(topKFrequent(input1,2)); //[i, love]
		System.err.println(topKFrequent(input2,4)); //[the, is, sunny, day]
	}

}
