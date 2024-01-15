/*Name: Gus
*Grade: 11
*Class: CS2
*Block: A
*/
public class Person {
    //Initializes instance variables
    private String firstName;
    private String lastName;
    private String phoneNumber;

    //Constructs instance variables
    public Person(String firstName, String lastName, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    //returns firstName
    public String getFirstName() {
        return firstName;
    }
    //returns lastname
    public String getLastName() {
        return lastName;
    }
    //returns phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }
    //sets firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //sets lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //sets phoneNumber
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //returns toString()
    public String toString()
    {
        return firstName + " " + lastName + " - " + "#" + phoneNumber;
    }

}
