package com.king.datastructures.tree.heap;

/**
 * 最小堆的操作工具类
 * @author king
 *
 */
public class MinHeapUtil {
	
	public void swap(int[] a, int m, int n){
		int tmp = a[m];
		a[m] = a[n];
		a[n] = tmp;
	}
	
	/**
	 * 
	 * 向上移动
	 * @param a
	 * @param i
	 */
	public void fixUp(int a[], int i){
	//  新加入i结点  其父结点为(i - 1) / 2 
		int j = (i - 1) / 2;      //父结点 
		while(j >= 0 && i != 0){
			if(a[i] >= a[j]){
				break;
			}
			swap(a , i , j);//把较大的子结点往下移动,替换它的子结点
			i = j;
			j = (i -1) / 2;
		}
		
	}
	
	/**
	 * 插入操作
	 * @param a
	 * @param cnt 插入后，元素的个数
	 * @param item 要插入的内容
	 */
	public void insert(int a[], int cnt, int item){
		a[cnt] = item;//把新的节点放到数组的最后
		fixUp(a, cnt);//进行向上移动
	}
	
	/**
	 * 向下移动
	 * @param a
	 * @param i 开始调整的节点
	 * @param cnt 元素数
	 */
	public void fixDown(int a[], int i, int cnt){
	//  从i节点开始调整,cnt为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2 
		int j = i*2 + 1;
		
		while(j < cnt){
			if(j + 1 < cnt && a[j] > a[j+1]){//在左右孩子中找最小的
				j++;
			}
			if(a[j] >= a[i]){//如果最小的孩子大于等于父节点，那就不用移动
				break;
			}
			swap(a ,j , i);//把较小的子结点往上移动,替换它的父结点
			i = j;
			j = i*2 + 1;
		}
	}
	
	/**
	 * 删除操作
	 * @param a
	 * @param cnt
	 */
	public void delete(int a[], int cnt){
		swap(a , 0 , cnt -1);
		fixDown(a , 0 , cnt -1);
	}
	

	/**
	 * 
	 * @param a
	 * @param cnt
	 */
	public void build(int a[], int cnt){
		for(int i = cnt / 2 - 1; i >= 0 ;i--){
			fixDown(a , i , cnt);
		}
	}
	
	/**
	 * 一次一次地插入
	 * @param a
	 * @param cnt
	 */
	public void build2(int a[], int cnt){
		
		for(int i = 1; i < cnt; i++){
			fixUp(a , i);
		}
	}
}
