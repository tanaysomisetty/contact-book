public class ContactNode {

	Contact currentContact; //The contact
	
	ContactNode next; //Pointer to the next contact in the linked list
	
	public ContactNode(Contact currentNode, ContactNode next) {
		this.currentContact = currentNode;
		this.next = next;
		
	}

}
