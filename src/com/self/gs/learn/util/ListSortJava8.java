package com.self.gs.learn.util;

import java.util.*;


public class ListSortJava8 {
	public static void main(String[] args) {
		String data[] = new String[3];
		data[0] = ("bob");
		data[1] = ("abe");
		data[2] = ("cob");
	
		List<String> lst = new ArrayList<String>(Arrays.asList(data));
		lst.sort((a,b)->a.compareTo(b)); // lambda to compare
		lst.remove(2); // if line #13 has just Arrays.asList(data), it wont work and throw unsuported excption
		System.out.println(lst);
		
		System.out.println(Arrays.toString(data));
	}
		
		
}
