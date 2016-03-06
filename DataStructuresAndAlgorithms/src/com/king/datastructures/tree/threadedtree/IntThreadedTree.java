package com.king.datastructures.tree.threadedtree;

/**
 * 线索树
 * @author king
 *
 */

public class IntThreadedTree {

	private IntThreadedTreeNode root;
	
	public IntThreadedTree(){
		root = null;
	}
	
	protected void visit(IntThreadedTreeNode p){
		System.out.print(p.key + " ");
	}
	
	/**
	 * 插入操作
	 * @param el
	 */
	public void threadedInsert(int el){
		IntThreadedTreeNode newNode = new IntThreadedTreeNode(el);
		if(root == null){//判断是否为空树，直接赋值给根节点
			root = newNode;
			return;
		}
		IntThreadedTreeNode p = root, prev = null;
		while(p != null){//找到要插入的位置
			prev = p;
			if(el < p.key){
				p = p.left;
			}
			else if(! p.hasSuccessor){//hasSuccessor == false，说明该节点的右子节点不存在，而是指向父节点或者祖先节点
				p = p.right;
			}
			else{
				break;
			}
		}
		if(el < prev.key){
			prev.left = newNode;
			newNode.hasSuccessor = true;
			newNode.right = prev;
		}
		else if(prev.hasSuccessor){
			newNode.hasSuccessor = true;
			prev.hasSuccessor = false;
			newNode.right = prev.right;
			prev.right = newNode;
		}
		else{
			prev.right = newNode;
		}
	}
	
	/**
	 * 中序遍历
	 */
	public void threadedInorder(){
		IntThreadedTreeNode prev, p = root;
		if(p != null){
			while(p.left != null){
				p = p.left;
			}
			while(p != null){
				visit(p);
				prev = p;
				p = p.right;
				if(p != null && !prev.hasSuccessor){
					while(p.left != null){
						p = p.left;
					}
				}
			}
		}
	}
	
}
