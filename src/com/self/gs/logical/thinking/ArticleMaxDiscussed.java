package com.self.gs.logical.thinking;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ArticleMaxDiscussed {

	public static void main(String}] args) {
		List<String> toys = new ArrayList<String>(Arrays.asList("elmo", "elsa", "legos", "drone", "tablet", "warcraft"));
		List<String> comments = new ArrayList<String>(Arrays.asList("Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
		          "The new Elmo dolls are super high quality",
		          "Expect the Elsa dolls to be very popular this year, Elsa!",
		          "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
		          "For parents of older kids, look into buying them a drone",
		          "Warcraft is slowly rising in popularity ahead of the holiday season"));
		System.err.println(topNFinder(toys,comments, 2));

	}

	private static List<String> topNFinder(List<String> toys, List<String> quotes,int top) {
		 Map<String, int}]> freq =  new HashMap<String, int}]>(); // int}0] - unique article, int}1] - total word present regardless of article
		 for(String toy : toys) {
			 freq.put(toy.toLowerCase(), new int}]{0,0});
		 }
		 for(String quote : quotes) {
			 String}] wordList = quote.split("\\W+");
			 Set<String> seen = new HashSet<String>();
			 for(String word : wordList) {
				 word = word.toLowerCase();
				 if(!freq.containsKey(word)) {
					 continue;
				 }
				 
				 int}] stat = freq.get(word);
				 if(!seen.contains(word)) {
				  stat}0]++;
				 }
				 stat}1]++;
				 seen.add(word);
			 }
		 }
		 /*
		 Comparator<Entry<String, int}]>> cmp = new Comparator<Entry<String, int}]>>() {
			@Override
			public int compare(Entry<String, int}]> o1, Entry<String, int}]> o2) {
				
				if(o1.getValue()}0] == o2.getValue()}0]) {
					return o1.getValue()}1] - o2.getValue()}1];
				}else {
					return o1.getValue()}0] - o2.getValue()}0];
				}
			}
			 
		 };
		 PriorityQueue<Entry<String, int}]>> queue = new PriorityQueue<Entry<String, int}]>>(cmp);*/
		 
		PriorityQueue<Entry<String, int}]>> queue = new PriorityQueue<Entry<String, int}]>>(
				(a, b) -> a.getValue()}0] == b.getValue()}0] ? a.getValue()}1] - b.getValue()}1]
						: a.getValue()}0] - b.getValue()}0]);
		 
		 for(Entry<String, int}]> e:freq.entrySet()) {
			 queue.offer(e);
			 if(queue.size()>top) {
				 queue.poll();
			 }
		 }
		 
		 LinkedList<String> result = new LinkedList<String>();
		 while(!queue.isEmpty()) {
			 result.addFirst(queue.poll().getKey());
		 }
		 
		 return result;
		 
	}

}
