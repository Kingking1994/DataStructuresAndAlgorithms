package com.king.datastructures.linkedlist.doublylinkedlist;

/**
 * 双向链表
 * @author king
 *
 */

public class IntDLList {
	private IntDLLNode head, tail;
	
	public IntDLList(){
		head = tail = null;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void addToTail(int el){
		if(!isEmpty()){
			tail = new IntDLLNode(el, null, tail);
			tail.prev.next = tail;
		}
		else{
			head = tail = new IntDLLNode(el);
		}
	}
	
	public void addToHead(int el){
		if(!isEmpty()){
			head = new IntDLLNode(el, head, null);
			head.next.prev = head;
		}
		else{
			head = tail = new IntDLLNode(el);
		}
	}
	
	public int removeFromTail(){
		int el = tail.info;
		if(head == tail){
			head = tail = null;
		}
		else{
			tail = tail.prev;
			tail.next = null;
		}
		return el;
	}
	
	public int removeFromHead(){
		int el = head.info;
		if(head == tail){
			head = tail = null;
		}else{
			head= head.next;
			head.prev = null;
		}
		return el;
	}
	
	public void printALL(){
		for(IntDLLNode tmp = head; tmp != null; tmp = tmp.next){
			System.out.println(tmp.info + " ");
		}
	}
	
	public void remove(int el){
		if(!isEmpty()){
			if(head == tail && head.info == el){
				head = tail = null;
			}
			else if(el == head.info){
				head = head.next;
				head.prev = null;
			}
			else{
				IntDLLNode tmp;
				for(tmp = head; tmp != null && tmp.info != el; tmp = tmp.next){}
				if(tmp != null){
					if(tmp == tail){
						tail = tail.prev;
						tail.next = null;
					}
					else{
						tmp.prev.next = tmp.next;
						tmp.next.prev = tmp.prev;
					}
				}
			}
		}
	}

}
