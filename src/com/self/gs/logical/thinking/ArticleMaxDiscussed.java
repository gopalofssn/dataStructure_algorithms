package com.self.gs.digits;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ArticleMaxDiscussed {

	public static void main(String[] args) {
		List<String> toys = new ArrayList<String>(Arrays.asList("ana","bella","crica"));
		List<String> comments = new ArrayList<String>(Arrays.asList("ana toy is better","bella is great than ana","best toy ana toy","crica is ok","bella good"));
		System.err.println(topNFinder(toys,comments, 2));

	}

	private static List<String> topNFinder(List<String> toys, List<String> comments,int top) {
		 Map<String, Integer> map =  new TreeMap<String, Integer>();
		 for(String c:comments) {
			 for(String t:toys) {
				 if(isContains(c,t)) {
						map.merge(t, 1, (a,b)->a+b); 
				 }
			 }
		 }
		 
		 Map<String, Integer> sortedMap = 
			     map.entrySet().stream()
			    .sorted(Entry.<String,Integer>comparingByValue().reversed())
			    .limit(top)
			    .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
			                             (e1, e2) -> e1, LinkedHashMap::new));
		 

		return new ArrayList<String>(sortedMap.keySet());
	}

	private static boolean isContains(String content, String pattern) {
		
		return content.contains(pattern);
	}

}
