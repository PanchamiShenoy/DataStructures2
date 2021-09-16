package bankingCashCounter;

import java.util.Scanner;

public class BankingCashCounter {
	Scanner sc = new Scanner(System.in);
	long Balance = 0;

	Queue queue = new Queue();

	/**
	 * method to add person into the queue
	 */
	public void addPerson() {

		System.out.println("How many people you wanna add");
		int peopleCount = sc.nextInt();
		for (int i = 1; i <= peopleCount; i++) {
			queue.enqueue(i);
		}
		getOption(peopleCount);

	}

	/**
	 * method to take input option for each person
	 * 
	 * @param peopleCount
	 */
	private void getOption(int peopleCount) {

		while (peopleCount != 0) {
			long cash = Balance;
			int option = 0;
			boolean flag = false;
			while (!flag) {
				System.out.println("peron " + queue.getFront() + " Available cash " + cash);
				System.out.println("You want to \n1: Withdraw \n2: Deposit");
				option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter the required amount to withdraw");

					long amount = sc.nextInt();
					if (amount > cash) {
						System.out.println("No sufficient cash");
						continue;
					} else
						cash = cash - amount;
					flag = true;
					queue.dequeue();
					peopleCount--;
					System.out.println("Available cash" + cash);
					break;
				case 2:
					System.out.println("Enter the required amount to deposit");
					long amt = sc.nextInt();
					System.out.println("amount deposited successfully");
					queue.dequeue();
					cash = cash + amt;
					flag = true;
					System.out.println("Updated cash " + cash);
					peopleCount--;
					break;
				default:
					break;

				}
			}

		}

	}

}