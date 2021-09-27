package com.problem1.service;

public class RiseFallCounter {

	public int countRiseNumber(boolean[] stockPriceStatusArray) {
		// TODO Auto-generated method stub
		
		int riseCounter = 0;
		
		for(int i=0;i<stockPriceStatusArray.length;i++)
		{
			if(stockPriceStatusArray[i])
				riseCounter++;
		}
		return riseCounter;
	}

	public int countFallNumber(boolean[] stockPriceStatusArray) {
		// TODO Auto-generated method stub
		int fallCounter = 0;
		
		for(int i=0;i<stockPriceStatusArray.length;i++)
		{
			if(!stockPriceStatusArray[i])
				fallCounter++;
		}
		return fallCounter;
		
	}

}
