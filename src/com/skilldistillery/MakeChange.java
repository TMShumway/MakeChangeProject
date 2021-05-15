package com.skilldistillery;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //instantiate scanner object to read in user input
		
		printHeader(); //call method to print welcome header

		//The user is prompted asking for the price of the item.
		System.out.print("What is the price of the item you'd like to purchase?: ");
		double purchasePrice = scanner.nextDouble();

		//The user is then prompted asking how much money was tendered by the customer.
		System.out.print("How much money was tendered? (xx.xx): ");		
		double amountTendered = scanner.nextDouble();
		
		//Create flags
		boolean insufficientMoneyFlag = amountTendered < purchasePrice;
		boolean exactAmountFlag = amountTendered == purchasePrice;

		//Display an appropriate message if the customer provided too little money or the exact amount.
		//If the amount tendered is more than the cost of the item, display the number of 
		//bills and coins that should be given to the customer.
		if(insufficientMoneyFlag) {
			System.out.println("\nWarning! Insufficient money provided to pay for the purchase!");					
		} else if(exactAmountFlag) {
			System.out.println("\nSpot on! Exact amount of money tendered. No change due.");							
		} else {			
			calculateChange(amountTendered, purchasePrice); //call method to calculate change
		}
		
		scanner.close();
		
		goodBye();
	}

	private static void printHeader() {
		System.out.println("************************* Welcome to MakeChange *************************");
		System.out.println("-------------------------------------------------------------------------");		
	}

	private static void calculateChange(double amountTendered, double purchasePrice) {			
		//initialize currency counters
		int twentyBills = 0; 
		int tenBills = 0;
		int fiveBills = 0;
		int oneBills = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;
		
		//calculate amount left over after purchase
		amountTendered -= purchasePrice;		

		//Convert Dollars and Change to whole numbers
		int dollars = (int)amountTendered;	
		int coins = (int)(((amountTendered - dollars) + .005) * 100);

		//Calculate change
		
		while(dollars != 0) { 
			if(dollars >= 20) {
				dollars -= 20;
				++twentyBills;
			} else if (dollars >= 10) {
				dollars -= 10;
				++tenBills;
			} else if(dollars >= 5) {
				dollars -= 5;
				++fiveBills;
			} else if(dollars >= 1) {
				dollars -= 1;
				++oneBills;
			}
		}
			
		while(coins != 0) {
			if(coins >= 25) {
				coins -= 25;
				++quarters;
			} else if(coins >= 10) {
				coins -= 10;
				++dimes;
			} else if(coins >= 5) {
				coins -= 5;
				++nickels;
			} else if(coins >= 1) {
				coins -= 1;
				++pennies;
			} 
			
		}

	
		printChange(twentyBills, tenBills, fiveBills, 
					oneBills, quarters, dimes, 
					nickels, pennies); //call method to print change results to user 
	
	} 

	private static void printChange(int twentyBills, int tenBills, int fiveBills, 
									int oneBills, int quarters, int dimes, 
									int nickels, int pennies) {		
		//Print out change to user
		System.out.print("\n\tYour change comes out to: \n");	
		
		if(twentyBills > 0) {
			System.out.print(twentyBills + " twenty dollar bill(s), ");
		} 
		if (tenBills > 0) {
			System.out.print(tenBills + " ten dollar bill(s), ");
		} 
		if(fiveBills > 0) {
			System.out.print(fiveBills + " five dollar bill(s), ");
		} 
		if(oneBills > 0) {
			System.out.print(oneBills + " one dollar bill(s), ");
		} 
		
		if(quarters > 0) {
			System.out.print(quarters + " quarters(s), ");
		} 
		if(dimes > 0) {
			System.out.print(dimes + " dimes(s), ");
		} 
		if(nickels > 0) {
			System.out.print(nickels + " nickels(s), ");
		} 
		if(pennies > 0) {
			System.out.print(pennies + " pennies(s), ");
		}
		System.out.println();
	}

	private static void goodBye() {
		System.out.println("-------------------------------------------------------------------------");		
		System.out.println("******************************* Farewell! *******************************");
		
	}
}
