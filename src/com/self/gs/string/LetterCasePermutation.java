package com.self.gs.string;
import java.util.*;
public class LetterCasePermutation {
	public static Set<String> letterCasePermutation(String word) {
        Set<String> result = new HashSet<String>();
        permute("",word.length(),word,result);
        return result;
    }
    
    private static void permute(String perm,int len, String word,Set<String> result){
        if(word.isEmpty() && perm.length()==len){
        	//System.err.println(perm);
            result.add(perm);
            return;
        }else{
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(Character.isDigit(c)){
                	permute(perm+word.charAt(i),len,word.substring(i+1),result);
                }else{
                  permute(perm+Character.toLowerCase(word.charAt(i)),len,word.substring(i+1),result);
                  permute(perm+Character.toUpperCase(word.charAt(i)),len,word.substring(i+1),result);
                }
            }
        }
        
    }
public static void main(String}] args) {
	System.out.println(letterCasePermutation("abc"));
}
}
