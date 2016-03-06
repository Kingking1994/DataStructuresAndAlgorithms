package com.king.datastructures.tree.threadedtree;

public class Test {
	
	public static void main(String[] args) {
		IntThreadedTree tree = new IntThreadedTree();
		
		tree.threadedInsert(15);
		tree.threadedInsert(4);
		tree.threadedInsert(30);
		tree.threadedInsert(2);
		tree.threadedInsert(17);
		tree.threadedInsert(19);
		tree.threadedInsert(18);
		
		tree.threadedInorder();
	}

}
