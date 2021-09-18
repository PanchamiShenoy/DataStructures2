package orderedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrderedList {

	Node head;
	static Scanner sc = new Scanner(System.in);

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}

	}

	/**
	 * method to add element into the linkedlist
	 * 
	 * @param data
	 */
	public void add(int data) {
		Node newNode = new Node(data);
		if (head == null || head.data > data) {
			newNode.next = head;
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null && temp.next.data < data) {
				temp = temp.next;

			}
			newNode.next = temp.next;
			temp.next = newNode;
		}

	}

	/**
	 * method to pop element fro linkedlist
	 * 
	 * @param input
	 */
	public void pop(int input) {

		if (input == head.data) {
			head = head.next;
			return;
		}
		Node temp = head.next;
		Node q = head;
		while (temp != null) {

			if (temp.data == input) {
				// System.out.println(temp.data);
				if (temp.next == null) {
					temp = temp.next;
					q.next = null;
				} else {
					q.next = temp.next;

					temp = temp.next;
				}
			} else {
				q = temp;
				temp = temp.next;
			}
		}

	}

	/**
	 * method to check if input is present in linkedlist
	 * 
	 * @param input
	 */
	public void search(int input) {
		boolean flag = true;
		Node temp;
		temp = head;
		while (temp != null) {
			if (temp.data == input) {

				flag = false;
				pop(input);

				break;
			} else {
				temp = temp.next;
			}

		}
		if (flag == true) {
			add(input);
		}

	}

	/**
	 * method to display linkedlist
	 */
	public void display() {
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

	/**
	 * method to sort array using bubble sort
	 * 
	 * @param a
	 * @return
	 */
	public int[] bubbleSort(int[] a) {

		int len = a.length;
		int temp;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		for (int t : a) {
			add(t);

		}

		System.out.println("Sorted array");
		printArray(a);

		return a;
	}

	public static void printArray(int[] a) {
		for (int t : a) {
			System.out.print(t + " ");

		}
		System.out.println();
	}

	/**
	 * method to write updated list to file
	 */
	public void write() {
		try {

			FileWriter fWriter = new FileWriter(
					"/Users/panchamishenoy/Desktop/assignment/DataStructures2/src/orderedlist/data.txt");

			String text = "";

			// fWriter.write(text);

			Node temp;
			temp = head;
			while (temp.next != null) {
				text = text + temp.data + " ";
				temp = temp.next;
			}
			text = text + temp.data;
			fWriter.write(text);

			fWriter.close();

			System.out.println("File is created successfully with the content.");
		}

		catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}
	/**
	 * To get the size
	 * @param <T>
	 * @return
	 */
	public int getSize() {
		int count = 0;
		if(head == null) {
			return 0;
		}
		else {

			Node temp = head;
			while(temp != null) {
				count++;
				temp = temp.next;

			}
		}
		return count;
	}

	public int get(int index) {
		Node temp = head;
		Node prev = null;

		for (int i = 0; i <= index; i++) {
			prev = temp;
			temp = temp.next;
		}
		return  prev.data;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner r= new Scanner(System.in);
		OrderedList o = new OrderedList();
		File file = new File("/Users/panchamishenoy/Desktop/assignment/DataStructures2/src/orderedlist/data.txt");
		Scanner sc = new Scanner(file);

		String str;
		String s = "";
		while (sc.hasNextLine()) {
			str = sc.nextLine();
			s = s + str;
		}
		sc.close();
		String[] arr = s.split(" ");
		int[] array = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			array[i] = Integer.parseInt(arr[i]);
		}
		o.bubbleSort(array);
		int choice=1;
		while(choice==1) {
			System.out.println("Enter the choice 1.enter input 2.quit");
		 choice=r.nextInt();
		 if(choice==1) {
		System.out.println("Enter the element");
		Integer input=r.nextInt();
		o.search(input);
		 o.display();
		 o.write();
		}}
}
}