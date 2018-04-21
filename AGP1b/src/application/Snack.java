package application;

public class Snack extends Product {
	private boolean onlyDessert;
	private boolean nuts;
	private boolean sugarFree;

	public Snack(String name, Double price) {
		super(name, price);
	}
	public Snack(String name, String serialNumber, double cost, double expense, boolean onlyDessert, boolean nuts,
			boolean sugarFree) {
		super(name, serialNumber, cost, expense);
		setOnlyDessert(onlyDessert);
		setNuts(nuts);
		setSugarFree(sugarFree);
	}

	public boolean isOnlyDessert() {
		return onlyDessert;
	}

	public void setOnlyDessert(boolean onlyDessert) {
		this.onlyDessert = onlyDessert;
	}

	public boolean isNuts() {
		return nuts;
	}

	public void setNuts(boolean nuts) {
		this.nuts = nuts;
	}

	public boolean isSugarFree() {
		return sugarFree;
	}

	public void setSugarFree(boolean sugarFree) {
		this.sugarFree = sugarFree;
	}

}
