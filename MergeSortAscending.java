package com.problem1.service;

public class MergeSortAscending {

	public void sort(double[] array, int left, int right) {
		
		
		if(left < right)
		{
			//find the middle element
			int mid = (left+right)/2;
			
			sort(array,left,mid);
			sort(array,mid+1,right);
			
			merge(array,left, mid, right);
		}
	}

	private void merge(double[] array, int left, int mid, int right) {
		int n1 = mid-left +1;// n1 = 3  
		int n2 = right-mid;  // n2 = 2
		
		double leftArray[] = new double[n1];
		double rightArray[] = new double[n2];
		
		for(int i = 0; i < n1; i++)
			leftArray[i] = array[left + i];
		for(int j = 0; j < n2; j++)
			rightArray[j] = array[mid+1+j];
		
		int k = left;
		int i = 0, j = 0;
		while(i < n1 && j < n2)
		{
			if(leftArray[i] <=rightArray[j])
			{
				array[k] = leftArray[i];
				i++;
			}
			else
			{
				array[k] = rightArray[j];
				j++;
			}
			
			k++;	
		}
		
		while(i<n1)
		{
			array[k] = leftArray[i];
			i++;
			k++;
		}
		
		while(j<n2)
		{
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}

}
