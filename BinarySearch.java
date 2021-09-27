package com.problem1.service;

public class BinarySearch {
	
	public int binarySearchImplement(double[] array, int low, int high, double key) {
		// TODO Auto-generated method stub
		if(high < low)
			return -1;
		int mid = (low+high)/2;
		
		if(key == array[mid])
			return mid;
		else if(key<array[mid])
			return binarySearchImplement(array,0,mid-1,key);
		else
			return binarySearchImplement(array,mid+1,high,key);
			
		
		
	}

}
