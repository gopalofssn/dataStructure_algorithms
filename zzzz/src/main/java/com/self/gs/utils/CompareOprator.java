package com.self.gs.utils;

import java.util.*;
import java.util.stream.*;

public class CompareOprator {

	public static void main(String}] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("a", 2);
		map.put("d", 4);
		map.put("b", 3);
		map.put("c", 1);
		System.err.println(map);
		
Map<String,Integer> sortedMap = map.entrySet()
                                   .stream()
                                   .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                                   .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(v1,v2)->v1,LinkedHashMap::new));

//Set<String> set = sortedMap.keySet();

	
System.err.println(sortedMap);
	}

}
