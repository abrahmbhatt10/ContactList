import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        this.contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts()
    {
        return contacts;
    }

    public void addContact(Person contact)
    {
        contacts.add(contact);
    }

    public void printContacts()
    {
        for(Person p: contacts)
        System.out.println(p.toString());
    }

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
                    contacts.set(j+1,contacts.get(j));
                    contacts.set(j,tmp);
                }
            }
        }
    }

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

    public Person searchByPhoneNumber(String phoneNumber)
    {
        for(int i = 0; i < contacts.size(); i++)
        {
            if(contacts.get(i).getLastName().equals(phoneNumber))
            {
                return contacts.get(i);
            }
        }
        return null;
    }

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

    public void run()
    {
        Scanner s = new Scanner(System.in);
        String firstName, lastName, phoneNumber, tclass;
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
            System.out.println("9. Exit");
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
                sort(1);
            }
            if(menuchoice == 3)
            {
                sort(2);
            }
            if(menuchoice == 4)
            {
                sort(3);
            }
            if(menuchoice == 5)
            {
                listStudents();
            }
            if(menuchoice == 6)
            {
                System.out.println("Enter a name: ");
                searchByFirstName(s.nextLine());
                if(searchByFirstName(s.nextLine()).equals(-1))
                {
                    System.out.println(s.nextLine() + "is not in the list");
                }
            }
            if(menuchoice == 7)
            {
                System.out.println("Enter a name: ");
                searchByLastName(s.nextLine());
                if(searchByLastName(s.nextLine()).equals(-1))
                {
                    System.out.println(s.nextLine() + "is not in the list");
                }
            }
            if(menuchoice == 8)
            {
                System.out.println("Enter a phone number: ");
                searchByPhoneNumber(s.nextLine());
                if(searchByPhoneNumber(s.nextLine()).equals(-1))
                {
                    System.out.println(s.nextLine() + "is not in the list");
                }
            }
        }while(menuchoice != 0);

    }
    public static void main(String args[])
    {
        ContactList nContactList = new ContactList();
        nContactList.run();
    }
}



