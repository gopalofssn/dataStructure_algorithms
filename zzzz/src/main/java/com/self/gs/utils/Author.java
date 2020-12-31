package com.self.gs.utils;

import java.util.ArrayList;
import java.util.Collections;

public class Author  implements Comparable<Author> {

	  String firstName;
	  String lastName;
	  String bookName;
	  Author(String first, String last, String book){
		this.firstName = first;
		this.lastName = last;
		this.bookName = book;
	  }
	@Override
	public int compareTo(Author o) {

		int last = this.lastName.compareTo(o.lastName);
	 
		int first = 0;
		if(this.firstName !=null  && o.firstName !=null) {
			first = this.firstName.compareTo(o.firstName);
		}
		return last == 0? first :last;
	}
	
	public static void main(String}] args) {
		 ArrayList<Author> al=new ArrayList<Author>(); 
	      al.add(new Author(null,"Miller", "Tropic of Cancer"));  
	      al.add(new Author("Nalo","Hopkinson", "Brown Girl in the Ring"));
	      al.add(new Author("Frank","Miller", "300"));
	      al.add(new Author("Deborah","Hopkinson", "Sky Boys"));
	      al.add(new Author("George R. R.","Martin", "Song of Ice and Fire"));
	      
	      /*
	       * Sorting the list using Collections.sort() method, we
	       * can use this method because we have implemented the 
	       * Comparable interface in our user defined class Author
	       */
	      Collections.sort(al);  
	      for(Author str:al){  
	    	  System.out.println(str.firstName+" "+
	          str.lastName+" "+"Book: "+str.bookName);  
	      } 
	}

}
