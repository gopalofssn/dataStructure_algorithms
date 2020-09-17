package com.gs.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

/*
  IP:
     SRC : abcdef
     DEST: abbde
    make dest string as same as src by doing
  OP
            -b+c+f
 */
public class CharAddSubtract {

	private static String find(String src, String dest) {
		Stack<Character> srcStack = populateStack(src);
		Stack<Character> destStack = populateStack(dest);
		LinkedList<String> ll = new LinkedList<String>();
		
		while(!srcStack.isEmpty()){
			if(srcStack.size() > destStack.size()){
				ll.addFirst("+" + srcStack.pop());
			}else if(srcStack.size() < destStack.size()){
				ll.addFirst("+" + destStack.pop());
			}else if(srcStack.size() == destStack.size() && srcStack.peek() == destStack.peek()){
				srcStack.pop();
				destStack.pop();
			}else{
				ll.addFirst("-" + destStack.pop());
				ll.addFirst("+" + srcStack.pop());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(String s : ll){
			sb.append(s);
		}
		return sb.toString();
	}

	private static Stack<Character> populateStack(String content) {
		Stack<Character> stack = new Stack<>();
		for(char c : content.toCharArray()){
			stack.push(c);
		}
		return stack;
	}

	public static void main(String[] args) {
		String src = "abcdef";
		String dest = "ade";
		System.out.println( find(src, dest));
	}
}
