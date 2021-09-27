package com.problem1.driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.problem1.service.MergeSortAscending;
import com.problem1.service.RiseFallCounter;
import com.problem1.service.StockSearch;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter the no of companies");
		int noOfCompanies = Integer.parseInt(br.readLine());
		
		double stockArray[] = new double[noOfCompanies];
		boolean stockPriceStatusArray[] = new boolean[noOfCompanies];
		
		for(int i=0;i<noOfCompanies;i++)
		{
			System.out.println("Enter current stock price of the company "+(i+1));
			stockArray[i] = Double.parseDouble(br.readLine());
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			stockPriceStatusArray[i]=Boolean.parseBoolean(br.readLine());
		}
		
		int choiece = 0;
		
		//creating a copy of the Original Array so as to not to disturb the rising and falling of price of Stock sequence
		
		double stockArrayCopy[] = new double[noOfCompanies];
		
		for(int i=0;i<stockArray.length;i++)
		{
			stockArrayCopy[i] = stockArray[i];
		}
		
		MergeSortAscending mSA = new MergeSortAscending();
		mSA.sort(stockArrayCopy, 0, stockArrayCopy.length-1);
		
		RiseFallCounter rfc = new RiseFallCounter();
		StockSearch ss = new StockSearch();
		
		do
		{
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Enter the operation that you want to perform\r\n" + 
					"1. Display the companies stock prices in ascending order\r\n" + 
					"2. Display the companies stock prices in descending order\r\n" + 
					"3. Display the total no of companies for which stock prices rose today\r\n" + 
					"4. Display the total no of companies for which stock prices declined today\r\n" + 
					"5. Search a specific stock price\r\n" + 
					"6. press 0 to exit");
			System.out.println("-------------------------------------------------------------------");
			choiece = Integer.parseInt(br.readLine());
			
			switch(choiece)
			{
				case 0:{
					break;
				}
				case 1:{
					System.out.println("Stock prices in ascending order are :");
					for(int i=0;i<stockArrayCopy.length;i++)
					{
						System.out.print(stockArrayCopy[i]+" ");
					}
					System.out.println();
					break;
				}
				case 2:{
					//Traversing in reverse order to get descending order as the array is already sorted in ascending order
					System.out.println("Stock prices in descending order are :");
					for(int i=stockArrayCopy.length-1;i>=0;i--)
					{
						System.out.print(stockArrayCopy[i]+" ");
					}
					System.out.println();
					break;
					
				}
				case 3:{
					
					int noOfRise = rfc.countRiseNumber(stockPriceStatusArray);
					System.out.println("Total no of companies whose stock price rose today :"+noOfRise);
					break;
				}
				case 4:{
					
					int noOfFall = rfc.countFallNumber(stockPriceStatusArray);
					System.out.println("Total no of companies whose stock price declined today : "+noOfFall);
					break;
				}
				case 5:{
					
					//the searching operation is performed in the copy of the array as the same is already sorted
					//hence we can implement binary sear algorithm
					System.out.println("enter the key value");
					double stock = Double.parseDouble(br.readLine());
					int result = ss.isStockPresent(stockArrayCopy,stock);
					if(result==-1)
						System.out.println("Value not found");
					else
						System.out.println("Stock of value "+stockArrayCopy[result]+" is present");
					break;
				}
				default :{
					
					System.out.println("Enter between 0 to 5");
				}
					
			}
			
		}while(choiece!=0);
		
		System.out.println("Exited successfully");
		
		
		
		

	}

}
