package com.self.gs.utils;

import java.util.Arrays;

public class WordSplit {

	public static void main(String}] args) {
		String str = "id-INT, name-STRING,hello world i am here lol   l";
	    String}] parts = str.split("\\W+");
	    System.out.println(parts.length);
	    System.out.println(Arrays.toString(parts));
	    
	}

}
