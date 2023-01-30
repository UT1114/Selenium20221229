package com.qa.java.tests;

public class RepeatedNumberInArray {

	public static void main(String[] args) {

		int arr[] = { 32, 12, 32, 65, 15, 77, 96, 23, 12, 65, 14, 98, 9, 77, 96 };

		for (int i = 0; i < arr.length; i++) {
			int flag = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] != arr[j]) {
					flag++;
				}

			}

			if (flag == 1) {
				System.out.println(arr[i]);
			}
		}

	}

}
