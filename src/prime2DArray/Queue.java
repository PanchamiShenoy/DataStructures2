
package prime2DArray;

class Queue {
	Node head;
	int count = 0;

	class Node {
		public int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	/**
	 * Constructor creates an object of MyLinkedList and initialises linked list
	 */
	public Queue() {
		this.head = null;
	}

	/**
	 * element to be added into the list
	 * 
	 */
	public void push(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			return;

		}
		Node temp = head;
		Node prev = null;

		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	/*
	 * to pop the data
	 */
	public void pop() {
		if (head == null) {
			System.out.println("Stack UnderFlow");
			return;
		}
		Node temp = head;
		head = temp.next;
		temp = null;
	}

	public void display() {
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

}