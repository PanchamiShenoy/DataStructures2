package balancedParenthesis;

public class BalancedParenthesis {

	Stack stack = new Stack();

	/**
	 * method to check is parenthesis is balanced or not
	 * 
	 * @param expr- which is needed to be checked is passed 
	 */
	public void isBalanced(String expr) {

		for (int i = 0; i < expr.length(); i++) {
			if (expr.charAt(i) == '(') {
				stack.push(expr.charAt(i));
			} else if (expr.charAt(i) == ')') {
				stack.pop();
			}
		}

		if (stack.isEmpty()) {
			System.out.println(expr + "is Balanced");
		} else {
			System.out.println(expr + "is Not balanced");
		}

	}

}
