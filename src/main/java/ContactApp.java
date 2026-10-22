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
        sortListByName();
        printAllContacts();
        Person personToEdit = findPersonByFirstName();
        if(personToEdit != null)
        {
            editPerson(personToEdit);
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

    void sortListByName()
    {
        list.sort((a1, a2) -> a1.firstName.compareTo(a2.firstName));
    }

    Person findPersonByFirstName()
    {
        String name = IO.readln("Name of person: ");
        for(Person person : list)
        {
            if(person.firstName.equals(name))
            {
                return person;
            }
        }
        IO.println("Could not find a contact with first name " + name);
        return null;
    }

    void editPerson(Person person)
    {
        person.firstName = IO.readln("New name: ");
        person.lastName = IO.readln("New last name: ");
        person.phoneNumber = IO.readln("New phone number: ");
        person.email = IO.readln("New email: ");
    }

    void deletePerson()
    {
        IO.println("Delete a person");
        Person toDelete = findPersonByFirstName();
        if(toDelete == null)
        {
            return;
        }
        list.remove(toDelete);
        IO.println(toDelete.firstName + " has been removed from your contact list");
    }
}
