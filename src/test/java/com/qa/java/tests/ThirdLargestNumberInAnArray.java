package com.qa.java.tests;

public class ThirdLargestNumberInAnArray {

	public static void main(String[] args) {
		int arr[] = {100,23, 12, 65, 14, 98, 9,89,88, 77, 96 };
		int max = 0;
		int secondMax = 0;
		int thirdMax = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];

			}

			else if (arr[i] > secondMax) {
				thirdMax = secondMax;
				secondMax = arr[i];

			}

			else if (arr[i] > thirdMax) {
				thirdMax = arr[i];

			}

		}
		System.out.println(thirdMax);

	}

}
