package com.king.datastructures.tree.bst;

import com.king.datastructures.stack.LLStack;
import com.king.datastructures.queue.Queue;


/**
 * 二叉查找树
 * 对于每个节点n，左子树所保存的所有值都小于节点n保存的值，
 * 右子树所保存的所有值都大于节点n保存的值，
 * 避免一个树中有多个重复的值，
 * 对于字符串则是按照字母顺序。
 * @author king
 *
 */

public class IntBST {

	public IntBSTNode root;
	
	public IntBST(){
		root = null;
	}
	
	public void visit(IntBSTNode p){
		System.out.print(p.key + " ");
	}
	
	public IntBSTNode search(IntBSTNode p, int el){
		while(p != null){
			if(el == p.key){
				return p;
			}
			else if(el < p.key){
				p = p.left;
			}
			else{
				p = p.right;
			}
		}
		return null;
	}
	
	/**
	 * 广度优先遍历是从最底层（最高层）开始逐层向上（向下）遍历，
	 * 而在同层自左向右（或自右向左访问每个节点）
	 * 
	 * 这里是自顶向下，自左向右的实现
	 */
	public void breadthFirst(){
		IntBSTNode p = root;
		Queue queue = new Queue();
		if(p != null){
			queue.enqueue(p);
			while(!queue.isEmpty()){
				p = (IntBSTNode)queue.dequeue();
				visit(p);
				if(p.left != null){
					queue.enqueue(p.left);
				}
				if(p.right != null){
					queue.enqueue(p.right);
				}
			}
		}
	}
	
	/**
	 *前序遍历 
	 * @param p
	 */
	protected void preorder(IntBSTNode p){
		if(p != null){
			visit(p);
			preorder(p.left);
			preorder(p.right);
		}
	}
	public void preorder(){
		preorder(root);
	}
	
	/**
	 * 中序遍历
	 * @param p
	 */
	protected void inorder(IntBSTNode p){
		if(p != null){
			inorder(p.left);
			visit(p);
			inorder(p.right);
		}
	}
	public void inorder(){
		inorder(root);
	}
	
	/**
	 * 后序遍历
	 * @param p
	 */
	protected void postorder(IntBSTNode p){
		if(p != null){
			postorder(p.left);
			postorder(p.right);
			visit(p);
		}
	}
	public void postorder(){
		postorder(root);
	}
	
	/**
	 * 先序遍历树的非递归实现
	 */
	public void iterativePreorder(){
		IntBSTNode p = root;
		LLStack travStack = new LLStack();
		if(p != null){
			travStack.push(p);
			while(!travStack.isEmpty()){
				p = (IntBSTNode)travStack.pop();
				visit(p);
				if(p.right != null){
					travStack.push(p.right);
				}
				if(p.left != null){
					travStack.push(p.left);
				}
			}
		}
	}
	
	/**
	 * 后序遍历树的非递归实现
	 * 向堆栈压入有两个子孙的节点，一次是在遍历它的左子树之前，一次是在遍历它的右子树之前，
	 * 可以引入用一个辅助的引用q来区分这两种情况
	 * 
	 * 注意只有一个子孙的节点只能被压入一次，
	 * 且树叶节点根本不用被压入
	 */
	public void iterativePostorder(){
		IntBSTNode p =root, q = root;
		LLStack travStack = new LLStack();
		while(p != null){
			for(; p.left != null; p = p.left){
				travStack.push(p);
			}
			while(p != null && (p.right == null || p.right == q)){
				visit(p);
				q = p;
				if(travStack.isEmpty()){
					return ;
				}
				p = (IntBSTNode)travStack.pop();
			}
			travStack.push(p);
			p = p.right;
		}
	}
	
	/**
	 * 中序遍历树的非递归实现
	 */
	public void iterativeInorder(){
		IntBSTNode p = root;
		LLStack travStack = new LLStack();
		while(p != null){
			while(p != null){
				if(p.right != null){
					travStack.push(p.right);
				}
				travStack.push(p);
				p = p.left;
			}
			p = (IntBSTNode)travStack.pop();
			while(!travStack.isEmpty() && p.right == null){
				visit(p);
				p = (IntBSTNode)travStack.pop();
			}
			visit(p);
			if(!travStack.isEmpty()){
				p = (IntBSTNode)travStack.pop();
			}else{
				p = null;
			}
		}
	}
	
