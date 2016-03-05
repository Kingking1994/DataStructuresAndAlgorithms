package com.king.datastructures.stack;

import java.util.ArrayList;

/**
 * 基于数组链表的堆栈实现
 * @author king
 *
 */

public class ALStack {
	
	private ArrayList<Object> pool = new ArrayList<>();
	
	public ALStack(){
		
	}
	
	public void clear(){
		pool.clear();
	}
	
	public boolean isEmpty(){
		return pool.isEmpty();
	}
	
	public Object peek(){
		if(isEmpty()){
			throw new java.util.EmptyStackException();
		}
		return pool.get(pool.size() - 1);
	}

	public Object pop(){
		if(isEmpty()){
			throw new java.util.EmptyStackException();
		}
		return pool.remove(pool.size() - 1);
	}
	
	public void push(Object el){
		pool.add(el);
	}
	
	public String toString(){
		return pool.toString();
	}
}
