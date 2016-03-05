package com.king.datastructures.stack;

import java.util.LinkedList;

/**
 * 基于链表的堆栈实现
 * @author king
 *
 */

public class LLStack {
	
	private LinkedList<Object> list = new LinkedList<>();

	public LLStack(){
		
	}
	
	public void clear(){
		list.clear();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public Object peek(){
		if(isEmpty()){
			throw new java.util.EmptyStackException();
		}
		return list.getLast();
	}
	
	public Object pop(){
		if(isEmpty()){
			throw new java.util.EmptyStackException();
		}
		return list.removeLast();
	}
	
	public void push(Object el){
		list.addLast(el);
	}
	
	public String toString(){
		return list.toString();
	}
}
