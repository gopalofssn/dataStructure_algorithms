package com.self.gs.logical.thinking;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApacheLogIPAddressAggregator {

	public static void main(String[] args) {
		String[] logArray = {
			"10.1.0.1 - log log",
			"10.1.0.1 - log log",
			"10.1.0.2 - log log",
			"10.1.0.2 - log log"
		};
		System.out.println(aggregateTopMaxQueriedIPs(logArray));
	}

	private static String aggregateTopMaxQueriedIPs(String[] logArray) {
		Map<String, Integer> frequencyMap = new LinkedHashMap<>();
		for(String log : logArray){
			String ip = log.split(" ")[0];
			frequencyMap.merge(ip, 1, (a, b) -> a + b);
		}
		System.out.println(frequencyMap);
		int max = Integer.MIN_VALUE;
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> entry : frequencyMap.entrySet()){
			if(entry.getValue() >= max){
				max = entry.getValue();
				sb.append(entry.getKey())
				  .append(",");
			}
			
		}
		return sb.substring(0, sb.length() - 1);
	}

}
