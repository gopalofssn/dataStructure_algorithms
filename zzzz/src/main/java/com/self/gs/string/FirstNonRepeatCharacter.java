package com.self.gs.string;
//Find first non-repeating string in a letter. e.g: For "apple" its a.
public class FirstNonRepeatCharacter {

	private static char find(String word) {
		char skipchar = ' ';
		char prev = word.charAt(0);
		for(int i = 1; i < word.length(); i++){
			char current = word.charAt(i);
			if(prev == current){
				skipchar = current;
			}else if(prev != skipchar && prev != current){
				return prev;
			}
			prev = current;
		}
		return ' ';
	}
	
	public static void main(String[] args) {
		String word = "aaaple";
		System.err.println(find(word));
	}

}
