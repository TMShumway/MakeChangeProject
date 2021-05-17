package com.skilldistillery;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //instantiate scanner object to read in user input
		
		printWelcomeHeader(); //call method to print welcome header

		//The user is prompted asking for the price of the item.
		System.out.print("What is the price of the item you'd like to purchase? (xx.xx): ");
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
		
		scanner.close(); //housekeeping
		
		goodBye(); //call method to wave farewell!
	}

	private static void printWelcomeHeader() {
		System.out.println("************************* Welcome to MakeChange *************************");
		System.out.println("-------------------------------------------------------------------------");		
	}

	private static void calculateChange(double amountTendered, double purchasePrice) {			
		int amountTenderedCopy = (int)((amountTendered + 0.005) * 100);
		int purchasePriceCopy = (int)((purchasePrice + 0.005) * 100);
		int change = amountTenderedCopy - purchasePriceCopy;
		int changeCopy = change;

		System.out.println("DELETE ME: " + change);
		//initialize currency counters
		int twentyBills = 0; 
		int tenBills = 0;
		int fiveBills = 0;
		int oneBills = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;

		//Calculate change...this could also be done with division and modulus and no loop		
		while(change != 0) {               
			if(change >= 2000) {			  
				change -= 2000;			  
				++twentyBills;			  
			} else if (change >= 1000) {   
				change -= 1000;            
				++tenBills;               
			} else if(change >= 500) {     
				change -= 500;             
				++fiveBills;              
			} else if(change >= 100) {     
				change -= 100;             
				++oneBills;
			} else if(change >= 25) {
				change -= 25;
				++quarters;
			} else if(change >= 10) {
				change -= 10;
				++dimes;
			} else if(change >= 5) {
				change -= 5;
				++nickels;
			} else if(change >= 1) {
				change -= 1;
				++pennies;
			} 
		}
		System.out.println("DELETE ME: " + pennies);

		printChange(twentyBills, tenBills, fiveBills, 
					oneBills, quarters, dimes, 
					nickels, pennies, changeCopy); //call method to print change results to user 
	
	} 

	private static void printChange(int twentyBills, int tenBills, int fiveBills, 
									int oneBills, int quarters, int dimes, 
									int nickels, int pennies, int change) {		
		//Print out change to user
		System.out.print("\n\t\t\tYour change comes out to: \n");	
		
		while(change > 0) {
			if(twentyBills > 0) {
				System.out.print(twentyBills + " twenty dollar " +
			                    (twentyBills > 1 ? "bills" : "bill"));
				change -= (2000 * twentyBills); 
				twentyBills = 0;
			} else if (tenBills > 0) {
				System.out.print(tenBills + " ten dollar " +
						        (tenBills > 1 ? "bills" : "bill"));
				change -= (1000 * tenBills); 
				tenBills = 0;
			} else if(fiveBills > 0) {
				System.out.print(fiveBills + " five dollar " +
						        (fiveBills > 1 ? "bills" : "bill"));
				change -= (500 * fiveBills); 
				fiveBills = 0;
			} else if(oneBills > 0) {
				System.out.print(oneBills + " one dollar " +
								(oneBills > 1 ? "bills" : "bill"));
				change -= (100 * oneBills);
				oneBills = 0;
			} else if(quarters > 0) {
				System.out.print(quarters + 
						        (quarters > 1 ? " quarters" : " quarter"));
				change -= (25 * quarters);
				quarters = 0;
			} else if(dimes > 0) {
				System.out.print(dimes + 
						        (dimes > 1 ? " dimes" : " dime"));
				change -= (10 * dimes);				
				dimes = 0;
			} else if(nickels > 0) {
				System.out.print(nickels + 
						        (nickels > 1 ? " nickels" : " nickel"));
				change -= (5 * nickels);								
				nickels = 0;
			} else if(pennies > 0) {
				System.out.print(pennies + 
						        (pennies > 1 ? " pennies" : " penny"));
				change -= (1 * pennies);												
				pennies = 0;
			} 
			System.out.print(change != 0 ? ", " : ". \n");
		} 
	}

	private static void goodBye() {
		System.out.println("-------------------------------------------------------------------------");		
		System.out.println("******************************* Farewell! *******************************");
		
	}
}