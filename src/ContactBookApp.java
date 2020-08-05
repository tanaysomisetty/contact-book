import java.util.Scanner;

public class ContactBookApp{
	
	static ContactBook main = new ContactBook();
	static String newline = System.getProperty("line.separator");
	
	
	public static void greeting() {
		Scanner sc = new Scanner(System.in);
		String option = sc.nextLine();
		option = option.toLowerCase();
		
		switch(option) {
		case "view":
			System.out.println(newline + "Your option is: " + option + newline);
			main.viewAllContacts();
			break;
		case "find":
			System.out.println("Your option is: " + option + newline);
			System.out.println("Enter the name of the contact you're looking for:");
			String findname = sc.nextLine();
			System.out.println(newline);
			main.findContact(findname);
			System.out.println(newline);
			break;
		case "delete":
			System.out.println("Your option is: " + option + newline);
			System.out.println("Enter the name of the contact you want to delete:");
			String deletename = sc.nextLine();
			System.out.println(newline);
			main.deleteContact(deletename).currentContact.getName();
			System.out.println(newline);
			break;
		case "add":
			System.out.println("Your option is: " + option + newline);
			System.out.println("Enter the first name:");
			String addfirstname = sc.nextLine();
			System.out.println("Enter the last name:");
			String addlastname = sc.nextLine();
			Contact addcontact = new Contact(addfirstname, addlastname);
			System.out.println("Enter a home number? yes or no");
			String query0 = sc.nextLine();
			if (query0.equalsIgnoreCase("yes")) {
				System.out.println("Enter the number");
				String addhomenumber = sc.nextLine();
				addcontact.setNumber("home", addhomenumber);
			}
			System.out.println("Enter a cell number? yes or no");
			String query1 = sc.nextLine();
			if (query1.equalsIgnoreCase("yes")) {
				System.out.println("Enter the number");
				String addcellnumber = sc.nextLine();
				addcontact.setNumber("cell", addcellnumber);
			}
			System.out.println("Enter an address? yes or no");
			String query2 = sc.nextLine();
			if (query2.equalsIgnoreCase("yes")) {
				System.out.println("Enter the address");
				String addaddress = sc.nextLine();
				addcontact.setAddress(addaddress);
			}
			
			main.addContact(addcontact);
			
			addcontact.printContact();
			break;
		case "quit":
			sc.close();
			System.exit(0);
			break;
		default:
			System.out.println("Sorry that is not a valid option please enter either ADD, DELETE, FIND, VIEW, or QUIT");
			greeting();
		}
		
		System.out.println("What would you like to do now?");
		greeting();
	}
	
	public static void main(String[] args) {
		
		Contact tank = new Contact("Tanay", "Somisetty");
		tank.setNumber("home", "7323290407");
		tank.setNumber("cell", "7322215790");
		tank.setAddress("402 Creststone Circle");
		
		Contact tots = new Contact("Bob", "Poopface");
		tots.setNumber("home", "7323550024");
		tots.setNumber("cell", "6098745526");
		tots.setAddress("Lawrence");
		
		Contact zoots = new Contact("Zeta", "Omega");
		zoots.setNumber("home", "733201831");
		zoots.setNumber("cell", "3802918301923");
		zoots.setAddress("your mom");
		
		
		main.addContact(tank);
		main.addContact(tots);
		main.addContact(zoots);
		
		System.out.println("Welcome to your contact book! What would you like to do?" + newline +
				"Your options are: ADD a contact, DELETE a contact, FIND a contact, VIEW all contacts, or QUIT the program");
		
		greeting();
				

		
		
		
		
		
	}
}
