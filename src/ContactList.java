//imports needed java classes to use scanner and arraylists
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    //Initializes instance variable
    private ArrayList<Person> contacts;

    //constructs contactlist by initializing instance variable contact list
    public ContactList() {
        this.contacts = new ArrayList<Person>();
    }

    //returns contacts
    public ArrayList<Person> getContacts()
    {
        return contacts;
    }

    //adds new contact
    public void addContact(Person contact)
    {
        contacts.add(contact);
    }

    //prints contacts
    public void printContacts()
    {
        for(Person p: contacts)
        System.out.println(p.toString());
    }

    //sorts by firstname, lastname, or phonenumber
    public void sort(int sortBy)
    {
        Person tmp = null;
        String tmp1 =  null;
        String tmp2 = null;
        for(int i = contacts.size(); i > 0; i--)
        {
            for(int j = 0; j < i-1; j++)
            {
                if(sortBy == 0)
                {
                    tmp1 = contacts.get(j).getFirstName();
                    tmp2 = contacts.get(j+1).getFirstName();
                }
                else if (sortBy == 1)
                {
                    tmp1 = contacts.get(j).getLastName();
                    tmp2 = contacts.get(j+1).getLastName();
                }
                else if (sortBy == 2)
                {
                    tmp1 = contacts.get(j).getPhoneNumber();
                    tmp2 = contacts.get(j+1).getPhoneNumber();
                }
                if(tmp1.compareTo(tmp2) > 0)
                {
                    tmp = contacts.get(j);
                    contacts.set(j,contacts.get(j+1));
                    contacts.set(j+1,tmp);
                }
            }
        }
    }

    //searches in contact list by firstname
    public Person searchByFirstName(String firstName)
    {
        for(int i = 0; i < contacts.size(); i++)
        {
            if(contacts.get(i).getFirstName().equals(firstName))
            {
                return contacts.get(i);
            }
        }
        return null;
    }

    //searches in contact list by last name
    public Person searchByLastName(String lastName)
    {
        for(int i = 0; i < contacts.size(); i++)
        {
            if(contacts.get(i).getLastName().equals(lastName))
            {
                return contacts.get(i);
            }
        }
        return null;
    }

    //searches in contact list by phone number
    public Person searchByPhoneNumber(String phoneNumber)
    {
        for(int i = 0; i < contacts.size(); i++)
        {
            if(contacts.get(i).getPhoneNumber().equals(phoneNumber))
            {
                return contacts.get(i);
            }
        }
        return null;
    }

    //lists students in contact list
    public void listStudents()
    {
        for(int i = 0; i < contacts.size(); i++)
        {
            if(contacts.get(i) instanceof Student)
            {
                System.out.println(contacts.get(i).toString());
            }
        }
    }

    //lists persons in contact list
    public void listPersons()
    {
        for(int i = 0; i < contacts.size(); i++)
        {
            System.out.println(contacts.get(i).toString());
        }
    }

    //runs program with choices and scans user input
    public void run()
    {
        Scanner s = new Scanner(System.in);
        String firstName, lastName, phoneNumber, tclass, searchStr;
        int grade;
        Person ptemp = null;
        int menuchoice;
        do
        {
            System.out.println("Menu: ");
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts By First Name");
            System.out.println("3. List All Contacts By Last Name");
            System.out.println("4. List ALl Contacts By Phone Number");
            System.out.println("5. List ALl Students");
            System.out.println("6. Search By First Name");
            System.out.println("7. Search By last Name");
            System.out.println("8. Search By Phone Number");
            System.out.println("0. Exit");
            menuchoice = s.nextInt();
            s.nextLine();
            if(menuchoice == 1)
            {
                System.out.println("Select a type of contact to add: ");
                System.out.println("1. Student");
                System.out.println("2. Teacher");
                String contactType = s.nextLine();
                System.out.println("Please fill in the following information");
                System.out.println("First Name: ");
                firstName = s.nextLine();
                System.out.println("Last Name: ");
                lastName = s.nextLine();
                System.out.println("Phone Number: ");
                phoneNumber = s.nextLine();
                if(contactType.equals("1"))
                {
                    System.out.println("Grade: ");
                    grade = s.nextInt();
                    ptemp = new Student(firstName, lastName, phoneNumber, grade);
                }
                else if (contactType.equals("2"))
                {
                    System.out.println("Class: ");
                    tclass = s.nextLine();
                    ptemp = new Teacher(firstName, lastName, phoneNumber, tclass);
                }
                addContact(ptemp);
            }
            if(menuchoice == 2)
            {
                sort(0);
                listPersons();
            }
            if(menuchoice == 3)
            {
                sort(1);
                listPersons();
            }
            if(menuchoice == 4)
            {
                sort(2);
                listPersons();
            }
            if(menuchoice == 5)
            {
                listStudents();
            }
            if(menuchoice == 6)
            {
                System.out.println("Enter a name: ");
                searchStr = s.nextLine();
                ptemp = searchByFirstName(searchStr);
                if(ptemp == null)
                {
                    System.out.println(searchStr + "is not in the list");
                }
                else
                {
                    System.out.println(ptemp.toString());
                }
            }
            if(menuchoice == 7)
            {
                System.out.println("Enter a name: ");
                searchStr = s.nextLine();
                ptemp = searchByLastName(searchStr);
                if(ptemp == null)
                {
                    System.out.println(searchStr + "is not in the list");
                }
                else
                {
                    System.out.println(ptemp.toString());
                }
            }
            if(menuchoice == 8)
            {
                System.out.println("Enter a phone number: ");
                searchStr = s.nextLine();
                ptemp = searchByPhoneNumber(searchStr);
                if(ptemp == null)
                {
                    System.out.println(s.nextLine() + "is not in the list");
                }
                else
                {
                    System.out.println(ptemp.toString());
                }
            }
        }while(menuchoice != 0);

    }

    //main method for program to run
    public static void main(String args[])
    {
        ContactList nContactList = new ContactList();
        nContactList.run();
    }
}



