package com.self.gs.string;

//Input: address = "255.100.50.0"
//Output: "255[.]100[.]50[.]0"

public class DefangIPAddress {
	
	private static String defang(String address) {
		if(address == null || address.isEmpty()) return address;
		StringBuilder sb = new StringBuilder();
		for(char c : address.toCharArray()){
			if(c == '.'){
				sb.append("[.]");
			}else{
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String address = "255.100.50.0";          
	    System.err.println(defang(address));
	}

}
