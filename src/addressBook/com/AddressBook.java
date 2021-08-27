package addressBook.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;


public class AddressBook {

	static Map<String, Person> myAddressBookMap = new HashMap<String, Person>();
	static List<Person> contactList = new ArrayList<>();
	

	// Method to add a new contact
	static void addContacts() throws Exception{
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

			System.out.println("Enter state: ");
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
			String COMMA_DELIMITER = ",";
			String NEW_LINE_SEPARATOR = "\n";
			String FILE_HEADER = "First Name,Last Name,Address,City,State,Phone Number,Zip";
			FileWriter fileWriter = null;
			
			try{
				contactList.add(person);
				fileWriter = new FileWriter("D:\\AddressBook.csv", true);
				fileWriter.append(FILE_HEADER);
				for (Person p : contactList) {
					fileWriter.append(NEW_LINE_SEPARATOR);
					fileWriter.append(person.getFirstName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(person.getLastName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(person.getAddress());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(person.getCity());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(person.getState());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(person.getZip());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(person.getPhoneNumber());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(person.getEmail());
					
				}
				System.out.println("Wrote CSV successfully!");
			} catch (Exception e) {
				System.out.println("Writing CSV error!");
				e.printStackTrace();
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e) {
					System.out.println("Closing error!");
					e.printStackTrace();
				}
			}
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

				System.out.println("Enter state: ");
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
		Set<Map.Entry<String, Person>> entries = myAddressBookMap.entrySet();
		for (Map.Entry<String, Person> emp : entries) {
			System.out.println(emp.getKey());
			Person person = emp.getValue();
			person.display();
		}
	}

	/* Method checking for the duplicate contacts from the contact list */
	static void avoidDuplicateContacts() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name which you want to find!");
		String myFirstName = scan.next();
		for (Person person : contactList) {
			if (myFirstName.equals(person.getFirstName())) {
				System.out.println("Person with same first name found!");
			} else
				System.out.println("Person with same first name not found!");
		}
	}

	/* Method to search person by city or state using for each loop */
	static void searchPersonByCityOrState() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter city in which you want to find:");
		String city = scanner.next();
		System.out.println("Enter state in which you want to find:");
		String state = scanner.next();

		for (Person person : contactList) {
			if (city.equals(person.getCity()) || state.equals(person.getState())) {
				System.out.println(person);
			}
		}
	}

	/* Method to get mobile number of a person by city or state */
	static void getMobileNumberByCityOrState() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter city to get the mobile number:");
		String city = scanner.next();
		System.out.println("Enter state to get mobile number:");
		String state = scanner.next();

		for (Person person : contactList) {
			if (city.equals(person.getCity()) || state.equals(person.getState())) {
				System.out.println("Mobile number of the people are: " + person.getPhoneNumber());
			}
		}
	}

	/*
	 * Method to sort every person in the contact-list alphabetically using java
	 * streams
	 */
	static void sortContactAlphabetically() {
		for (Person person : contactList) {
			System.out.println(person.getFirstName());
		}
		contactList.stream();
		contactList.sort(Comparator.comparing(Person::getFirstName));
		contactList.forEach((Person person) -> System.out.println(person.getFirstName() + " " + person.getLastName()));
	}

	/*
	 * Method to sort every person in the contact-list by city using java streams
	 */
	static void sortByCity() {
		for (Person person : contactList) {
			System.out.println(person.getCity());
		}
		contactList.stream();
		contactList.sort(Comparator.comparing(Person::getCity));
		contactList.forEach((Person person) -> System.out.println(person.getFirstName() + " " + person.getLastName()));
	}

	/*
	 * Method to sort every person on the contact-list by Zip-code using java
	 * streams
	 */
	static void sortByZip() {
		for (Person person : contactList) {
			System.out.println(person.getZip());
		}
		contactList.stream();
		contactList.sort(Comparator.comparing(Person::getZip));
		contactList.forEach((Person person) -> System.out.println(person.getFirstName() + " " + person.getLastName()));
	}
	
	public static void readCSVFile() throws Exception {
		String file = "C:\\Users\\prata\\AddressBook\\resources\\AddressBook.csv";
		BufferedReader reader = null;
		String line = "";
		try {
			reader = new BufferedReader(new FileReader(file));
			while((line = reader.readLine())!=null) {
				String [] person = line.split(",");
				System.out.println("Peson[First Name=" + person[0] +",Last Name ="+person[1]+",Address ="+person[2]+", City ="+person[3]+
						", State ="+person[4]+ ", ZipCode ="+person[5] +", Phone Number ="+person[6]+ ", E=mail= "+person[7]+"]");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Main method to call all methods created using switch statement
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to address book program!");
		// Asking user want function he/she wants to perform

		boolean choice = true;
		while (choice) {
			System.out.println("What you wanna do? \n" + "Enter 1 to add a contact: \n"
					+ "Enter 2 to edit a contact: \n" + "Enter 3 to delete a contact: \n"
					+ "Enter 4 to add a new address book: \n" + "Enter 5 to check for duplicate contacts: \n"
					+ "Enter 6 to search person by city or state: \n"
					+ "Enter 7 to get mobile number of people by city or state: \n"
					+ "Enter 8 to sort every person in the " + "contactlist alphabetically \n"
					+ "Enter 9 to sort every person by city \n"
					+ "Enter 10 to sort every person in contact list by zipcode"
					+ "Enter 11 to read csv file");

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
			case 6:
				searchPersonByCityOrState();
				break;
			case 7:
				getMobileNumberByCityOrState();
				break;
			case 8:
				sortContactAlphabetically();
				break;
			case 9:
				sortByCity();
				break;
			case 10:
				sortByZip();
				break;
			case 11:
				readCSVFile();
			default:
				System.out.println("Enter 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 or 11: ");
				break;
			}
		}
	}
}