	/**
	 * 插入操作
	 * @param el
	 */
	public void insert(int el){
		IntBSTNode p = root, prev = null;
		while(p != null){
			prev = p;
			if(p.key < el){
				p = p.right;
			}else{
				p = p.left;
			}
		}
		if(root == null){
			root = new IntBSTNode(el);
		}
		else if(prev.key < el){
			prev.right = new IntBSTNode(el);
		}
		else{
			prev.left = new IntBSTNode(el);
		}
	}
	
	/**
	 * 该遍历算法会破坏树的结构，所以只能遍历一次
	 */
	public void MorrisInorder(){
		IntBSTNode p = root , tmp ;
		while(p != null){
			if(p.left == null){
				visit(p);
				p = p.right;
			}
			else{
				tmp = p.left;
				while(tmp.right != null && tmp.right != p){
					tmp =tmp.right;
				}
				if(tmp.right == null){
					tmp.right = p;
					p = p.left;
				}
				else{
					visit(p);
					tmp.right = null;
					p = p.right;
				}
			}
		}
	}
	
	/**
	 * 归并删除法
	 * @param el
	 */
	public void deleteByMerging(int el){
		IntBSTNode tmp, node, p = root, prev = null;
		while(p != null && p.key != el){                //找到要被删除的节点
			prev = p;
			if(p.key < el){
				p = p.right;
			}else{
				p = p.left;
			}
		}
		
		node = p;//被删除的节点
		
		if(p != null && p.key == el){
			if(node.right == null){//node没有右子节点的情况
				node = node.left;
			}
			else if(node.left == null){//node没有左子节点的情况
				node = node.right;
			}
			else{//node有两个节点的情况
				
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>与deleteByCopying不同的地方				
				tmp = node.left;
				while(tmp.right != null){
					tmp = tmp.right;
				}
				tmp.right = node.right;
				node = node.left;
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
			}
			
			if(p == root){//当被删除的节点为根节点时
				root = node;
			}
			else if(prev.left == p){//当被删除的节点为左节点时
				prev.left = node;
			}
			else{//当被删除的节点为右节点时
				prev.right = node;
			}
		}
		else if(root != null){
			System.out.println("key " + el + "is not in the tree");
		}
		else{
			System.out.println("the tree is empty");
		}
	}
	
	/**
	 * 复制删除法
	 * @param el
	 */
	public void deleteByCopying(int el){
		IntBSTNode tmp, node, p = root, prev = null;
		while(p != null && p.key != el){                //找到要被删除的节点
			prev = p;
			if(p.key < el){
				p = p.right;
			}else{
				p = p.left;
			}
		}
		
		node = p;//被删除的节点
		
		if(p != null && p.key == el){
			if(node.right == null){//node没有右子节点的情况
				node = node.left;
			}
			else if(node.left == null){//node没有左子节点的情况
				node = node.right;
			}
			else{//node有两个节点的情况
				
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>与deleteByMerging不同的地方				
				tmp = node.left;
				IntBSTNode previous = node;
				while(tmp.right != null){
					previous = tmp;
					tmp = tmp.right;
				}
				node.key = tmp.key;
				if(previous == node){
					previous.left = tmp.left;
				}
				else{
					previous.right = tmp.right;
				}
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
				
			}
			
			if(p == root){//当被删除的节点为根节点时
				root = node;
			}
			else if(prev.left == p){//当被删除的节点为左节点时
				prev.left = node;
			}
			else{//当被删除的节点为右节点时
				prev.right = node;
			}
		}
		else if(root != null){
			System.out.println("key " + el + "is not in the tree");
		}
		else{
			System.out.println("the tree is empty");
		}
	}
	
	/**
	 * 树的平衡
	 * 
	 * @param data
	 * @param first
	 * @param last
	 */
	public void balance(int data[],int first , int last ){
		if(first <= last){
			int midlle = (first + last) / 2;
			insert(data[midlle]);
			balance(data, first, midlle -1);
			balance(data ,midlle + 1, last);
		}
	}
	
	//DSW算法
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
}
