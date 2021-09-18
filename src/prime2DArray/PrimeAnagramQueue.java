package prime2DArray;

public class PrimeAnagramQueue {
	Queue queue = new Queue();
	int array[][] = new int[10][100];
	int prime[][] = new int[10][100];

	public void primeArray() {

		int temp = 1;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				array[i][j] = temp;
				temp++;
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (checkPrime(array[i][j])) {
					prime[i][j] = array[i][j];
				} else {
					prime[i][j] = 0;
				}
			}
		}
	}

	/**
	 * method to check if prime number is anagram or not
	 */
	public void isAnagram() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (prime[i][j] != 0) {
					for (int k = j + 1; k < 100; k++) {
						if (prime[i][k] != 0 && anagram(prime[i][j], prime[i][k])) {
							queue.push(prime[i][j]);
						}
					}
				}
			}
		}

		System.out.println("Prime Anagrams in reverse order is");
		queue.display();
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

	/**
	 * method to calculate frequency of digit in number
	 * 
	 * @param n    - number who's frequency needs to be calculated
	 * @param freq - array to update frequency of each digit
	 */
	static void calculateFreq(int n, int[] freq) {

		while (n > 0) {
			int digit = n % 10;

			freq[digit]++;

			n /= 10;
		}
	}

	/**
	 * method to check if a number is anagram or not
	 * 
	 * @param a-       number1
	 * @param b-number 2
	 * @return boolean true or false
	 */
	public boolean anagram(int a, int b) {

		int[] freqA = new int[10];
		int[] freqB = new int[10];

		calculateFreq(a, freqA);

		calculateFreq(b, freqB);
		for (int i = 0; i < 10; i++) {

			if (freqA[i] != freqB[i])
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		PrimeAnagramQueue p = new PrimeAnagramQueue();
		p.primeArray();
		p.isAnagram();
	}
}
