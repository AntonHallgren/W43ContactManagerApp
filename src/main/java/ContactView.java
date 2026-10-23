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
        printContactInfo();
        IO.println("What do you want to do with " + selected.firstName + "?");
        IO.println("1: Call");
        IO.println("2: Edit");
        IO.println("3: Remove from list");
        IO.println("4: Go back");
        String option = IO.readln().toLowerCase();
        switch (option)
        {
            case "1", "call" -> IO.println("This has not been implemented");
            case "2", "edit" -> editContact();
            case "3", "remove" -> {
                shouldRemoveContact = true;
                running = false;
            }
            case "4", "back" -> running = false;
            default -> IO.println("I could not understand you");
        }
    }

    private void printContactInfo()
    {
        IO.println();
        IO.println("First name:   " + selected.firstName);
        IO.println("Last name:    " + selected.lastName);
        IO.println("Phone number: " + selected.phoneNumber);
        IO.println("Email:        " + selected.email);
        IO.println();
    }


    private void editContact()
    {
        ContactEditor editor = new ContactEditor(selected);
        while(editor.isRunning())
        {
            editor.showMenu();
        }
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
