package balancedParenthesis;

class Stack {
	char data[];
	int top = -1;

	Stack() {
		data = new char[100];
	}

	/**
	 * push symbol into the stack
	 * 
	 * @param a-character passed to push
	 */
	public void push(char a) {
		data[++top] = a;

	}

	/**
	 * pop element from the stack
	 */

	public char pop() {
		char c = data[top--];
		return c;
	}

	/**
	 * check if stock is empty
	 * 
	 * @return boolean to specify if stack is empty or not
	 */
	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}
}