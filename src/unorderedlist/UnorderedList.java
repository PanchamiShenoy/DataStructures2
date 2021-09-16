package unorderedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UnorderedList {
	Node head;

	private class Node<T> {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
			next = null;
		}

	}

	/*
	 * to read the file and contents into the array
	 */
	public <T> void readFile() {
		try {
			Scanner sc = new Scanner(
					new File("/Users/panchamishenoy/Desktop/assignment/Algorithm/Data/BinarySearch.txt"));

			String whole = "";
			while (sc.hasNext()) {
				whole = whole + sc.next() + " ";
			}
			T[] array = (T[]) whole.split(" ");
			// add(array);
			for (T t : array) {
				add(t);

			}

			sc.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * add new data into to linkedlist
	 * 
	 * @param <T>
	 * @param data
	 */
	public <T> void add(T data) {

		Node newNode = new Node(data);

		if (head == null)
			head = newNode;
		else {
			Node temp;
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}

	}

	/**
	 * method to display the linkedlist
	 * 
	 * @param <T>
	 */
	public <T> void display() {
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

	/**
	 * method to take input from the user
	 * 
	 * @param <T>
	 */
	public <T> void getUserInput() {
		Scanner r = new Scanner(System.in);
		System.out.println("Enter word you wanna search");
		T input = (T) r.next();
		search(input);

	}

	/**
	 * method to search if input already exists in linkedlist
	 * 
	 * @param <T>
	 * @param input
	 */
	private <T> void search(T input) {
		Node temp;
		temp = head;
		while (temp != null) {
			if (temp.data.equals(input)) {
				remove(input);
				break;
			} else {
				temp = temp.next;
			}

		}
		if (temp == null) {
			add(input);
		}

	}

	/**
	 * method to remove input from linkedlist if already existed
	 * 
	 * @param <T>
	 * @param input
	 */
	private <T> void remove(T input) {

		if (input.equals(head.data)) {
			head = head.next;
			return;
		}
		Node temp = head.next;
		Node q = head;
		while (temp != null) {

			if (temp.data.equals(input)) {
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
	 * method to write updated contents into the file
	 */
	public void writeFile() {
		try {
			FileWriter writer = new FileWriter(
					"/Users/panchamishenoy/Desktop/assignment/Algorithm/Data/BinarySearch.txt");
			Node temp;
			temp = head;
			while (temp.next != null) {
				writer.write(temp.data + " ");
				temp = temp.next;

			}
			writer.write(temp.data + "");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String Args[]) {
		UnorderedList ul = new UnorderedList();
		ul.readFile();
		ul.display();
		int choice = 1;

		while (choice == 1) {
			System.out.println("enter 1.to enter input   2.to quit");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			if (choice == 1) {
				ul.getUserInput();
				ul.display();
				ul.writeFile();
			}
		}
	}
	
}
