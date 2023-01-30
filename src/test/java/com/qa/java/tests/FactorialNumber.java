package com.qa.java.tests;

import java.util.Scanner;

public class FactorialNumber {

	 public static void main(String[] args) {
	        int num;
	        try (Scanner in = new Scanner(System.in)) {
				System.out.println("Enter your number");
				num = in.nextInt();
			}
	        int fact=1;
	        for(int i=1; i<=num; i++)
	        {
	        	fact=fact*i;
	        	
	        }
	        System.out.println(fact);	        	

	         
	    }
	
	
}
