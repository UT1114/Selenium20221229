package com.qa.java.tests;

public class SecondLargestNumber {
	public static void main(String[] args) {

		int arr[] = { 23, 12, 65, 14, 98, 9, 77, 96 };
		int secondMax = arr[0];
		int max = secondMax;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];

			} else if (arr[i] > secondMax) {
				secondMax = arr[i];
			}

		}

		System.out.println(secondMax);

	}

}
