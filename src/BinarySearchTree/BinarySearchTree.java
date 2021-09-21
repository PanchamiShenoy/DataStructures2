package BinarySearchTree;

import java.util.Scanner;

public class BinarySearchTree {

	/**
	 * @param num - number who's factorial we are supposed to find
	 * @return the factorial of number
	 */
	public static int factorial(int n) {

		int fact = 1;
		if (n == 0)
			return 1;

		return (n * factorial(n - 1));

	}

	/*
	 * method to find number of binary search tree
	 */
	public static void numOfBinarySearchTree(int numOfNode) {
		int catalanNumber = factorial(2 * numOfNode) / (factorial(numOfNode) * factorial(numOfNode + 1));
		System.out.println("Number of binary search tree with " + catalanNumber);
	}

	public static void main(String[] args) {
		System.out.println("enter number of test case");
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		System.out.println("enter number of nodes for each test case");
		int[] arr = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = sc.nextInt();
		}
		int i = 0;
		while (count != 0) {

			BinarySearchTree.numOfBinarySearchTree(arr[i++]);
			count--;
		}

	}
}
