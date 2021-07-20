package addressBook.com;

import java.util.Scanner;

public class AddressBook {

	 static void addContacts() {
		
		Person person = new Person();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter first name: ");
		String firstName= scan.next();
		person.setFirstName(firstName);
		
		System.out.println("Enter last name: ");
		String lastName= scan.next();
		person.setLastName(lastName);
		
		System.out.println("Enter address: ");
		String address= scan.next();
		person.setAddress(address);
		
		System.out.println("Enter city: ");
		String city= scan.next();
		person.setCity(city);
		
		System.out.println("Enter state ");
		String state= scan.next();
		person.setState(state);
		
		System.out.println("Enter zip code: ");
		String zip= scan.next();
		person.setZip(zip);
		
		System.out.println("Enter phone number: ");
		String phoneNumber= scan.next();
		person.setPhoneNumber(phoneNumber);
		
		System.out.println("Enter email: ");
		String email= scan.next();
		person.setEmail(email);
		
		System.out.println(person.toString());
	}
		//Main method
		public static void main(String[] args) {
			System.out.println("Welcome to address book program!");
			//Calling add contacts method in main main method
			
			addContacts();
		}
}
