package com.self.gs.string;

public class LongestCommonPrefix {
	

	private static char[] longestCommonPrefix(String[] strs) {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String[] args) {
		String[] strs = new String[] {"flower","flow","flight"};
		System.err.println(longestCommonPrefix(strs));
	}

}






/*
public static String longestCommonPrefix(String[] strArray) {
       StringBuilder sb = new StringBuilder();
       int index = 0;
       for(char c : strArray[0].toCharArray()){
    	   for(int i = 1; i < strArray.length; i++){
    		   if(strArray[i].length() < index || c != strArray[i].charAt(index)){
    			   return sb.toString();
    		   }
    	   }
    	   sb.append(c);
    	   index++;
       }
       return sb.toString();
    }
*/