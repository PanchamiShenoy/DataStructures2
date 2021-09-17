package prime2DArray;

public class Prime2DArray {

	public void primeArray() {
		int array[][] = new int[10][100];
		int prime[][] = new int[10][100];
		int temp = 1;

		// taking range of numbers 0-1000
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				array[i][j] = temp;
				temp++;
			}
		}
		// Check if numbers in range are prime
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (checkPrime(array[i][j])) {
					prime[i][j] = array[i][j];
				} else {
					prime[i][j] = 0;
				}
			}
		}

		// Print the prime in 2D Array
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (prime[i][j] != 0) {
					System.out.print(prime[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * method to check if number is prime
	 * 
	 * @param num
	 * @return
	 */
	private boolean checkPrime(int num) {

		boolean flag = true;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {

		Prime2DArray obj = new Prime2DArray();
		obj.primeArray();
	}
}