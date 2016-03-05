package com.king.datastructures.queue;

import java.util.LinkedList;

/**
 * 基于链表的队列实现
 * @author king
 *
 */

public class Queue {
	
	private LinkedList<Object> list = new LinkedList<>();
	
	public Queue(){
		
	}
	
	public void clear(){
		list.clear();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public Object firstEl(){
		return list.getFirst();
	}
	
	
	public Object dequeue(){
		return list.removeFirst();
	}
	
	public void enqueue(Object el){
		list.addLast(el);
	}
	
	public String toString(){
		return list.toString();
	}

}
