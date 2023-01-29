package com.qa.java.tests;

public class PalindromNumber {

	public static void main(String[] args) {

		int num = 1234321;
		int num2 = num;
		int sum = 0;

		for (; num > 0;) {
			int remainder = num % 10;
			num = num / 10;
			sum = (sum * 10) + remainder;

		}
		if (sum == num2) {
			System.out.println("Palindrom Number");
		} else {
			System.out.println("Sum- " + sum);
			System.out.println("num- " + num2);

			System.out.println("Not");
		}
	}

}
