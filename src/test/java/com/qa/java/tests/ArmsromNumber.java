package com.qa.java.tests;

public class ArmsromNumber {
	public static void main(String[] args) {

		int number = 371;
		int number2 = number;
		int numberLength = numberLength(number);

		int sum2 = 0;
		for (; number2 > 0;) {

			int rem = number2 % 10;
			number2 = number2 / 10;
			int sum = 1;

			for (int i = 0; i < numberLength; i++) {
				sum = sum * rem;
			}

			sum2 = sum2 + sum;
			System.out.println(sum2);
			

		}
		if (sum2 == number) {
			System.out.println("Number is armstrom");

		} else {
			
			System.out.println("Original Number: "+number);
			System.out.println("New Number: "+sum2);

			System.out.println("Number is not armstrom");

		}
	}

	static int numberLength(int num2) {
		int length = 0;
		while (num2 > 0) {
			length++;
			num2 = num2 / 10;
		}

		return length;

	}

}
