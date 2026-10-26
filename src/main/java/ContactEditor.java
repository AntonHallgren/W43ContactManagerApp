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
        String firstName = IO.readln("Enter new first name: ");
        String lastName = IO.readln("Enter new last name: ");
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
    }

    private void editNumber()
    {
        String phoneNumber = IO.readln("Enter new phone number: ");
        contact.setPhoneNumber(phoneNumber);
    }

    private void editEmail()
    {
        String email = IO.readln("Enter new email: ");
        contact.setEmail(email);
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
