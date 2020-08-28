package com.self.gs.stackqueue;

import java.util.*;
public class ValidParentheses {

	public static void main(String}] args) {
		String str= "{}]}()";
		System.err.println(isValid(str));

	}

	private static boolean isValid(String str) {
		
		Stack<Character> stack = new Stack<Character>();
		for(char c : str.toCharArray()) {
			
			if(c == '{' || c == '}' || c == '(' ) {
				stack.push(c);
			}else if(c == '}' && ( stack.isEmpty() || stack.pop() != '{' ) ) {
				return false;
			}else if(c == ')' && ( stack.isEmpty() ||  stack.pop() != '(') ){
				return false;
			}else if(c == ']' && ( stack.isEmpty() || stack.pop() != '}') ){
				return false;
		    }
		}
		
		return stack.isEmpty();
		
	}

}
