package com.qa.java.tests;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {

		System.out.println("Please enter a number to check");
		try (Scanner sc = new Scanner(System.in)) {
			int num = sc.nextInt();

			int flag = 0;

			if (num == 0 || num == 1) {
				System.out.println("Prime Number");
			}

			for (int i = 2; i < num; i++) {

				if (num % i == 0) {
					flag = 1;
				}
			}
			if (flag == 0) {
				System.out.println(num + " :Prime number");
			} else {
				System.out.println(num + ": Not Prime");
			}
		}

	}
}
