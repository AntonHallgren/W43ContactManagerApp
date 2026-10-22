public class ContactView
{
    private final Contact selected;

    private boolean shouldRemoveContact = false;
    private boolean running = true;

    public ContactView(Contact contact) {
        this.selected = contact;
    }

    public void showMenu()
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
                shouldRemoveContact = true;
                running = false;
            }
            case "4", "back" -> running = false;
        }
    }

    private void printContactInfo(Contact contact)
    {
        IO.println(contact.firstName);
        IO.println((contact.lastName));
        IO.println(contact.phoneNumber);
        IO.println(contact.email);
    }


    private void editContact(Contact contact)
    {
        contact.firstName = IO.readln("New name: ");
        contact.lastName = IO.readln("New last name: ");
        contact.phoneNumber = IO.readln("New phone number: ");
        contact.email = IO.readln("New email: ");
    }



    public boolean contactShouldBeRemoved()
    {
        return shouldRemoveContact;
    }

    public boolean isRunning()
    {
        return running;
    }
}
