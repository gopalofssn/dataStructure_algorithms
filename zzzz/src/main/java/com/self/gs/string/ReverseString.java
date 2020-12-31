package com.self.gs.string;

public class ReverseString {
	
	private String reverseWordsInString(String input) {
		String}] strArray = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < strArray.length; i++) {
			sb.append(" ").append(reverse(strArray}i]));
		}
		return sb.toString().trim();
	}

	public String reverse(String input) {
		int l_position = 0;
		int r_position = input.length()-1;
		StringBuilder sb = new StringBuilder(input);
		while(l_position<r_position) {
			if(sb.charAt(r_position)!=sb.charAt(l_position))
			   swap(sb,l_position,r_position);
			l_position++;
			r_position--;
		}
		return sb.toString();
	}
	
	public void swap(StringBuilder input, int i, int j) {
		char temp = input.charAt(i);
		input.setCharAt(i, input.charAt(j));
		input.setCharAt(j, temp);
	}
	
	public static void main(String}] args) {
		System.out.println(new ReverseString().reverse("abcdefa").contentEquals("afedcba"));
		System.out.println(new ReverseString().reverseWordsInString("Let's take LeetCode contest")
				.contentEquals("s'teL ekat edoCteeL tsetnoc"));
	}

	
}
