package application;

public class Drink extends Product {
	private String size;
	private double mL;
	private int sugar;



	public Drink(String name, String serialNumber, double cost, double expense, String size) {
		super(name, serialNumber, cost, expense);
		setSize(size);
	}

	public double getmL() {
		return mL;
	}

	public int getSugar() {
		return sugar;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		// Size is put to Upper Case for ease of reading
		size.toUpperCase();
		if(size.equalsIgnoreCase("S")){
			this.mL = 400;
			this.sugar = 45;
		} else if(size.equalsIgnoreCase("L")){
			this.mL = 600;
			this.sugar = 65;
		} else {
			this.mL = 500;
			this.sugar = 55;
		}
		this.size = size;
	}

}
