public class ContactEditor {
    private final Contact contact;

    private boolean running = true;

    public ContactEditor(Contact contact) {
        this.contact = contact;
    }

    public void showMenu()
    {
        IO.println("1: Edit name");
        IO.println("2: Edit phone number");
        IO.println("3: Edit email");
        IO.println("4: Edit All");
        IO.println("5: Done");
        String option = IO.readln().toLowerCase();
        switch (option)
        {
            case "1", "name" -> editName();
            case "2", "phone", "number", "phone number" -> editNumber();
            case "3", "email" -> editEmail();
            case "4", "all" -> editAll();
            case "5", "done" -> running = false;
            default -> IO.println("I could not understand you");
        }
    }


    private void editName()
    {
        contact.firstName = IO.readln("Enter new first name: ");
        contact.lastName = IO.readln("Enter new last name: ");
    }

    private void editNumber()
    {
        contact.phoneNumber = IO.readln("Enter new phone number: ");
    }

    private void editEmail()
    {
        contact.email = IO.readln("Enter new email: ");
    }

    private void editAll()
    {
        editName();
        editNumber();
        editEmail();
    }

    public boolean isRunning() {
        return running;
    }

}
