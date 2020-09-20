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
            
    S :ramya 
    D :ryan
    
        +a+m-n
 */
public class CharAddSubtract {

	private static String find(String src, String dest) {
		int[] charCountArray = new int[26];
		int i = 0;
		int j = 0;
		while(i < src.length() && j < dest.length()){
			char s = src.charAt(i);
			char d = dest.charAt(j);
			if(s == d){
				i++;
				j++;
			}else{
				charCountArray[s - 'a']++;
				i++;
			}
		}
		
		while(i < src.length() ){
			char s = src.charAt(i);
			charCountArray[s - 'a']++;
			i++;
		}
		
		while(j < dest.length()){
			char d = dest.charAt(j);
			charCountArray[d - 'a']--;
			j++;
		}
		

		System.out.println("********" );
		for(char c = 'a'; c < 'z'; c++){
			System.out.println(c + " --> " + charCountArray[c - 'a']);
		}
		System.out.println("********");
		
		i = 0;
		j = 0;
		StringBuilder sb = new StringBuilder();
		while(i < src.length() && j < dest.length()){
			char s = src.charAt(i);
			char d = dest.charAt(j);
			if(s == d){
				i++;
				j++;
				continue;
			} 
			
			int pos = s - 'a';
			if(charCountArray[pos] > 0){
				charCountArray[pos]--;
				sb.append("+")
				  .append(s);
				i++;
			}else{
				charCountArray[pos]++;
				sb.append("-")
				  .append(d);
				j++;
			}
		}
		
	 
		while(i < src.length()){
			char s = src.charAt(i);
			int pos = s - 'a';
			if(charCountArray[pos] > 0){
				charCountArray[pos]--;
				sb.append("+")
				  .append(s);
			}
			i++;
		}
		

		
		while(j < dest.length()){ 
			char d = dest.charAt(j);
			System.out.println(d);
			int pos = d - 'a';
			if(charCountArray[pos] < 0){
				charCountArray[pos]++;
				sb.append("-")
				  .append(d);
			}
			j++;
		}
		
		return sb.toString();
	}

 

	public static void main(String[] args) {
		String src = "abcdef";
		String dest = "adegk";
		//System.out.println( find(src, dest)); // +b+c+f-g-k
		//System.out.println( find("ramya", "ryan")); // +a+m-n
		System.out.println( find("ryan", "ramya")); // -a-m+n
	}
}
