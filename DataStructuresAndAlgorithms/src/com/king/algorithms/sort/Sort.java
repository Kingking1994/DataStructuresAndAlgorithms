package com.king.algorithms.sort;

public class Sort {
	
	/**
	 * 插入排序，升序
	 * @param data
	 */
	public void insertionSort(int[] data){
		for(int i = 1, j; i < data.length; i++){
			int tmp = data[i];
			for(j = i; j > 0 && tmp < data[j -1]; j--){
				data[j] = data[j-1];
			}
			data[j] = tmp;
		}
	}
	
	/**
	 * 选择排序，升序
	 * @param data
	 */
	public void selectionSort(int[] data){
		int i, j ,least;
		for(i=0; i < data.length; i++ ){
			for(j = i+1, least = i; j < data.length; j++){
				if(data[i] > data[j]){
					least = j;
				}
				if(i != least){
					swap(data,i,least);
				}
			}
		}
	}
	
	/**
	 * 冒泡排序，升序
	 * @param data
	 */
	public void bubbleSort(int[] data){
		for(int i=0; i < data.length -1; i++){
			for(int j = data.length - 1; j > i; j--){
				if(data[j] < data[j-1]){
					swap(data, j, j-1);
				}
			}
		}
	}
	
	   /*-----------------------快速排序法（一）--------------------------------------------- 
    这边所介绍的快速演算如下：将最左边的数设定为轴，并记录其值为s 
    廻圈处理： 
    令索引i 从数列左方往右方找，直到找到大于s 的数 
    令索引j 从数列左右方往左方找，直到找到小于s 的数 
    如果i >= j，则离开回圈 
    如果i < j，则交换索引i与j两处的值 
    将左侧的轴与j 进行交换 
    对轴左边进行递回 
    对轴右边进行递回   
    --------------------------------------------------------------------------------*/  
	public void quickSort(int[] data){
		quickSort(data, 0, data.length-1);
	}
	
	public void quickSort(int[] data, int left, int right){
		int le, ri, pivot;
		if(left < right){
			le = left + 1;
			ri = right;
			pivot = data[left];
			
			while(true){

				while(le < data.length-1 && data[le] <= pivot){
					le++;
				}
				
				while(ri > 0 && data[ri] > pivot){
					ri--;
				}
				
				
				if(le >= ri){
					break;
				}
				
				swap(data, ri, le);
			}
			data[left] = data[ri];
			data[ri] = pivot;
			quickSort(data, left, ri-1);
			quickSort(data, ri+1, right);
		}
	}
	
	   /*-----------------------快速排序法（二）--------------------------------------------- 
    在这个例子中，取中间的元素s作比较，同样的先得右找比s大的索引i，然后找比s小的 
    索引j，只要两边的索引还没有交会，就交换i 与j 的元素值，这次不用再进行轴的交换了， 
    因为在寻找交换的过程中，轴位置的元素也会参与交换的动作，例如： 
    41 24 76 11 45 64 21 69 19 36 
    首先left为0，right为9，(left+right)/2 = 4（取整数的商），所以轴为索引4的位置，比较的元素是 
    45，您往右找比45大的，往左找比45小的进行交换： 
    41 24 76* 11 [45] 64 21 69 19 *36 
    41 24 36 11 45* 64 21 69 19* 76 
    41 24 36 11 19 64* 21* 69 45 76 
   [41 24 36 11 19 21] [64 69 45 76] 
    完成以上之后，再初别对左边括号与右边括号的部份进行递回，如此就可以完成排序的目的。 
   --------------------------------------------------------------------------------*/ 
	public void quickSort2(int[] data){
		quickSort2(data, 0, data.length-1);
	}
	public void quickSort2(int[] data, int left, int right){
		int le, ri, pivot;
		if(left < right){
			pivot = data[(left + right)/2];
			le = left - 1;
			ri = right + 1;
			while(true){
				while(le < data.length-1 && data[++le] < pivot);
				
				while(ri > 0 && data[--ri] > pivot);
				
				if(le >= ri){
					break;
				}
				swap(data, ri, le);
			}
			quickSort2(data, left, le - 1);
			quickSort2(data, ri + 1, right);
		}
		
	}
	
	
	
	
	
	
	
	
	
	public void swap(int[] data, int i, int j){
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

}
