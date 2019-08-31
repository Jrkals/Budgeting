public class Expense {
	MyDate date;
	String description;
	String category;
	String location;
	double amount;
	String paymentMethod;
	boolean fixedHuh;
	int ID;
	/*
	 * full constructor
	 */
	public Expense(String date, String desc, String categ, String loc, double amt, String method, boolean fixed) {
		if(date == null) this.date = new MyDate();
		else this.date = new MyDate(date);
		this.description = desc;
		this.category = categ;
		this.location = loc;
		this.amount = amt;
		this.paymentMethod = method;
		this.fixedHuh = fixed;
		this.ID = -999;
	}
	
	public Expense(String date, String desc, String categ, String loc, double amt, String method, boolean fixed, int ID) {
		if(date == null) this.date = new MyDate();
		else this.date = new MyDate(date);
		this.description = desc;
		this.category = categ;
		this.location = loc;
		this.amount = amt;
		this.paymentMethod = method;
		this.fixedHuh = fixed;
		this.ID = ID;
	}
	
	public String toString() {
		String rv = "";
		rv += date +", ";
		rv += description +", ";
		rv += category+", ";
		rv += location + ", ";
		rv += amount +" ,";
		rv += paymentMethod + ", ";
		if(fixedHuh) {
			rv += "FIXED";
		}
		else {
			rv += "VARIABLE";
		}
		rv += ", "+ID;
		return rv;
	}

}
