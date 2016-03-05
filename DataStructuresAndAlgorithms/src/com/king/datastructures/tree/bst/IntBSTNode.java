package com.king.datastructures.tree.bst;

/**
 * 二叉查找树节点
 * @author king
 *
 */

public class IntBSTNode {
	
	public int key;
	public IntBSTNode left, right;
	
	public IntBSTNode(){
		left = right = null;
	}
	
	public IntBSTNode(int el){
		this(el, null, null);
	}
	
	public IntBSTNode(int el, IntBSTNode lt, IntBSTNode rt){
		key = el;
		left = lt;
		right = rt;
	}

}
