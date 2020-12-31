package com.self.gs.string;

import java.util.Stack;

public class ValidParenthesisChecker {
	
	private static boolean isValid(String str) {
		Stack<Character> stack = new Stack<>();
		for(char c : str.toCharArray()){
			if(c == '('){
				stack.push(c);
			}else if(c == ')'){
				if(stack.isEmpty()) return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("((s)())")); // true
		System.out.println(isValid("(())(v))")); // false
		System.out.println(isValid("(())(v)(")); // false
		
	}
}
