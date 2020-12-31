package improve_coding_skills;

import java.util.HashMap;
import java.util.Map;

public class NumbersOfWaysToDecode {
	
	static Map<Character, Integer> referenceTable = new HashMap<>();
	
	static{
		int counter = 1;
		for(char c = 'a'; c <='z'; c++){
			referenceTable.put(c, counter++);
		}
	}
	
	private static int findNumberOfWay(String s) {
		if(s == null || s.isEmpty()) return 0;
		
		int val = Integer.parseInt(s);
		if(val == 0) return 0;
		if(val == 10 || val == 1) return 1;
		
		int l = 0;
		int r = 2;
		int count = 1;
		while(r <= s.length()){
			String portion = s.substring(l, r);
			int i = Integer.parseInt(portion);
			if(i <= 26) count++;
			l++;
			r++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(findNumberOfWay("226")); // 3
		System.out.println(findNumberOfWay("0")); // 0
		System.out.println(findNumberOfWay("10")); // 1
		System.out.println(findNumberOfWay("01")); // 0
		System.out.println(findNumberOfWay("100")); // 3
	}



}
