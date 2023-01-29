package com.qa.java.tests;

import java.util.Scanner;

public class ReverseString {

	
	public static void main(String[] args) {
		
		System.out.println("Please enter a String");
		try(Scanner sc=new Scanner(System.in))
		{
			String str=sc.next();
			
			//char[] charArray = str.toCharArray();
			
			String reverseString="";
			for (int i=str.toCharArray().length-1;i>=0;i--) {
			     reverseString=reverseString+""+str.charAt(i); 
				
			}
			
			System.out.println("Reversed String is : "+reverseString);
			System.out.println("Original String is : "+str);

			
			
		}
	}
	
	
}
