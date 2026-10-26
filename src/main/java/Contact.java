import java.time.LocalDateTime;

public class Contact
{

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private final LocalDateTime timeCreated;

    public Contact(String firstName, String lastName, String phoneNumber, String email)
    {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        timeCreated = LocalDateTime.now();
    }

    public String fullName()
    {
        return firstName + " " + lastName;
    }

    public String nameReverseOrder()
    {
        return lastName + " " + firstName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }
}
