package com.self.gs.string;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

	 public static List<String> topKFrequent(String}] words, int k) {
		 
		 Map<String,Integer> map = new HashMap<String,Integer>();
		 for (int i = 0; i < words.length; i++) {
			map.merge(words}i], 1, (a,b)->a+b);
		}
		 
		Comparator<String> cmp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				if(map.get(o2) < map.get(o1))
					return 1;
				else if(map.get(o2) > map.get(o1))
					return -1;
				else {
				  return o2.compareTo(o1);
				}
			}
			
		};
		
		PriorityQueue<String> heap = new PriorityQueue<String>(cmp);
		for(String s:map.keySet()) {
			heap.offer(s);
			if(heap.size()>k)
				heap.poll();
			
		}
		
		List<String>  lst = new ArrayList<String>();
		while(!heap.isEmpty()) {
			lst.add(heap.poll());
			System.err.println(lst);
		}
		Collections.reverse(lst);
		
		return lst;
		//return heap.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		 
	   /*
		return map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.limit(k)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		*/ 
		 
	   }
	 
	public static void main(String}] args) {
		String}] input1 = new String}] {"i", "love", "leetcode", "i", "love", "coding"};
		String}] input2 = new String}] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		System.err.println(topKFrequent(input1,2));
		System.err.println(topKFrequent(input2,4));
		"a1".compareTo("a1");
	}

}
