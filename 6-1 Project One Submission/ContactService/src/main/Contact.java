package main;
public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String userAddress;


    public String getContactId() {
        return this.contactId;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public String getUserAddress() {
        return this.userAddress;
    }


    public void setFirstName(String firstName) {
        checkIfGreaterThanTenOrNull(firstName);
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        checkIfGreaterThanTenOrNull(lastName);
        this.lastName = lastName;
    }
    public void setPhoneNumber(String phoneNumber) {
        checkIfTenAndNotNull(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
    public void setUserAddress(String userAddress) {
        checkIfAddressIsThirtyCharactersAndNotNull(userAddress);
        this.userAddress = userAddress;
    }


    private static void checkIfGreaterThanTenOrNull(String newVariable) {
        if (newVariable == null || newVariable.length() > 10) {
            throw new ArithmeticException("Has more than 10 char");
        }
    }


    private static void checkIfTenAndNotNull(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new ArithmeticException("Phone number is not 10 characters");
        }
    }


    private static void checkIfAddressIsThirtyCharactersAndNotNull(String address) {
        if (address == null || address.length() > 30) {
            throw new ArithmeticException("Address is greater than 30 char");
        }
    }


    public Contact(String contactId, String firstName, String lastName, String phoneNumber, String userAddress) {

        checkIfGreaterThanTenOrNull(contactId);
        checkIfGreaterThanTenOrNull(firstName);
        checkIfGreaterThanTenOrNull(lastName);
        checkIfTenAndNotNull(phoneNumber);
        checkIfAddressIsThirtyCharactersAndNotNull(userAddress);


        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.userAddress = userAddress;
    }
}
