package addressBook.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

			static List<Person> contactList = new ArrayList<>();
			//Method to add a new contact	
			
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
					contactList.add(person);
					
					System.out.println(person.toString());
				}
				
				//Method to edit a contact
				
				public static void editContacts() {
					 Scanner scan = new Scanner(System.in);
					 System.out.println("Enter first name: ");
					 String firstName = scan.next();
					 
					 for(int i=0; i<contactList.size(); i++) {
						 Person person = contactList.get(i);
						 
						 if(firstName.equals(person.getFirstName())) {
							 System.out.println("Select option for details you want to edit: \n"+"1. To edit last name: \n"+"2. To edit address: \n"+
									 				"3. To edit city: \n "+" 4. To edit state: \n"+ "5. To edit zip code: \n"+"6. To edit phone number \n"+
									 					"7. To edit email: ");
							 
							 int optionSelected = scan.nextInt();
							 switch(optionSelected) {
							 
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
						 } else {
							 System.out.println("First name not found: /n"+"Want to add a new contact?");
							 String optionSelected = scan.next();
							 
							 if(optionSelected.compareTo("yes")==0) {
								 addContacts();
							 } else {
								 System.out.println("You have come out of the program!");
								 break;
							 } 
						 }
					 }
				 }
				//Main method
				public static void main(String[] args) {
					System.out.println("Welcome to address book program!");
					//Asking user want function he/she wants to perform
					
					System.out.println("What you wanna do? \n"+"Enter 1 to add a contact: \n"+"Enter 2 to edit a contact:");
					Scanner scan = new Scanner(System.in);
					int optionSelected = scan.nextInt();
					
					switch(optionSelected) {
					
					case 1:
						addContacts();
						break;
						
					case 2:
						editContacts();
						break;
						
					default: 
					System.out.println("Enter 1 or 2: ");		
					break;
					
					}
			}
	}
