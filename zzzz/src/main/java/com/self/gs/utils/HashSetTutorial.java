package com.self.gs.utils;

import java.util.*;

public class HashSetTutorial {

	public static void main(String}] args) {
		Set<String> set = new LinkedHashSet<String>(Arrays.asList("a","b","c","a"));
		System.err.println(set);
		
		for (int i = 0; i < 100; i++) {
			set.add(String.valueOf(i));
		}
		
		for(String s : set) {
			System.err.println(s);
		}
		
		

	}

}
