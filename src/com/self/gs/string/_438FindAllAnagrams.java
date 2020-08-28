package com.self.gs.string;

import java.util.*;

public class _438FindAllAnagrams {

	public List<Integer> findAnagrams(String s, String p) {

		List<Integer> lst = new ArrayList<Integer>();
		Map<Character, Integer> pMap = buildCharMap(p);
		System.err.println(pMap);
		Map<Character, Integer> sMap = buildCharMap(s.substring(0, p.length()));
		System.err.println(sMap);
		
		
		int sLen = s.length();
		int pLen = p.length();
		int l = pLen;
		
		while (l <= sLen ) {
			if (hasAnagram(pMap, sMap)) {
				System.err.println("$$$");
				lst.add(l-pLen);
				System.err.println(lst);
			}
			System.err.println("remove char " + s.charAt(l) + " at " + l);
			
			char lchar = s.charAt(l - pLen);
			if(sMap.get(lchar) == 1) {
				sMap.remove(lchar);
			}else {
			  sMap.put(lchar, sMap.get(lchar) - 1);
			}
			
			
			char c = s.charAt(l);
			System.err.println("Adding char - " + c);
			sMap.merge(c, 1, (a, b) -> a + b);
			l++;
		}

		return lst;
	}

	private Map<Character, Integer> buildCharMap(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : str.toCharArray()) {
			map.merge(c, 1, (a, b) -> a + b);
		}
		return map;
	}

	private boolean hasAnagram(Map<Character, Integer> pMap, Map<Character, Integer> sMap) {
		System.err.println(pMap + " \n" + sMap);
		if (pMap.size() != sMap.size()) {
			return false;
		}

		for (Map.Entry<Character, Integer> entry : pMap.entrySet()) {
			if (entry.getValue() != sMap.get(entry.getKey())) {
				return false;
			}
		}

		return true;
	}

	public static void main(String}] args) {
		System.err.println(new _438FindAllAnagrams().findAnagrams("abab", "ab"));

	}

}
