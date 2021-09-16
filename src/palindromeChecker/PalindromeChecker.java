package palindromeChecker;

import java.util.Scanner;

public class PalindromeChecker {
	public static void main(String[] args) {
		Stack q = new Stack();
		Scanner sc = new Scanner(System.in);
		System.out.println("Palindrome Checker");
		System.out.println("enter the word ");
		String text = sc.next();
		char arr[] = text.toCharArray();
		for (char ch : arr) {
			q.push(ch);
		}
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str = str + q.pop();
		}
		if (text.equals(str)) {
			System.out.println(str + " is a palindrome");
		} else {
			System.out.println(str + " is not a palidrome");
		}

	}
}
