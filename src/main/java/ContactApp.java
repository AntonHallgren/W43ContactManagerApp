import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactApp
{

    List<Contact> list = new ArrayList<>();
    Contact selected = null;
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
        IO.println("4: Quit");
        String option = IO.readln();
        switch (option.toLowerCase())
        {
            case "3", "add", "add contact" -> createNewContact();
            case "2", "find", "find contact" ->
            {
                selected = findPersonByFirstName();
                while(selected != null)
                {
                    showContactMenu();
                }
            }
            case "1", "show", "show contact" ->
            {
                sortListByName();
                printAllContacts();
            }
            case "4", "quit" -> running = false;
            default -> IO.println("I could not understand you");
        }
    }




    private void showContactMenu()
    {
        printContactInfo(selected);
        IO.println("What do you want to do with " + selected.firstName + "?");
        IO.println("1: Call");
        IO.println("2: Edit");
        IO.println("3: Remove from list");
        IO.println("4: Go back");
        String option = IO.readln().toLowerCase();
        switch (option)
        {
            case "1", "call" -> IO.println("This has not been implemented");
            case "2", "edit" -> editContact(selected);
            case "3", "remove" -> {
                removeContact(selected);
                selected = null;
            }
            case "4", "back" -> selected = null;
        }
    }

    private void createNewContact()
    {
        Contact newContact = new Contact();
        newContact.firstName = IO.readln("Enter first name: ");
        newContact.lastName = IO.readln("Enter last name: ");
        newContact.phoneNumber = IO.readln("Enter phone number: ");
        newContact.email = IO.readln("Enter email: ");

        list.add(newContact);

    }

    private void printAllContacts()
    {
        for(Contact contact : list)
        {
            IO.println(contact.fullName());

        }
    }

    private void sortListByName()
    {
        list.sort(Comparator.comparing(a -> a.firstName));
    }

    private void printContactInfo(Contact contact)
    {
        IO.println(contact.firstName);
        IO.println((contact.lastName));
        IO.println(contact.phoneNumber);
        IO.println(contact.email);
    }


    private Contact findPersonByFirstName()
    {
        String name = IO.readln("Name of person: ");
        for(Contact contact : list)
        {
            if(contact.firstName.equals(name))
            {
                return contact;
            }
        }
        IO.println("Could not find a contact with first name " + name);
        return null;
    }

    private void editContact(Contact contact)
    {
        contact.firstName = IO.readln("New name: ");
        contact.lastName = IO.readln("New last name: ");
        contact.phoneNumber = IO.readln("New phone number: ");
        contact.email = IO.readln("New email: ");
    }

    private void removeContact(Contact contact)
    {
        if(contact == null)
        {
            return;
        }
        boolean success = list.remove(contact);
        if(success)
        {
            IO.println(contact.firstName + " has been removed from your contact list");
        }
    }
}
