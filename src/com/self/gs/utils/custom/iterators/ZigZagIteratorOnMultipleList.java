package com.self.gs.utils.custom.iterators;

import java.util.*;

public class ZigZagIteratorOnMultipleList<T> implements Iterator<T> {

	private final int TOTAL;
	private int currentVisitedCount;
	private int currentRow;
	private int currentCol;
	private List<List<T>> lists;
	
	public ZigZagIteratorOnMultipleList(List<List<T>> lists) {
		this.lists = lists;
		this.TOTAL = findTotalElements(lists);
		this.currentVisitedCount = 0;
		this.currentRow = 0;
		this.currentCol = 0;
	}

	private int findTotalElements(List<List<T>> lists) {
		int total = 0;
		for(List<T> current : lists){
			total += (current != null) ? current.size() : 0;
		}
		System.out.println("Total item count " + total);
		return total;
	}

	@Override
	public boolean hasNext() {
		return (currentVisitedCount < TOTAL) ;
	}

	@Override
	public T next() {
		if(!hasNext()) throw new NoSuchElementException();
		helper();
		T val = lists.get(currentRow).get(currentCol);
		currentRow++;
		currentVisitedCount++;
		return val;
	}

	private void helper() {
		if(currentRow >= lists.size()){
			currentRow = currentRow % lists.size();
			currentCol++;
		}
		while( lists.get(currentRow) == null 
				|| lists.get(currentRow).size() == 0 
				|| lists.get(currentRow).size() <= currentCol){
			currentRow++;
			if(currentRow >= lists.size()){
				currentRow = currentRow % lists.size();
				currentCol++;
			}
		}
	}

	public static void main(String[] args) {
		List<List<String>> lists = new ArrayList<List<String>>();
		List<String> lst1 = new ArrayList<String>(Arrays.asList("1", "11", "111", "1111", "11111"));
		lists.add(lst1);
		List<String> lst2 = new ArrayList<String>(Arrays.asList("2", "22","222"));
		lists.add(lst2);
		List<String> lst3 = new ArrayList<String>(Arrays.asList("3", "33"));
		lists.add(lst3);
		List<String> lst4 = null;
		lists.add(lst4);
		List<String> lst5 = new ArrayList<String>();
		lists.add(lst5);
		List<String> lst6 = new ArrayList<String>(Arrays.asList("6","66","666"));
		lists.add(lst6);
		List<String> lst7 = new ArrayList<String>();
		lists.add(lst7);
		List<String> lst8 = new ArrayList<String>(Arrays.asList("8"));
		lists.add(lst8);
		ZigZagIteratorOnMultipleList<String> iterator = new ZigZagIteratorOnMultipleList<String>(lists);
		while(iterator.hasNext()){
			System.out.println(iterator.next()); // 1 11 2 22 3 4 5
		}
	}
	
}
