package com.king.datastructures.tree.heap;


public class Test {
	
	public static void main(String[] args) {
		MinHeapUtil heapUtil = new MinHeapUtil();
		int[] a ={2,8,6,1,10,15,3,12,11};
		int[] b = {2,8,6,1,10,15,3,12,11};
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");		
		}
		System.out.println();
		
		heapUtil.build(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");		
		}
		System.out.println();

		heapUtil.build2(b, b.length);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}

}
