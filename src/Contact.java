public class Contact {
	private String firstName;
	private String lastName;
	private String homeNumber;
	private String cellNumber;
	private String address;
	
	
	public Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Contact(String firstName) {
		this.firstName = firstName;
	}
	
	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getName(String type) {
		switch(type) {
			case "full":
			return this.firstName + " " + this.lastName;
			case "first":
				return this.firstName;
			case "last":
				return this.lastName;
			default:
				return "Please try again";
		}
	}
	
	public String getName() { 
		if(this.firstName != null && this.firstName != null) {
			return this.firstName + " " + this.lastName;
		}
		else {
		return "";
		}
	}
	
	public void setNumber(String type, String number) {
		switch(type) {
			case "home":
				this.homeNumber = number;
			case "cell":
				this.cellNumber = number;
		}
	}
	
	
	public String getNumber(String type) {
		type = type.toLowerCase();
		switch(type) {
		case "home":
			return this.homeNumber;
		case "cell":
			return this.cellNumber;
		default:
			return "Please try again";
			
		}
	}
	
	public void setAddress(String addy) {
		this.address = addy;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String printContact() {
		String newline = System.getProperty("line.separator");
		if(this.lastName == null) {
			System.out.println("Name: " + this.getName("first"));
			System.out.println("Home Number: " + this.getNumber("home"));
			System.out.println("Cell Number: " + this.getNumber("cell"));
			System.out.println("Address: " + this.getAddress());
			return "Name: " + this.getName("first") + newline + "Home Number: " + this.getNumber("home") + newline +
					"Cell Number: " + this.getNumber("cell") + newline + "Address: " + this.getAddress();
		}
		else {
			System.out.println("Name: " + this.getName("full"));
			System.out.println("Home Number: " + this.getNumber("home"));
			System.out.println("Cell Number: " + this.getNumber("cell"));
			System.out.println("Address: " + this.getAddress());
			return "Name: " + this.getName("full") + newline + "Home Number: " + this.getNumber("home") + newline +
					"Cell Number: " + this.getNumber("cell") + newline + "Address: " + this.getAddress();
		}
	}
}
