import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int type, level;
		boolean run = true;
		
		while (run) {
			System.out.println("\tWelcome to our Car Wash!");
			do {
				System.out.print("What type of Car do you have?\n1 - Sedan\n2 - Pick-up Truck\n3 - Sedan\nyour car: ");
				type = in.nextInt();
			} while (type < 1 || type > 3);
			
			System.out.println();
			
			do {
				System.out.print("What level of cleaning do you want for your vehicle?\n1 - Basic Wash : (Exterior only)"
						+ "\n2 - Intermediate Wash : (Exterior + Vaccuming Interior)\n3 - Full-service Wash : (Exterior + Full Interior)\nlevel: ");
				level = in.nextInt();
			} while (level < 1 || level > 3);
			
			CarWash car1 = new CarWash(type, level);
			
			System.out.print("Do you want to use the car wash again? y/n: ");
			char ans = in.next().toLowerCase().charAt(0);
			if (ans == 'y') {
				System.out.println();
				continue;
			} else if (ans == 'n'){
				run = false;
			}
		}
		
		
	}

}
