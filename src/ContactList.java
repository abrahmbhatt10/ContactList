import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList(ArrayList<Person> contacts) {
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
        System.out.println(p);
    }

    public void sort(int sortBy)
    {
        if(sortBy == 0)
        {
            for(int i = 0; i < contacts.size(); i++)
            {
                if(contacts.get(i).getFirstName().compareTo(contacts.get(i+1).getFirstName()) > 0)
                {
                    Person temp = contacts.get(i+1);
                    contacts.set(i+1,contacts.get(i));
                    contacts.set(i,temp);
                }
            }
        }

        if(sortBy == 1)
        {
            for(int i = 0; i < contacts.size(); i++)
            {
                if(contacts.get(i).getLastName().compareTo(contacts.get(i+1).getLastName()) > 0)
                {
                    Person temp = contacts.get(i+1);
                    contacts.set(i+1,contacts.get(i));
                    contacts.set(i,temp);
                }
            }
        }

        if(sortBy == 2)
        {
            for(int i = 0; i < contacts.size(); i++)
            {
                if(contacts.get(i).getPhoneNumber().compareTo(contacts.get(i+1).getPhoneNumber()) > 0)
                {
                    Person temp = contacts.get(i+1);
                    contacts.set(i+1,contacts.get(i));
                    contacts.set(i,temp);
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

    public Student listStudents()
    {
        ArrayList<Student> listStudents = new ArrayList<Student>();
        for(int i = 0; i < contacts.size(); i++)
        {
            if(contacts.get(i) instanceof Student)
            {
                listStudents.add((Student) contacts.get(i));
            }
        }

        for(int i = 0; i < listStudents.size(); i++)
        {
            return listStudents.get(i);
        }
        return null;
    }

    public void run()
    {
        Scanner s = new Scanner(System.in);
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
        if(s.nextLine().equals("1"))
        {
            System.out.println("Select a type of contact to add: ");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            String contactType = s.nextLine();
            System.out.println("Please fill in the following information");
            System.out.println("First Name: ");
            String firstName = s.nextLine();
            System.out.println("Last Name: ");
            String lastName = s.nextLine();
            System.out.println("Phone Number: ");
            String phoneNumber = s.nextLine();
            if(contactType.equals("1"))
            {
                System.out.println("Grade: ");
                String grade = s.nextLine();
            }
            else if (contactType.equals("2"))
            {
                System.out.println("Class: ");
                String tclass = s.nextLine();
            }
        }
        if(s.nextLine().equals("2"))
        {
            sort(1);
        }
        if(s.nextLine().equals("3"))
        {
            sort(2);
        }
        if(s.nextLine().equals("4"))
        {
            sort(3);
        }
        if(s.nextLine().equals("5"))
        {
            listStudents();
        }
        if(s.nextLine().equals("6"))
        {
            System.out.println("Enter a name: ");
            searchByFirstName(s.nextLine());
            if(searchByFirstName(s.nextLine()).equals(-1))
            {
                System.out.println(s.nextLine() + "is not in the list");
            }
        }
        if(s.nextLine().equals("7"))
        {
            System.out.println("Enter a name: ");
            searchByLastName(s.nextLine());
            if(searchByLastName(s.nextLine()).equals(-1))
            {
                System.out.println(s.nextLine() + "is not in the list");
            }
        }
        if(s.nextLine().equals("8"))
        {
            System.out.println("Enter a phone number: ");
            searchByPhoneNumber(s.nextLine());
            if(searchByPhoneNumber(s.nextLine()).equals(-1))
            {
                System.out.println(s.nextLine() + "is not in the list");
            }
        }
        if(s.nextLine().equals("9"))
        {
            System.out.println("Goodbye");
        }
    }

    public static void main (String args[])
    {
        ArrayList<Person> personArr = new ArrayList<Person>();
        ContactList nContactList = new ContactList(personArr);
        nContactList.run();
    }
}
