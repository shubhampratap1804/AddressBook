package addressBook.com;

public class NewAddressBook {

	String addressBookName;

	public NewAddressBook(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	public String getAddressBookName() {
		return addressBookName;
	}

	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	@Override
	public String toString() {
		return "NewAddressBook [addressBookName=" + addressBookName + "]";
	}

}
