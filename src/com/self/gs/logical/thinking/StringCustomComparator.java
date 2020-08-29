package com.self.gs.logical.thinking;

public class StringCustomComparator {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hell";
		System.err.println(compare(s1, s2));

	}

	private static int compare(String s1, String s2) {
		char[] v1 = s1.toCharArray();
		char[] v2 = s2.toCharArray();
		int len1 = v1.length;
		int len2 = v2.length;
		int limit = Math.min(len1, len2);
		int k = 0;
		while(limit > k) {
			char c1 = v1[k];
			char c2 = v2[k];
			if(c1 != c2) {
				return c1 - c2;
			}
			k++;
		}
		return len1 - len2;
	}

}
