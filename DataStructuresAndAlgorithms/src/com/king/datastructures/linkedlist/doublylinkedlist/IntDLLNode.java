package com.king.datastructures.linkedlist.doublylinkedlist;

public class IntDLLNode {
	public int info;
	public IntDLLNode next , prev;
	
	public IntDLLNode(int el){
		this(el,null,null);
	}
	
	public IntDLLNode(int el,IntDLLNode n, IntDLLNode p){
		info = el;
		next = n;
		prev = p;
	}

}
