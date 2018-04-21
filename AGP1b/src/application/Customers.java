package application;

public class Customers implements Comparable<Customers>{

	private String name;
	private String phoneNumber;
	private boolean call;

	public Customers(String name, String phoneNumber) {
		name.trim();
		if(name.equals("")) {
			setName("Name Not Entered");
		} else {
			setName(name);
		}
		phoneNumber.trim();
		if(phoneNumber.equals("")) {
			setPhoneNumber("No Number Entered");
		} else {
			setPhoneNumber(phoneNumber);
		}
		setCall(true);
	}

	public Customers(String name, String phoneNumber, boolean call) {
		this(name, phoneNumber);
		if (call == false) {
			setCall(call);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name.trim();
		boolean word = true;
		for (int i = 0; i < name.length() && word == true; i++) {
			if (Character.isDigit(name.charAt(i))) {
				word = false;
			}
		}
		if (word && !name.isEmpty()) {
			this.name = name;
		} else {
			this.name = "Entered incorrectly";
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		boolean number = true;
		for (int i = 0; i < phoneNumber.length() && number == true; i++) {
			if (!Character.isDigit(phoneNumber.charAt(i)) || phoneNumber.charAt(i) == '-') {
				number = false;
			}
		}
		if ((phoneNumber.length() == 10 || phoneNumber.length() == 12) && number == true) {
			if (phoneNumber.length() == 12) {
				this.phoneNumber = (phoneNumber.substring(0, 2) + phoneNumber.substring(4, 6)
						+ phoneNumber.substring(8, 11));
			} else if (phoneNumber.length() == 10) {
				this.phoneNumber = phoneNumber;
			}
		} else {
			System.out.println("Bad phone number.\nFormat: XXX-XXX-XXXX or XXXXXXXXXX");
			this.phoneNumber = "Entered incorrectly";
		}
	}

	public boolean isCall() {
		return call;
	}

	public void setCall(boolean call) {
		this.call = call;
	}

	@Override
	public int compareTo(Customers arg0) {
		return (this.getName().compareTo(arg0.getName()));

	}

}
