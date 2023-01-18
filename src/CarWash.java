
public class CarWash {
	private double price;
	private int type;
	private int level;
	private String car;
	
	CarWash(int type, int level) {
		this.type = type;
		this.level = level;
	}
	
	public double getPrice() {
		if (type == 1) {
			if (level == 1) {
				price = 250;
			} else if (level == 2) {
				price = 500;
			} else {
				price = 750;
			}
		}
		else if (type == 2) {
			if (level == 1) {
				price = 500;
			} else if (level == 2) {
				price = 750;
			}
		}
		return price;
	}
	
	public String getType() {
		if (type == 1) {
			car = "Sedan";
		} else if (type == 2) {
			car = "Pick-up Truck";
		} else {
			car = "SUV";
		}
		return car;
	}
}
