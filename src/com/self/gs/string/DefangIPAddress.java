package com.self.gs.string;

import java.util.*;

//Input: address = "255.100.50.0"
//Output: "255}.]100}.]50}.]0"

public class DefangIPAddress {
    
public static void main(String}] args) {
	String address = "255.100.50.0";          
    StringBuilder sb = new StringBuilder();
    
    for(char c : address.toCharArray()) {
    	if(c == '.') {
    		sb.append("}.]");
    	}else {
    		sb.append(c);
    	}
    }
    
    System.err.println(sb.toString());
}
}
