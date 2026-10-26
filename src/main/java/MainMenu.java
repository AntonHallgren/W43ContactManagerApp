import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainMenu {

    private final List<Contact> list = new ArrayList<>();
    private boolean running = true;

    public enum SortingMethod{
        FIRST_NAME,
        LAST_NAME,
        TIME_CREATED
    }

    private SortingMethod sortingMethod = SortingMethod.FIRST_NAME;
    private boolean reverseOrder;

    public void showMainMenu()
    {
        IO.println("What do you want to do?");
        IO.println("1: Show contacts");
        IO.println("2: Find contact");
        IO.println("3: Add contact");
        IO.println("4: Order contacts");
        IO.println("5: Quit");
        String option = IO.readln().toLowerCase();
        switch (option)
        {
            case "3", "add", "add contact" -> createNewContact();
            case "2", "find", "find contact" -> findContact();
            case "1", "show", "show contact" ->
            {
                sort();
                printAllContacts();
            }
            case "5", "quit" -> running = false;
            case "4", "order" -> orderMenu();
            default -> IO.println("I could not understand you");
        }
    }

    private void orderMenu()
    {
        IO.println("Chose order");
        IO.println("1: First name");
        IO.println("2: Last name");
        IO.println("3: Time created");
        IO.println("4: Reverse order");
        IO.println("5: Exit");
        String option = IO.readln().toLowerCase();
        switch (option)
        {
            case "1" -> sortingMethod = SortingMethod.FIRST_NAME;
            case "2" -> sortingMethod = SortingMethod.LAST_NAME;
            case "3" -> sortingMethod = SortingMethod.TIME_CREATED;
            case "4" -> reverseOrder = !reverseOrder;
        }
    }




    private void createNewContact()
    {
        String firstName = IO.readln("Enter first name: ");
        String lastName = IO.readln("Enter last name: ");
        String phoneNumber = IO.readln("Enter phone number: ");
        String email = IO.readln("Enter email: ");

        Contact newContact = new Contact(firstName, lastName, phoneNumber, email);
        list.add(newContact);

    }

    private void printAllContacts()
    {
        for(Contact contact : list)
        {
            IO.println(contact.fullName());

        }
    }

    private void sort()
    {
        Comparator<Contact> comparator = Comparator.comparing(Contact::fullName);
        switch (sortingMethod)
        {
            case SortingMethod.FIRST_NAME ->
            {
                comparator = Comparator.comparing(Contact::getFirstName, String.CASE_INSENSITIVE_ORDER);
                comparator = comparator.thenComparing(Contact::getLastName, String.CASE_INSENSITIVE_ORDER);
            }
            case SortingMethod.LAST_NAME ->
            {
                comparator = Comparator.comparing(Contact::getLastName, String.CASE_INSENSITIVE_ORDER);
                comparator = comparator.thenComparing(Contact::getFirstName, String.CASE_INSENSITIVE_ORDER);
            }
            case SortingMethod.TIME_CREATED ->
            {
                comparator = Comparator.comparing(Contact::getTimeCreated);
            }
        }

        comparator = reverseOrder ? comparator.reversed() : comparator;
        list.sort(comparator);
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
            if(contact.getFirstName().equals(name))
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
            IO.println(contact.fullName() + " has been removed from your contact list");
        }
    }

    public boolean isRunning()
    {
        return running;
    }
}
