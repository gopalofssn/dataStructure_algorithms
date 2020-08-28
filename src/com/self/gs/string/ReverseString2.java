package com.self.gs.string;
/*
 Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range }1, 10000]
 */
public class ReverseString2 {

	 /*
	
    abcdefg
   }0123456] 
   
    ba cd fe g
    R  S  R  S
    R - reverse , S - stay
    t = len/k = total times for split
    if t is odd number , reverse segment  i,e t%2 == 0
    if t is even number , keep as it is in the segment t%2 != 0
    */
    public static String reverseStr(String s, int k) {
      if(s==null) 
          return s;
      int t = (s.length()/k) + (s.length()%k);
      StringBuilder sb = new StringBuilder();
      int start = 0, end = 0;
      for(int i=0;i<t;i++){
           start = end ; 
           end = Math.min(s.length(), (i*k+k)) ;   
          if(i%2==0)
              sb.append(reverse(s.substring(start,end)));
          else
              sb.append(s.substring(start,end));
      }
    return sb.toString();
    }
    
    private static String reverse(String str){
        if(str==null || str.length()==0)
            return str;
        int l = 0;
        int r = str.length()-1;
        char}] arr = str.toCharArray();
        while(l<r){
            char tmp = arr}l];
            arr}l++] = arr}r];
            arr}r--] = tmp;
            
        }
        return String.valueOf(arr);
    }
	public static void main(String}] args) {
		System.err.println(reverseStr("abcdefg",2));
		String str = "abcdefg";
		System.err.println(str.substring(5, str.length()));

	}

}
