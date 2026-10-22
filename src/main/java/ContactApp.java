import java.util.ArrayList;
import java.util.List;

public class ContactApp
{

    List<Person> list = new ArrayList<>();

    void main()
    {
        boolean continueCreating = true;

        while(continueCreating)
        {
            String input = IO.readln("Do you want to create a new contact? (yes/no): ");
            if(input.equals("yes"))
            {
                createNewContact();
            }
            else if(input.equals("no")){
                continueCreating = false;
            }
        }
        printAllContacts();
    }

    void createNewContact()
    {
        Person newPerson = new Person();
        newPerson.firstName = IO.readln("Enter first name: ");
        newPerson.lastName = IO.readln("Enter last name: ");
        newPerson.phoneNumber = IO.readln("Enter phone number: ");
        newPerson.email = IO.readln("Enter email: ");

        list.add(newPerson);

    }

    void printAllContacts()
    {
        for(Person person : list)
        {
            IO.println(person.firstName);
            IO.println((person.lastName));
            IO.println(person.phoneNumber);
            IO.println(person.email);

        }
    }

}
