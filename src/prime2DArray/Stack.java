package prime2DArray;

class Stack {
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
	public Stack() {
		this.head = null;
	}

	/**
	 * element to be added into the list
	 * 
	 */
	public void push(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		count++;
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
		count--;
	}

	/*
	 * peek the data
	 */
	public int peek() {
		if (head == null) {
			System.out.println("no data present");
		}
		int temp = (int) head.data;
		return temp;
	}

	public boolean isEmpty() {
		return count == 0 ? true : false;
	}

	public int size() {
		return count;
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
