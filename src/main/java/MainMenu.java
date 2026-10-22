import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainMenu {

    private final List<Contact> list = new ArrayList<>();
    private boolean running = true;


    public void showMainMenu()
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
            case "2", "find", "find contact" -> findContact();
            case "1", "show", "show contact" ->
            {
                sortListByName();
                printAllContacts();
            }
            case "4", "quit" -> running = false;
            default -> IO.println("I could not understand you");
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


    private void findContact()
    {
        Contact selected = findPersonByFirstName();
        if(selected == null)
        {
            return;
        }
        ContactView contactView = new ContactView(selected);
        while(contactView.isRunning())
        {
            contactView.showMenu();
        }
        if(contactView.contactShouldBeRemoved())
        {
            removeContact(selected);
        }
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

    public boolean isRunning()
    {
        return running;
    }
}
