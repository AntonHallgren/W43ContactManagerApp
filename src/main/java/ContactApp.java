import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactApp
{

    List<Person> list = new ArrayList<>();
    boolean running = true;


    void main()
    {
        while(running)
        {
            showMainMenu();
        }
    }

    private void showMainMenu()
    {
        IO.println("What do you want to do?");
        IO.println("1: Show contacts");
        IO.println("2: Find contact");
        IO.println("3: Add contact");
        IO.println("4: Edit contact");
        IO.println("5: Remove contact");
        IO.println("6: Quit");
        String option = IO.readln();
        switch (option.toLowerCase())
        {
            case "3", "add", "add contact" -> createNewContact();
            case "2", "find", "find contact" ->
            {
                Person person = findPersonByFirstName();
                if(person != null)
                {
                    printContactInfo(person);
                }
            }
            case "1", "show", "show contact" ->
            {
                sortListByName();
                printAllContacts();
            }
            case "4", "edit", "edit contact" ->
            {
                Person personToEdit = findPersonByFirstName();
                if(personToEdit != null)
                {
                    editPerson(personToEdit);
                }
            }
            case "5", "remove", "remove contact" -> deletePerson();
            case "6", "quit" -> running = false;
            default -> IO.println("I could not understand you");
        }
    }

    private void createNewContact()
    {
        Person newPerson = new Person();
        newPerson.firstName = IO.readln("Enter first name: ");
        newPerson.lastName = IO.readln("Enter last name: ");
        newPerson.phoneNumber = IO.readln("Enter phone number: ");
        newPerson.email = IO.readln("Enter email: ");

        list.add(newPerson);

    }

    private void printAllContacts()
    {
        for(Person person : list)
        {
            IO.println(person.fullName());

        }
    }

    private void sortListByName()
    {
        list.sort(Comparator.comparing(a -> a.firstName));
    }

    private void printContactInfo(Person person)
    {
        IO.println(person.firstName);
        IO.println((person.lastName));
        IO.println(person.phoneNumber);
        IO.println(person.email);
    }


    private Person findPersonByFirstName()
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

    private void editPerson(Person person)
    {
        person.firstName = IO.readln("New name: ");
        person.lastName = IO.readln("New last name: ");
        person.phoneNumber = IO.readln("New phone number: ");
        person.email = IO.readln("New email: ");
    }

    private void deletePerson()
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
