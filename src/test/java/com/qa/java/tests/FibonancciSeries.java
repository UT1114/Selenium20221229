package com.qa.java.tests;

import java.util.Scanner;

public class FibonancciSeries {

	public static void main(String[] args) {
	      int num, a=0,b=1,c;
	        try (Scanner in = new Scanner(System.in)) {
				System.out.println("Enter your number");
				num = in.nextInt();
			}
	        
	        System.out.println(a+"\n"+b);
	        
	        
	        for (int i = 0; i < num; i++) {
				c=a+b;
				a=b;
				b=c;
				
	        	System.out.println(c);
	        	
	        	
			}
	        
	        
	        
	        
	        
	        
	}
	
	
}
