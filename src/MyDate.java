public class MyDate {
	
	String form;
	byte month;
	byte day;
	short year;
	
	public MyDate() {
		month = 1;
		day = 1;
		year = 1;
	}
	
	public MyDate(String form) {
		String[] parts = form.split("/");
		if(parts.length != 3) {
			System.out.println("Error");
		}
		else {
			day = Byte.parseByte(parts[0]);
			month = Byte.parseByte(parts[1]);
			year = Short.parseShort(parts[2]);
		}
	}
	
	public String toString() {
		String rv = "";
		rv += day +"/";
		rv += month + "/";
		rv += year;
		return rv;
	}

}

