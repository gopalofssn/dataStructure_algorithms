package com.gs.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IPaddressRestore {

	 public List<String> restoreIpAddresses(String s) {
	        if(isNullOrEmpty(s)) return Collections.emptyList();
	        final int LEN = s.length();
	        if(LEN < 4 || LEN > 12) return Collections.emptyList();
	        List<String> result = new ArrayList<String>();
	        restoreIpAddressesHelper("", s, 0, 0, result);
	        return result;
	    }
	 
	 private void restoreIpAddressesHelper(String ip, String s, int index, int segmentNumber, List<String> result) {
		 System.out.println("s " + s);
		if(s.isEmpty() && segmentNumber == 4) {
			System.out.println("adding " + ip);
			result.add(ip);
		}else if(s.isEmpty() || segmentNumber == 4) {
			return;
		}else {
			int maxSegmentSize = (s.length()) - index > 3 ? 3 : (s.length()) - index ;
			if(s.charAt(index) == 0)
				maxSegmentSize = 1;
			for(int i = 1; i <= maxSegmentSize; i++) {
				System.out.println(index + " , " + i);
				String segment = s.substring(index, index + i);
				System.out.println(segment);
				if(ip == "") ip = segment;
				else ip = ip + "." + segment;
				s = s.substring(index + i);
				restoreIpAddressesHelper(ip, s, index + 1, segmentNumber + 1, result);
			}
		}
		
	 }

	private static boolean isNullOrEmpty(String s){
	        return (s == null || s.isEmpty());
	    }

	public static void main(String[] args) {
		String s = "010010";
		System.out.println(new IPaddressRestore().restoreIpAddresses(s));
	}

}
