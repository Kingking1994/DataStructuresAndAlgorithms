package com.king.algorithms.sort;

public class Test {
	
	public static void main(String[] args) {
		Sort sort = new Sort();
		int[] data = new int[20];
		for (int i = 0; i < data.length; i++) {
			data[i] = (int)(Math.random()*100);
		}
		
		
//		sort.insertionSort(data);
//		for (int i = 0; i < data.length; i++) {
//			System.out.print(data[i] + " ");
//		}
//		
//		
//		sort.selectionSort(data);
//		for (int i = 0; i < data.length; i++) {
//			System.out.print(data[i] + " ");
//		}
//		
//		sort.bubbleSort(data);
//		for (int i = 0; i < data.length; i++) {
//			System.out.print(data[i] + " ");
//		}
//		
//		sort.quickSort(data);
//		for (int i = 0; i < data.length; i++) {
//		System.out.print(data[i] + " ");
//		}
		
		sort.quickSort2(data);
		for (int i = 0; i < data.length; i++) {
		System.out.print(data[i] + " ");
		}
		
	}

}
