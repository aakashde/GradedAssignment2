package com.problem1.service;

public class StockSearch {

	public int isStockPresent(double[] stockArrayCopy, double stock) {
		// TODO Auto-generated method stub
		
		BinarySearch bS = new BinarySearch();
		
		return bS.binarySearchImplement(stockArrayCopy, 0, stockArrayCopy.length-1, stock);
		
		
		//return 0;
	}
	
	
	

}
