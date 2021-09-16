package balancedParenthesis;

public class BalancedParenthesisMain {
	public static void main(String[] args) {
		String expr1 = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
		String expr2 = "((1+3)";

		BalancedParenthesis bp = new BalancedParenthesis();
		bp.isBalanced(expr1);
		bp.isBalanced(expr2);

	}
}
