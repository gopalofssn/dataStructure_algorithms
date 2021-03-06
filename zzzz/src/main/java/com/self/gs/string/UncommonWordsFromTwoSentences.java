package com.self.gs.string;

import java.util.*;

public class UncommonWordsFromTwoSentences {

	public static String[] uncommonFromSentences(String A, String B) {
		Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
		for (String s : A.split(" ")) {
			wordCountMap.put(s, wordCountMap.getOrDefault(s, 0) + 1);
		}
		for (String s : B.split(" ")) {
			wordCountMap.merge(s, 1, Integer::sum);
		}
		System.err.println(wordCountMap);
		List<String> lst = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
			if (entry.getValue() == 1) {
				lst.add(entry.getKey());
			}
		}
		System.err.println(lst);
		return lst.toArray(new String[lst.size()]);
	}

	public static void main(String[] args) {
		System.err.println(Arrays.toString(uncommonFromSentences("this apple is sweet", "this apple is sour")));
	}

}
