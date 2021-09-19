package Hashing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Hashing<T> {

	Node<T>[] array = new Node[11];
	Node<T> next;

	class Node<T> {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/**
	 * method to add the data
	 * 
	 * @param data
	 */
	public void add(int data) {
		Node<T> new_Node = new Node(data);
		int index = data % 11;
		if (array[index] == null) {
			array[index] = new_Node;
		} else {
			Node<T> temp = array[index];
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new_Node;
		}
	}

	/**
	 * method to display the data
	 */
	public void display() {
		for (int i = 0; i < array.length; i++) {
			Node<T> temp = array[i];
			System.out.print(" [" + i + "]-----------> {");
			while (temp != null) {
				System.out.print(temp.data + "  ");
				temp = temp.next;

			}
			System.out.println("}");
		}
	}

	/**
	 * method to write data into file
	 */
	public void write() {
		try {
			FileWriter fWriter = new FileWriter(
					"/Users/panchamishenoy/Desktop/assignment/DataStructures2/src/Hashing/output");

			String text = "";
			fWriter.write(text);

			for (int i = 0; i < array.length; i++) {
				text = "";
				Node<T> temp = array[i];
				if (temp != null) {
					text = " [" + i + "] ------->{";
					while (temp != null) {
						text = text + temp.data + " ";
						temp = temp.next;
					}
					text = text + "}\n";
					fWriter.write(text);
				} else if (temp == null) {
					text = " [" + i + "] ------->{}\n";
					fWriter.write(text);
				}
			}

			fWriter.close();
			System.out.println("File is created");
		}

		catch (IOException e) {
			System.out.print(e.getMessage());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		Hashing<Integer> hash = new Hashing<Integer>();

		File file = new File("/Users/panchamishenoy/Desktop/assignment/DataStructures2/src/Hashing/input");
		Scanner sc = new Scanner(file);
		String str;
		String str2 = "";
		while (sc.hasNextLine()) {
			str = sc.nextLine();
			str2 = str2 + str;
		}
		System.out.println(str2);
		sc.close();
		String[] arr = str2.split(" ");
		int[] arr2 = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arr2[i] = Integer.parseInt(arr[i]);
		}
		for (int i : arr2) {
			hash.add(i);

		}
		hash.write();
		hash.display();
	}

}
