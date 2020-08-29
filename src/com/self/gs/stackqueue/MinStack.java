package com.self.gs.stackqueue;

import java.util.Stack;
//https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
public class MinStack implements SpecialStack{

	private Stack<Integer> stack;
	private Integer minElement;
	
	public MinStack() {
		stack = new Stack<Integer>();
	}
	
	/*
	 Push(x) : Inserts x at the top of stack.

If stack is empty, insert x into the stack and make minEle equal to x.
If stack is not empty, compare x with minEle. Two cases arise:
If x is greater than or equal to minEle, simply insert x.
If x is less than minEle, insert (2*x – minEle) into the stack and make minEle equal to x. 
   For example, let previous minEle was 3. Now we want to insert 2. We update minEle as 2 and insert 2*2 – 3 = 1 into the stack.
   2*X-min = stack push element
	 */
	@Override
	public Integer push(Integer element) {
        if(stack.isEmpty()) {
        	minElement = element;
        	stack.push(element);
        }else if(element>=minElement){
        	stack.push(element);
        }else {
        	stack.push(2*element - minElement);
        	minElement = element;
        }
		return element;
	}

	@Override
	public Integer peek() {
		if(isEmpty())
			throw new MyStackException("Min Stack is Empty !!!");
		
		int peek = stack.peek();
		if(peek>=minElement)
			return peek;
		int tmp = (2*minElement)-peek;
		return tmp;
	}
	
	/*
	Pop() : Removes an element from top of stack.

Remove element from top. Let the removed element be y. Two cases arise:
If y is greater than or equal to minEle, the minimum element in the stack is still minEle.
If y is less than minEle, the minimum element now becomes (2*minEle – y), so update (minEle = 2*minEle – y). 
   This is where we retrieve previous minimum from current minimum and its value in stack. 
   For example, let the element to be removed be 1 and minEle be 2. We remove 1 and update minEle as 2*2 – 1 = 3.
	 */
	@Override
	public Integer pop(){
		if(isEmpty())
			throw new MyStackException("Min Stack is Empty !!!");
		int tmp = stack.pop();
		if(tmp<minElement) {
			minElement = 2*minElement-tmp;
		}
		return tmp;
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}
   
	public Integer getMin() {
		return this.minElement;
	}
	
	public Stack<Integer> getStack() {
		return this.stack;
	}
	
	public static void main(String[] args) {
		MinStack s =new MinStack();
		int[] data = new int[] {3,5,2,1,-1};
		for(int d:data) {
			System.out.println(s.push(d));
		}
		System.out.println(s.getStack());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

	
   
}
