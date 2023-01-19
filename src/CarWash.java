
public class CarWash {
	private double price, change;
	private int type, level;
	private String car, lvl;
	
	// constructor that takes in the type and level of the car as parameter and makes it available for the class
	CarWash(int type, int level) {
		this.type = type;
		this.level = level;
	}
	
	// method for getting the price from the list (depending on type and level) and returning it
	public double getPrice() {
		// 2D array to access prices easier depending on the level of the carwash and the type of car
		int[][] prices = {{250, 500, 750},
							{500, 750, 1000},
							{750, 1000, 1250}
							};
		price = prices[level-1][type-1];
		return price;
	}

	// method for calulating change and returning it
	public double getChange(double pay) {
		change = pay-price;
		return (double)change;
	}
	
	// method for identifying the type of car and returning it
	public String getType() {
		if (type == 1) {
			car = "Sedan";
		} else if (type == 2) {
			car = "SUV";
		} else {
			car = "Van";
		}
		return car;
	}

	// method for identifying level of car and returning it
	public String getLevel() {
		if (level == 1) {
			lvl = "Normal Wash";
		} else if (level == 2) {
			lvl = "Intermediate Wash";
		} else {
			lvl = "Full-service Wash";
		}
		return lvl;
	}

	// method for printing the receipt after completing transaction
	public void printReceipt(double pay) {
		System.out.println();
		System.out.println("\tReceipt:");
		System.out.println("Type of Car: " + car);
		System.out.println("Level of Cleaning: " + lvl);
		System.out.println("Price: " + price);
		System.out.println("Payment amount: " + pay);
		System.out.println("Change: " + change);
	}
}
