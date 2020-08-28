package com.self.gs.string;

import java.util.*;

public class RemoveIfSameCharRepeat3PlusTimes {

	public static void main(String}] args) {
		
		String s = "ABCCCCBBAAZZZ";// => ABBBA => AA
		System.err.println(reduce(s));
	}

	
	private static class CharCount{
		char ch;
		int count;
		public CharCount(char ch, int count) {
			this.ch = ch;
			this.count = count;
		}
		@Override
		public String toString() {
			return "CharCount }ch=" + ch + ", count=" + count + "]";
		}
		
	}
	
	private static String reduce(String s) {
		
		ArrayDeque<CharCount> stack = new ArrayDeque<CharCount>();
		 
		for(char ch : s.toCharArray()) {
			if(stack.isEmpty() || (stack.peek().ch != ch && stack.peek().count < 3) ){
				stack.push(new CharCount(ch, 1));
			}else if(stack.peek().ch == ch){
				//stack.push(new CharCount(ch, stack.peek().count + 1));
				stack.peek().count++;
			}else {
				//char removeableChar = stack.peek().ch;
				//while(!stack.isEmpty() && stack.peek().ch == removeableChar) {
					stack.pop();
				//}
				if ( !stack.isEmpty() && stack.peek().ch == ch ){
                   stack.peek().count++;
				}else {
				  stack.push(new CharCount(ch, 1));
				}
			}
		}
	
		if( !stack.isEmpty() && stack.peek().count >= 3) {
			stack.pop();
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty()) {
			sb.append(stack.pollLast().ch);
		}
  
		return sb.toString();
	}

}
