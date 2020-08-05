
public class ContactBook {

	ContactNode addressbook = new ContactNode(null, null);
	ContactNode head = addressbook;
	
	/*Creates a ContactNode and puts the contact in it's 
	 * correct alphabetical position in the linked list*/
	public void addContact(Contact toBeAdded) {
		ContactNode toBeAddedNode = new ContactNode(toBeAdded, null);
		ContactNode ptr = head;
		
		
		if(head.currentContact == null) { //if the addressbook is empty
			head = toBeAddedNode;
			System.out.println("Added!");
		}
		else {
			/*loops through the list until the Node toBeAdded is 
			 * alphabetically greater than the ptr node or it is less than the last node in the list*/
			while(ptr != null) { 
				String name = toBeAddedNode.currentContact.getName();
				String ptrName = ptr.currentContact.getName();
				//String tailName = tail.currentContact.getName();
				
				
				if(name.compareToIgnoreCase(ptrName) < 0 && ptr == head) { //if toBeAdded comes before every other contact alphabetically
					toBeAddedNode.next = ptr;
					head = toBeAddedNode;
					System.out.println("Added!");
					break;
				}
				else if(name.compareToIgnoreCase(ptrName) > 0 && ptr.next == null) { //if toBeAdded comes after every other contact alphabetically
					ptr.next = toBeAddedNode;
					System.out.println("Added!");
					break;
				}
				else if(name.compareToIgnoreCase(ptrName) > 0 && name.compareToIgnoreCase(ptr.next.currentContact.getName()) < 0) { //placing toBeAddedNode in between two existing Nodes
					toBeAddedNode.next = ptr.next;
					ptr.next = toBeAddedNode;
					System.out.println("Added!");
					break;
				}
				
				
				
				ptr = ptr.next;
			}
		}
	}
	
	public ContactNode getHead() {
		System.out.println(head.currentContact.getName());
		return head;
	}
	
	//Delete a contact
	public ContactNode deleteContact(String name) {
		ContactNode ptr = head;
		ContactNode tail = null;
		
		if(ptr == null) {
			System.out.println("The contact book is empty!");
			return null;
			
		}
		
		while(ptr != null) {
			if(ptr.currentContact.getName().toLowerCase().contains(name.toLowerCase()) == true) {
				if (tail == null && ptr == head) { //ContactNode to be deleted is the first one in the book
					head = ptr.next;
					ptr.next = null;
					System.out.println("Deleted " + ptr.currentContact.getName());
					return ptr;
				}
				tail.next = ptr.next;
				ptr.next = null;
				System.out.println("Deleted " + ptr.currentContact.getName());
				return ptr;
			}
			tail = ptr;
			ptr = ptr.next;
		}
		
		System.out.println("This contact isn't in the contact book!");
		return null;
		
		
	}
	
	//View all contacts
	public String viewAllContacts() {
		ContactNode ptr = head;
		String newline = System.getProperty("line.separator");
		String output = "";
		
		while(ptr != null) {
			output += ptr.currentContact.printContact();
			output += newline + "--------------------------" + newline;
			System.out.println("--------------------------");
			ptr = ptr.next;
		}
		
		return output;
	}
	
	//find a specific contact
	public ContactNode findContact(String name) {
		ContactNode ptr = head;
		while(ptr != null) {
			if(ptr.currentContact.getName().toLowerCase().contains(name.toLowerCase()) == true) {
				ptr.currentContact.printContact();
				return ptr;
			}
			ptr = ptr.next;
		}
		System.out.println("Contact not found in Contact Book");
		return null;
		
	}
}
