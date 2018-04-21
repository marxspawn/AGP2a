package application;

public class Sales implements Comparable<Object> {
	private String timestamp;
	private double subtotal;
	private double tax;
	private double total;
	private String payment;
	private int foodSold;
	private int drinkSold;
	private int snackSold;

	public Sales (double subtotal, double tax, double total) {
		setSubtotal(subtotal);
		setTax(tax);
		setTotal(total);
	}
	
	public Sales(String timestamp, double subtotal, double tax, double total, String payment, int foodSold,
			int drinkSold, int snackSold) {
		setTimestamp(timestamp);
		setSubtotal(subtotal);
		setTax(tax);
		setTotal(total);
		setPayment(payment);
		setFoodSold(foodSold);
		setDrinkSold(drinkSold);
		setSnackSold(snackSold);
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		if(timestamp.equals("")) {
			this.timestamp = ("NO TIMESTAMP ENTERED");
		} else {this.timestamp = timestamp;}
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		if(subtotal >= 0) {
			this.subtotal = subtotal;
		} else {
			this.subtotal = 0;
		}
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		if(tax >= 0) {
			this.tax = tax;
		} else {
			this.tax = 0;
		}
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		if(total >= 0) {
			this.total = total;
		} else {
			this.total = 0;
		}
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		if(payment.equals("")) {
			this.payment = ("PAYMENT NOT ENTERED");
		} else {
			this.payment = payment;			
		}
	}

	public int getFoodSold() {
		return foodSold;
	}

	public void setFoodSold(int foodSold) {
		if(foodSold >=0 && foodSold <= 2000000000) {
			this.foodSold = foodSold;
		} else if(foodSold > 2000000000) {
			foodSold = 2000000000;
		} else {
			foodSold = 0;
		}
	}

	public int getDrinkSold() {
		return drinkSold;
	}

	public void setDrinkSold(int drinkSold) {
		if(drinkSold >=0 && drinkSold <= 2000000000) {
			this.drinkSold = drinkSold;
		} else if(drinkSold > 2000000000) {
			drinkSold = 2000000000;
		} else {
			drinkSold = 0;
		}
	}

	public int getSnackSold() {
		return snackSold;
	}

	public void setSnackSold(int snackSold) {
		if(snackSold >=0 && snackSold <= 2000000000) {
			this.snackSold = snackSold;
		} else if(snackSold > 2000000000) {
			snackSold = 2000000000;
		} else {
			snackSold = 0;
		}
	}

	
	
	@Override
	public String toString() {
		return "	" + getSubtotal()  + "\n	" + getTax() + "\n	" + getTotal();
	}

	@Override
	public int compareTo(Object arg0) {
		return (this.getTimestamp().compareTo(((Sales) arg0).getTimestamp()));
	}
}
