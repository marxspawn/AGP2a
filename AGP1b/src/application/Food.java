package application;

public class Food extends Product {
	private int calories;
	private String allergens;

	public Food (String name, double price) {
		setName(name);
		setPrice(price);
		
	}
	public Food(String name, String serialNumber, int calories, double price, double expense, String allergens) {
		super(name, serialNumber, price, expense);
		setCalories(calories);
		setAllergens(allergens);
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		if(calories >= 0) {
			this.calories = calories;
		} else {
			this.calories = 0;
		}
	}

	public String getAllergens() {
		return allergens;
	}

	public void setAllergens(String allergens) {
		this.allergens = allergens;
	}
	
}
