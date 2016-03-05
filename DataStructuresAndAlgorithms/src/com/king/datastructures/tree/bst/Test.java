package com.king.datastructures.tree.bst;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IntBST intBST = new IntBST();
		intBST.insert(13);
		intBST.insert(10);
		intBST.insert(25);
		intBST.insert(2);
		intBST.insert(12);
		intBST.insert(20);
		intBST.insert(31);
		intBST.insert(29);
		
		System.out.print("breadthFirst:");
		intBST.breadthFirst();
		System.out.println();
		
		System.out.print("inorder:");
		intBST.inorder();
		System.out.println();
		
		System.out.print("preorder:");
		intBST.preorder();
		System.out.println();
		
		System.out.print("postorder:");
		intBST.postorder();
		System.out.println();
		
		System.out.print("iterativeInorder:");
		intBST.iterativeInorder();
		System.out.println();
		
		System.out.print("iterativePreorder:");
		intBST.iterativePreorder();
		System.out.println();
		
		System.out.print("iterativePostorder:");
		intBST.iterativePostorder();
		System.out.println();
	}

}
