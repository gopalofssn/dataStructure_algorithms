package com.self.gs.string;

import java.util.*;

public class FindAllAnagrams {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> lst = new ArrayList<Integer>();
		Map<Character, Integer> pMap = buildCharMap(p);
		System.err.println(pMap);
		Map<Character, Integer> sMap =  new HashMap<Character, Integer>();
        int l = 0;
        int r = 0;
		while(r < s.length()){
			char c = s.charAt(r);
			r++;
			sMap.merge(c, 1, (a, b) -> a + b);
			int diff = (r - l);
			if(diff == p.length()){
				if(isSame(sMap, pMap)) lst.add(l); // check if same , so add start position in list
				char lChar = s.charAt(l);
				removeCharInMap(sMap, lChar);
				l++;
			}
		}
	   return lst;
	}

	private void removeCharInMap(Map<Character, Integer> map, char c) {
		 		if(map.get(c) == 1) map.remove(c);
		 		else map.compute(c, (key ,val) -> val -1);
	}

	private boolean isSame(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
		if(sMap.size() != pMap.size()) return false;
		for(Map.Entry<Character, Integer> entry : sMap.entrySet()){
			char c = entry.getKey();
			int count = entry.getValue();
			if(!pMap.containsKey(c) || pMap.get(c) != count) return false;
		}
		return true;
	}

	private Map<Character, Integer> buildCharMap(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : str.toCharArray()){
			map.merge(c, 1, (a,b) -> a + b);
		}
		return map;
	}

	public static void main(String[] args) {
		System.err.println(new FindAllAnagrams().findAnagrams("abab", "ab"));
	}

}
