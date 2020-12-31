package com.gs.iterator;

import java.util.*;

public class Flatten2DVectorIterator implements Iterator<Integer> {
	
	int index;
	List<List<Integer>>  lists;
	Iterator<Integer> iterator;
	
	public Flatten2DVectorIterator(List<List<Integer>>  lst) {
		this.lists =  lst;
		this.index = 0;
		addToIterator();
	}

	private boolean addToIterator() {
		if(index >= lists.size()) return false;
		
	    if(lists.get(index) == null || lists.get(index).size() == 0) { // null or empty 
			index++;
			return addToIterator();
		}
		System.err.println("index " + index);
		iterator = lists.get(index).iterator();
		index++;
		return true;
	}

	@Override
	public boolean hasNext() {
		if(iterator.hasNext()) return true;
		return addToIterator() && hasNext();
	}

	@Override
	public Integer next() {
		if(hasNext()) return iterator.next();
		else return null;
	}

	public static void main(String[] args) {
		List<List<Integer>>  lists = new ArrayList<List<Integer>>();
		lists.add(new ArrayList<Integer>(Arrays.asList(1,2,3))); //0
		lists.add(new ArrayList<Integer>(Arrays.asList(4,5))); //1
		lists.add(new ArrayList<Integer>()); //2
		lists.add(new ArrayList<Integer>(Arrays.asList(6,7,8))); //3
		lists.add(null); //4
		lists.add(new ArrayList<Integer>(Arrays.asList(10))); //5

		Iterator<Integer> iterator = new Flatten2DVectorIterator(lists);
		while(iterator.hasNext()) {
			System.err.println(iterator.next());
			lists.get(3).add(55);
		}
		
		System.err.println(iterator.next());
	}
	
}
