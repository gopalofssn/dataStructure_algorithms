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
    	char[] v = s.toCharArray();
    	int len = s.length();
    	int maxIteration = (len / k) + 1;
    	k = Math.min(len, k);
    	boolean flag = true;
    	int l = 0;
    	int r = k - 1;
    	for(int i = 0; i < maxIteration; i++){
        	if(flag){
        		System.out.println("rev.." + l + " " + r);
        		reverse(v, l, r);
        	}
        	flag = !flag;
        	l += k;
        	r += k;		
        	len -= k;
    	}
    	
    	return String.valueOf(v);
    }
	private static void reverse(char[] v, int l, int r) {
		while(l < r){
			char tmp = v[l];
			v[l++] = v[r];
			v[r--] = tmp;
		}
	}
	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefg",2));
		System.out.println(reverseStr("abcdefg",9));
	}

}
