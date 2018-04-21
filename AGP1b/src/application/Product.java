package application;

public class Product {
	private String name;
	private String serialNumber;
	private double cost;
	private Double price = 0.00;
	private double expense;

	
	public Product() {
		this.name = "";
		this.price = 0.00;		
	}
	public Product(String name, double price) {
		setName(getName());
		setPrice(getPrice());
	}

	
	public Product(String name, String serialNumber, double cost, double expense) {
		setName(name);
		setSerialNumber(serialNumber);
		setCost(cost);
		setExpense(expense);
	}
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		// Name set to UpperCase for easier reading.
		if (name.equals("")) {
			this.name = ("NO NAME ENTERED");
		} else {
			this.name = name.toUpperCase();
		}
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		// Serial Number set to UpperCase for easier reading.
		if (serialNumber.equals("")) {
			this.serialNumber = ("NO SERIAL NUMBER ENTERED");
		} else {
			this.serialNumber = serialNumber.toUpperCase();
		}
	}

	public double getCost() {
		return cost;
	}
	

	public void setCost(double cost) {
		if (cost >= 0) {
			this.cost = cost;
		} else {
			this.cost = 0;
		}
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		if (expense >= 0) {
			this.expense = expense;
		} else {
			this.expense = 0;
		}
	}
	@Override
	public String toString() {
		return getName() + "	$ " + getPrice() + "0";
	}
	

}
