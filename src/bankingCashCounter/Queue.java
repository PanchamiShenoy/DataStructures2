package bankingCashCounter;

class Queue {
	int queue[] = new int[100];
	int front;
	int rear = -1;
	int size;

	public void enqueue(int data) {
		queue[++rear] = data;
		size++;
	}

	public int dequeue() {
		int a = queue[front];
		front++;
		size--;

		return a;

	}

	public int getFront() {
		return queue[front];
	}

}