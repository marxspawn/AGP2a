package application;

public class Services {
	private String serviceName;
	private double cost;

	public Services(String serviceName) {
		setServiceName(serviceName);
		setCost(0);
	}

	public Services(String serviceName, double cost) {
		this(serviceName);
		if (cost > 0) {
			setCost(cost);
		}
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		if(serviceName.equals("")) {
			this.serviceName = ("SERVICE NAME NOT ENTERED");
		} else {
			this.serviceName = serviceName.toUpperCase();	
		}
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		if(cost >= 0) {
			this.cost = cost;
		} else {
			this.cost = 0;
		}
	}

}