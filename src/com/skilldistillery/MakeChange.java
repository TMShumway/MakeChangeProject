package com.skilldistillery;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //instantiate scanner object to read in user input
		
		printHeader(); 

		//The user is prompted asking for the price of the item.
		System.out.print("What is the price of the item you'd like to purchase?: ");
		double purchasePrice = scanner.nextDouble();
		
		//The user is then prompted asking how much money was tendered by the customer.
		System.out.print("How much money was tendered? (xx.xx): ");		
		double amountTendered = scanner.nextDouble();
		
		//Display an appropriate message if the customer provided too little money or the exact amount.
		System.out.println("Warning! Insufficient money provided to pay for the purchase!");		
		System.out.println("Spot on! Exact amount of money tendered. No change due.");				
		
		//If the amount tendered is more than the cost of the item, display the number of 
		//bills and coins that should be given to the customer.
		System.out.println("Your change comes out to: ");
		
	}

	private static void printHeader() {
		System.out.println("******************** Welcome to MakeChange ********************");
		System.out.println("---------------------------------------------------------------");		
	}


}
