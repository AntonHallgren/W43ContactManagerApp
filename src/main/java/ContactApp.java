import java.util.ArrayList;
import java.util.List;

public class ContactApp
{

    List<Person> list = new ArrayList<>();

    void main()
    {
        createNewContact();
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

}
