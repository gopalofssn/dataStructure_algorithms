package com.self.gs.string;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveVowels {
	public static String vowelsString = "aeiouAEIOU" ;
	public static String SPACE =" ";
	public static ArrayList<Character> vowelsList = new ArrayList<>(
											vowelsString
											.chars()
											.mapToObj(i -> Character.valueOf((char)i))
											.collect(Collectors.toList())
											);

	
	public static void option1(String input) {
		input = input.replaceAll("["+vowelsString+"]", SPACE);
		print(Thread.currentThread().getStackTrace()[1].getMethodName(),input);
	}

	private static void option2(String str) {
		char[] charArray = str.toCharArray();
		StringBuilder builder = new StringBuilder(); // I choose string builder , because it is faster than SB
		for(char c : charArray) {
			builder = builder.append(
					vowelsList.contains(c)?SPACE:c
					);
		}
		print(Thread.currentThread().getStackTrace()[1].getMethodName() , builder.toString());
		
	}
	
	private static void print(String opt, String input) {
		System.out.println(opt +" -" + input);
	}
	
	public static void main(String[] args) {
		String str = " I am Legend";
		option1(str);
		option2(str);
	}

	
}
