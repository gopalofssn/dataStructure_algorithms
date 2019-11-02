package com.self.gs.string;

import java.util.*;

//Input: address = "255.100.50.0"
//Output: "255[.]100[.]50[.]0"

 class Person{
	public String firstName;
	public String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
public class DefangIPAddress {
    private static final long MEGABYTE = 1024L * 1024L;

    
	public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }
	
public static void main(String[] args) {
	String address = "255.100.50.0";                         //2684544
	// System.out.println(address.replace(".", "[.]"));       //2684544
   // System.out.println(address.replaceAll("\\.", "[.]"));   //285920
	
	List<Person> list = new ArrayList<Person>();
    for (int i = 0; i <= 100000; i++) {
    	System.out.println(i);
        list.add(new Person("Jim", "Knopf"));
    }
    
	Runtime runtime = Runtime.getRuntime();
    // Run the garbage collector
    runtime.gc();
    // Calculate the used memory
    long memory = runtime.totalMemory() - runtime.freeMemory();
    System.out.println("Used memory is bytes: " + memory);
   // System.out.println("Used memory is megabytes:" + bytesToMegabytes(memory));
    
    
}
}
