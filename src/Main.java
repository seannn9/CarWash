import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int type, level;
		double pay = 0.0;
		boolean run = true;	
		String typePrompt = "What type of Car do you have?\n1 - Sedan\n2 - SUV\n3 - Van\nyour car: ";
		String lvlPrompt = "What level of cleaning do you want for your vehicle?\n1 - Basic Wash : (Exterior only)"
			+ "\n2 - Intermediate Wash : (Exterior + Vaccuming Interior)\n3 - Full-service Wash : (Exterior + Full Interior)\nlevel: ";

		while (run) {
			System.out.println("\tWelcome to our Car Wash!");

			// call getInput and pass prompt to get input on type and level
			type = getInput(typePrompt);
			System.out.println();
			level = getInput(lvlPrompt);

			// Created a CarWash object that takes the type and level argument
			CarWash car = new CarWash(type, level);

			// call processPayment to accept payment from user
			pay = processPayment(car.getPrice());
			
			// call required methods from CarWash class
			car.getChange(pay); 
			car.getType(); 
			car.getLevel(); 
			car.printReceipt(pay); 

			// call tryAgain method to ask if the user wants to go again or not and assing it to the run variable in the while loop
			run = tryAgain();
		}
		in.close();
	}

	// method for getting input for level and type that takes in the prompt as a parameter
	public static int getInput(String prompt) {
		int num = 0;
		boolean valid = false; 
		while (!valid) { // while True, keep looping
			System.out.print(prompt);
			try {
				num = in.nextInt();
				if (num >= 1 && num <= 3) { // only accept between 1 and 3
					valid = true; // set valid as true resulting in !true which is false and exit the loop
				} else {
					System.out.println("\nIvalid Input, please enter a number between 1-3\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Input, please enter a number between 1-3\n");
				in.nextLine();
			}
		}
		return num;
	}

	// method for getting payment from user that takes in price variable from the CarWash class
	public static double processPayment(double price) {
		double pay = 0.0;
		System.out.println("\nProceeding to payment...");
			System.out.println("The price is: " + price);
			do {
				System.out.print("Enter your payment amount: ");
				try {
					pay = in.nextDouble();
				if (pay < price) {
					System.out.println("\nInsufficient amount, please try again");
				}
				} catch (InputMismatchException e) {
					System.out.println("\nInvalid input, please enter a valid amount");
					in.nextLine();
				}
			} while (pay < price);
		return pay;
	}

	// method for getting decision from user if they want to go again
	public static boolean tryAgain() {
		String ans;
		boolean run = true;
		boolean tryAgain = true;
		while (run) {
			System.out.print("\nDo you want to use the car wash again? y/n: ");
			ans = in.next().toLowerCase();
			in.nextLine();
			if (ans.equals("y")) {
				System.out.println();
				run = false;
				tryAgain = true;
			} else if (ans.equals("n")){
				System.out.println("\nThank you for trusting our car wash. Please come again!\n");
				run = false;
				tryAgain = false;
			} else {
				System.out.println("\nInvalid input, please enter y/n");
			}
		}
		return tryAgain;
	} 
} 
