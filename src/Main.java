import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int type, level;
		boolean run = true;
		double pay;
		
		while (run) {
			System.out.println("\tWelcome to our Car Wash!");
			do {
				System.out.print("What type of Car do you have?\n1 - Sedan\n2 - SUV\n3 - Van\nyour car: ");
				type = in.nextInt();
			} while (type < 1 || type > 3);
			
			System.out.println();
			
			do {
				System.out.print("What level of cleaning do you want for your vehicle?\n1 - Basic Wash : (Exterior only)"
						+ "\n2 - Intermediate Wash : (Exterior + Vaccuming Interior)\n3 - Full-service Wash : (Exterior + Full Interior)\nlevel: ");
				level = in.nextInt();
			} while (level < 1 || level > 3);

			CarWash car = new CarWash(type, level);

			System.out.println("\nProceeding to payment...");
			System.out.println("The price is: " + car.getPrice());
			do {
				System.out.print("Enter your payment amount: ");
				pay = in.nextDouble();
				if (pay < car.getPrice()) {
					System.out.println("Insufficient amount");
				}
			} while (pay < car.getPrice());
			
			car.getChange(pay);
			car.getType();
			car.getLevel();
			car.printReceipt(pay);


			System.out.print("\nDo you want to use the car wash again? y/n: ");
			char ans = in.next().toLowerCase().charAt(0);
			if (ans == 'y') {
				System.out.println();
				continue;
			} else if (ans == 'n'){
				System.out.println("Thank you for trusting our car wash. Please come again!");
				run = false;
			}
		}
		in.close();
	}
}
