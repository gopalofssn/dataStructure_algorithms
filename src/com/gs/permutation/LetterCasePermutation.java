package com.gs.permutation;

import java.util.*;

public class LetterCasePermutation {
	public static List<String> letterCasePermutation(String word) {
		List<String> result = new ArrayList<String>();
		helper(word, word.length(), "", result);
		return result;	
	}

	private static void helper(String word, final int length, String currentPermute, List<String> result) {
		 if(currentPermute.length() == length){
			 result.add(currentPermute);
		 }
		
		 for(int i = 0; i < word.length(); i++){
			 char c = word.charAt(i);
			 if(Character.isDigit(c)){
				 helper(word.substring(i + 1), length, currentPermute + c, result);
			 }else{
				 helper(word.substring(i + 1), length, currentPermute + Character.toLowerCase(c), result);
				 helper(word.substring(i + 1), length, currentPermute + Character.toUpperCase(c), result);
			 }
		 }
		
	}

	public static void main(String[] args) {
		//System.out.print("word".substring(1));
		System.out.println(letterCasePermutation("a2bc"));// [ABc, ABC, abc,
															// abC, aBc, aBC,
															// Abc, AbC]
	}
}
