package com.self.gs.string;

/*
 dog, god - both permute same 
 */
public class SamePermule {


	private static boolean permuteSame(String str1, String str2) {
          if(isNullOrEmpty(str1) && isNullOrEmpty(str2)) return true;
          if(isNullOrEmpty(str1) || isNullOrEmpty(str2)) return false;
          if(str1.length() != str2.length()) return false;
          int[] v1 = new int[26];
          int[] v2 = new int[26];
          populateCount(str1, v1);
          populateCount(str2, v2);
          return isSame(v1, v2);
	}

	private static void populateCount(String str, int[] v) {
		for(char ch : str.trim().toCharArray()){
			ch = Character.toLowerCase(ch);
			v[ch - 'a']++;
		}
	}

	private static boolean isSame(int[] v1, int[] v2) {
		for(int i = 0; i < v1.length; i++){
			if(v1[i] != v2[i]) return false;
		}
		return true;
	}

	private static boolean isNullOrEmpty(String str) {
		return (str == null || str.trim().isEmpty());
	}
	
	public static void main(String[] args) {
		System.err.println(permuteSame("dog","god"));// true
		System.err.println(permuteSame("god","god"));// true
		System.err.println(permuteSame("god","God"));// true
		System.err.println(permuteSame("dog","omg")); // false
		System.err.println(permuteSame("dog","omgd"));// false
		System.err.println(permuteSame(null,null));
	}
}
