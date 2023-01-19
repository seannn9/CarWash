import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int type = 0, level = 0;
		double pay = 0.0;
		char ans;		
		do {
			System.out.println("\tWelcome to our Car Wash!");
			
			type = getInput("What type of Car do you have?\n1 - Sedan\n2 - SUV\n3 - Van\nyour car: ");
			level = getInput("What level of cleaning do you want for your vehicle?\n1 - Basic Wash : (Exterior only)"
			+ "\n2 - Intermediate Wash : (Exterior + Vaccuming Interior)\n3 - Full-service Wash : (Exterior + Full Interior)\nlevel: ");

			CarWash car = new CarWash(type, level); // created a new CarWash object

			System.out.println("\nProceeding to payment...");
			System.out.println("The price is: " + car.getPrice());
			do {
				System.out.print("Enter your payment amount: ");
				try {
					pay = in.nextDouble();
				if (pay < car.getPrice()) {
					System.out.println("Insufficient amount, please try again");
				}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input, please enter a valid amount");
					in.nextLine();
				}
			} while (pay < car.getPrice());
			
			car.getChange(pay);
			car.getType();
			car.getLevel();
			car.printReceipt(pay);

			System.out.print("\nDo you want to use the car wash again? y/n: ");
			ans = in.next().toLowerCase().charAt(0);
			if (ans == 'y') {
				System.out.println();
				continue;
			} else if (ans == 'n'){
				System.out.println("Thank you for trusting our car wash. Please come again!");
				break;
			}
		} while (ans == 'y');
		in.close();
	}

	// method for getting input for level and type
	public static int getInput(String prompt) {
		int num = 0;
		boolean valid = false;
		while (!valid) {
			System.out.print(prompt);
			try {
				num = in.nextInt();
				if (num >= 1 && num <= 3) {
					valid = true;
				} else {
					System.out.println("Ivalid Input, please enter a number between 1-3");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input, please enter a number between 1-3");
				in.nextLine();
			}
		}
		return num;
	}
} 
