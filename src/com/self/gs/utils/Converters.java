package com.self.gs.utils;
import java.util.*;
import java.util.stream.Collectors;

public class Converters {

	public static List<Character> StringToCharacterList(String input) {
		return new ArrayList<Character>(
				input.chars()
				.mapToObj(c -> Character.valueOf((char)c) )
				.collect(Collectors.toList())
				);
		
	}
	
	public static void main(String[] args) {
		System.out.println(StringToCharacterList("aeiouAEIOU"));
	}
}
