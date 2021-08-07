package addressBook.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressBook {


	static List<Person> contactList = new ArrayList<>();
	// Method to add a new contact

	static void addContacts() {
		Scanner scan = new Scanner(System.in);

		System.out.println("How many person you want to add?");
		int numberOfPerson = scan.nextInt();

		for (int i = 0; i < numberOfPerson; i++) {
			Person person = new Person();

			System.out.println("Enter first name: ");
			String firstName = scan.next();
			person.setFirstName(firstName);

			System.out.println("Enter last name: ");
			String lastName = scan.next();
			person.setLastName(lastName);

			System.out.println("Enter address: ");
			String address = scan.next();
			person.setAddress(address);

			System.out.println("Enter city: ");
			String city = scan.next();
			person.setCity(city);

			System.out.println("Enter state ");
			String state = scan.next();
			person.setState(state);

			System.out.println("Enter zip code: ");
			String zip = scan.next();
			person.setZip(zip);

			System.out.println("Enter phone number: ");
			String phoneNumber = scan.next();
			person.setPhoneNumber(phoneNumber);

			System.out.println("Enter email: ");
			String email = scan.next();
			person.setEmail(email);
			contactList.add(person);

		}
		System.out.println(contactList);
	}

	// Method to edit a contact

	static void editContacts() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first name: ");
		String firstName = scan.next();

		for (int i = 0; i < contactList.size(); i++) {
			Person person = contactList.get(i);

			if (firstName.equals(person.getFirstName())) {
				System.out.println("Select option for details you want to edit: \n" + "1. To edit last name: \n"
						+ "2. To edit address: \n" + "3. To edit city: \n " + " 4. To edit state: \n"
						+ "5. To edit zip code: \n" + "6. To edit phone number \n" + "7. To edit email: ");

				int optionSelected = scan.nextInt();
				switch (optionSelected) {

				case 1:
					System.out.println("Enter new last name: ");
					String lastName = scan.next();
					person.setLastName(lastName);
					break;

				case 2:
					System.out.println("Enter new address: ");
					String address = scan.next();
					person.setAddress(address);
					break;

				case 3:
					System.out.println("Enter new city: ");
					String city = scan.next();
					person.setCity(city);
					break;

				case 4:
					System.out.println("Enter new state: ");
					String state = scan.next();
					person.setState(state);
					break;

				case 5:
					System.out.println("Enter new zip code: ");
					String zip = scan.next();
					person.setZip(zip);
					break;

				case 6:
					System.out.println("Enter new phone number: ");
					String phoneNumber = scan.next();
					person.setPhoneNumber(phoneNumber);
					break;

				case 7:
					System.out.println("Enter new email: ");
					String email = scan.next();
					person.setEmail(email);
					break;

				default:
					System.out.println("Enter values in between 1 and 7!");
				}
				System.out.println(contactList);
			}
		}
	}

	// Method to delete a contact
	static void deleteContact() {
		System.out.println("Enter first name of the contact you want to delete: ");
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();

		for (int i = 0; i < contactList.size(); i++) {
			Person person = contactList.get(i);

			if (firstName.equals(person.getFirstName())) {
				contactList.remove(person);
				System.out.println(contactList);
			} else {
				System.out.println("First name not found!");
			}
		}
	}

	// Method to create a new address book
	static void newAddressBook() {

		Map<String, Person> myAddressBookMap = new HashMap<String, Person>();
		Scanner scan = new Scanner(System.in);
		// Asking user how many address book you want to add?
		System.out.println("Enter how many address book you want to add?");
		int option = scan.nextInt();

		for (int i = 0; i < option; i++) {
			System.out.println("Enter name of the new address book:");
			Scanner scanner = new Scanner(System.in);
			String newAddressBookName = scanner.next();	
			NewAddressBook addressBook = new NewAddressBook(newAddressBookName);
			
			Scanner scanner1 = new Scanner(System.in);

			System.out.println("How many person you want to add?");
			int numberOfPerson = scanner1.nextInt();

			for (int j = 0; j < numberOfPerson; j++) {
				Person person = new Person();

				System.out.println("Enter first name: ");
				String firstName = scanner1.next();
				person.setFirstName(firstName);

				System.out.println("Enter last name: ");
				String lastName = scanner1.next();
				person.setLastName(lastName);

				System.out.println("Enter address: ");
				String address = scanner1.next();
				person.setAddress(address);

				System.out.println("Enter city: ");
				String city = scanner1.next();
				person.setCity(city);

				System.out.println("Enter state ");
				String state = scanner1.next();
				person.setState(state);

				System.out.println("Enter zip code: ");
				String zip = scanner1.next();
				person.setZip(zip);

				System.out.println("Enter phone number: ");
				String phoneNumber = scanner1.next();
				person.setPhoneNumber(phoneNumber);

				System.out.println("Enter email: ");
				String email = scanner1.next();
				person.setEmail(email);

				myAddressBookMap.put(newAddressBookName, person);
			}
		}
		
		// Displaying all added address book details
		Set<Map.Entry<String,Person>> entries = myAddressBookMap.entrySet();
		for(Map.Entry<String, Person> emp : entries) {
			System.out.println(emp.getKey());
			Person person = emp.getValue();
			person.display();
		}
	}
	/* Method checking for the duplicate contacts from the contact list*/
	static void avoidDuplicateContacts() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name which you want to find!");
		String myFirstName = scan.next();
		for(Person person : contactList) {
			if(myFirstName.equals(person.getFirstName())){
				System.out.println("Person with same first name found!");
			} else System.out.println("Person with same first name not found!");
		}
	}

	// Main method to call all methods created using switch statement
	public static void main(String[] args) {
		System.out.println("Welcome to address book program!");
		// Asking user want function he/she wants to perform

		boolean choice = true;
		while (choice) {
			System.out
					.println("What you wanna do? \n" + "Enter 1 to add a contact: \n" + "Enter 2 to edit a contact: \n"
							+ "Enter 3 to delete a contact: \n" + "Enter 4 to add a new address book: \n"+
							"Enter 5 to check for duplicate contacts:");

			Scanner scan = new Scanner(System.in);
			int optionSelected = scan.nextInt();

			switch (optionSelected) {
			case 1:
				addContacts();
				break;

			case 2:
				editContacts();
				break;

			case 3:
				deleteContact();
				break;

			case 4:
				newAddressBook();
				break;
			case 5:
				avoidDuplicateContacts();
				break; 
			default:
				System.out.println("Enter 1, 2, 3, 4 or 5: ");
				break;
			}
		}
	}
}
